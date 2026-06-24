package com.tss.creational.AbstractFactoryDesign.factory;

import com.tss.creational.AbstractFactoryDesign.model.Car;
import com.tss.creational.AbstractFactoryDesign.model.CarType;
import com.tss.creational.AbstractFactoryDesign.model.HyundaiCar;

public class HyundaiFactory implements CarFactory{

    @Override
    public Car makeCar(CarType type) {
        return new HyundaiCar("Creta",1200000);
    }
}
