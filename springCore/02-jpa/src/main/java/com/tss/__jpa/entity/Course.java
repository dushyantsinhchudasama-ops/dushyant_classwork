package com.tss.__jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Collate;

@Entity
@Table(name = "courses")
@Data
public class Course {

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    @Column(name = "name")
    private String courseName;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "fees")
    private Double fees;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
}
