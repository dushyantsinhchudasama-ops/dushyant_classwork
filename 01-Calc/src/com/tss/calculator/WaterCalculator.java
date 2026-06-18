package com.tss.calculator;

import java.util.Scanner;

public class WaterCalculator {
    public static void main() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Meter Charge: ");
        float meter_charge = scanner.nextFloat();

        float charge = calculateCharge(meter_charge);


    }

    private static float calculateCharge(float charge)
    {
        if(charge <= 100)
        {
            return charge;
        }

        return charge;
    }

}
