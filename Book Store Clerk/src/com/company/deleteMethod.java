package com.company;
import javax.swing.*;
import java.sql.*;

public class deleteMethod {
    public static void myDeleteMethod(){
        try (
                //Allocating a database 'connection' object
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore_db?allowPublicKeyRetrieval=true&useSSL=false", "myuser", "a1C#3cF%d4");
                Statement stmt = conn.createStatement();
        ){
            //SELECT query to display books in console so user can see which one to delete
            String strSelect = "select * from books";
            System.out.println("The SQL query is: " + strSelect);
            ResultSet rSet = stmt.executeQuery(strSelect);

            // Move the cursor to the next row
            while (rSet.next()) {
                System.out.println(rSet.getInt("id") + ", "
                        + rSet.getString("Title") + ", "
                        + rSet.getString("Author") + ", "
                        + rSet.getInt("Qty"));
            }

            //This string will prompt the user on which book they want to delete.
            String str1 = JOptionPane.showInputDialog(null, "Enter name of Book you want to delete:   ");
            String bookToDelete = str1;

            //SQL query to delete book by fetching it from its title
            String sqlDelete = "DELETE FROM books WHERE Title = '" + bookToDelete + "'";
            System.out.println("The SQL query is: " + sqlDelete);

            //The count here will show us how many records have been deleted.
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + " records deleted.\n");

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}