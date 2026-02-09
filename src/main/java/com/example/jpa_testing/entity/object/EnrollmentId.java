package com.example.jpa_testing.entity.object;

import com.example.jpa_testing.entity.Enrollment;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EnrollmentId implements Serializable {
    private Long studentId;
    private Long courseId;

    public EnrollmentId() {}

    public EnrollmentId(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
}
