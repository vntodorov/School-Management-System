package com.iStudent.model.validation;

import com.iStudent.model.entity.enums.Gender;
import javax.validation.*;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = ValidGenderValidator.class)
public @interface ValidGender {
    Gender[] anyOf();

    String message() default "Invalid Gender";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
