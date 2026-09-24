package com.tss.emp.service.employee_service.controller;

import com.tss.emp.service.employee_service.dto.ApiResponse;
import com.tss.emp.service.employee_service.dto.EmployeeRequestDto;
import com.tss.emp.service.employee_service.dto.EmployeeResponseDto;
import com.tss.emp.service.employee_service.dto.UpdateDeptReqDto;
import com.tss.emp.service.employee_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeRequestDto request) {

        return ResponseEntity.ok(employeeService.createEmployee(request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResponseDto>> getAll() {

        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("oe/{id}")
    public ResponseEntity<EmployeeResponseDto> getById(@PathVariable Long id) {

        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getEmployeeWithDept(@PathVariable Long id)
    {
        return ResponseEntity.ok(employeeService.getEmployeeWithDepartment(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmpDept(@PathVariable Long id, @RequestBody UpdateDeptReqDto request) {

        return ResponseEntity.ok(employeeService.updateEmpDept(id,request.getDeptId()));
    }
}
