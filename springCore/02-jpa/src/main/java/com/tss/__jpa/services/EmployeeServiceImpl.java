package com.tss.__jpa.services;

import com.tss.__jpa.dto.EmployeeRequestDto;
import com.tss.__jpa.dto.EmployeeResponseDto;
import com.tss.__jpa.entity.Employee;
import com.tss.__jpa.mapper.EmployeeMapper;
import com.tss.__jpa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeResponseDto> readAll() {

        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponseDto> response = new ArrayList<>();

        for(Employee employee : employees)
        {
            EmployeeResponseDto dto = new EmployeeResponseDto();
            dto.setId(employee.getId());
            dto.setName(employee.getName());

            response.add(dto);
        }
        return response;
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("ID Does not found!")
        );
    }

    @Override
    public EmployeeResponseDto addEmployee(EmployeeRequestDto requestDto) {

//        Employee employee = new Employee();
//        employee.setName(requestDto.getName());
//        employee.setAge(requestDto.getAge());

        Employee employee = employeeMapper.toEmployeeDto(requestDto);

       Employee result = employeeRepository.save(employee);

//       EmployeeResponseDto response = new EmployeeResponseDto();
//       response.setId(result.getId());
//       response.setName(result.getName());

       return employeeMapper.responsetoEmployee(result);
    }


    //mapping methods
    private Employee employeeRequestDtotoEmployee(EmployeeRequestDto dto)
    {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setAge(dto.getAge());

        return employee;
    }

    private EmployeeResponseDto employeetoResponseDto(Employee employee)
    {
        EmployeeResponseDto responseDto = new EmployeeResponseDto();
        responseDto.setName(employee.getName());
        responseDto.setId(employee.getId());

        return responseDto;
    }

}
