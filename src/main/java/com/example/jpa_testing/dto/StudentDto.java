package com.example.jpa_testing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    @JsonProperty("email_address")
    private String email;
}
