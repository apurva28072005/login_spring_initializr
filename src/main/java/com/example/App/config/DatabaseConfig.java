package com.example.App.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfig {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/apu_db",
                "root",
                "root" // replace with your DB password
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
