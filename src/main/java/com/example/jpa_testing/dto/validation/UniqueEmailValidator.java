package com.example.jpa_testing.dto.validation;

import com.example.jpa_testing.dto.UniqueEmail;
import com.example.jpa_testing.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        // If email is null, consider it valid (or handle differently)
        if (email == null || email.isEmpty()) {
            return true;
        }

        // Return true if email is unique (does NOT exist)
        return !userRepository.existsByEmail(email);
    }
}

