package com.tss.ioc.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Computer {

    private String company;
    private Harddisk harddisk;

//    public Computer() {
//    }

    public Computer(String company, Harddisk harddisk) {
        System.out.println("parameterized called from computer");
        this.company = company;
        this.harddisk = harddisk;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Harddisk getHarddisk() {
        return harddisk;
    }

    @Autowired
    public void setHarddisk(Harddisk harddisk) {
        this.harddisk = harddisk;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "company='" + company + '\'' +
                ", harddisk=" + harddisk +
                '}';
    }
}
