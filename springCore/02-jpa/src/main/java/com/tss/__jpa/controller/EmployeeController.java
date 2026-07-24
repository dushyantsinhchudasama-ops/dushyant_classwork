package com.tss.__jpa.controller;

import com.tss.__jpa.dto.EmployeeRequestDto;
import com.tss.__jpa.dto.EmployeeResponseDto;
import com.tss.__jpa.entity.Employee;
import com.tss.__jpa.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeResponseDto>> getAll()
    {
        return new ResponseEntity<>(employeeService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public Employee getByID(@PathVariable Long id)
    {
        return employeeService.getById(id);
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeResponseDto> addEmployee(@RequestBody EmployeeRequestDto requestDto)
    {
        return new ResponseEntity<>(employeeService.addEmployee(requestDto), HttpStatus.CREATED);
    }

}
