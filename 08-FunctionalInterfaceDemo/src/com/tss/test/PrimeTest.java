package com.tss.test;

import com.tss.model.Prime;

import java.util.Scanner;
import java.util.function.Predicate;

public class PrimeTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number: ");
        int num = scanner.nextInt();

        Predicate<Integer> prime = (n) -> {

            if (n <= 1) {
                return false;
            }

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }

            return true;
        };

        checkPrime(prime, num);
    }

    public static void checkPrime(Predicate<Integer> p, int number)
    {
        System.out.println(p.test(number));
    }

}
