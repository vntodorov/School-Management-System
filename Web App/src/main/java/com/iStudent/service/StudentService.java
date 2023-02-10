package com.iStudent.service;

import com.iStudent.model.DTOs.AddStudentDTO;
import com.iStudent.model.DTOs.StudentDTO;
import com.iStudent.model.entity.Student;
import com.iStudent.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final ModelMapper mapper;

    @Autowired
    public StudentService(StudentRepository studentRepository, ModelMapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository
                .findAll()
                .stream()
                .map(this::mapToStudentDTO)
                .toList();
    }

    public Optional<StudentDTO> getStudentById(Long studentId) {
        return studentRepository
                .findById(studentId)
                .map(this::mapToStudentDTO);
    }

    public long addStudent(AddStudentDTO addStudentDTO) {
        Student student = mapper.map(addStudentDTO, Student.class);

        studentRepository.save(student);

        return student.getId();
    }

    public void deleteStudentById(Long studentId) {
        //TODO: implement
    }

    private StudentDTO mapToStudentDTO(Student student) {
        return mapper.map(student, StudentDTO.class);
    }
}
