package com.regex.basicregexproblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LicensePlateNumber {

    // Method to validate the license plate number using regex
    public static boolean isValidLicensePlate(String licensePlate) {
        // Regular expression for a valid license plate
        String regex = "^[A-Z]{2}\\d{4}$";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(licensePlate);

        // Check if the license plate matches the regex
        return matcher.matches();
    }

    public static void main(String[] args) {
            String[] licencePlates={"AB1234", "A12345"};
            for(String licencePlate: licencePlates){
                System.out.println(licencePlate+ ": " + (isValidLicensePlate(licencePlate)?"Valid":"Invalid"));
            }
    }
}
