package com.regex.advancedproblems;

import java.util.regex.*;

public class CreditCardNumberValidator {
    public static void main(String[] args) {
        // Example input credit card number
        String creditCardNumber = "411122233334444";

        // Regex pattern to validate Visa (starts with 4) and MasterCard (starts with 5), both with 16 digits
        String regex = "^(4\\d{15}|5\\d{15})$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the credit card number against the regex pattern
        Matcher matcher = pattern.matcher(creditCardNumber);

        // Output the result of validation
        if (matcher.matches()) {
            System.out.println(creditCardNumber + " is a valid credit card number.");
        } else {
            System.out.println(creditCardNumber + " is not a valid credit card number.");
        }
    }
}