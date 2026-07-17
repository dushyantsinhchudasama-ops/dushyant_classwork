package com.tss.model;

public class Student {

    private IStudent student;

    public Student(IStudent student) {
        this.student = student;
    }

    public double calculateAverage()
    {
        return student.getMarks() / student.getSubjects();
    }
}
