package com.tss.__jpa.services;

import com.tss.__jpa.dto.EmployeeRequestDto;
import com.tss.__jpa.dto.EmployeeResponseDto;
import com.tss.__jpa.dto.PageResponseDto;
import com.tss.__jpa.dto.StudentResponseDto;
import com.tss.__jpa.entity.Employee;
import com.tss.__jpa.entity.Student;
import com.tss.__jpa.exception.EmployeeNotFoundByIDException;
import com.tss.__jpa.mapper.EmployeeMapper;
import com.tss.__jpa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

//    @Override
//    public List<EmployeeResponseDto> readAll() {
//
//        List<Employee> employees = employeeRepository.findAll();
//        List<EmployeeResponseDto> response = new ArrayList<>();
//
//        for(Employee employee : employees)
//        {
//            EmployeeResponseDto dto = new EmployeeResponseDto();
//            dto.setId(employee.getId());
//            dto.setName(employee.getName());
//
//            response.add(dto);
//        }
//        return response;
//    }

    //using pagination

    @Override
    public PageResponseDto<EmployeeResponseDto> readAll(int page, int size) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by("id").ascending());

        Page<Employee> employeePage = employeeRepository.findAll(pageable);

        PageResponseDto<EmployeeResponseDto> response = new PageResponseDto<>();

        response.setContent(
                employeePage.getContent()
                        .stream()
                        .map(employeeMapper::responsetoEmployee)
                        .toList()
        );

        response.setPageNumber(employeePage.getNumber());
        response.setPageSize(employeePage.getSize());
        response.setTotalElements(employeePage.getTotalElements());
        response.setTotalPages(employeePage.getTotalPages());
        response.setFirst(employeePage.isFirst());
        response.setLast(employeePage.isLast());
        response.setHasNext(employeePage.hasNext());
        response.setHasPrevious(employeePage.hasPrevious());

        return response;
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundByIDException(id)
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

        logger.info("Employee added successfully with id: {}", result.getId());

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
