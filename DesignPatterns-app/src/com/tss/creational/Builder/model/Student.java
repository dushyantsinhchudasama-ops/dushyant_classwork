package com.tss.creational.Builder.model;

public class Student {

    private String name;
    private String id;
    private String email;
    private int age;

    public Student(int age, String email, String id, String name) {
        this.age = age;
        this.email = email;
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student {" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
