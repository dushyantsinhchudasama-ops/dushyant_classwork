package com.tss.core.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class HardDisk {

    private int capacity;

    public HardDisk() {
        System.out.println("Default constructor of harddisk");
    }

//    @Autowired
    public HardDisk(int capacity) {
        System.out.println("Parameterized constructor of harddisk");
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        System.out.println("setter of harddisk");
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "HardDisk{" +
                "capacity=" + capacity +
                '}';
    }
}
