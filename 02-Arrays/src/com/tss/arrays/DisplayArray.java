package com.tss.arrays;

import java.util.Scanner;

public class DisplayArray {
    static void main() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Etner size of array: ");
        int size = scanner.nextInt();

        int array[] = new int[size];

        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
    }
}
