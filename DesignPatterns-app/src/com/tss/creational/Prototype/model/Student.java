package com.tss.creational.Prototype.model;

public class Student {

    String name;
    String id;
    String email;
    int age;

    public Student(int age, String email, String id, String name) {
        this.age = age;
        this.email = email;
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
