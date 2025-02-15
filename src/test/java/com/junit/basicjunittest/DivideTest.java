package com.junit.basicjunittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DivideTest {

    Calculator calc = new Calculator();

    @Test
    public void testDivideByZero() {
        // Verify ArithmeticException is thrown when dividing by zero
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0);
        });
    }

    @Test
    public void testDivideNormal() {
        // Verify normal division
        assertEquals(2, calc.divide(10, 5));
    }
}