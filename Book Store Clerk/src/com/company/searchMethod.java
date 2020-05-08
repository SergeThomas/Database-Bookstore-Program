package com.company;
import javax.swing.*;
import java.sql.*;

public class searchMethod {
    public static void mySearchMethod() {
        try (
                //Allocating a database 'connection' object
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore_db?allowPublicKeyRetrieval=true&useSSL=false", "myuser", "a1C#3cF%d4");
                Statement stmt = conn.createStatement();
        ) {
//            JOptionPane.showConfirmDialog(null, "Display all books ");

            //Strings store the name and title of book the user is searching for
            String str1 = JOptionPane.showInputDialog("Enter Title of Book:  ");
            String str2 = JOptionPane.showInputDialog("Enter Name of Author: ");

            if ((str1 == null) & (str2 == null)) {
                JOptionPane.showMessageDialog(null, "Enter Input, Try again.", "Ebookstore", JOptionPane.INFORMATION_MESSAGE);
            }

            String TitBook = str1;
            String NamBook = str2;

            String strSelect = "SELECT * FROM books WHERE (Title='" + TitBook + "' AND Author='" + NamBook + "') ";
            System.out.println("The SQL query is: " + strSelect);
            ResultSet rSet = stmt.executeQuery(strSelect);

            // Move the cursor to the next row
            while (rSet.next()) {
                JOptionPane.showMessageDialog(null,  "Search Results: \n" + rSet.getInt("id") + ", "
                        + rSet.getString("Title") + ", "
                        + rSet.getString("Author") + ", "
                        + rSet.getInt("Qty"), "ebookStore_db", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}