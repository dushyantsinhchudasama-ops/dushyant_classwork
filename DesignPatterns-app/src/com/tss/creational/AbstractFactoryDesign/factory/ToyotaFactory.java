package com.tss.creational.AbstractFactoryDesign.factory;

import com.tss.creational.AbstractFactoryDesign.model.Car;
import com.tss.creational.AbstractFactoryDesign.model.CarType;
import com.tss.creational.AbstractFactoryDesign.model.Toyta;

public class ToyotaFactory implements CarFactory{

    @Override
    public Car makeCar(CarType type) {
        return new Toyta("Innova",3500000);
    }
}
