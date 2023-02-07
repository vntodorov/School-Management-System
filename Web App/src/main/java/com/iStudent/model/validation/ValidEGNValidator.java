package com.iStudent.model.validation;

import com.iStudent.model.entity.Town;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidEGNValidator implements ConstraintValidator<ValidEGN, String> {


    @Override
    public boolean isValid(String EGN, ConstraintValidatorContext context) {
        return EGN.length() == 10;
    }
}
