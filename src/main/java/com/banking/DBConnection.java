package com.banking;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/banking", "root", "mysql2025");
            System.out.println("✅ Connected to DB");
            return con;
        } catch (Exception e) {
            System.out.println("❌ DB Connection failed:");
            e.printStackTrace();  // Print exact error
            throw e;
        }
    }
}
