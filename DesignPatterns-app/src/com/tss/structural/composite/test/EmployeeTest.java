package com.tss.structural.composite.test;

import com.tss.structural.composite.component.Employee;
import com.tss.structural.composite.composite.Manager;
import com.tss.structural.composite.leaf.Developer;

public class EmployeeTest {
    public static void main(String[] args) {

        Employee dev1 =
                new Developer(101, "Rahul");

        Employee dev2 =
                new Developer(102, "Amit");

        Employee dev3 =
                new Developer(103, "Neha");

        Employee dev4 =
                new Developer(104, "Priya");

        Manager hrManager =
                new Manager(201, "Suresh");

        Manager itManager =
                new Manager(202, "Rakesh");

        hrManager.addEmployee(dev1);
        hrManager.addEmployee(dev2);

        itManager.addEmployee(dev3);
        itManager.addEmployee(dev4);

        Manager ceo =
                new Manager(301, "Vikram");

        ceo.addEmployee(hrManager);
        ceo.addEmployee(itManager);

        ceo.showDetail();
    }
}
