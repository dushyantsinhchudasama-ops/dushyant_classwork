package com.tss.structural.Adapter.test;

import com.tss.structural.Adapter.adapter.HatAdapter;
import com.tss.structural.Adapter.model.*;

public class ShoppingCartTest {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        IItems oreo = new Biscuit("Oreo",20);
        IItems mariGold = new Biscuit("MariGold",15);
        IItems dairyMilk = new Chocolate("Dairy Milk",150);
        IItems fiveStar = new Chocolate("Five Star",200);
        Hat hat = new Hat(120,"Simple","Hat",5);
        IItems simplHat = new HatAdapter(hat);

        cart.addItemtoCart(oreo);
        cart.addItemtoCart(mariGold);
        cart.addItemtoCart(dairyMilk);
        cart.addItemtoCart(fiveStar);
        cart.addItemtoCart(simplHat);

        cart.displayCart();
    }
}
