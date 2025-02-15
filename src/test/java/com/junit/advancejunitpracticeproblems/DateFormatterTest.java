package com.junit.advancejunitpracticeproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.format.DateTimeParseException;

public class DateFormatterTest {

    DateFormatter formatter = new DateFormatter();

    @Test
    public void testValidDate() {
        // Validate conversion for a valid date
        String formatted = formatter.formatDate("2025-02-15");
        assertEquals("15-02-2025", formatted);
    }

    @Test
    public void testInvalidDate() {
        // Validate exception for an invalid date
        assertThrows(DateTimeParseException.class, () -> {
            formatter.formatDate("invalid-date");
        });
    }
}