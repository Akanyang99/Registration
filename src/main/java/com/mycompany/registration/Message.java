package com.mycompany.registration;

import java.util.Random;

public class Message {

    private String messageID;
    private String recipient;
    private String message;

    private static int numSentMessages = 0;

    private static String[] sentMessages = new String[100];
    private static String[] storedMessages = new String[100];
    private static String[] disregardedMessages = new String[100];
    private static String[] messageHashes = new String[100];
    private static String[] messageIDs = new String[100];
    private static String[] recipients = new String[100];

    private static int messageCount = 0;
    private static int disregardedCount = 0;

    public Message(String recipient, String message) {
        this.messageID = generateMessageID();
        this.recipient = recipient;
        this.message = message;
    }

    private String generateMessageID() {
        Random rand = new Random();
        long number = 1000000000L + (long) (rand.nextDouble() * 9000000000L);
        return String.valueOf(number);
    }

    public boolean checkRecipientCell() {
        return recipient.matches("\\d{10}");
    }

    public boolean checkMessageLength() {
        return message != null
                && !message.trim().isEmpty()
                && message.length() <= 250;
    }

    public String createMessageHash() {
        String[] words = message.trim().split("\\s+");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        return messageID.substring(0, 2)
                + ":"
                + numSentMessages
                + ":"
                + firstWord
                + "_"
                + lastWord;
    }

    public String sentMessage(int choice) {

        String hash = createMessageHash();

        switch (choice) {

            case 1:
                sentMessages[messageCount] = message;
                recipients[messageCount] = recipient;
                messageIDs[messageCount] = messageID;
                messageHashes[messageCount] = hash;

                messageCount++;
                numSentMessages++;

                return "Message successfully sent.";

            case 2:
                disregardedMessages[disregardedCount] = message;
                disregardedCount++;

                return "Message disregarded.";

            case 3:
                storedMessages[messageCount] = message;
                recipients[messageCount] = recipient;
                messageIDs[messageCount] = messageID;
                messageHashes[messageCount] = hash;

                messageCount++;

                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    public String getMessageID() {
        return messageID;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public static int returnTotalMessages() {
        return numSentMessages;
    }

    public static void displayStoredMessages() {

        System.out.println("\nStored Messages");

        for (int i = 0; i < messageCount; i++) {

            if (storedMessages[i] != null) {

                System.out.println("Recipient: " + recipients[i]);
                System.out.println("Message: " + storedMessages[i]);
                System.out.println();
            }
        }
    }

    public static void displayLongestStoredMessage() {

        String longest = "";

        for (String msg : storedMessages) {

            if (msg != null && msg.length() > longest.length()) {
                longest = msg;
            }
        }

        System.out.println("\nLongest Stored Message:");
        System.out.println(longest);
    }

    public static void searchMessageID(String id) {

        for (int i = 0; i < messageIDs.length; i++) {

            if (messageIDs[i] != null && messageIDs[i].equals(id)) {

                System.out.println("Recipient: " + recipients[i]);

                if (sentMessages[i] != null) {
                    System.out.println("Message: " + sentMessages[i]);
                }

                if (storedMessages[i] != null) {
                    System.out.println("Message: " + storedMessages[i]);
                }

                return;
            }
        }

        System.out.println("Message ID not found.");
    }

    public static void searchRecipient(String recipientNumber) {

        boolean found = false;

        for (int i = 0; i < recipients.length; i++) {

            if (recipients[i] != null
                    && recipients[i].equals(recipientNumber)) {

                found = true;

                if (sentMessages[i] != null) {
                    System.out.println(sentMessages[i]);
                }

                if (storedMessages[i] != null) {
                    System.out.println(storedMessages[i]);
                }
            }
        }

        if (!found) {
            System.out.println("No messages found.");
        }
    }

    public static void deleteMessage(String hash) {

        for (int i = 0; i < messageHashes.length; i++) {

            if (messageHashes[i] != null
                    && messageHashes[i].equals(hash)) {

                sentMessages[i] = null;
                storedMessages[i] = null;
                recipients[i] = null;
                messageIDs[i] = null;
                messageHashes[i] = null;

                System.out.println("Message successfully deleted.");
                return;
            }
        }

        System.out.println("Hash not found.");
    }

    public static void displayReport() {

        System.out.println("\nFULL MESSAGE REPORT");

        for (int i = 0; i < messageCount; i++) {

            if (sentMessages[i] != null || storedMessages[i] != null) {

                System.out.println("----------------------");
                System.out.println("Message ID: " + messageIDs[i]);
                System.out.println("Message Hash: " + messageHashes[i]);
                System.out.println("Recipient: " + recipients[i]);

                if (sentMessages[i] != null) {
                    System.out.println("Message: " + sentMessages[i]);
                }

                if (storedMessages[i] != null) {
                    System.out.println("Message: " + storedMessages[i]);
                }
            }
        }
    }
}
