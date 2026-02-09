package com.example.jpa_testing.dto.validation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 100, message = "Password must be 8-100 character")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",
                message = "Password must contain uppercase, lowercase, and number"
        )
        String password,

        @NotBlank(message = "First name is required")
        @Size(min = 1, max = 50, message = "First name must be 1-50 characters")
        String firstName,

        @NotBlank(message = "Last name is required")
        @Size(min = 1, max = 50, message = "Last name must be 1-50 characters")
        String lastName
) {}
