package com.mycompany.registration;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {

    private Map<String, String> users = new HashMap<>();
    private Map<String, String> phones = new HashMap<>();
    private boolean loggedIn = false;

    // Register new user
    public void register(Scanner sc) {
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        if (!checkUserName(username) || !checkPassword(password) || !checkPhone(phone)) {
            System.out.println("Invalid registration data.");
            return;
        }

        users.put(username, password);
        phones.put(username, phone);
        System.out.println("User registered!");
    }

    // Login user
    public boolean login(Scanner sc) {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            loggedIn = true;
            System.out.println("Login successful!");
            return true;
        } else {
            loggedIn = false;
            System.out.println("Username or password incorrect.");
            return false;
        }
    }

    public boolean checkUserName(String username) {
        return username != null && username.matches("[a-zA-Z0-9]{3,}");
    }

    public boolean checkPassword(String password) {
        return password != null && password.length() >= 8;
    }

    public boolean checkPhone(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    boolean isUserRegistered(String myUser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
