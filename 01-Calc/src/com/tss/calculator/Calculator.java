package com.tss.calculator;

import java.util.Scanner;

public class Calculator {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number 1:");
        int number1 = scanner.nextInt();
        System.out.println("Enter number 2:");
        int number2 = scanner.nextInt();

        int number3;
        number3 = addition(number1, number2);
        System.out.println("Addition is: "+number3);

        number3 = subtraction(number1, number2);
        System.out.println("Subtraction is: "+number3);

        number3 = multiplication(number1, number2);
        System.out.println("Addition is: "+number3);

        number3 = divison(number1, number2);
        System.out.println("Addition is: "+number3);

    }

    private static int addition(int num1, int num2)
    {
        return num2 + num1;
    }

    private static int subtraction(int num1, int num2)
    {
        return num2 - num1;
    }

    private static int multiplication(int num1, int num2)
    {
        return num2 * num1;
    }

    private static int divison(int num1, int num2)
    {
        return num2 / num1;
    }
}
