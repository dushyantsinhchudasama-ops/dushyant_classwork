package com.tss.structural.Adapter.model;

public class Biscuit implements IItems {

    String name;
    double price;

    public Biscuit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
