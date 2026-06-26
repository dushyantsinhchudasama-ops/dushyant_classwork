package com.tss.structural.Proxy.model;

public class RealImage implements IImage{

    String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;

        loadImage();
    }

    public void loadImage()
    {
        System.out.println("Loading image...");
    }


    @Override
    public void display() {
        System.out.println("Displaying: " + fileName);
    }
}
