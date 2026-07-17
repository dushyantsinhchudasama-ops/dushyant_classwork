package com.tss.db.database;

import com.tss.db.model.Student;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    //connection object for singleton
    public static Connection connection;

    private static PreparedStatement preparedStatement;

    private Database()
    {

    }

    //establish connection
    public static Connection getConnection()
    {
        try{

            if(connection == null || connection.isClosed())
            {
                Class.forName("org.postgresql.Driver");

                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tss2026Studentsdb","postgres","Temp@123456");

                System.out.println("Connection established successfully!");
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public static void closeConnection() {

        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection Closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readAllStudent()
    {
        List<Student> students = new ArrayList<>();
        try{

            connection.prepareStatement("SELECT * FROM students");

            ResultSet result = preparedStatement.executeQuery();

            while(result.next())
            {
                Student student = new Student();

                student.setStudent_id(result.getInt(1));
                student.setName(result.getString(2));
                student.setAge(result.getInt(3));

                students.add(student);
            }

        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return students;
    }


    //inserting a student
    public static void addNewStudent(Student student)
    {
        try{

            preparedStatement = connection.prepareStatement("INSERT INTO students(name, age) values (?,?)");

            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());

            System.out.println("student inserted");

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void updateStudent(Student student)
    {

        try {

           connection.prepareStatement("UPDATE students SET name = ? and age = ? WHERE student_id = ?");

           preparedStatement.setString(1,student.getName());
           preparedStatement.setInt(2,student.getAge());
           preparedStatement.setInt(3,student.getStudent_id());

           if(preparedStatement.executeUpdate() > 0)
                System.out.println("Student updated successfully.");
           else
               System.out.println("Can not update student");

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteStudent(int id)
    {
        try{

            connection.prepareStatement("DELETE FROM students WHERE student_id = ?");

            preparedStatement.setInt(1,id);

            if(preparedStatement.executeUpdate() > 0)
                System.out.println("Student delete successfully");
            else
                System.out.println("Can not delete student!");

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
