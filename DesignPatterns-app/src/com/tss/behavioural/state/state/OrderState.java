package com.tss.behavioural.state.state;

public interface OrderState {

    void showStatus();

    OrderState nextState();

    OrderState previousState();
}
