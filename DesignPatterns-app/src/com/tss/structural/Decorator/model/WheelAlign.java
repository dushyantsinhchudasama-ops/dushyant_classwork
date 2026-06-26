package com.tss.structural.Decorator.model;

import com.tss.structural.Decorator.decorator.CarServiceDecorator;

public class WheelAlign extends CarServiceDecorator {

    public WheelAlign(ICarService carObj) {
        super(carObj);
    }

    @Override
    public double getCost() {
        return 400 + super.getCost();
    }
}