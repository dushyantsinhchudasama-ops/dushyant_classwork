package com.tss.structural.Adapter.model;

public class Hat {

    String shortName;
    String LongName;
    double basePrice;
    double tax;

    public Hat(double basePrice, String longName, String shortName, double tax) {
        this.basePrice = basePrice;
        LongName = longName;
        this.shortName = shortName;
        this.tax = tax;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getLongName() {
        return LongName;
    }

    public String getShortName() {
        return shortName;
    }

    public double getTax() {
        return tax;
    }
}
