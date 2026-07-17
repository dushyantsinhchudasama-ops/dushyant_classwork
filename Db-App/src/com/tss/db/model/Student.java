package com.tss.db.model;

public class Student {

    private int student_id;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public Student(int student_id, String name, int age) {
        this.age = age;
        this.name = name;
        this.student_id = student_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
}
