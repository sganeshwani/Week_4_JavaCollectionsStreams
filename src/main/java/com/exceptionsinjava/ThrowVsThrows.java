package com.exceptionsinjava;

public class ThrowVsThrows {
    // Method that calculates interest and throws an exception for invalid input
    public static void calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        // Check if any input is zero or negative, throw an exception if invalid
        if (amount <= 0 || rate <= 0 || years <= 0) {
            throw new IllegalArgumentException("Invalid input: Amount, rate, and years must be positive");
        }
        // Calculate and print interest if inputs are valid
        System.out.println("Calculated Interest: " + (amount * rate * years) / 100);
    }

    public static void main(String[] args) {
        try {
            calculateInterest(10000, -10, 2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}