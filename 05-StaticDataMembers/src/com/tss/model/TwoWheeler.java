package com.tss.model;

public class TwoWheeler extends Vehicle{

    private int milage;

    public TwoWheeler(String name, double price, String company, int milage) {
        super(name, price, company);
        this.milage = milage;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public String toString() {
        return "TwoWheeler Details:\n" +
                "Name: " + getName() + "\n"+
                "Company: " + getName() + "\n"+
                "Price: " + getPrice() + "\n"+
                "milage=" + milage;
    }
}
