package SchoolManagementSystem.services;

import SchoolManagementSystem.domain.DTOs.AddTeacherDTO;
import SchoolManagementSystem.domain.DTOs.SubjectDTO;
import SchoolManagementSystem.domain.entities.Subject;
import SchoolManagementSystem.domain.entities.Teacher;
import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.domain.enums.Gender;
import SchoolManagementSystem.exceptions.EntityException;
import SchoolManagementSystem.repositories.CountryRepository;
import SchoolManagementSystem.repositories.SubjectRepository;
import SchoolManagementSystem.repositories.TeacherRepository;
import SchoolManagementSystem.repositories.TownRepository;
import SchoolManagementSystem.services.interfaces.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static SchoolManagementSystem.Constants.Validations.*;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final TownRepository townRepository;

    private final ModelMapper modelMapper;

    private final CountryRepository countryRepository;

    private final SubjectRepository subjectRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository, TownRepository townRepository, ModelMapper modelMapper, CountryRepository countryRepository, SubjectRepository subjectRepository) {
        this.teacherRepository = teacherRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.countryRepository = countryRepository;
        this.subjectRepository = subjectRepository;
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

        if (!checkTown(townRepository, countryRepository, townName)){
            return NO_ANSWER;
        }

        Town town = townRepository.findByName(townName).orElseThrow();

        try {
            teacherDTO = new AddTeacherDTO(firstName, middleName, lastName, EGN, age, gender, town, email, subjectToAdd);
        } catch (EntityException e){
            return e.getMessage();
        }

        Teacher teacher = modelMapper.map(teacherDTO, Teacher.class);

        teacherRepository.save(teacher);

        return String.format(SUCCESSFULLY_ADDED_TEACHER, teacher);
    }
}
