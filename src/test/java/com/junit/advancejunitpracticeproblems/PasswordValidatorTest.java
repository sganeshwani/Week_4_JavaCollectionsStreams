package com.junit.advancejunitpracticeproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    PasswordValidator validator = new PasswordValidator();

    @Test
    public void testValidPassword() {
        // Verify password meets criteria
        assertTrue(validator.isValid("Password1"));
    }

    @Test
    public void testShortPassword() {
        // Verify password fails due to insufficient length
        assertFalse(validator.isValid("Pass1"));
    }

    @Test
    public void testMissingUppercase() {
        // Verify password fails due to no uppercase letter
        assertFalse(validator.isValid("password1"));
    }

    @Test
    public void testMissingDigit() {
        // Verify password fails due to no digit
        assertFalse(validator.isValid("Password"));
    }

    @Test
    public void testNullPassword() {
        // Verify password fails when null
        assertFalse(validator.isValid(null));
    }
}