package com.tss.model;

public class FeeCalculator {

    public double calculateFee(String courseType) {

        switch (courseType.toUpperCase()) {

            case "BASIC":
                return 5000;

            case "ADVANCED":
                return 10000;

            case "PRO":
                return 15000;

            default:
                return 0;
        }
    }
}