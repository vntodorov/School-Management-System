package com.iStudent.model.validation;

import com.iStudent.repository.UserRepository;
import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserRepository userRepository;

    @Autowired
    public UniqueEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return userRepository
                .findByEmail(value)
                .isEmpty();
    }
}
