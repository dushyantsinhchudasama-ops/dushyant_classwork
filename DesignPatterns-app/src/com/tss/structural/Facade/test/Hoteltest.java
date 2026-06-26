package com.tss.structural.Facade.test;

import com.tss.structural.Facade.facade.HotelReception;

public class Hoteltest {
    public static void main(String[] args) {

        HotelReception indialMenu = new HotelReception();
        HotelReception italianMenu = new HotelReception();

        indialMenu.getIndianMenu();
        System.out.println();
        italianMenu.getItalianMenu();
    }
}
