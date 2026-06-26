package com.tss.model;

public interface Ia {

    void show();

    default void showDefault()
    {
        System.out.println("Default method from interface");
    }

    static void showStaic()
    {
        System.out.println("Static method from Inteface");
    }

    private void showPrivate()
    {
        System.out.println("Private method from interface");
    }

    default void getPrivate()
    {
        System.out.println("Get private method");
        showPrivate();
    }


}
