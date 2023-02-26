package com.iStudent.model.validation;

import com.iStudent.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueClubNameValidator implements ConstraintValidator<UniqueClubName, String> {

    private final ClubRepository clubRepository;

    @Autowired
    public UniqueClubNameValidator(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public boolean isValid(String clubName, ConstraintValidatorContext context) {
        return clubRepository.
                findByName(clubName).
                isEmpty();
    }
}
