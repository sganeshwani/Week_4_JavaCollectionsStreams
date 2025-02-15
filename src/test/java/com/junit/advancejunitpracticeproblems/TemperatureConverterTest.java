package com.junit.advancejunitpracticeproblems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    TemperatureConverter converter = new TemperatureConverter();

    @Test
    public void testCelsiusToFahrenheit() {
        // Validate conversion from Celsius to Fahrenheit
        double fahrenheit = converter.celsiusToFahrenheit(0);
        assertEquals(32, fahrenheit, 0.001);

        fahrenheit = converter.celsiusToFahrenheit(100);
        assertEquals(212, fahrenheit, 0.001);
    }

    @Test
    public void testFahrenheitToCelsius() {
        // Validate conversion from Fahrenheit to Celsius
        double celsius = converter.fahrenheitToCelsius(32);
        assertEquals(0, celsius, 0.001);

        celsius = converter.fahrenheitToCelsius(212);
        assertEquals(100, celsius, 0.001);
    }
}