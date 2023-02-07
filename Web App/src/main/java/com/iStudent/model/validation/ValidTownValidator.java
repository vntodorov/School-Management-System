package com.iStudent.model.validation;

import com.iStudent.model.entity.Town;
import com.iStudent.repository.TownRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidTownValidator implements ConstraintValidator<ValidTown, Town> {

    private final TownRepository townRepository;

    @Autowired
    public ValidTownValidator(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public boolean isValid(Town town, ConstraintValidatorContext context) {
        return
                townRepository
                        .findById(town.getId())
                        .isPresent();
    }
}
