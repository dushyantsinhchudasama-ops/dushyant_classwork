package com.tss.test;

import com.tss.model.FourWheeler;
import com.tss.model.TwoWheeler;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VehicleTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        while (true)
        {
            System.out.println("Enter\n 1.For Two Wheeler \n 2.For Four Wheeler \n 3.exit");
            try{
                choice = scanner.nextInt();

                if(choice < 0)
                {
                    System.out.println("Please enter valid choice");
                }
                else {
                    break;
                }
            } catch (InputMismatchException e)
            {
                System.out.println("Enter valid choice from menu!");
                scanner.next();
            }
        }
        switch (choice)
        {
            case 1:
                buyTwoWheeler();
                break;
            case 2:
                buyFourWheeler();
                break;
            case 3:
                return;
            default:
                System.out.println("Enter valid choice from menu!");
        }

    }

    public static void buyTwoWheeler()
    {
        String name;
        String company;
        int milage = 0;
        double price;

        Scanner scanner = new Scanner(System.in);

            System.out.println("Enter name of Vehicle: ");
            name = scanner.nextLine();
            System.out.println("Enter name of company: ");
            company = scanner.nextLine();
            while(true) {
                try {
                    System.out.println("Enter price: ");
                    price = scanner.nextDouble();

                    if (price < 0) {
                        System.out.println("Enter valid Price!");

                    } else {
                        break;
                    }
                } catch (InputMismatchException e)
                {
                    System.out.println("Enter valid Prive!");
                    scanner.next();   // Clear the invalid input
                    continue;
                }
            }

            while(true) {

                try {
                    System.out.println("Enter Milage: ");
                    milage = scanner.nextInt();

                    if (milage < 0) {
                        System.out.println("Enter valid Milage!");
                        continue;
                    } else {
                        break;
                    }
                } catch (InputMismatchException e)
                {
                    System.out.println("Enter valid Milage!");
                    scanner.next();   // Clear the invalid input
                    continue;
                }
            }

        TwoWheeler twoWheeler = new TwoWheeler(name, price, company, milage);
        System.out.println(twoWheeler);
    }

    public static void buyFourWheeler()
    {
        String name;
        String company;
        int noOfSeats;
        double price;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name of Vehicle: ");
        name = scanner.nextLine();
        System.out.println("Enter name of company: ");
        company = scanner.nextLine();
        while(true) {
            try {
                System.out.println("Enter price: ");
                price = scanner.nextDouble();

                if (price < 0) {
                    System.out.println("Enter valid Price!");
                    continue;
                } else {
                    break;
                }
            } catch (InputMismatchException e)
            {
                System.out.println("Enter valid Price!");
                scanner.next();   // Clear the invalid input
                continue;
            }
        }

        while(true) {

            try {
                System.out.println("Enter Number of seats: ");
                noOfSeats = scanner.nextInt();

                if (noOfSeats < 0) {
                    System.out.println("Enter valid Seats!");
                    continue;
                } else {
                    break;
                }
            } catch (InputMismatchException e)
            {
                System.out.println("Enter valid seats!");
                scanner.next();   // Clear the invalid input
                continue;
            }
        }

        FourWheeler fourWheeler = new FourWheeler(name, price, company, noOfSeats);
        System.out.println(fourWheeler);
    }
}
