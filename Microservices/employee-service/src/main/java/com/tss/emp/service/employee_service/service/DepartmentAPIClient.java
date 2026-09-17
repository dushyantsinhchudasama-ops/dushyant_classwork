package com.tss.emp.service.employee_service.service;

import com.tss.emp.service.employee_service.dto.DeptDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-service")
public interface DepartmentAPIClient {

    @GetMapping("api/dept/{id}")
    public DeptDto getDepartment(@PathVariable Long id);

}
