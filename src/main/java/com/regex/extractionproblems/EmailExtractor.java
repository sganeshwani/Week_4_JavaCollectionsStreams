package com.regex.extractionproblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExtractor {
    public static void main(String[] args) {
        // Sample text containing email addresses
        String text = "Contact us at support@example.com and info@company.org";

        /* Define the regex pattern for matching email addresses
        [a-zA-Z0-9._%+-]+ : Matches one or more allowed characters in the email's username.
        @                 : The '@' symbol separating the username and domain.
        [a-zA-Z0-9.-]+    : Matches one or more allowed characters in the domain name.
        \\.               : Escaped dot ('.') character to match the period in the domain.
        [a-zA-Z]{2,}      : Matches the domain extension which must have at least two letters.
        */
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

        // Create a matcher that will search the text for the pattern
        Matcher matcher = emailPattern.matcher(text);

        // Iterate over all matches found and print them
        while (matcher.find()) {
            // matcher.group() returns the matched email address
            System.out.println(matcher.group());
        }
    }
}