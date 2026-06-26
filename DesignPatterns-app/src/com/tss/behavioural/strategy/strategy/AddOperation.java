package com.tss.behavioural.strategy.strategy;

import com.tss.behavioural.strategy.model.IOperation;

public class AddOperation implements IOperation {

    @Override
    public int doOperation(int a, int b) {
        return a + b;
    }
}