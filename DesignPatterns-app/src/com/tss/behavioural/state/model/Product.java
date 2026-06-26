package com.tss.behavioural.state.model;

import com.tss.behavioural.state.state.OrderState;
import com.tss.behavioural.state.state.OrderedState;

public class Product {

    private String productName;

    private OrderState currentState;

    public Product(String productName) {

        this.productName = productName;

        this.currentState = new OrderedState();
    }

    public void nextState() {

        currentState = currentState.nextState();
    }

    public void previousState() {

        currentState = currentState.previousState();
    }

    public void showCurrentState() {

        System.out.print(productName + " : ");

        currentState.showStatus();
    }
}
