package com.tss.model;

public class StudentEnrollment {

    private String studentName;
    private String email;
    private int age;

    private String courseName;
    private String courseType;

    private boolean scholarship;

    public StudentEnrollment(String studentName,
                             String email,
                             int age,
                             String courseName,
                             String courseType,
                             boolean scholarship) {

        this.studentName = studentName;
        this.email = email;
        this.age = age;
        this.courseName = courseName;
        this.courseType = courseType;
        this.scholarship = scholarship;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public boolean isScholarship() {
        return scholarship;
    }
}