package com.tss.structural.Decorator.test;

import com.tss.structural.Decorator.model.CarInspection;
import com.tss.structural.Decorator.model.ICarService;
import com.tss.structural.Decorator.model.OilChange;
import com.tss.structural.Decorator.model.WheelAlign;

public class CarServiceTest {

    public static void main(String[] args) {

        ICarService car = new CarInspection();
        System.out.println("Inspection Cost : "+ car.getCost());

        ICarService oilService = new OilChange(car);
        System.out.println("Inspection + Oil Change : "+ oilService.getCost());

        ICarService wheelService = new WheelAlign(car);
        System.out.println("Inspection + Wheel Align : "+ wheelService.getCost());

        ICarService fullService = new WheelAlign(oilService);
        System.out.println("Inspection + Oil Change + Wheel Align : "+ fullService.getCost());
    }
}
