package com.tss.__jpa.services;

import com.tss.__jpa.dto.EmployeeRequestDto;
import com.tss.__jpa.dto.EmployeeResponseDto;
import com.tss.__jpa.entity.Employee;
import com.tss.__jpa.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeResponseDto> readAll();

    public Employee getById(Long id);

    EmployeeResponseDto addEmployee(EmployeeRequestDto requestDto);
}
