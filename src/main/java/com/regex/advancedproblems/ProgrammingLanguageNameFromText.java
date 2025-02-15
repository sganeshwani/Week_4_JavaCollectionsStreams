package com.regex.advancedproblems;

import java.util.regex.*;

public class ProgrammingLanguageNameFromText {
    public static void main(String[] args) {
        // Example input text
        String inputText = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // Regex pattern to match programming languages like Java, Python, JavaScript, Go, etc.
        String regex = "\\b(Java|Python|JavaScript|Go)\\b";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher to find the matches
        Matcher matcher = pattern.matcher(inputText);

        // Find  all matching Text to the list
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

