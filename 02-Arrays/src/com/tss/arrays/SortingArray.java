package com.tss.arrays;

import java.util.Scanner;

public class SortingArray {
    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Size of array: ");
        int size = scanner.nextInt();

        int array[] = new int[size];

        for(int i = 0; i < array.length; i++)
        {
            System.out.println("Enter element " + (i+1));
            array[i] = scanner.nextInt();
        }

        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array.length- i -1; j++)
            {
                if(array[j] > array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        System.out.println("Sorted Array: ");
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(" " + array[i]);
        }
    }
}
