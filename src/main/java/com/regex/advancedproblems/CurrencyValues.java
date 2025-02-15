package com.regex.advancedproblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyValues {
    public static void main(String[] args) {
        //Input text
        String text= "The price is $45.99, and the discount is 10.50.";

        // Regex pattern to match
        String regex = "\\$?\\d+(?:\\.\\d{2})?";

        //Compile the regex pattern
        Pattern pattern= Pattern.compile(regex);

        // Create a matcher to find the matches
        Matcher matcher= pattern.matcher(text);

        //Find all matching words or numbers
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
