package com.tss.__jpa.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class StudentRequestDto {

    private String name;
    private Integer age;
}
