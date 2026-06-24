package com.tss.creational.Factory.model;

public class HyundaiCar extends Car {


    public HyundaiCar(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "HyundaiCar{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
