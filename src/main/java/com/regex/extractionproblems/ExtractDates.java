package com.regex.extractionproblems;

import java.util.regex.*;

public class ExtractDates {
    public static void main(String[] args) {
        // Example text containing dates
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        // Regular expression for extracting dates in dd/mm/yyyy format
        String regex = "\\d{2}/\\d{2}/\\d{4}";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(text);

        // Find and add all matching dates to the list
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
        }

