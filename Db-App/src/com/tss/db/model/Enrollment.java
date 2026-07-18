package com.tss.db.model;

import java.sql.Date;

public class Enrollment {

    private int enrollmentId;
    private int studentId;
    private String courseCode;
    private Date enrollmentDate;
    private String status;
    private String studentName;
    private String courseName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Enrollment() {
    }

    public Enrollment(int studentId, String courseCode) {
        this.studentId = studentId;
        this.courseCode = courseCode;
    }

    public Enrollment(int studentId, String courseCode, String status) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.status = status;
    }

    public Enrollment(int enrollmentId, int studentId, String courseCode,
                      Date enrollmentDate, String status) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getcourseCode() {
        return courseCode;
    }

    public void setcourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}