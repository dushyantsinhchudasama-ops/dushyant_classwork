package com.tss.__jpa.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class StudentResponseDto {

    private String name;
    private Long id;
}
