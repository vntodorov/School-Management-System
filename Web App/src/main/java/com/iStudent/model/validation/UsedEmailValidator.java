package com.iStudent.model.validation;

import com.iStudent.repository.EmployeeRepository;
import com.iStudent.repository.ParentRepository;
import com.iStudent.repository.StudentRepository;
import com.iStudent.repository.TeacherRepository;

import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;

public class UsedEmailValidator implements ConstraintValidator<UsedEmail, String> {

    private final StudentRepository studentRepository;

    private final TeacherRepository teacherRepository;

    private final EmployeeRepository employeeRepository;

    private final ParentRepository parentRepository;

    @Autowired
    public UsedEmailValidator(StudentRepository studentRepository,
                              TeacherRepository teacherRepository,
                              EmployeeRepository employeeRepository,
                              ParentRepository parentRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.employeeRepository = employeeRepository;
        this.parentRepository = parentRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return studentRepository.findByEmail(email).isPresent() ||
                teacherRepository.findByEmail(email).isPresent() ||
                employeeRepository.findByEmail(email).isPresent() ||
                parentRepository.findByEmail(email).isPresent();
    }
}
