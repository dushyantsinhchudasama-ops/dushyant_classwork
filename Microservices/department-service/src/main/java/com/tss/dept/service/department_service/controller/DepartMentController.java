package com.tss.dept.service.department_service.controller;


import com.tss.dept.service.department_service.dto.DepartmentRequestDto;
import com.tss.dept.service.department_service.dto.DepartmentResponseDto;
import com.tss.dept.service.department_service.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dept")
@RequiredArgsConstructor
public class DepartMentController {

    private final DepartmentService departmentService;

    @GetMapping("/all")
    public ResponseEntity<List<DepartmentResponseDto>> getall()
    {
        return ResponseEntity.ok(departmentService.getall());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> getById(@PathVariable Long id) {

        System.out.println("Department controller called with id = " + id);


        return ResponseEntity.ok(
                departmentService.getDepartmentById(id)
        );
    }

    @PostMapping("/add")
    public ResponseEntity<DepartmentResponseDto> createDepartment(@RequestBody DepartmentRequestDto request)
    {
       return ResponseEntity.ok(departmentService.createDepartment(request));
    }
}
