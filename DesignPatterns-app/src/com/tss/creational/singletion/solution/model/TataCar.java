package com.tss.creational.singletion.solution.model;

public class TataCar extends Car{

    public TataCar(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "TataCar{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
