package com.tss.emp.service.employee_service.service;

import com.tss.emp.service.employee_service.dto.ApiResponse;
import com.tss.emp.service.employee_service.dto.DeptDto;
import com.tss.emp.service.employee_service.dto.EmployeeRequestDto;
import com.tss.emp.service.employee_service.dto.EmployeeResponseDto;
import com.tss.emp.service.employee_service.entity.Employee;
import com.tss.emp.service.employee_service.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;
    private final WebClient webClient;

    public EmployeeResponseDto createEmployee(EmployeeRequestDto request) {

        Employee employee = new Employee();

        employee.setEmployeeName(request.getEmployeeName());
        employee.setSalary(request.getSalary());
        employee.setDepartmentNo(request.getDepartmentNo());

        Employee savedEmployee = employeeRepository.save(employee);

        return new EmployeeResponseDto(
                savedEmployee.getEmployeeId(),
                savedEmployee.getEmployeeName(),
                savedEmployee.getSalary(),
                savedEmployee.getDepartmentNo());
    }

    public List<EmployeeResponseDto> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(
                        employee -> new EmployeeResponseDto(
                                employee.getEmployeeId(),
                                employee.getEmployeeName(),
                                employee.getSalary(),
                                employee.getDepartmentNo()
                        )
                )
                .toList();
    }

    public EmployeeResponseDto getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found")
                );

        return new EmployeeResponseDto(employee.getEmployeeId(),
                employee.getEmployeeName(),
                employee.getSalary(),
                employee.getDepartmentNo());
    }

    @Override
    public ApiResponse getEmployeeWithDepartment(Long id) {

        EmployeeResponseDto employee = getEmployeeById(id);

        //following is for getting through rest template

        //ResponseEntity<DeptDto> entity = restTemplate.getForEntity("http://localhost:8080/api/dept/" + employee.getDepartmentNo(), DeptDto.class);

       // DeptDto dto = entity.getBody();

        //following is for getting using web client (web flux)

        DeptDto dto = webClient.get()
                .uri("http://localhost:8080/api/dept/" + employee.getDepartmentNo())
                .retrieve()
                .bodyToMono(DeptDto.class)
                .block(); //use this when we want to use asynchronous

        return new ApiResponse(employee, dto);
    }

}