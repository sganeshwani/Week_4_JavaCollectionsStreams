package com.exceptionsinjava;

import java.util.*;

// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message); // Pass message to Exception class
    }
}

class BankAccount {
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Method to withdraw money with exception handling
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) { // Check for negative amount
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) { // Check for sufficient balance
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount; // Deduct amount from balance
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double balance = input.nextDouble(); // Get initial balance from user
        BankAccount account = new BankAccount(balance);

        try {
            System.out.print("Enter withdrawal amount: ");
            double amount = input.nextDouble(); // Get withdrawal amount
            account.withdraw(amount); // Attempt withdrawal
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage()); // Handle insufficient balance
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Handle invalid amount
        } finally {
            input.close(); // Close scanner resource
        }
    }
}

