package com.tss.core.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Computer{

    private String company;
     //here add autowired for feild injection
    private HardDisk hardDisk;

    public Computer() {
        System.out.println("Default constructor of Computer");

    }

    //here add @autowired for constructor injection
    public Computer(String company, HardDisk hardDisk) {
        System.out.println("Parameterized constructor of Computer");
        this.company = company;
        this.hardDisk = hardDisk;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        System.out.println("setter of company");
        this.company = company;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    //add annotation here for setter injection
    public void setHardDisk(HardDisk hardDisk) {
        System.out.println("setter of harddisk from computer");
        this.hardDisk = hardDisk;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "company='" + company + '\'' +
                ", hardDisk=" + hardDisk +
                '}';
    }
}
