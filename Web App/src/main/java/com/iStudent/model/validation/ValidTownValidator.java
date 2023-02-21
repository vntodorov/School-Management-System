package com.iStudent.model.validation;

import com.iStudent.model.DTOs.TownDTO;
import com.iStudent.model.entity.Town;
import com.iStudent.repository.TownRepository;
import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;

public class ValidTownValidator implements ConstraintValidator<ValidTown, TownDTO> {

    private final TownRepository townRepository;

    @Autowired
    public ValidTownValidator(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public boolean isValid(TownDTO town, ConstraintValidatorContext context) {
        return
                townRepository
                        .findById(town.getId())
                        .isPresent();
    }
}
