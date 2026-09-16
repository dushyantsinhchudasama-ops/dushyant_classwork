package com.tss.dept.service.department_service.service;

import com.tss.dept.service.department_service.dto.DepartmentRequestDto;
import com.tss.dept.service.department_service.dto.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {

    List<DepartmentResponseDto> getall();
    DepartmentResponseDto getDepartmentById(Long id);
    DepartmentResponseDto createDepartment(DepartmentRequestDto requestDto);
}
