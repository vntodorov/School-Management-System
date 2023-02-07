package com.iStudent.web;

import com.iStudent.model.DTOs.AddStudentDTO;
import com.iStudent.model.DTOs.StudentDTO;
import com.iStudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity
                .ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") Long studentId) {
        Optional<StudentDTO> student = this.studentService.getStudentById(studentId);

        if (student.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();

        } else {
            return ResponseEntity
                    .ok(student.get());

        }
    }

    @PostMapping("/add")
    public ResponseEntity<AddStudentDTO> addStudent(@RequestBody AddStudentDTO addStudentDTO,
                                                    UriComponentsBuilder uriComponentsBuilder) {

        long newStudentId = studentService.addStudent();

        return ResponseEntity
                .created(uriComponentsBuilder.path("/{id}")
                        .build(newStudentId))
                .build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<StudentDTO> deleteStudentById(@PathVariable("id") Long studentId) {
        this.studentService.deleteStudentById(studentId);

        return ResponseEntity
                .noContent()
                .build();
    }

}
