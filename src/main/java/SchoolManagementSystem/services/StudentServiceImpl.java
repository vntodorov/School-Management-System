package SchoolManagementSystem.services;

import static SchoolManagementSystem.constants.Validations.*;

import SchoolManagementSystem.domain.DTOs.AddStudentDTO;
import SchoolManagementSystem.domain.DTOs.StudentBasicInfoDTO;
import SchoolManagementSystem.domain.entities.Student;
import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.domain.enums.Gender;
import SchoolManagementSystem.exceptions.EntityException;
import SchoolManagementSystem.repositories.CountryRepository;
import SchoolManagementSystem.repositories.StudentRepository;
import SchoolManagementSystem.repositories.TownRepository;
import SchoolManagementSystem.services.interfaces.StudentService;
import SchoolManagementSystem.services.interfaces.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final TownRepository townRepository;

    private final TownService townService;

    private final ModelMapper modelMapper;

    private final CountryRepository countryRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, TownRepository townRepository, TownService townService, ModelMapper modelMapper, CountryRepository countryRepository) {
        this.studentRepository = studentRepository;
        this.townRepository = townRepository;
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.countryRepository = countryRepository;
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

        Town town = townRepository.findByName(townName).orElseThrow();

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
}
