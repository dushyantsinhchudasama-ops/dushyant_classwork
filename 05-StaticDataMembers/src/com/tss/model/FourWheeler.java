package com.tss.model;

public class FourWheeler extends Vehicle{

    private int noOfSeats;

    public FourWheeler(String name, double price, String company, int noOfSeats) {
        super(name, price, company);
        this.noOfSeats = noOfSeats;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public String toString() {
        return "Four Wheeler Details:\n" +
                "Name: " + getName() + "\n"+
                "Company: " + getName() + "\n"+
                "Price: " + getPrice() + "\n"+
                "Total Seats: " + noOfSeats;
    }
}
