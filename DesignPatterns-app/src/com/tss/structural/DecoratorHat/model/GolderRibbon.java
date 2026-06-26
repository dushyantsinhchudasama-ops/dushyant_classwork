package com.tss.structural.DecoratorHat.model;

import com.tss.structural.DecoratorHat.decorator.HatDecorator;

public class GolderRibbon extends HatDecorator {

    public GolderRibbon(IHat hatObj) {
        super(hatObj);
    }

    @Override
    public double getHatPrice() {
        return 50 + super.getHatPrice();
    }
}
