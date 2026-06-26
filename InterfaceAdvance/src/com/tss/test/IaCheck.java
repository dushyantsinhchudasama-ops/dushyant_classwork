package com.tss.test;

import com.tss.model.Ia;

public class IaCheck extends IaTest{

    public static void main(String[] args) {

        IaTest test = new IaTest();

        test.show();
        Ia.showStaic();
        test.showDefault();
        test.getPrivate();
    }
}
