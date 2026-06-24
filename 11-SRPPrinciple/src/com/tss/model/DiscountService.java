package com.tss.model;

public class DiscountService {

    public double applyDiscount(double fee, boolean scholarship) {

        if (scholarship) {
            return fee * 0.8;
        }

        return fee;
    }
}