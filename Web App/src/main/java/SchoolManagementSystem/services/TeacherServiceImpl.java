package SchoolManagementSystem.services;

import SchoolManagementSystem.domain.DTOs.AddTeacherDTO;
import SchoolManagementSystem.domain.DTOs.StudentBasicInfoDTO;
import SchoolManagementSystem.domain.DTOs.SubjectDTO;
import SchoolManagementSystem.domain.DTOs.TeacherBasicInfoDTO;
import SchoolManagementSystem.domain.entities.Student;
import SchoolManagementSystem.domain.entities.Teacher;
import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.domain.enums.Gender;
import SchoolManagementSystem.exceptions.EntityException;
import SchoolManagementSystem.repositories.CountryRepository;
import SchoolManagementSystem.repositories.SubjectRepository;
import SchoolManagementSystem.repositories.TeacherRepository;
import SchoolManagementSystem.repositories.TownRepository;
import SchoolManagementSystem.services.interfaces.TeacherService;
import SchoolManagementSystem.services.interfaces.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static SchoolManagementSystem.constants.Validations.*;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final TownService townService;

    private final ModelMapper modelMapper;


    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository, TownService townService, ModelMapper modelMapper) {
        this.teacherRepository = teacherRepository;
        this.townService = townService;
        this.modelMapper = modelMapper;

    }

    @Override
    @Transactional
    public String addTeacher(List<String> teacherData) {
        String firstName = teacherData.get(0);
        String middleName = teacherData.get(1);
        String lastName = teacherData.get(2);
        String EGN = teacherData.get(3);
        int age = Integer.parseInt(teacherData.get(4));
        Gender gender = Gender.valueOf(teacherData.get(5));
        String townName = teacherData.get(6);
        String email = teacherData.get(7);
        String subjectName = teacherData.get(8);

        SubjectDTO subjectToAdd = new SubjectDTO(subjectName);

        AddTeacherDTO teacherDTO;

        String resultOfAddingTown = townService.addTown(townName);

        if (resultOfAddingTown.equals(NO_ANSWER)) {
            return NO_ANSWER;
        } else if (resultOfAddingTown.equals(SUCCESSFULLY_ADDED_TOWN)) {
            System.out.println(resultOfAddingTown);
        }

        Town town = townService.findByName(townName);

        try {
            teacherDTO = new AddTeacherDTO(firstName, middleName, lastName, EGN, age, gender, town, email, subjectToAdd);
        } catch (EntityException e) {
            return e.getMessage();
        }

        Teacher teacher = modelMapper.map(teacherDTO, Teacher.class);

        teacherRepository.save(teacher);

        return String.format(SUCCESSFULLY_ADDED_TEACHER, teacher);
    }

    @Override
    public String viewTeacherInfo(String[] viewTeacherData) {
        String firstName = viewTeacherData[0];
        String lastName = viewTeacherData[1];

        Optional<Teacher> teacher = this.teacherRepository.findByFirstNameAndLastName(firstName, lastName);

        if (teacher.isEmpty()) {
            return String.format(TEACHER_DOES_NOT_EXIST, firstName, lastName);
        }

        TeacherBasicInfoDTO teacherToShow = this.modelMapper.map(teacher, TeacherBasicInfoDTO.class);

        return teacherToShow.toString();

    }
}
