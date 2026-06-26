package com.tss.structural.DecoratorHat.decorator;

import com.tss.structural.DecoratorHat.model.IHat;

public abstract class HatDecorator implements IHat {

    protected IHat hatObj;

    public HatDecorator(IHat hatObj) {
        this.hatObj = hatObj;
    }

    @Override
    public double getHatPrice() {
        return hatObj.getHatPrice();
    }
}
