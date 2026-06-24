package com.tss.creational.singletion.solution.test;

import com.tss.creational.singletion.solution.model.Car;
import com.tss.creational.singletion.solution.model.HyundaiCar;
import com.tss.creational.singletion.solution.model.MarutiCar;
import com.tss.creational.singletion.solution.model.TataCar;

public class CatTest {
    public static void main(String[] args) {

        Car marutiCar = new MarutiCar("Creta",750000);
        System.out.println(marutiCar.toString());
        Car hyundaiCar = new HyundaiCar("Innova",3500000);
        System.out.println(hyundaiCar.toString());
        Car tataCar = new TataCar("Verna",950000);
        System.out.println(tataCar.toString());
    }
}
