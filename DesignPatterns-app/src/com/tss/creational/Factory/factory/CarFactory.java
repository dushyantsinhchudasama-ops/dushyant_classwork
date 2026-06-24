package com.tss.creational.Factory.factory;

import com.tss.creational.Factory.model.*;

public class CarFactory {

    public static Car getCarObject(CarType type) {

        switch (type) {
            case HYUNDAI:
                return new HyundaiCar("Verna", 950000);

            case TOYOTA:
                return new ToyotaCar("Innova", 3500000);

            case MARUTI:
                return new MarutiCar("Swift", 800000);

            default:
                throw new IllegalArgumentException("Invalid Car Type");
        }
    }
}
