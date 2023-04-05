package com.arcadehub.arcade_hub;
import java.sql.*;

public class Jdbc {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arcadehub", "root", "root");

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users;");

             // Process the results
             while (rs.next()) {
                 String email = rs.getString("email");
                 String password = rs.getString("password");
                 System.out.println("ArcadeHub UserMailID: " + email + ", ArcadeHub UserPassword: " + password);
             }

            // Close the resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
