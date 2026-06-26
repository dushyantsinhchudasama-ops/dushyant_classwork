package com.tss.structural.Facade.model;

import com.tss.structural.Facade.inteface.IMenu;

public class IndianMenu implements IMenu {
    @Override
    public void displayMenu() {
        System.out.println("Indian Menu Items:\n1.Sabji-Roti\n2.Dal-Bhat");
    }
}
