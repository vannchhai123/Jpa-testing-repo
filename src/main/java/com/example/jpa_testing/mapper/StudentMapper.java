package com.example.jpa_testing.mapper;

import com.example.jpa_testing.dto.NewStudentRequestDto;
import com.example.jpa_testing.dto.StudentDto;
import com.example.jpa_testing.dto.StudentListDto;
import com.example.jpa_testing.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {

    StudentListDto toStudentListDto(Student model);
    StudentDto toStudentDto(Student model);

    @Mapping(target = "id", ignore = true)
    Student toStudentModel(NewStudentRequestDto dto);
}
