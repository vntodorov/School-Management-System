package com.iStudent.model.validation;

import javax.validation.*;


public class ValidEGNValidator implements ConstraintValidator<ValidEGN, String> {


    @Override
    public boolean isValid(String EGN, ConstraintValidatorContext context) {
        return EGN.length() == 10;
    }
}
