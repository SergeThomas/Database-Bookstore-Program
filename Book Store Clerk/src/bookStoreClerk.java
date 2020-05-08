import com.company.insertMethod;
import com.company.searchMethod;
import com.company.updateMethod;
import com.company.deleteMethod;

import javax.swing.*;
import java.awt.*;

public class bookStoreClerk {
    public static void main(String[] args) {

        int selection; //Initialised up here so we can call it below.
        do {
            //This will bring up the menu that is under the loop until the user decides to leave.
            String selectionStr = JOptionPane.showInputDialog(null,"Pick an Option Below\n 1. Enter book\n 2. Update book\n 3. Delete book\n 4. Search books\n 0. Exit");
            if (selectionStr == null) {
                try {
                    JOptionPane.showMessageDialog(null, "Program Terminated");
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
            }
            //Switch case to go through each option the user chooses and return appropriate result through method called.
            selection = Integer.parseInt(selectionStr);
            switch (selection) {
                case 1:    //Method to insert
                    insertMethod inMeth = new insertMethod();
                    inMeth.myInsertMethod();
                    JOptionPane.showMessageDialog(null, "Book has been entered into the Database", "EbookStore_db", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 2:    //Method to update
                    updateMethod upMeth = new updateMethod();
                    upMeth.myUpdateMethod();
                    JOptionPane.showMessageDialog(null, "Database has been updated",  "Ebookstore_db", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 3:    //Method to delete
                    deleteMethod deMeth = new deleteMethod();
                    deMeth.myDeleteMethod();
                    JOptionPane.showMessageDialog(null, "Book has been deleted!", "Ebookstore_db", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 4:    //Method to search
                    searchMethod seMeth = new searchMethod();
                    seMeth.mySearchMethod();
                    JOptionPane.showMessageDialog(null,"Search Complete", "Ebookstore_db", JOptionPane.INFORMATION_MESSAGE);
                    break;


                default:    //This is our error handling, if the user enters anything more than the options showed to them then we show them the error/warning message
                    if (selection >= 5){
                    JOptionPane.showMessageDialog(null, "Invalid Input Entered! \nTry Again", "EbookStore_db", JOptionPane.WARNING_MESSAGE);
                }
                    break;
            }
         //If the user enters 0 the program will break out the loop and end.
        } while (selection != 0);
        JOptionPane.showMessageDialog(null, "You Have Exited the Database.\n Goodbye!", "EbookStore_db", JOptionPane.INFORMATION_MESSAGE);
    }
}