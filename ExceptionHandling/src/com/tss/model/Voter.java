package com.tss.model;

import com.tss.exception.AgeInvalidException;

public class Voter {

    private String name;
    private long id;
    private int age;

    public Voter(String name, long id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
        if(age < 18)
            throw new AgeInvalidException(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<18)
            throw new AgeInvalidException(age);
        this.age = age;
    }
}
