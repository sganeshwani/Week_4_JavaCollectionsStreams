package com.regex.basicregexproblems;

import java.util.*;
public class ValidUsername {
    // Method to validate username using regex
    public static boolean isValidUsername(String username) {
        // Using regex to check for valid username format
        /*
        1. Can only contain letters (a-z, A-Z), numbers (0-9), and underscores (_)
        2. Must start with a letter
        3. Must be between 5 and 15 characters long
        */
        return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a username: "); // take username as input
        String username = input.nextLine();

        if (isValidUsername(username)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}