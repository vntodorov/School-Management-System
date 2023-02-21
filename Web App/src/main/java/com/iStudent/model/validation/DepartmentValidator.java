package com.iStudent.model.validation;

import com.iStudent.model.DTOs.DepartmentDTO;
import com.iStudent.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DepartmentValidator implements ConstraintValidator<ValidDepartment, DepartmentDTO> {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentValidator(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public boolean isValid(DepartmentDTO department, ConstraintValidatorContext context) {
        return departmentRepository.findById(department.getId()).isPresent();
    }
}
