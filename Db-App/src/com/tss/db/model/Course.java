package com.tss.db.model;

public class Course {

    private String course_name;
    private String course_code;
    private String description;
    private int duration_months;
    private int max_students;

    public Course() {
    }

    public Course(String course_code, String course_name, String description, int duration_months, int max_students) {
        this.course_code = course_code;
        this.course_name = course_name;
        this.description = description;
        this.duration_months = duration_months;
        this.max_students = max_students;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration_months() {
        return duration_months;
    }

    public void setDuration_months(int duration_months) {
        this.duration_months = duration_months;
    }

    public int getMax_students() {
        return max_students;
    }

    public void setMax_students(int max_students) {
        this.max_students = max_students;
    }
}
