package com.tss.test;

import com.tss.model.Factorial;

import java.util.Scanner;
import java.util.function.Function;

public class FactorialTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number: ");
        int num = scanner.nextInt();

        Function<Integer, Long> factorial = (n)->{

            long fact = 1;

            for(int i = 1; i <= n; i++)
            {
                fact *= i;
            }

            return fact;
        };

        showFactorial(factorial, num);


    }

    public static void showFactorial(Function<Integer,Long> factorial, int num)
    {
        System.out.println("Factorial of " + num + " = " + factorial.apply(num));
    }
}
