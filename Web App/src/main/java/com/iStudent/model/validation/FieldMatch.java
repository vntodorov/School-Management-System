package com.iStudent.model.validation;

import javax.validation.*;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = FieldMatchValidator.class)
public @interface FieldMatch {

    String first();

    String second();

    String message() default "Passwords should match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
