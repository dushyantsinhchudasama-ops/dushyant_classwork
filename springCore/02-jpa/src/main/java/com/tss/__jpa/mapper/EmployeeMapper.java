package com.tss.__jpa.mapper;

import com.tss.__jpa.dto.EmployeeRequestDto;
import com.tss.__jpa.dto.EmployeeResponseDto;
import com.tss.__jpa.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEmployeeDto(EmployeeRequestDto requestDto);

    EmployeeResponseDto responsetoEmployee(Employee employee);
}
