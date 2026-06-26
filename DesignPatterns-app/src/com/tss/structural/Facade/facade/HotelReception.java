package com.tss.structural.Facade.facade;

import com.tss.structural.Facade.inteface.IHotel;
import com.tss.structural.Facade.inteface.IMenu;
import com.tss.structural.Facade.model.IndianHotel;
import com.tss.structural.Facade.model.ItalianHotel;
import com.tss.structural.Facade.model.ItalianMenu;

public class HotelReception {

    public void getIndianMenu()
    {
        IHotel indianMenu = new IndianHotel();
        IMenu menu = indianMenu.getMenu();
        menu.displayMenu();
    }

    public void getItalianMenu()
    {
        IHotel italianMenu = new ItalianHotel();
        IMenu menu = italianMenu.getMenu();
        menu.displayMenu();
    }
}
