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
        if(email == null) {
            return !userRepository.existsByEmail(email);
        }
    }
}
