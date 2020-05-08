package com.company;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class updateMethod {
    //This is the update method that will called in the main function.
    public static void myUpdateMethod(){
        try (
                // Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager . getConnection (
                        "jdbc:mysql://localhost:3306/ebookStore_db?useSSL=false" , "myuser" , "a1C#3cF%d4" );
                //Allocate a 'Statement' object in the Connection
                Statement stmt = conn.createStatement ();
        ) {
            JOptionPane.showMessageDialog(null, "Library Displayed In Console \n", "Ebookstore_db", JOptionPane.INFORMATION_MESSAGE);

            //Issue a SELECT to display the books.
            String strSelect = "select * from books";
            System.out.println("The SQL query is: " + strSelect);
            ResultSet rSet = stmt.executeQuery(strSelect);

            while (rSet.next ()) { // Move the cursor to the next row
                System.out.println(rSet.getInt ( "id" ) + ", "
                        + rSet.getString ( "author" ) + ", "
                        + rSet.getString ( "title" ) + ", "
                        + rSet.getInt ( "qty" ));
            }

            // Execute a SQL UPDATE via executeUpdate()
            String str1 = JOptionPane.showInputDialog("Enter the Title of the Book you want to update:  ");
            String str2 = JOptionPane.showInputDialog("Enter New Qty of book:  ");

            String bookToUpdate = str1;
            int bookQuantity = Integer.parseInt(str2);

            String strUpdate = "UPDATE BOOKS SET Qty = '" + bookQuantity + "' WHERE TITLE = '" + bookToUpdate + "' ";
            System.out.println("The SQL query is: " + strUpdate );
            int countUpdated = stmt.executeUpdate(strUpdate);
            System.out.println(countUpdated + " records affected." );

        } catch ( SQLException ex ) {
            ex.printStackTrace ();
        }
        // Step 5: Close the resources - Done automatically by try-with-resources
    }
}

