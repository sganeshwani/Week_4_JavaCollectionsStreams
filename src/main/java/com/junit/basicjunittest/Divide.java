package com.junit.basicjunittest;

public class Divide {

    // Divide a by b and throw exception if b is zero
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}