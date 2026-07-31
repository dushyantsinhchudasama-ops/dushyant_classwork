package com.tss.__jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "instructor")
@Data
public class Instructor {

    @Column(name = "instructor_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;
    @Column(name = "name")
    private String name;
    @Column(name = "qualification")
    private String qualification;

    @OneToMany(mappedBy = "instructor", cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH})
    private List<Course> courses;
}
