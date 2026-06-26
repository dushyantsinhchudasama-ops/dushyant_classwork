package com.tss.behavioural.state.state;

public class OrderedState implements OrderState {

    @Override
    public void showStatus() {
        System.out.println("I am in Ordered State");
    }

    @Override
    public OrderState nextState() {
        return new ShippedState();
    }

    @Override
    public OrderState previousState() {

        System.out.println(
                "Already in first state");

        return this;
    }
}
