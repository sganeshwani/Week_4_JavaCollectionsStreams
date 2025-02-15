package com.regex.replaceandmodifystrings;

public class CensorBadWords {
    public static void main(String[] args) {
        // Example input
        String input = "This is a damn bad example with some stupid words.";

        // List of bad words
        String[] badWords = {"damn", "stupid"};

        // Censor each bad word
        for (String badWord : badWords) {
            // Replace each bad word with "****"
            input = input.replaceAll("(?i)\\b" + badWord + "\\b", "****");
        }

        // Output the result
        System.out.println(input);
    }
}
