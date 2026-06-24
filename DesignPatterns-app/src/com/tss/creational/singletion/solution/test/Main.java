package com.tss.creational.singletion.solution.test;

import com.tss.creational.singletion.solution.model.DBConnection;

public class Main {
    public static void main(String[] args) {

        DBConnection connection = DBConnection.createInstance();

        connection.display();

        DBConnection connection2 = DBConnection.createInstance();

        connection2.display();
    }
}
