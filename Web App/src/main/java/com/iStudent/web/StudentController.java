package com.iStudent.web;

import com.iStudent.model.DTOs.MarkDTO;
import com.iStudent.model.DTOs.StudentDTO;
import com.iStudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
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

    @GetMapping
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

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@Valid @RequestBody StudentDTO studentDTO,
                                                 UriComponentsBuilder uriComponentsBuilder) {

        long newStudentId = studentService.addStudent(studentDTO);

        return ResponseEntity
                .created(uriComponentsBuilder.path("/students/{id}")
                        .build(newStudentId))
                .build();
    }

    @PostMapping("/{id}/add/mark")
    public ResponseEntity<StudentDTO> addMarkToStudent(@PathVariable("id") Long studentId,
                                                       @Valid @RequestBody MarkDTO markDTO) {

        if (studentService.addMarkToStudent(studentId, markDTO)) {
            return ResponseEntity.
                    ok().
                    build();
        } else {
            return ResponseEntity.
                    notFound().
                    build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDTO> deleteStudentById(@PathVariable("id") Long studentId) {
        this.studentService.deleteStudentById(studentId);

        return ResponseEntity
                .noContent()
                .build();
    }

}
