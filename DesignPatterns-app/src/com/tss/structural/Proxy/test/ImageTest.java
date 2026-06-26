package com.tss.structural.Proxy.test;

import com.tss.structural.Proxy.model.IImage;
import com.tss.structural.Proxy.proxy.ProxyImage;


public class ImageTest {
    public static void main(String[] args) {

        IImage image = new ProxyImage("Test.jpg");

        System.out.println("Proxy object created");

        image.display();

    }
}
