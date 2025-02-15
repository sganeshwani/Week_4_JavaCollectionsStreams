package com.junit.basicjunittest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    // Test for reverse method.
    @Test
    public void testReverse() {
        String original = "hello";
        String expected = "olleh";
        assertEquals(expected, StringUtils.reverse(original));
    }

    // Test for isPalindrome method.
    @Test
    public void testIsPalindrome() {
        // "racecar" is a palindrome.
        assertTrue(StringUtils.isPalindrome("racecar"));

        // "hello" is not a palindrome.
        assertFalse(StringUtils.isPalindrome("hello"));
    }

    // Test for toUpperCase method.
    @Test
    public void testToUpperCase() {
        String original = "hello";
        String expected = "HELLO";
        assertEquals(expected, StringUtils.toUpperCase(original));
    }
}