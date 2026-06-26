package com.tss.structural.DecoratorHat.model;

import com.tss.structural.DecoratorHat.decorator.HatDecorator;

public class SilverRibbon extends HatDecorator {

    public SilverRibbon(IHat hatObj) {
        super(hatObj);
    }

    @Override
    public double getHatPrice() {
        return 30 + super.getHatPrice();
    }
}
