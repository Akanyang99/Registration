package com.mycompany.registration;

import java.util.Scanner;

public class QuickChat {

    public static void launchChat(Scanner input) {
        System.out.print("Enter number of messages: ");
        int total = input.nextInt();
        input.nextLine();

        System.out.println("\nWelcome to QuickChat!");

        for (int i = 0; i < total; i++) {
            System.out.print("\nEnter recipient number (10 digits): ");
            String recipient = input.nextLine();

            System.out.print("Enter message: ");
            String message = input.nextLine();

            Message msg = new Message(recipient, message);

            if (!msg.checkRecipientCell()) {
                System.out.println("Cell phone number is incorrectly formatted.");
                i--; // retry this message
                continue;
            }

            if (!msg.checkMessageLength()) {
                System.out.println("Please enter a message of less than 250 characters.");
                i--; // retry this message
                continue;
            }

            System.out.println("Message ID: " + msg.getMessageID());
            System.out.println("Message Hash: " + msg.createMessageHash());

            System.out.println("\nChoose option:");
            System.out.println("1) Send Message");
            System.out.println("2) Disregard Message");
            System.out.println("3) Store Message");
            int choice = input.nextInt();
            input.nextLine();

            System.out.println(msg.sentMessage(choice));
        }

        System.out.println("\nTotal messages sent: " + Message.returnTotalMessages());
    }
}