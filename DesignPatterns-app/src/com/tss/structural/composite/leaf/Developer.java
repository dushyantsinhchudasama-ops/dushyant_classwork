package com.tss.structural.composite.leaf;

import com.tss.structural.composite.component.Employee;

public class Developer implements Employee {

    private int id;
    private String name;

    public Developer(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public void showDetail() {
        System.out.println("Developer ID: " + id +
                ", Name: " + name);
    }
}
