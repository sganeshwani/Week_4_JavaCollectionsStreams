package com.junit.basicjunittest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

public class PerformanceTesterTest {

    PerformanceTester tester = new PerformanceTester();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    public void testLongRunningTask() {
        // This test should fail due to timeout
        assertEquals("done", tester.longRunningTask());
    }
}