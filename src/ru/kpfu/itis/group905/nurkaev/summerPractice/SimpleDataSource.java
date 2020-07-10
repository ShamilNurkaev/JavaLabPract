package ru.kpfu.itis.group905.nurkaev.summerPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleDataSource {
    public Connection openConnection(String url, String user, String password) {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
