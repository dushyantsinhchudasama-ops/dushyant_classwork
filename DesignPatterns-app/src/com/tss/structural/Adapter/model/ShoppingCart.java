package com.tss.structural.Adapter.model;

import java.util.List;

public class ShoppingCart {

    List<IItems> cart;

    public ShoppingCart() {

    }

    public void addItemtoCart(IItems item)
    {
        cart.add(item);
    }

    public void displayCart()
    {
        double totalBill = 0;
        System.out.printf("%-20s %-10s%n", "Items", "Price");

        for(IItems item : cart)
        {
            System.out.printf("%-20s %-10s%n", item.getName(), item.getPrice());
            totalBill += item.getPrice();
        }

        System.out.println("-----------------------------------------------------");
        System.out.printf("%-20s %-10s%n", "Total Bill", totalBill);
    }
}
