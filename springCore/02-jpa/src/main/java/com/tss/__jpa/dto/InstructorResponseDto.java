package com.tss.__jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorResponseDto {

    private Long instructorId;
    private String name;
    private String qualification;
}
