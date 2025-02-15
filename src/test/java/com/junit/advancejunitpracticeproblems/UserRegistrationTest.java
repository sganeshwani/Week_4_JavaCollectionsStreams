package com.junit.advancejunitpracticeproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    UserRegistration userReg = new UserRegistration();

    @Test
    public void testValidRegistration() {
        String result = userReg.registerUser("john", "john@example.com", "password123");
        // Verify valid registration returns success message
        assertEquals("User registered successfully", result);
    }

    @Test
    public void testInvalidUsername() {
        // Verify exception is thrown for invalid username
        assertThrows(IllegalArgumentException.class, () -> {
            userReg.registerUser("", "john@example.com", "password123");
        });
    }

    @Test
    public void testInvalidEmail() {
        // Verify exception is thrown for invalid email
        assertThrows(IllegalArgumentException.class, () -> {
            userReg.registerUser("john", "johnexample.com", "password123");
        });
    }

    @Test
    public void testInvalidPassword() {
        // Verify exception is thrown for invalid password
        assertThrows(IllegalArgumentException.class, () -> {
            userReg.registerUser("john", "john@example.com", "pass");
        });
    }
}