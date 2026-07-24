package com.tss.__jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.SpringApplicationEvent;

@RequiredArgsConstructor
@Data
@Entity(name = "student")
public class Student {

    @Id
    @Column(name = "Student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_age")
    private Integer age;

}
