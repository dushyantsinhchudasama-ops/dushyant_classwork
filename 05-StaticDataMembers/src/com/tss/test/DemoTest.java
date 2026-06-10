package com.tss.test;

import com.tss.model.Demo;

public class DemoTest {

    public static void main(String[] args) {

        Demo demo1 = new Demo();
        Demo demo2 = new Demo();
        Demo demo3 = new Demo();

        demo1.show();
        demo2.show();
        demo3.show();

        demo1.increment();
        demo1.show();

        demo2.increment();
        demo2.show();

        demo3.increment();
        demo3.show();

    }

    {
        System.out.println("Non static Block From DemoTest");
    }

    static {
        System.out.println("Static Block From DemoTest");
    }
}
