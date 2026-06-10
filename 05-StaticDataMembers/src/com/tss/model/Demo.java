package com.tss.model;

public class Demo {

    private int a;
    private static int b;

    public Demo()
    {
        a= 0;
        b = 0;
    }

    public void show()
    {
        System.out.println("a : " + a);
        System.out.println("b : " + b);
    }

    public void increment()
    {
        a++;
        b++;
    }

    static {
        System.out.println("Static Block From Demo");
    }
    {
        System.out.println("Non Static Block From Demo");
    }

}
