package com.tss.behavioural.strategy.test;


import com.tss.behavioural.strategy.model.MultiplyOperation;
import com.tss.behavioural.strategy.model.OperationStrategy;
import com.tss.behavioural.strategy.strategy.AddOperation;

public class StrategyTest {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        OperationStrategy operationStrategy = new OperationStrategy(new AddOperation());

        System.out.println("Addition : " + operationStrategy.doOperation(a, b));

        operationStrategy.setOperation(new MultiplyOperation());

        System.out.println("Multiplication : " + operationStrategy.doOperation(a, b));
    }
}