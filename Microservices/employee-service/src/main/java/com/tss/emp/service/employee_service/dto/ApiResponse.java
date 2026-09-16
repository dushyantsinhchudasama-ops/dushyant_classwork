package com.tss.emp.service.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiResponse {

    private EmployeeResponseDto employee;
    private DeptDto deptDto;
}
