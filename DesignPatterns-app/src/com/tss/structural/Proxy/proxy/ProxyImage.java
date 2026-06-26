package com.tss.structural.Proxy.proxy;

import com.tss.structural.Proxy.model.IImage;
import com.tss.structural.Proxy.model.RealImage;

public class ProxyImage implements IImage
{
    private RealImage realImage;

    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null)
        {
            realImage = new RealImage(fileName);
        }

        realImage.display();
    }
}
