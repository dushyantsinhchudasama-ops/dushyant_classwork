package com.tss.emp.service.employee_service.dto;


import lombok.Data;

@Data
public class EmployeeRequestDto {

    private String employeeName;
    private Double salary;
    private Long departmentNo;
}
