package com.tss.__jpa.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class EmployeeResponseDto {

    private String name;
    private Long id;
}
