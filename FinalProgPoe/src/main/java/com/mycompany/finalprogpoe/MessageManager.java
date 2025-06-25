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
package com.mycompany.finalprogpoe;

import javax.swing.*;
import java.util.ArrayList;

public class MessageManager {
//Manages sending, storing, searching, and deleting messages. Also generates reports and allows message export to JSON.
 

    private static ArrayList<Message> messages = new ArrayList<>();

    public static void sendMessage() {
        String input = JOptionPane.showInputDialog("How many messages would you like to send? (Leave blank for infinite)");
        int numMessages = -1;

        if (input != null && !input.isBlank()) {
            try {
                numMessages = Integer.parseInt(input);
                if (numMessages <= 0) {
                    JOptionPane.showMessageDialog(null, "Enter a number greater than 0.");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number entered.");
                return;
            }
        }

        int count = 0;
        while (numMessages == -1 || count < numMessages) {
            String recipient = JOptionPane.showInputDialog("Enter recipient phone number (e.g., +27831234567):");
            if (recipient == null || !recipient.matches("\\+27\\d{9}")) {
                JOptionPane.showMessageDialog(null, "Invalid recipient phone number.");
                continue;
            }

            String msg = JOptionPane.showInputDialog("Enter your message (max 250 characters):");
            if (msg == null) {
                break;
            }

            if (msg.length() > 250) {
                int over = msg.length() - 250;
                JOptionPane.showMessageDialog(null, "Message is too long by " + over + " characters.");
                continue;
            }

            Message message = new Message(recipient, msg);

            String[] options = {"Send & Store", "Send & Disregard", "Cancel"};
            int choice = JOptionPane.showOptionDialog(null,
                    "Message:\n" + msg + "\nRecipient: " + recipient,
                    "Choose Option",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);

            if (choice == 0) { // Send & Store
                messages.add(message);
                JOptionPane.showMessageDialog(null,
                        "Message sent and stored.\nMessage ID: " + message.getMessageID()
                        + "\nMessage Hash: " + message.getMessageHash());
                count++;
            } else if (choice == 1) { // Disregard
                JOptionPane.showMessageDialog(null, "Message sent but NOT stored.");
                count++;
            } else { // Cancel
                JOptionPane.showMessageDialog(null, "Message canceled.");
                break;
            }

            if (numMessages == -1) {
                int cont = JOptionPane.showConfirmDialog(null, "Send another message?", "Continue?", JOptionPane.YES_NO_OPTION);
                if (cont != JOptionPane.YES_OPTION) {
                    break;
                }
            }
        }
    }

    public static void viewLongestMessage() {
        if (messages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages to display.");
            return;
        }

        Message longest = messages.get(0);
        for (Message m : messages) {
            if (m.getMessageText().length() > longest.getMessageText().length()) {
                longest = m;
            }
        }

        JOptionPane.showMessageDialog(null, "Longest Message (" + longest.getMessageText().length() + " chars):\n"
                + longest.getSummary());
    }

    public static void searchMessage() {
        if (messages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages stored to search.");
            return;
        }

        String input = JOptionPane.showInputDialog("Search by:\n1. Message ID\n2. Message Hash");
        if (input == null) {
            return;
        }

        String value = JOptionPane.showInputDialog("Enter the value to search:");
        if (value == null || value.isBlank()) {
            return;
        }

        Message found = null;
        for (Message msg : messages) {
            if ((input.equals("1") && msg.getMessageID().equals(value))
                    || (input.equals("2") && msg.getMessageHash().equalsIgnoreCase(value))) {
                found = msg;
                break;
            }
        }

        if (found != null) {
            JOptionPane.showMessageDialog(null, "Message found:\n" + found.getSummary());
        } else {
            JOptionPane.showMessageDialog(null, "No message found with that value.");
        }
    }

    public static void deleteMessage() {
        if (messages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages to delete.");
            return;
        }

        StringBuilder all = new StringBuilder();
        for (int i = 0; i < messages.size(); i++) {
            all.append(i + 1).append(". ").append(messages.get(i).getSummary()).append("\n");
        }

        String input = JOptionPane.showInputDialog("Choose message number to delete:\n" + all);
        if (input == null) {
            return;
        }

        try {
            int index = Integer.parseInt(input) - 1;
            if (index >= 0 && index < messages.size()) {
                messages.remove(index);
                JOptionPane.showMessageDialog(null, "Message deleted.");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid number.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input.");
        }
    }

    public static void showFullReport() {
        if (messages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages stored.");
            return;
        }

        StringBuilder report = new StringBuilder("Message Report:\n");
        for (Message m : messages) {
            report.append(m.getSummary()).append("\n");
        }

        JOptionPane.showMessageDialog(null, report.toString());
    }
}
