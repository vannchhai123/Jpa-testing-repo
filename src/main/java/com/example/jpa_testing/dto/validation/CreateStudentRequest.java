package com.example.jpa_testing.dto.validation;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record CreateStudentRequest(
        @Past(message = "Birth date must be in the past")
        LocalDateTime birthDate,

        @Min(value = 0) @Max(value = 4)
        @Digits(integer = 1, fraction = 2)
        BigDecimal gpa,

        @Positive(message = "Department ID must be positive")
        Long departmentId,

        @Size(max = 5, message = "Maximum 5 course allowed")
        List<@Positive Long> courseIds
) {}
