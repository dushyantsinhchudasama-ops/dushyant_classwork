package com.tss.arrays;

import java.util.Scanner;
import java.util.InputMismatchException;

public class SortedSquares {

    public static int[] getSortedSquares(int[] arr) {

        int n = arr.length;
        int[] squareArray = new int[n];


        for (int i = 0; i < n; i++) {
            squareArray[i] = arr[i] * arr[i];
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (squareArray[j] > squareArray[j + 1]) {

                    int temp = squareArray[j];
                    squareArray[j] = squareArray[j + 1];
                    squareArray[j + 1] = temp;
                }
            }
        }

        return squareArray;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter size of array: ");
            int n = sc.nextInt();

            if (n <= 0) {
                System.out.println("Array size must be greater than 0");
                return;
            }

            int[] arr = new int[n];

            System.out.println("Enter array elements:");

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {

                    if (arr[j] > arr[j + 1]) {

                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }

            int[] result = getSortedSquares(arr);

            System.out.println("Sorted Array:");

            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }

            System.out.println();

            System.out.println("Sorted Square Array:");

            for (int i = 0; i < n; i++) {
                System.out.print(result[i] + " ");
            }

        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Enter integers only.");
        }
        catch (NegativeArraySizeException e) {
            System.out.println("Array size cannot be negative.");
        }
        catch (Exception e) {
            System.out.println("Something went wrong.");
        }

    }
}
