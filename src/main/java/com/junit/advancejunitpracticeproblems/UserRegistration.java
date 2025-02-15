package com.junit.advancejunitpracticeproblems;

public class UserRegistration {

    // Registers a user and validates inputs
    public String registerUser(String username, String email, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Invalid password");
        }
        // Registration logic can be added here
        return "User registered successfully";
    }
}