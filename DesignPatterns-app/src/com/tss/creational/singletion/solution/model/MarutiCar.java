package com.tss.creational.singletion.solution.model;

public class MarutiCar extends Car{


    public MarutiCar(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "MarutiCar{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
