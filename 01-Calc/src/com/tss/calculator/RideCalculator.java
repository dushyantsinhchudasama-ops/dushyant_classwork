package com.tss.calculator;

import java.util.Scanner;

public class RideCalculator {

    static void main() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your height: ");
        int height = scanner.nextInt();
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        byte wantPhotos;

        do {
            System.out.println("Do you want photos(0 for eys and 1 for no):");
            wantPhotos = scanner.nextByte();
        } while(wantPhotos > 1);

        int final_price = 0;

        if(height < 120)
        {
            System.out.println("You can not ride!");
        }
        else
        {
            final_price = getTotalPrice(age, wantPhotos);
            System.out.println("Total price: " + final_price);
        }
    }

    private static int getTotalPrice(int age, byte wantPhotos)
    {
        int final_amount = 0;

        boolean wantphotos = (wantPhotos == 1);

        if(age < 12)
        {
            final_amount += 5;

            if(wantphotos)
            {
                final_amount += 3;
            }
        } else if (age > 12 && age < 18) {
            final_amount += 7;
            if(wantphotos)
            {
                final_amount += 3;
            }
        } else if (age > 18 && age < 45) {
            final_amount += 12;
            if(wantphotos)
                final_amount += 3;
        } else if (age >= 45 && age <= 55) {
            if(wantphotos)
                final_amount += 3;
        }

        return final_amount;
    }
}
