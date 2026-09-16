package com.tss.emp.service.employee_service.service;

import com.tss.emp.service.employee_service.dto.ApiResponse;
import com.tss.emp.service.employee_service.dto.EmployeeRequestDto;
import com.tss.emp.service.employee_service.dto.EmployeeResponseDto;

import java.util.List;


public interface EmployeeService {

    EmployeeResponseDto createEmployee(EmployeeRequestDto request);
    List<EmployeeResponseDto> getAllEmployees();
    EmployeeResponseDto getEmployeeById(Long id);
    ApiResponse getEmployeeWithDepartment(Long id);

    EmployeeResponseDto updateEmpDept(Long id, Long deptId);
}
