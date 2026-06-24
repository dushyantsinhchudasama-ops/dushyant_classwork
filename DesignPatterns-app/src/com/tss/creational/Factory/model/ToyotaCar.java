package com.tss.creational.Factory.model;

public class ToyotaCar extends Car {


    public ToyotaCar(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Toyota Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
