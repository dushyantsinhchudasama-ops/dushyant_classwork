package com.tss.structural.Decorator.decorator;

import com.tss.structural.Decorator.model.ICarService;

public abstract class CarServiceDecorator implements ICarService {

    protected ICarService carObj;

    public CarServiceDecorator(ICarService carObj) {
        this.carObj = carObj;
    }

    @Override
    public double getCost() {
        return carObj.getCost();
    }
}