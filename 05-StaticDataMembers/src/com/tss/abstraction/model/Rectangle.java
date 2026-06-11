package com.tss.abstraction.model;

public class Rectangle implements Shape{

    private int width;
    private int bridth;

    public Rectangle(int width, int bridth) {
        this.width = width;
        this.bridth = bridth;
    }


    @Override
    public void calculateArea() {
        System.out.println("Area of Rectangle is: " + (width * bridth));
    }
}
