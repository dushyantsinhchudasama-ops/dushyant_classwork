package com.tss.__jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDto {

    private Long courseId;
    private String courseName;
    private Integer duration;
    private Double fees;
}
