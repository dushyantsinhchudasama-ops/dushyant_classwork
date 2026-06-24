package com.tss.creational.AbstractFactoryDesign.test;

import com.tss.creational.AbstractFactoryDesign.factory.CarFactory;
import com.tss.creational.AbstractFactoryDesign.factory.HyundaiFactory;
import com.tss.creational.AbstractFactoryDesign.factory.MarutiFactory;
import com.tss.creational.AbstractFactoryDesign.factory.ToyotaFactory;
import com.tss.creational.AbstractFactoryDesign.model.Car;
import com.tss.creational.AbstractFactoryDesign.model.CarType;

public class CarTest {
    public static void main(String[] args) {

        CarFactory hyundaiFactory = new HyundaiFactory();
        Car hyundaiCar = hyundaiFactory.makeCar(CarType.HYUNDAI);
        System.out.println(hyundaiCar);

        CarFactory marutiCatFactory = new MarutiFactory();
        Car marutiCar = marutiCatFactory.makeCar(CarType.MARUTI);
        System.out.println(marutiCar);

        CarFactory toyotaFactory = new ToyotaFactory();
        Car toyotaCar = toyotaFactory.makeCar(CarType.TOYOTA);
        System.out.println(toyotaCar);
    }
}
