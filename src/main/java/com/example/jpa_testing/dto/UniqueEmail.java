package com.example.jpa_testing.dto;

import jakarta.validation.Constraint;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
public @interface UniqueEmail {
    String message() default "Email already exists";
    Class<?> [] groups() default {};
    Class<?> [] rejectedValues() default {};
}
