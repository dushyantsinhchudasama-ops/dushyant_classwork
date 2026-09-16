package com.tss.dept.service.department_service.repository;

import com.tss.dept.service.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
