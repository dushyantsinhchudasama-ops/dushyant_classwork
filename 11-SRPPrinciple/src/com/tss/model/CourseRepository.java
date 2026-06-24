package com.tss.model;

import java.util.List;

public class CourseRepository {

    public List<Course> getCourses() {

        return List.of(
                new Course("Java", 5),
                new Course("Python", 0),
                new Course("Spring", 10),
                new Course("Full Stack using Java",3)
        );
    }
}