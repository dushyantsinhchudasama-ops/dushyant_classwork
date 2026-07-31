package com.tss.__jpa.mapper;

import com.tss.__jpa.dto.InstructorRequestDto;
import com.tss.__jpa.dto.InstructorResponseDto;
import com.tss.__jpa.entity.Instructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorMapper {

    Instructor toEntity(InstructorRequestDto requestDto);

    InstructorResponseDto toDto(Instructor instructor);
}
