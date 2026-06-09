package com.tss.arrays;

import java.util.Scanner;

public class SecondMax {
    static void main() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Size of array: ");
        int size = scanner.nextInt();

        int array[] = new int[size];

        int max = 0;
        int secondMax = 0;

        for(int i = 0; i < array.length; i++)
        {
            System.out.println("Enter element: ");
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < size; i++) {
            if (array[i] > max) {
                secondMax = max;
                max = array[i];
            }
        }

        System.out.println("Second Maximum elemenf from the array : " + secondMax);
    }
}
