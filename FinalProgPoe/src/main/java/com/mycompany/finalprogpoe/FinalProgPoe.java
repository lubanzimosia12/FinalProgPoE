/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.finalprogpoe;

/**
 *
 * @author Nqobile
 */
/**
 * CODE ATTRIBUTION!!!!!!!!!!! Login class handles user registration, login, and
 * welcome message logic.
 *
 * Date: April 2025
 *
 * Code Attribution:
 *
 * Title: Java Scanner Class Author: W3Schools Date Accessed: 19 April 2025
 * Version: N/A Available: https://www.w3schools.com/java/java_user_input.asp
 *
 * Title: Java Regular Expressions - Java Regex Author: Oracle Date Accessed: 19
 * April 2025 Version: Java SE 8 Available:
 * https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
 *
 * Title: How to Validate Phone Numbers in Java Author: Baeldung Date Accessed:
 * 19 April 2025 Version: N/A Available:
 * https://www.baeldung.com/java-regex-validate-phone-numbers
 */
import javax.swing.*;

// Main class to start the application using a menu-driven JOptionPane interface,handles user registration, login, and access to the message menu.
public class FinalProgPoe {

    public static void main(String[] args) {

// Infinite loop to show main menu until user exits
        while (true) {
            String[] options = {"Register", "Login", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Welcome", "Main Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    options, options[0]);

            if (choice == 0) {
                RegistrationLogin.registerUser();
            } else if (choice == 1) {
                User user = RegistrationLogin.loginUser();
                if (user != null) {
                    messageMenu(user);
                }
            } else {
                break; // Exit the application
            }
        }
    }
// Menu after login for sending, managing and exporting messages

    private static void messageMenu(User user) {
        while (true) {
            String[] menu = {"Send Message", "View Longest", "Search", "Delete", "Report", "Logout"};
            int opt = JOptionPane.showOptionDialog(null, "Welcome " + user.getUsername(),
                    "Messaging Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, menu, menu[0]);

            switch (opt) {
                case 0 ->
                    MessageManager.sendMessage();  // Send new message
                case 1 ->
                    MessageManager.viewLongestMessage(); //Show longest message
                case 2 ->
                    MessageManager.searchMessage(); //search by ID or hash
                case 3 ->
                    MessageManager.deleteMessage(); //deletes a message
                case 4 ->
                    MessageManager.showFullReport();  //show full message summary 
                case 5 -> {
                    return; //Logout
                }
            }
        }
    }
}
