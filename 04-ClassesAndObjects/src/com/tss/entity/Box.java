package com.tss.entity;

public class Box {

    private double height;
    private double width;
    private double depth;

    //creting constructors

    public Box(){
        width = 100;
        height = 200;
        depth = 300;
    }

    //parameterized constructor
    public Box(double height, double width, double depth)
    {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    //gettes and setters methods

    public void setWidth(double width){
        this.width = width;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public void setDepth(double depth){
        this.depth = depth;
    }

    public double getHeight(){ return height;}
    public double getWidth(){ return width;}
    public double getDepth(){ return depth;}

//    public void intializeValue()
//    {
//        height = 10;
//        width = 20;
//        depth = 30;
//    }

//    public double calculateArea()
//    {
//        return height * width * depth;
//    }
//
//    public void printDetails(){
//        System.out.println("Height: " + height);
//        System.out.println("Width: " + width);
//        System.out.println("Depth: " + depth);
//
//    }
}
