package com.example.jpa_testing.repository;

import com.example.jpa_testing.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

    List<Enrollment> findTop5ByOrderByEnrollmentDateDesc();

    @Query("""
        SELECT DISTINCT e.student
        FROM Enrollment e
        WHERE e.enrollmentDate > :date
        """)
    List<Enrollment> findStudentsEnrolledAfter(@Param("date") LocalDateTime date);
}
