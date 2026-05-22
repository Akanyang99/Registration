package com.mycompany.registration;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login login = new Login();
        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    login.register(sc);
                    break;

                case "2":
                    boolean loggedIn = login.login(sc);
                    if (loggedIn) {
                        QuickChat.launchChat(sc); // launch chat after login
                    }
                    break;

                case "3":
                    System.out.println("Exiting program...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        sc.close();
    }
}