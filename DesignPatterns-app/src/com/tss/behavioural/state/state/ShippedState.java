package com.tss.behavioural.state.state;

public class ShippedState implements OrderState {

    @Override
    public void showStatus() {
        System.out.println("I am in Shipped State");
    }

    @Override
    public OrderState nextState() {
        return new DeliveredState();
    }

    @Override
    public OrderState previousState() {
        return new OrderedState();
    }
}