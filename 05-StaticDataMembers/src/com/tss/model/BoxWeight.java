package com.tss.model;

public class BoxWeight extends Box {

    private double weight;

    public BoxWeight(double width, double height, double depth, double weight) {
        super(width, height, depth);
        this.weight= weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String toString() {
        return "Box Details : {" +
                "height=" + getHeight() +
                "width=" + getWidth() +
                "depth=" + getDepth() +
                "weight=" + weight +
                '}';
    }

    public void show()
    {
        System.out.println("From BoxWeight show");
    }

}
