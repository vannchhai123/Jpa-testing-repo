package com.example.jpa_testing.controllers;

import com.example.jpa_testing.dto.Pagination;
import com.example.jpa_testing.dto.PaginationResponse;
import com.example.jpa_testing.dto.StudentListDto;
import com.example.jpa_testing.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<PaginationResponse<StudentListDto>> getStudents(Pagination pagination) {
        PaginationResponse<StudentListDto> response = new PaginationResponse<>();
        response.setData(studentService.getAllStudents(pagination));
        response.setPagination(pagination);
        return ResponseEntity.ok(response);
    }
}
