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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Message {

    private String messageID;
    private String recipient;
    private String messageText;
    private String messageHash;

    public Message(String recipient, String messageText) {
        this.messageID = generateRandomID();
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = generateHash(messageText);
    }

    // Auto-incrementing ID on each message creation
// Generates a unique hash based on message ID, length, first and last words
    public String getMessageID() {
        return messageID;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public String getSummary() {
        return "ID: " + messageID
                + "\nHash: " + messageHash
                + "\nTo: " + recipient
                + "\nMsg: " + messageText + "\n";
    }

    private String generateRandomID() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10)); // 0–9
        }
        return sb.toString();
    }

    private String generateHash(String message) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(message.getBytes());
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            return "HASH_ERROR";
        }
    }
}
