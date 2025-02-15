package com.regex.advancedproblems;

import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
        // Example input IP address
        String ipAddress = "192.118.1.1";

        // Regex pattern to validate IPv4 address
        String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the IP address against the regex pattern
        Matcher matcher = pattern.matcher(ipAddress);

        // Output the result of validation
        if (matcher.matches()) {
            System.out.println(ipAddress + " is a valid IPv4 address.");
        } else {
            System.out.println(ipAddress + " is not a valid IPv4 address.");
        }
    }
}

