package com.junit.basicjunittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class CalculatorTest {

    // Create an instance of Calculator to test.
    Calculator calc = new Calculator();

    // Test for the add method.
    @Test
    public void testAddition() {
        assertEquals(5, calc.add(2, 3));
    }

    // Test for the subtract method.
    @Test
    public void testSubtraction() {
        assertEquals(1, calc.subtract(3, 2));
    }

    // Test for the multiply method.
    @Test
    public void testMultiplication() {
        assertEquals(6, calc.multiply(2, 3));
    }

    // Test for the divide method.
    @Test
    public void testDivision() {
        assertEquals(2, calc.divide(6, 3));
    }

    // Test that division by zero throws an exception.
    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(5, 0);
        });
    }
}