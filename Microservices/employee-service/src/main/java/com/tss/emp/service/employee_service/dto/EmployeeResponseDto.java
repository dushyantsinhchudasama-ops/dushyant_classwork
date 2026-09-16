package com.tss.emp.service.employee_service.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDto {

    private Long employeeId;
    private String employeeName;
    private Double salary;
    private Long departmentNo;
}
