package com.junit.advancejunitpracticeproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount(1000); // Initial balance 1000
    }

    @Test
    public void testDeposit() {
        account.deposit(500);
        // Verify balance is updated correctly
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void testWithdrawWithSufficientFunds() {
        boolean result = account.withdraw(300);
        // Verify withdrawal is successful and balance updates
        assertTrue(result);
        assertEquals(700, account.getBalance());
    }

    @Test
    public void testWithdrawWithInsufficientFunds() {
        boolean result = account.withdraw(2000);
        // Verify withdrawal fails when funds are insufficient
        assertFalse(result);
        assertEquals(1000, account.getBalance());
    }
}