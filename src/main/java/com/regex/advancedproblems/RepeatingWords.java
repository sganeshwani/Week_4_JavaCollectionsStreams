package com.regex.advancedproblems;

import java.util.regex.*;
import java.util.HashSet;
import java.util.Set;

public class RepeatingWords {
    public static void main(String[] args) {
        // Example input text
        String text = "This is is a repeated repeated word test.";

        // Regex pattern to match repeated words
        String regex = "\\b(\\w+)\\b(?=.*\\b\\1\\b)";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(text);

        // Set to store the repeated words (to avoid duplicates)
        Set<String> repeatedWords = new HashSet<>();

        // Find all matching words
        while (matcher.find()) {
            // Add the repeated word to the set
            repeatedWords.add(matcher.group(1));
        }

        // Print the repeated words as a comma-separated string
        System.out.println(String.join(", ", repeatedWords));
    }
}
