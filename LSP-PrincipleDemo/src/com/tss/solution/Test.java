package com.tss.solution;

public class Test {
    public static void main(String[] args) {

        FlyingBird sparrow = new Sparrow();
        Bird penguin = new Penguin();

        sparrow.eat();
        sparrow.fly();
        penguin.eat();
    }
}
