package com.tss.__jpa.services;

import com.tss.__jpa.dto.CountOfCourseForAllInstructors;
import com.tss.__jpa.dto.CourseResponseDto;
import com.tss.__jpa.dto.InstructorRequestDto;
import com.tss.__jpa.dto.InstructorResponseDto;

import java.util.List;

public interface InstructorService {

    InstructorResponseDto addInstructor(InstructorRequestDto requestDto);

    void assignCourse(Long instructorId, Long courseId);

    List<CourseResponseDto> getCourse(Long instructorId);

    List<InstructorResponseDto> readAll();

    Integer getCourseCount(Long instructorId);

    List<CountOfCourseForAllInstructors> getCourseCountPerInstructor();
}
