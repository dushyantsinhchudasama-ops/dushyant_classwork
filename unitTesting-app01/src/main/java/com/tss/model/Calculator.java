package com.tss.model;

public class Calculator {

    public int addition(int a, int b)
    {
        return a + b;
    }

    public int multiplication(int a, int b)
    {
        return a * b;
    }

    public double divison(int a, int b) {

        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return (double) a / b;
    }

    public int subtraction(int a, int b)
    {
        return a - b;
    }
}
