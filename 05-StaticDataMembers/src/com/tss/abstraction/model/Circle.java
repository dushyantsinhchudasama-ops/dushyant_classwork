package com.tss.abstraction.model;

public class Circle implements Shape{

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        System.out.println("Area of Circle is: " + (3.14 * radius * radius));
    }
}
