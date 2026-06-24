package com.tss.model;
public class CourseValidator {

    private CourseRepository repository;

    public CourseValidator(CourseRepository repository) {
        this.repository = repository;
    }

    public boolean courseExists(String courseName) {

        return repository.getCourses()
                .stream()
                .anyMatch(course ->
                        course.getName().equals(courseName));
    }

    public boolean seatsAvailable(String courseName) {

        return repository.getCourses()
                .stream()
                .filter(course ->
                        course.getName().equals(courseName))
                .findFirst()
                .map(course ->
                        course.getAvailableSeats() > 0)
                .orElse(false);
    }
}