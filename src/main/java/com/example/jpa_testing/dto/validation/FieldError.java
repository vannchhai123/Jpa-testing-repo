package com.example.jpa_testing.dto.validation;

public record FieldError(
        String field,
        String message,
        Object rejectedValue
) {}