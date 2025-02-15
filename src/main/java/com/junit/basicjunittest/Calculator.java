package com.junit.basicjunittest;

public class Calculator {

    // Adds two numbers
    public int add(int a, int b) {
        return a + b;
    }

    // Subtracts two numbers
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplies two numbers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Divides the first number by the second
    // Throws ArithmeticException if division by zero is attempted
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}