package com.tss.model;

public class StudentValidator
{
    public void validateStudent(StudentEnrollment enrollment)
    {
        if(enrollment.getStudentName() == null || enrollment.getCourseName().isBlank())
            throw new IllegalArgumentException("Student name can not ne empty");

        if(enrollment.getEmail() == null || !enrollment.getEmail().contains("@"))
            throw new IllegalArgumentException("Invalid email address");

        if(enrollment.getAge() < 16)
            throw new IllegalArgumentException("Student age must be grater than 16");
    }
}
