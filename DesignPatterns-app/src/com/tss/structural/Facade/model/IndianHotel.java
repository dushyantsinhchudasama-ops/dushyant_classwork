package com.tss.structural.Facade.model;

import com.tss.structural.Facade.inteface.IHotel;
import com.tss.structural.Facade.inteface.IMenu;

public class IndianHotel implements IHotel {

    @Override
    public IMenu getMenu() {
        return new IndianMenu();
    }
}
