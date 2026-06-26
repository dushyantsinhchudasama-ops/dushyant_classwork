package com.tss.behavioural.state.state;

public class DeliveredState implements OrderState {

    @Override
    public void showStatus() {
        System.out.println("I am in Delivered State");
    }

    @Override
    public OrderState nextState() {

        System.out.println("Already in last state");
        return this;
    }

    @Override
    public OrderState previousState() {
        return new ShippedState();
    }
}
