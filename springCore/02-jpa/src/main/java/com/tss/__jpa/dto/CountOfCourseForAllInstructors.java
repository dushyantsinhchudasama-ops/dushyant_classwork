package com.tss.__jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CountOfCourseForAllInstructors {

    private String name;
    private Long courseCount;
}
