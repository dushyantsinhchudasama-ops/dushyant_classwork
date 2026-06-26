package com.tss.structural.Adapter.adapter;

import com.tss.structural.Adapter.model.Hat;
import com.tss.structural.Adapter.model.IItems;

public class HatAdapter implements IItems
{

    private Hat hat;

    public HatAdapter(Hat hat) {
        this.hat = hat;
    }

    String hatName = hat.getShortName() + hat.getLongName();

    double tax = hat.getTax();
    double finalPrice = hat.getBasePrice() * tax / 100;

    @Override
    public String getName() {
        return hatName;
    }

    @Override
    public double getPrice() {
        return finalPrice;
    }
}
