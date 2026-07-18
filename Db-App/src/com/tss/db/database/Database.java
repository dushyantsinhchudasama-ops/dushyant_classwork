package com.tss.db.database;

import com.tss.db.model.Course;
import com.tss.db.model.Enrollment;
import com.tss.db.model.Student;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    //connection object for singleton
    private static Connection connection;

    private static PreparedStatement preparedStatement;

    private static ResultSet result;

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

    public static List<Student> readAllStudent() throws SQLException {
        List<Student> students = new ArrayList<>();
        try{

            preparedStatement = connection.prepareStatement("SELECT * FROM students");

            result = preparedStatement.executeQuery();

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
        finally {
            preparedStatement.close();
            result.close();
        }

        return students;
    }


    //inserting a student
    public static void addNewStudent(Student student) throws SQLException {
        try{

            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement("INSERT INTO students(name, age) values (?,?)");

            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());

            preparedStatement.executeUpdate();

            connection.commit();

            System.out.println("student inserted");

        }
        catch (SQLException e)
        {
            connection.rollback();
            System.out.println(e.getMessage());
        }

    }

    public static void updateStudent(Student student) throws SQLException {

        try {

            connection.setAutoCommit(false);

           preparedStatement = connection.prepareStatement("UPDATE students SET name = ? and age = ? WHERE student_id = ?");

           preparedStatement.setString(1,student.getName());
           preparedStatement.setInt(2,student.getAge());
           preparedStatement.setInt(3,student.getStudent_id());

           int rows = preparedStatement.executeUpdate();

           connection.commit();

           if(rows > 0)
                System.out.println("Student updated successfully.");
           else
               System.out.println("Can not update student");

        }
        catch (SQLException e)
        {
            connection.rollback();
            System.out.println(e.getMessage());
        }
    }

    public static void deleteStudent(int id) throws SQLException
    {
        try{

            connection.setAutoCommit(false);

            preparedStatement =  connection.prepareStatement("DELETE FROM students WHERE student_id = ?");

            preparedStatement.setInt(1,id);

            int rows = preparedStatement.executeUpdate();

            connection.commit();

            if(rows > 0)
                System.out.println("Student delete successfully");
            else
                System.out.println("Can not delete student!");

        }
        catch (SQLException e)
        {
            connection.rollback();
            System.out.println(e.getMessage());
        }
    }

    public static List<Course> readAllCourses() throws SQLException {
        List<Course> courses = new ArrayList<>();
        try{

            preparedStatement = connection.prepareStatement("SELECT * FROM courses");

            result = preparedStatement.executeQuery();

            while(result.next())
            {
                Course course = new Course();

                course.setCourse_name(result.getString(2));
                course.setCourse_code(result.getString(3));
                course.setDescription(result.getString(4));
                course.setDuration_months(result.getInt(5));
                course.setMax_students(result.getInt(6));

                courses.add(course);
            }

        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            preparedStatement.close();
            result.close();
        }

        return courses;
    }


    public static void addNewCourse(Course course) throws SQLException {
        try{

            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO courses(course_name, course_code, description, duration_months, max_students) VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setString(1, course.getCourse_name());
            preparedStatement.setString(2, course.getCourse_code());
            preparedStatement.setString(3, course.getDescription());
            preparedStatement.setInt(4, course.getDuration_months());
            preparedStatement.setInt(5, course.getMax_students());

            int rowsAffected = preparedStatement.executeUpdate();

            connection.commit();

            if (rowsAffected > 0) {
                System.out.println("Course inserted successfully.");
            } else {
                System.out.println("Course could not be inserted.");
            }

        }
        catch (SQLException e)
        {
            connection.rollback();
            System.out.println(e.getMessage());
        }

    }

    public static void updateCourse(Course course) throws SQLException {

        try {

            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE courses SET " +
                            "course_name = ?, " +
                            "description = ?, " +
                            "duration_months = ?, " +
                            "max_students = ? " +
                            "WHERE course_code = ?"
            );

            preparedStatement.setString(1, course.getCourse_name());
            preparedStatement.setString(2, course.getDescription());
            preparedStatement.setInt(3, course.getDuration_months());
            preparedStatement.setInt(4, course.getMax_students());
            preparedStatement.setString(5, course.getCourse_code());

            int rows = preparedStatement.executeUpdate();

            connection.commit();

            if(rows > 0)
                System.out.println("Course updated successfully.");
            else
                System.out.println("Can not update course");

        }
        catch (SQLException e)
        {
            connection.rollback();
            System.out.println(e.getMessage());
        }
    }

    public static void deleteCourse(String code) throws SQLException
    {
        try{

            connection.setAutoCommit(false);

            preparedStatement =  connection.prepareStatement("DELETE FROM courses WHERE course_code = ?");

            preparedStatement.setString(1,code);

            int rows = preparedStatement.executeUpdate();

            connection.commit();

            if(rows > 0)
                System.out.println("Course delete successfully");
            else
                System.out.println("Can not delete course!");

        }
        catch (SQLException e)
        {
            connection.rollback();
            System.out.println(e.getMessage());
        }
    }


    public static List<Enrollment> readAllEnrollments() throws SQLException {

        List<Enrollment> enrollments = new ArrayList<>();

        try {

            preparedStatement = connection.prepareStatement(
                    "SELECT e.enrollment_id, e.student_id, s.name, " +
                            "e.course_code, c.course_name, e.enrollment_date, e.status " +
                            "FROM enrollments e " +
                            "JOIN students s " +
                            "ON e.student_id = s.student_id " +
                            "JOIN courses c " +
                            "ON c.course_code = e.course_code"
            );
            result = preparedStatement.executeQuery();

            while (result.next()) {

                Enrollment enrollment = new Enrollment();

                enrollment.setEnrollmentId(result.getInt("enrollment_id"));
                enrollment.setStudentId(result.getInt("student_id"));
                enrollment.setStudentName(result.getString("name"));
                enrollment.setcourseCode(result.getString("course_code"));
                enrollment.setCourseName(result.getString("course_name"));
                enrollment.setEnrollmentDate(result.getDate("enrollment_date"));
                enrollment.setStatus(result.getString("status"));

                enrollments.add(enrollment);
            }

        } catch(SQLException e) {

            System.out.println(e.getMessage());

        }
        return enrollments;
    }

    public static void addEnrollment(Enrollment enrollment) throws SQLException {

        try {

            connection.setAutoCommit(false);

            // Step 1: Get maximum students allowed
            preparedStatement = connection.prepareStatement(
                    "SELECT max_students FROM courses WHERE course_code = ?"
            );

            preparedStatement.setString(1, enrollment.getcourseCode());

            ResultSet rs = preparedStatement.executeQuery();

            if (!rs.next()) {
                System.out.println("Course not found.");
                connection.rollback();
                return;
            }

            int maxStudents = rs.getInt("max_students");

            rs.close();
            preparedStatement.close();

            // Step 2: Count current enrollments
            preparedStatement = connection.prepareStatement(
                    "SELECT COUNT(*) FROM enrollments WHERE course_code = ?"
            );

            preparedStatement.setString(1, enrollment.getcourseCode());

            rs = preparedStatement.executeQuery();

            rs.next();
            int currentStudents = rs.getInt(1);

            rs.close();
            preparedStatement.close();

            // Step 3: Check capacity
            if (currentStudents >= maxStudents) {
                System.out.println("Course is already full! Enrollment failed");
                connection.rollback();
                return;
            }

            // Step 4: Insert enrollment
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO enrollments(student_id, course_code, status) VALUES(?,?,?)"
            );

            preparedStatement.setInt(1, enrollment.getStudentId());
            preparedStatement.setString(2, enrollment.getcourseCode());
            preparedStatement.setString(3, enrollment.getStatus());

            int rows = preparedStatement.executeUpdate();

            connection.commit();

            if (rows > 0)
                System.out.println("Enrollment added successfully.");
            else
                System.out.println("Could not add enrollment.");

        } catch (SQLException e) {

            connection.rollback();
            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null)
                preparedStatement.close();

            connection.setAutoCommit(true);
        }
    }

    public static void updateEnrollment(Enrollment enrollment)
            throws SQLException {

        try {

            connection.setAutoCommit(false);

            preparedStatement =
                    connection.prepareStatement(
                            "UPDATE enrollments SET status = ? WHERE enrollment_id = ?");

            preparedStatement.setString(1, enrollment.getStatus());
            preparedStatement.setInt(2, enrollment.getEnrollmentId());

            int rows = preparedStatement.executeUpdate();

            connection.commit();

            if(rows > 0)
                System.out.println("Enrollment updated successfully.");
            else
                System.out.println("Enrollment not found.");

        } catch(SQLException e) {

            connection.rollback();
            System.out.println(e.getMessage());
        }
    }

    public static void deleteEnrollment(int enrollmentId) throws SQLException {

        try {

            connection.setAutoCommit(false);

            preparedStatement =
                    connection.prepareStatement(
                            "DELETE FROM enrollments WHERE enrollment_id = ?");

            preparedStatement.setInt(1, enrollmentId);

            int rows = preparedStatement.executeUpdate();

            connection.commit();

            if(rows > 0)
                System.out.println("Enrollment deleted successfully.");
            else
                System.out.println("Enrollment not found.");

        } catch(SQLException e) {

            connection.rollback();
            System.out.println(e.getMessage());
        }
    }
}
