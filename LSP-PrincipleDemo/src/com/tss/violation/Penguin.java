package com.tss.violation;

public class Penguin extends Bird{

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguin can not fly");
    }
}
