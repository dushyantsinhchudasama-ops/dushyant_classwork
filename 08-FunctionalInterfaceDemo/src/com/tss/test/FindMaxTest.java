package com.tss.test;

import com.tss.model.FindMax;

import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FindMaxTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number: ");
        int num = scanner.nextInt();
        System.out.println("Enter number 2:" );
        int num2 = scanner.nextInt();

        BiFunction<Integer, Integer, Integer> findMax = (n1, n2) ->{

            if(n1 > n2)
                return n1;

            return n2;
        };

        checkMax(findMax, num, num2);

    }

    public static void checkMax(BiFunction<Integer, Integer, Integer> findMax, int n1, int n2)
    {
        System.out.println("Maximum From both is : " + findMax.apply(n1,n2));
    }
}
