package ru.kpfu.itis.group905.nurkaev.summerPractice;

import java.sql.*;

public class Main {

    public static final String URL = "jdbc:postgresql://localhost:5432/java_lab_pract_2020";
    public static final String USER = "postgres";
    public static final String PASSWORD = "9aw25pxj";

    public static void main(String[] args) {
        SimpleDataSource dataSource = new SimpleDataSource();
        Connection connection = dataSource.openConnection(URL, USER, PASSWORD);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("id"));
                System.out.println("First Name: " + resultSet.getString("first_name"));
                System.out.println("Last Name: " + resultSet.getString("last_name"));
                System.out.println("Age: " + resultSet.getInt("age"));
                System.out.println("Group: " + resultSet.getInt("group_number"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}