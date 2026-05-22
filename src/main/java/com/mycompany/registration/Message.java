package com.mycompany.registration;

import java.util.Random;

public class Message {

    private String messageID;
    private String recipient;
    private String message;
    private static int numSentMessages = 0;

    // Constructor
    public Message(String recipient, String message) {
        this.messageID = generateMessageID();
        this.recipient = recipient;
        this.message = message;
    }

    // Generate 10-digit message ID
    private String generateMessageID() {
        Random rand = new Random();
        long number = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(number);
    }

    // Validate recipient number
    public boolean checkRecipientCell() {
        return recipient.matches("\\d{10}");
    }

    // Validate message length
    public boolean checkMessageLength() {
        return message != null && !message.trim().isEmpty() && message.length() <= 250;
    }

    // Create message hash
    public String createMessageHash() {
        String[] words = message.trim().split("\\s+");
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();
        return messageID.substring(0, 2) + ":" + numSentMessages + ":" + firstWord + "_" + lastWord;
    }

    // Send / Store / Disregard
    public String sentMessage(int choice) {
        switch (choice) {
            case 1:
                numSentMessages++;
                return "Message successfully sent.";
            case 2:
                return "Message disregarded.";
            case 3:
                return "Message successfully stored.";
            default:
                return "Invalid option.";
        }
    }

    // Getters
    public String getMessageID() { return messageID; }
    public String getRecipient() { return recipient; }
    public String getMessage() { return message; }

    public static int returnTotalMessages() { return numSentMessages; }
}