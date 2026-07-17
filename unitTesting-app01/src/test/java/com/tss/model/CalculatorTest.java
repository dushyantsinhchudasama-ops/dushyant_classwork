package com.tss.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    static Calculator calculator;

    @BeforeAll
    static void init()
    {
        calculator = new Calculator();
    }

    @Test
    void addition() {

        int actual = calculator.addition(2,3);

        assertEquals(5,actual);
    }

    @Test
    void multiplication() {

        int actual = calculator.multiplication(2,3);

        assertEquals(6,actual);
    }

    @Test
    void divison() {

        double actual = calculator.divison(12,6);

        assertEquals(2,actual);
    }

    @Test
    void subtraction() {

        int actual = calculator.subtraction(10,5);

        assertEquals(5,actual);
    }

    @Test
    void devideByZero(){

       ArithmeticException exception =  assertThrows(ArithmeticException.class, ()-> calculator.divison(12,0));

        assertEquals("Cannot divide by zero", exception.getMessage());

    }
}