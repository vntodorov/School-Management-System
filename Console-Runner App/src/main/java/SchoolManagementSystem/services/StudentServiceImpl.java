package SchoolManagementSystem.services;

import static SchoolManagementSystem.constants.Validations.*;

import SchoolManagementSystem.domain.DTOs.AddStudentDTO;
import SchoolManagementSystem.domain.DTOs.StudentBasicInfoDTO;
import SchoolManagementSystem.domain.entities.Club;
import SchoolManagementSystem.domain.entities.Parent;
import SchoolManagementSystem.domain.entities.Student;
import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.domain.enums.Gender;
import SchoolManagementSystem.domain.enums.Mark;
import SchoolManagementSystem.exceptions.EntityException;
import SchoolManagementSystem.repositories.StudentRepository;
import SchoolManagementSystem.services.interfaces.ClubService;
import SchoolManagementSystem.services.interfaces.ParentService;
import SchoolManagementSystem.services.interfaces.StudentService;
import SchoolManagementSystem.services.interfaces.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final TownService townService;

    private final ClubService clubService;
    private final ParentService parentService;

    private final ModelMapper modelMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, TownService townService, ClubService clubService, ParentService parentService, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.townService = townService;
        this.clubService = clubService;
        this.parentService = parentService;
        this.modelMapper = modelMapper;
    }


    @Override
    @Transactional
    public String addStudent(List<String> studentData) {

        String firstName = studentData.get(0);
        String middleName = studentData.get(1);
        String lastName = studentData.get(2);
        String EGN = studentData.get(3);
        int age = Integer.parseInt(studentData.get(4));
        Gender gender = Gender.valueOf(studentData.get(5));
        String townName = studentData.get(6);
        String email = studentData.get(7);

        AddStudentDTO studentDTO;

        String resultOfAddingTown = townService.addTown(townName);

        if (resultOfAddingTown.equals(NO_ANSWER)) {
            return NO_ANSWER;
        } else if (resultOfAddingTown.equals(SUCCESSFULLY_ADDED_TOWN)) {
            System.out.println(resultOfAddingTown);
        }

        Town town = townService.findByName(townName);

        try {
            studentDTO = new AddStudentDTO(firstName, middleName, lastName, EGN, age, gender, town, email);
        } catch (EntityException e) {
            return e.getMessage();
        }

        Student student = modelMapper.map(studentDTO, Student.class);

        studentRepository.save(student);

        return String.format(SUCCESSFULLY_ADDED_STUDENT, student);
    }

    @Override
    public String viewStudentInfo(String[] viewStudentData) {
        String firstName = viewStudentData[0];
        String lastName = viewStudentData[1];

        Optional<Student> student = this.studentRepository.findByFirstNameAndLastName(firstName, lastName);

        if (student.isEmpty()) {
            return String.format(STUDENT_DOES_NOT_EXIST, firstName, lastName);
        }

        StudentBasicInfoDTO studentToShow = this.modelMapper.map(student, StudentBasicInfoDTO.class);

        return studentToShow.toString();
    }

    @Override
    @Transactional
    public String addMark(String[] studentMarkData) {
        String firstName = studentMarkData[0];
        String lastName = studentMarkData[1];
        int markValue = Integer.parseInt(studentMarkData[2]);

        Mark markToAdd = Arrays.stream(Mark.values()).filter(m -> m.getValue() == markValue).findFirst().orElseThrow();

        Optional<Student> student = this.studentRepository.findByFirstNameAndLastName(firstName, lastName);

        if (student.isEmpty()) {
            return String.format(STUDENT_DOES_NOT_EXIST, firstName, lastName);
        }

        student.get().addMark(markToAdd);
        studentRepository.save(student.get());

        return String.format(SUCCESSFULLY_ADDED_MARK_TO_STUDENT, markValue, firstName, lastName);

    }

    @Override
    @Transactional
    public String addClub(String[] studentClubData) {
        String firstName = studentClubData[0];
        String lastName = studentClubData[1];
        String clubName = studentClubData[2];

        Club club = clubService.findByName(clubName);

        Optional<Student> student = this.studentRepository.findByFirstNameAndLastName(firstName, lastName);

        if (student.isEmpty()) {
            return String.format(STUDENT_DOES_NOT_EXIST, firstName, lastName);
        }

        student.get().addClub(club);
        studentRepository.save(student.get());

        return String.format(SUCCESSFULLY_ADDED_CLUB_TO_STUDENT, clubName, firstName, lastName);
    }

    @Override
    @Transactional
    public String addParent(List<String> studentParentData) {
        parentService.addParent(studentParentData);

        String parentFirstName = studentParentData.get(0);
        String parentLastName = studentParentData.get(2);

        String studentFirstName = studentParentData.get(9);
        String studentLastName = studentParentData.get(10);

        Optional<Student> student = this.studentRepository.findByFirstNameAndLastName(studentFirstName, studentLastName);

        if (student.isEmpty()) {
            return String.format(STUDENT_DOES_NOT_EXIST, studentFirstName, studentLastName);
        }

        Parent parent = parentService.findByFirstNameAndLastName(parentFirstName, parentLastName);

        student.get().setParent(parent);

        studentRepository.save(student.get());

        return String.format(SUCCESSFULLY_ADDED_PARENT_TO_STUDENT, studentFirstName, studentLastName);


    }
}
