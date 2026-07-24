package com.tss.__jpa.services;


import com.tss.__jpa.dto.StudentRequestDto;
import com.tss.__jpa.dto.StudentResponseDto;
import com.tss.__jpa.entity.Student;

import java.util.List;

public interface StudentService {

    public List<StudentResponseDto> readAll();

    public Student getById(Long id);

    StudentResponseDto addStudent(StudentRequestDto requestDto);
}
