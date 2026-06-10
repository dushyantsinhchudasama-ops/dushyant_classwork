package com.tss.model;

public class Vehicle {

    private String name;
    private String company;
    private double price;

    public Vehicle(String name, double price, String company) {
        this.name = name;
        this.price = price;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
