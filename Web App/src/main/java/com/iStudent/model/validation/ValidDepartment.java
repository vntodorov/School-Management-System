package com.iStudent.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = DepartmentValidator.class)
public @interface ValidDepartment {

    String message() default "Invalid Department";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
