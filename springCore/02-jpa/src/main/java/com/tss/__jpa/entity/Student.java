package com.tss.__jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.SpringApplicationEvent;

import java.util.List;

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

    //this is for address storing
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany
    @JoinTable(name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id") )
    List<Course> courses;
}
