package com.tss.structural.Decorator.model;

import com.tss.structural.Decorator.decorator.CarServiceDecorator;

public class OilChange extends CarServiceDecorator {

    public OilChange(ICarService carObj) {
        super(carObj);
    }

    @Override
    public double getCost() {
        return 500 + super.getCost();
    }
}