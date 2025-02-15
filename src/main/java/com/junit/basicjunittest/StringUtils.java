package com.junit.basicjunittest;

public class StringUtils {

    // Reverses the given string
    public static String reverse(String str) {
        // Using StringBuilder to reverse the string
        return new StringBuilder(str).reverse().toString();
    }

    // Returns true if the string is a palindrome
    public static boolean isPalindrome(String str) {
        // A string is a palindrome if it equals its reverse
        return str.equals(reverse(str));
    }

    // Converts the string to uppercase
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
}