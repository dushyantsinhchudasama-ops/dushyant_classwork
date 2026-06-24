package com.tss.model;

public class Course {

    private String name;
    private int availableSeats;

    public Course(String name, int availableSeats) {
        this.name = name;
        this.availableSeats = 2;
    }

    public String getName() {
        return name;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}