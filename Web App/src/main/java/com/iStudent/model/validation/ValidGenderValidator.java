package com.iStudent.model.validation;

import com.iStudent.model.entity.enums.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class ValidGenderValidator implements ConstraintValidator<ValidGender, Gender> {

    private Gender[] values;

    @Override
    public void initialize(ValidGender constraintAnnotation) {
        this.values = constraintAnnotation.anyOf();
    }

    @Override
    public boolean isValid(Gender gender, ConstraintValidatorContext context) {
        return Arrays.asList(values).contains(gender);
    }
}
