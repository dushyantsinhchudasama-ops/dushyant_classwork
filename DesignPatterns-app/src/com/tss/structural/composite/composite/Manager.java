package com.tss.structural.composite.composite;

import com.tss.structural.composite.component.Employee;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee{

    private int id;
    private String name;

    private List<Employee> employees = new ArrayList<>();

    public Manager(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public void showDetail() {


        System.out.println("\nManager ID: " + id +
                ", Name: " + name);

        for (Employee employee : employees) {
            employee.showDetail();
        }
    }
}
