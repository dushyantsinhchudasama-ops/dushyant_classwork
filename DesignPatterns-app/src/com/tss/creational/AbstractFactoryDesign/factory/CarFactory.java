package com.tss.creational.AbstractFactoryDesign.factory;

import com.tss.creational.AbstractFactoryDesign.model.Car;
import com.tss.creational.AbstractFactoryDesign.model.CarType;

public interface CarFactory {

    Car makeCar(CarType type);
}
