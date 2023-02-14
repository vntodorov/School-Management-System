package com.iStudent.service;

import com.iStudent.model.DTOs.TeacherDTO;
import com.iStudent.model.entity.Subject;
import com.iStudent.model.entity.Teacher;
import com.iStudent.model.entity.Town;
import com.iStudent.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    private final TownService townService;

    private final ModelMapper mapper;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, TownService townService, ModelMapper mapper) {
        this.teacherRepository = teacherRepository;
        this.townService = townService;
        this.mapper = mapper;
    }


    public Optional<TeacherDTO> getTeacherById(Long teacherId) {
        return teacherRepository.
                findById(teacherId).
                map(this::mapToTeacherDTO);
    }

    private TeacherDTO mapToTeacherDTO(Teacher teacher) {
        return mapper.map(teacher, TeacherDTO.class);
    }

    public long addTeacher(TeacherDTO teacherDTO) {
        Town townToMap = townService.findByTownName(teacherDTO.getTown().getName());

        Teacher teacher = mapper.map(teacherDTO, Teacher.class);

        teacher.setTown(townToMap);

        teacherRepository.save(teacher);

        return teacher.getId();
    }

    public List<TeacherDTO> getAllStudents() {
        return teacherRepository.
                findAll().
                stream().
                map(this::mapToTeacherDTO).
                toList();
    }

    public TeacherDTO changeTeacherSubject(Long teacherId, TeacherDTO teacherDTO) {

        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);

        if (optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();
            Subject subject = new Subject(teacherDTO.getSubject().getName());
            teacher.setSubject(subject);
            teacherRepository.save(teacher);
            return mapToTeacherDTO(teacher);

        }

        return null;


    }

    public void deleteTeacherById(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }
}
