package com.tss.arrays;

import java.util.Scanner;

public class SearchArrayElement {
    static void main() {

        Scanner scanner = new Scanner(System.in);

        int array[] = {10,20,30,40,50};

        System.out.println("Enter element to search from array: ");
        int search = scanner.nextInt();

        boolean falg = false;
        int index = 0;

        for(int i = 0; i < array.length; i++)
        {
            if(array[i] == search)
            {
               falg = true;
               index = i;
                break;
            }
        }

        if(falg)
            System.out.println("Element found at index: " + index);
        else
            System.out.println("Element not found in array");
    }
}
