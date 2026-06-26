package com.tss.structural.Facade.model;

import com.tss.structural.Facade.inteface.IMenu;

public class ItalianMenu implements IMenu {
    @Override
    public void displayMenu() {
        System.out.println("Italian Menu:\n1.Pasta\n2.Pizza");
    }
}
