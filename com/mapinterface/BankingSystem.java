package com.mapinterface;

import java.util.*;

public class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>();
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Add a new account
    public void addAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    // Deposit money
    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double oldBalance = accounts.get(accountNumber);
            sortedAccounts.remove(oldBalance);
            double newBalance = oldBalance + amount;
            accounts.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber);
        }
    }

    // Request a withdrawal
    public void requestWithdrawal(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.offer(new WithdrawalRequest(accountNumber, amount));
        }
    }

    // Process withdrawals
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            int accountNumber = request.accountNumber;
            double amount = request.amount;

            if (accounts.containsKey(accountNumber) && accounts.get(accountNumber) >= amount) {
                double oldBalance = accounts.get(accountNumber);
                sortedAccounts.remove(oldBalance);
                double newBalance = oldBalance - amount;
                accounts.put(accountNumber, newBalance);
                sortedAccounts.put(newBalance, accountNumber);
                System.out.println("Withdrawal successful for account " + accountNumber + " Amount: " + amount);
            } else {
                System.out.println("Insufficient funds for account " + accountNumber);
            }
        }
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<Double, Integer> entry : sortedAccounts.entrySet()) {
            System.out.println("Account: " + entry.getValue() + " Balance: " + entry.getKey());
        }
    }

    // Withdrawal request class
    static class WithdrawalRequest {
        int accountNumber;
        double amount;

        WithdrawalRequest(int accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount(101, 5000);
        bank.addAccount(102, 3000);
        bank.addAccount(103, 7000);

        bank.deposit(101, 2000);
        bank.requestWithdrawal(102, 1000);
        bank.requestWithdrawal(103, 8000);

        bank.processWithdrawals();
        bank.displaySortedAccounts();
    }
}