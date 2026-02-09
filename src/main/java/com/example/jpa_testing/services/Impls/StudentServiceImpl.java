package com.example.jpa_testing.services.Impls;

import com.example.jpa_testing.dto.Pagination;
import com.example.jpa_testing.dto.StudentListDto;
import com.example.jpa_testing.entity.Student;
import com.example.jpa_testing.mapper.StudentMapper;
import com.example.jpa_testing.repository.StudentRepository;
import com.example.jpa_testing.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentListDto> getAllStudents(Pagination pagination) {
        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getSize(), Sort.by("id").descending());

        Page<Student> students = studentRepository.findAll(pageable);
        List<Student> studentsList = students.getContent();

        pagination.setTotal(students.getTotalElements());
        pagination.setTotalPages(students.getTotalPages());

        List<StudentListDto> dos = new ArrayList<>();
        for (Student student : studentsList) {
            StudentListDto dto = studentMapper.toStudentListDto(student);
            dos.add(dto);
        }
        return dos;
    }

    @Override
    public Optional<Student> getStudentById(Long id) {

        return Optional.empty();
    }
}
