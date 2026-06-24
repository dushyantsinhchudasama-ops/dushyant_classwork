package com.tss.creational.AbstractFactoryDesign.factory;

import com.tss.creational.AbstractFactoryDesign.model.Car;
import com.tss.creational.AbstractFactoryDesign.model.CarType;
import com.tss.creational.AbstractFactoryDesign.model.Maruti;

public class MarutiFactory implements CarFactory{


    @Override
    public Car makeCar(CarType type) {
        return new Maruti("Swift",500000);
    }
}
