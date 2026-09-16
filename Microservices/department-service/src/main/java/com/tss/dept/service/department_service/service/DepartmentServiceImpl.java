package com.tss.dept.service.department_service.service;

import com.tss.dept.service.department_service.dto.DepartmentRequestDto;
import com.tss.dept.service.department_service.dto.DepartmentResponseDto;
import com.tss.dept.service.department_service.entity.Department;
import com.tss.dept.service.department_service.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentResponseDto> getall() {

        return departmentRepository.findAll()
                    .stream()
                    .map(
                department -> new DepartmentResponseDto(
                        department.getId(),
                        department.getName()
                            )
                    ).toList();
    }

    @Override
    public DepartmentResponseDto getDepartmentById(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found")
                );

        return new DepartmentResponseDto(
                department.getId(),
                department.getName()
        );
    }

    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto requestDto) {

        Department department = new Department();

        department.setName(requestDto.getName());

        Department savedDepartment = departmentRepository.save(department);

        DepartmentResponseDto responseDto = new DepartmentResponseDto();

        responseDto.setId(savedDepartment.getId());
        responseDto.setName(savedDepartment.getName());

        return responseDto;
    }

}
