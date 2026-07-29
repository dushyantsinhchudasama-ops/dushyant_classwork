package com.tss.__jpa.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class EmployeeRequestDto {

    @NotBlank(message = "Employee name is required")
    @Size(min = 3, max = 50, message = "Name must contain 3 to 50 characters")
    private String name;

//    @Positive(message = "Age must be a positive value")
    @Min(value = 18, message = "Employee age cannot be less than 18")
    @Max(value = 60, message = "Employee age cannot exceed 60")
    private Integer age;

}
