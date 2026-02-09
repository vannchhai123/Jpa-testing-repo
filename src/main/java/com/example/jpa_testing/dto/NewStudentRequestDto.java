package com.example.jpa_testing.dto;

import lombok.Data;

@Data
public class NewStudentRequestDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
