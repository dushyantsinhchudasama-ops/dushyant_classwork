package com.tss.Services;

import com.tss.DB.Database;

import javax.xml.crypto.Data;
import java.sql.Connection;

public class BankServices {

    private Connection connection;

    public BankServices()
    {
        connection = Database.getConnection();
    }

    public void getAccountDetails(long accountNumber)
    {

    }

}
