package com.regex.extractionproblems;

import java.util.regex.*;

public class LinksFromWebPage {

    public static void main(String[] args) {
        // Example text containing URLs
        String text = "Visit https://www.google.com and http://example.org for more info.";

        // Regular expression for extracting links (URLs)
        String regex = "\\bhttps?://(?:www\\.)?[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}(?:/[a-zA-Z0-9-./?=&%]*)?\\b";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(text);

        // Find and add all matching URLs to the list
        while (matcher.find()) {
            System.out.println("Result: " + matcher.group());
        }
    }
}
