package com.tss.dept.service.department_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DeptConfig {

    @Value("${spring.cloud.message}")
    private String message;

    public String getMessage()
    {
        return message;
    }
}
