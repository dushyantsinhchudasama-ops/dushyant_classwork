package com.tss.creational.singletion.solution.model;

public class DBConnection {

    //here it is variable to store object when it is first time created will check if the object already exist or not
    private static DBConnection instance = null;

    private DBConnection() //making object private to avoid creation of multiple objects
    {

    }

    public static DBConnection createInstance() //this method will help to check weather the object is already created or not and act accordingly
    {
        if(instance == null)
        {
            System.out.println("Object Created for first Time");
            instance = new DBConnection();
        }

        return instance;
    }

    //testing method
    public void display()
    {
        System.out.println("Object creation using singleton");
    }
}
