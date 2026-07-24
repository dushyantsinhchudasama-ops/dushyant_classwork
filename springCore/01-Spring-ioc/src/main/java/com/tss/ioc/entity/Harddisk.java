package com.tss.ioc.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Harddisk {

    private Integer capacity;

//    public Harddisk() {
//    }

    public Harddisk(Integer capacity) {
        System.out.println("parameterized called from harddisk");
        this.capacity = capacity;

    }

    public Integer getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Harddisk{" +
                "capacity=" + capacity +
                '}';
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
