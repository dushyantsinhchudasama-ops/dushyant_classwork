package com.tss.__jpa.services;


import com.tss.__jpa.dto.PageResponseDto;
import com.tss.__jpa.dto.StudentRequestDto;
import com.tss.__jpa.dto.StudentResponseDto;
import com.tss.__jpa.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    //this is without pagination
    //public List<StudentResponseDto> readAll();

    //for using pagination
    PageResponseDto<StudentResponseDto> readAll(int page, int size);

    public Student getById(Long id);

    StudentResponseDto addStudent(StudentRequestDto requestDto);

    PageResponseDto<StudentResponseDto> findStudentByName(int page, int size, String name);

    Integer deleteByAge(Integer age);
}
