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

public class User {

    private String username;
    private String password;
    private String phone;

    public User(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }
}
