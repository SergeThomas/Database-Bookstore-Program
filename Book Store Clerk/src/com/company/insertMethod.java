package com.company;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class insertMethod {
    //This is the insert method that will called in the main function.
    public static void myInsertMethod(){
         try (
        //Allocating a database 'connection' object
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore_db?allowPublicKeyRetrieval=true&useSSL=false", "myuser", "a1C#3cF%d4");
        Statement stmt = conn.createStatement();

        ){
             //user Inputs will be stored in these strings
             String str1 = JOptionPane.showInputDialog("Enter Name of book");
             String str2 = JOptionPane.showInputDialog("Enter Name of Author");
             String str3 = JOptionPane.showInputDialog("Enter amount of books");

             String Nb = str1;
             String Na = str2;
             int Ab = Integer.parseInt(str3);

             //The sql statement is the command that we would type into the database but initiated here.
             String sql="INSERT INTO books(Title,Author,Qty) VALUES('" + Nb + "', '" + Na + "', '" + Ab + "')";
             stmt.executeUpdate(sql);

             //This is for us to see that record was inserted into the table.
             System.out.println("Inserted records into the table...");

            // Issue a SELECT to check the changes
            String strSelect = "select * from books";
            System.out.println("The SQL query is: " + strSelect); //this is for us so it will be displayed to us.
            ResultSet rSet = stmt.executeQuery(strSelect);

            // Move the cursor to the next row
            while (rSet.next()) {
                System.out.println(rSet.getInt("id") + ", "
                        + rSet.getString("Title") + ", "
                        + rSet.getString("Author") + ", "
                        + rSet.getInt("Qty"));
            }
        } catch (
        SQLException e) {
            e.printStackTrace();
        }
    }
}
