package com.example.jpa_testing.entity;

import com.example.jpa_testing.entity.object.EnrollmentId;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Enrollment {

    @EmbeddedId
    private EnrollmentId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalDateTime enrollmentDate;
    private String grade;
}

