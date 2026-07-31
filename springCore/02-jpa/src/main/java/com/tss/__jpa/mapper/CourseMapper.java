package com.tss.__jpa.mapper;

import com.tss.__jpa.dto.CourseRequestDto;
import com.tss.__jpa.dto.CourseResponseDto;
import com.tss.__jpa.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toEntity(CourseRequestDto requestDto);

    CourseResponseDto toDto(Course course);
}
