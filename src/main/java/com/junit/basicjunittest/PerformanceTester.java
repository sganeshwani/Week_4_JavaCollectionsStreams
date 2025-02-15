package com.junit.basicjunittest;

public class PerformanceTester {

    // Sleep for 3 seconds and return a result
    public String longRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "done";
    }
}