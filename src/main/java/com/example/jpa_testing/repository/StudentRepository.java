package com.example.jpa_testing.repository;

import com.example.jpa_testing.entity.Enrollment;
import com.example.jpa_testing.entity.enums.StudentStatus;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa_testing.entity.Student;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

//    Page<Student> pagination(Pageable pageable);

    Optional<Student> findByEmail(String email);

    Optional<StudentStatus> findByStatus(StudentStatus status);

    Optional<Student> findByDepartmentId(Long departmentId);

    List<StudentStatus> countByStatus(StudentStatus status);
}
