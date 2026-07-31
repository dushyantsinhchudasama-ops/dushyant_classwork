package com.tss.__jpa.services;

import com.tss.__jpa.dto.CourseRequestDto;
import com.tss.__jpa.dto.CourseResponseDto;
import com.tss.__jpa.dto.InstructorResponseDto;
import com.tss.__jpa.dto.StudentResponseDto;

import java.util.List;

public interface CourseService {

    CourseResponseDto addCourse(CourseRequestDto requestDto);

    void assignInstructure(Long courseId, Long instructureId);

    InstructorResponseDto getCourse(Long courseId);

    List<CourseResponseDto> readAll();

    void assignStudent(Long courseId, Long studentId);

    List<StudentResponseDto> getAllStudentsByID(Long courseId);
}
