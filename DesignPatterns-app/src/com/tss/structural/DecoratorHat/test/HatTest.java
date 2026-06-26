package com.tss.structural.DecoratorHat.test;

import com.tss.structural.DecoratorHat.model.*;

public class HatTest {
    public static void main(String[] args) {

        IHat hat = new StandardHat();
        System.out.println("Standard hat price: " + hat.getHatPrice());

        IHat prominientHat = new ProminientHat();
        System.out.println("Prominient hat price: " + prominientHat.getHatPrice());

        IHat silverStandard = new SilverRibbon(hat);
        System.out.println("Standard + Silver ribbon: " + silverStandard.getHatPrice());

        IHat golderStandart = new GolderRibbon(hat);
        System.out.println("Standard + Golder ribbon: " + golderStandart.getHatPrice());

        IHat silverProminient = new SilverRibbon(prominientHat);
        System.out.println("Standard + Silver ribbon: " + silverProminient.getHatPrice());

        IHat goldenProminient = new GolderRibbon(prominientHat);
        System.out.println("Standard + Golder ribbon: " + goldenProminient.getHatPrice());

    }
}
