package com.example.jpa_testing.services;

import com.example.jpa_testing.dto.Pagination;
import com.example.jpa_testing.dto.StudentListDto;
import com.example.jpa_testing.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<StudentListDto> getAllStudents(Pagination pagination);

    Optional<Student> getStudentById(Long id);
}
