package com.example.jpa_testing.seeds;

import com.example.jpa_testing.entity.Department;
import com.example.jpa_testing.entity.Student;
import com.example.jpa_testing.repository.DepartmentRepository;
import com.example.jpa_testing.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("dev")
@RequiredArgsConstructor
public class LoadData implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {
        Department department = Department.builder().name("IT").build();

        department = departmentRepository.save(department);

        Student john = Student
                .builder()
                .email("John@gmail.com")
                .firstName("John")
                .lastName("Doe")
                .department(department)
                .build();
        Student kimheang = Student
                .builder()
                .email("kimheang@gmail.com")
                .firstName("Kim")
                .lastName("heang")
                .department(department)
                .build();
        Student masterly = Student
                .builder()
                .email("masterly@gmail.com")
                .firstName("Master")
                .lastName("Ly")
                .department(department)
                .build();
        studentRepository.saveAll(List.of(john, kimheang, masterly));
    }
}
