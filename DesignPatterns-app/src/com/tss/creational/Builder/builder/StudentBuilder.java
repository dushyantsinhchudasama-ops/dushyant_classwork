package com.tss.creational.Builder.builder;

import com.tss.creational.Builder.model.Student;

public class StudentBuilder {

    private String name;
    private String id;
    private String email;
    private int age;

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public StudentBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Student build()
    {
        return new Student(age, email, id, name);
    }
}
