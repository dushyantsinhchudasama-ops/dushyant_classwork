package com.tss.arrays;

import java.util.Scanner;

public class SumOfArrayElements {
    static void main() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Size of array: ");
        int size = scanner.nextInt();

        int array[] = new int[size];

        int sum = 0;

        for(int i = 0; i < array.length; i++)
        {
            System.out.println("Enter element " + (i+1));
            array[i] = scanner.nextInt();
            sum += array[i];
        }

        System.out.println("Sum of all the array element is: " + sum);

    }
}
