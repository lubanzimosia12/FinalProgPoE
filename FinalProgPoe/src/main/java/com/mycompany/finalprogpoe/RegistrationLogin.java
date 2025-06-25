/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogpoe;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 
 *
 * Title: Java TUTORIAL
 *
 * Author: W3Schools
 *
 * Date Accessed: 19 April 2025
 *
 * Version: N/A
 *
 * Available: https://www.w3schools.com/java/java_user_input.asp
 *
 *
 *
 * Title: How to Validate Phone Numbers in Java
 *
 * Author: Baeldung
 *
 * Date Accessed: 19 April 2025
 *
 * Version: N/A
 *
 * Available: https://www.baeldung.com/java-regex-validate-phone-numbers

 * ChatGPT by OpenAI (2025) assisted with debugging, refactoring and code completion under supervision of the student.
 */
import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.*;

//Handles registration and login functionality with validation. 
//Enforces strong password, valid phone number, and specific username rules.
public class RegistrationLogin {

    private static ArrayList<User> users = new ArrayList<>();

    public static void registerUser() {
        String firstName = JOptionPane.showInputDialog("Enter your First Name:");
        if (firstName == null || firstName.isBlank()) {
            JOptionPane.showMessageDialog(null, "First Name is required.");
            return;
        }

        String lastName = JOptionPane.showInputDialog("Enter your Last Name:");
        if (lastName == null || lastName.isBlank()) {
            JOptionPane.showMessageDialog(null, "Last Name is required.");
            return;
        }

        String username = JOptionPane.showInputDialog("Enter username (must include _ and max 5 characters):");
        if (username == null || !isValidUsername(username)) {
            JOptionPane.showMessageDialog(null, "Invalid username. It must contain an underscore (_) and be no more than 5 characters long.");
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Username successfully captured.");
        }

        String password = JOptionPane.showInputDialog("Enter password (min 8 chars, 1 uppercase, 1 digit):");
        if (password == null || !isValidPassword(password)) {
            JOptionPane.showMessageDialog(null, "Password must be 8+ chars with 1 uppercase & digit.");
            return;
        }

        String phone = JOptionPane.showInputDialog("Enter phone number (Must start with +27...):");
        if (phone == null || !phone.matches("\\+27\\d{9}")) {
            JOptionPane.showMessageDialog(null, "Invalid phone number. It must start with +27 and have 12 digits.");
            return;
        }

        users.add(new User(username, password, phone));
        JOptionPane.showMessageDialog(null, "Registration successful.\nWelcome " + firstName + " " + lastName + "!");
    }

    private static boolean isValidPassword(String pwd) {
        return pwd.length() >= 8
                && Pattern.compile("[A-Z]").matcher(pwd).find()
                && Pattern.compile("\\d").matcher(pwd).find();
    }

    private static boolean isValidUsername(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    public static User loginUser() {

        //Allows usser to enter their username and password
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");

        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(null, "Login successful!");
                return u;
            }
        }

        JOptionPane.showMessageDialog(null, "Login failed.");
        return null;
    }
}
