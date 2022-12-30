package SchoolManagementSystem.services;

import SchoolManagementSystem.domain.DTOs.CreateStudentDTO;
import SchoolManagementSystem.domain.entities.Student;
import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.repositories.StudentRepository;
import SchoolManagementSystem.repositories.TownRepository;
import SchoolManagementSystem.services.interfaces.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final TownRepository townRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, TownRepository townRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    @Transactional
    public void addStudent(CreateStudentDTO studentDTO) {
        Optional<Town> town = townRepository.findByName(studentDTO.getTown().getName());

        town.ifPresent(studentDTO::setTown);

        Student student = modelMapper.map(studentDTO, Student.class);

        studentRepository.save(student);

    }
}
