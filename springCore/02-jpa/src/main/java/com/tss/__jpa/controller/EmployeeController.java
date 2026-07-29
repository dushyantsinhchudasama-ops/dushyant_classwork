package com.tss.__jpa.controller;

import com.tss.__jpa.dto.EmployeeRequestDto;
import com.tss.__jpa.dto.EmployeeResponseDto;
import com.tss.__jpa.dto.PageResponseDto;
import com.tss.__jpa.dto.StudentResponseDto;
import com.tss.__jpa.entity.Employee;
import com.tss.__jpa.services.EmployeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
@Validated
public class EmployeeController {

    private final EmployeeService employeeService;

    //this was without pagination

//    @GetMapping("/employees")
//    public ResponseEntity<List<EmployeeResponseDto>> getAll()
//    {
//        return new ResponseEntity<>(employeeService.readAll(), HttpStatus.OK);
//    }

    //this will be with pagination

    @GetMapping("/employees")
    public ResponseEntity<PageResponseDto<EmployeeResponseDto>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1") int size) {

        return ResponseEntity.ok(employeeService.readAll(page, size));
    }

    @GetMapping("/employee/{id}")
    public Employee getByID(@Positive(message = "Id Must be a positive value") @PathVariable Long id)
    {
        return employeeService.getById(id);
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeResponseDto> addEmployee(@Valid @RequestBody EmployeeRequestDto requestDto)
    {
        return new ResponseEntity<>(employeeService.addEmployee(requestDto), HttpStatus.CREATED);
    }

}
