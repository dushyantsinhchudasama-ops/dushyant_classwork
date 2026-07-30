package com.tss.__jpa.mapper;

import com.tss.__jpa.dto.AddressRequestDto;
import com.tss.__jpa.dto.AddressResponseDto;
import com.tss.__jpa.dto.StudentRequestDto;
import com.tss.__jpa.dto.StudentResponseDto;
import com.tss.__jpa.entity.Address;
import com.tss.__jpa.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toStudentDto(StudentRequestDto requestDto);

    StudentResponseDto responseDtoToStudent(Student student);

    //methods for addresses

    AddressResponseDto addressToResponseDto(Address address);

    Address requestDtoToAddress(AddressRequestDto dto);
}
