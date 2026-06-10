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
        System.out.println("\nTotal messages sent: "
        + Message.returnTotalMessages());

char option;

do {

    System.out.println("\nSTORED MESSAGES MENU");
    System.out.println("a) Display sender and recipient of all stored messages");
    System.out.println("b) Display the longest stored message");
    System.out.println("c) Search for a message by Message ID");
    System.out.println("d) Search for all messages for a particular recipient");
    System.out.println("e) Delete a message using its Message Hash");
    System.out.println("f) Display full report of all stored messages");
    System.out.println("g) Return to CloudChat Menu");
    System.out.print("Choose an option: ");

    option = input.nextLine().toLowerCase().charAt(0);

    switch (option) {

        case 'a':

            Message.displayStoredMessages();
            break;

        case 'b':

            Message.displayLongestStoredMessage();
            break;

        case 'c':

            System.out.print("Enter Message ID: ");
            String id = input.nextLine();

            Message.searchMessageID(id);
            break;

        case 'd':

            System.out.print("Enter Recipient Number: ");
            String recipient = input.nextLine();

            Message.searchRecipient(recipient);
            break;

        case 'e':

            System.out.print("Enter Message Hash: ");
            String hash = input.nextLine();

            Message.deleteMessage(hash);
            break;

        case 'f':

            Message.displayReport();
            break;

        case 'g':

            System.out.println("Returning to CloudChat Menu...");
            break;

        default:

            System.out.println("Invalid option.");
    }

} while (option != 'g');
    }
}
