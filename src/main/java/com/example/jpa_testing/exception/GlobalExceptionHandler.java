package com.example.jpa_testing.exception;

import com.example.jpa_testing.dto.validation.ErrorResponse;
import com.example.jpa_testing.dto.validation.FieldError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        List<FieldError> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(e -> new FieldError(e.getField(), e.getDefaultMessage(), e.getRejectedValue()))
                .toList();

        return ResponseEntity.badRequest()
                .body(new ErrorResponse(400, "Validation Failed", errors.toString()));
    }
}
