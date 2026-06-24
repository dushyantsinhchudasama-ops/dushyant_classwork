package com.tss.creational.Factory.test;

import com.tss.creational.Factory.factory.CarFactory;
import com.tss.creational.Factory.model.Car;
import com.tss.creational.Factory.model.CarType;

public class CarTest {

    public static void main(String[] args) {

        Car marutiCar = CarFactory.getCarObject(CarType.MARUTI);
        System.out.println(marutiCar);
        Car hyundaiCar = CarFactory.getCarObject(CarType.HYUNDAI);
        System.out.println(hyundaiCar);
        Car toyotaCar = CarFactory.getCarObject(CarType.TOYOTA);
        System.out.println(toyotaCar);
    }
}
