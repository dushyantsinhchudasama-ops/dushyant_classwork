package com.tss.behavioural.state.test;

import com.tss.behavioural.state.model.Product;

public class StateTest {

    public static void main(String[] args) {

        Product product = new Product("Laptop");

        product.showCurrentState();

        System.out.println();

        product.nextState();
        product.showCurrentState();

        System.out.println();

        product.nextState();
        product.showCurrentState();

        System.out.println();

        product.nextState();
        product.showCurrentState();

        System.out.println();

        product.previousState();
        product.showCurrentState();

        System.out.println();

        product.previousState();
        product.showCurrentState();

        System.out.println();

        product.previousState();
        product.showCurrentState();
    }
}