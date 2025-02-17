package com.annotations.intermediatelevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class ExecutionTimeLogger {

    // Method to log execution time of a method annotated with @LogExecutionTime
    public static void logExecutionTime(Object target, Method method, Object[] args) throws Exception {
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.nanoTime();  // Capture start time

            // Invoke the method
            method.invoke(target, args);

            long endTime = System.nanoTime();    // Capture end time
            long duration = endTime - startTime; // Calculate the execution time in nanoseconds

            System.out.println("Execution time of " + method.getName() + ": " + duration + " nanoseconds");
        } else {
            // If the method is not annotated, just invoke it
            method.invoke(target, args);
        }
    }
}

class SampleMethods {

    @LogExecutionTime
    public void methodOne() {
        try {
            Thread.sleep(500);  // Simulate some work (500 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void methodTwo() {
        try {
            Thread.sleep(200);  // Simulate some work (200 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void methodThree() {
        try {
            Thread.sleep(1000);  // Simulate some work (1000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class LoggingMethod {
    public static void main(String[] args) throws Exception {
        SampleMethods sampleMethods = new SampleMethods();

        // Get method references from SampleMethods class
        Method methodOne = SampleMethods.class.getMethod("methodOne");
        Method methodTwo = SampleMethods.class.getMethod("methodTwo");
        Method methodThree = SampleMethods.class.getMethod("methodThree");

        // Log execution times of methods
        System.out.println("Logging execution time for methodOne:");
        ExecutionTimeLogger.logExecutionTime(sampleMethods, methodOne, null);

        System.out.println("\nLogging execution time for methodTwo:");
        ExecutionTimeLogger.logExecutionTime(sampleMethods, methodTwo, null);

        System.out.println("\nLogging execution time for methodThree:");
        ExecutionTimeLogger.logExecutionTime(sampleMethods, methodThree, null);
    }
}