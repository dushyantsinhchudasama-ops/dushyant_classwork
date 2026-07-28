package com.tss.DB;

import com.tss.model.Account;

import java.sql.*;

public class Database {

    private static Connection connection;
    private PreparedStatement preparedStatement;

    private Database()
    {

    }

    public static Connection getConnection()
    {
        try {
            if (connection != null || connection.isClosed())
            {
                Class.forName("org.postgresql.Driver");

                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransactionJDBCDemo","postgres","Temp@123456");

                System.out.println("Connection established successfully!");
            }
        }
        catch (SQLException | ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public Account getAccountDetails(long accountNumber)
    {
        Account account = new Account();

        try {
            connection.prepareStatement("SELECT * from bank_details where account_number = ?");

            ResultSet result = preparedStatement.executeQuery();

            account.setAccountId(result.getInt(1));
            account.setName(result.getString(2));
            account.setAccountNo(result.getString(3));
            account.setBalance(result.getDouble(4));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return account;
    }

    public boolean createAccount(Account account)
    {
        connection.prepareStatement("INSERT INTO  bank_details (account)")

        return true;
    }
}

