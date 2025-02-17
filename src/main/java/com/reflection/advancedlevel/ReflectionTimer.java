package com.reflection.advancedlevel;

import java.lang.reflect.Method;

class SampleClass {

    public void method1() {
        try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Method 1 executed");
    }

    public void method2() {
        try { Thread.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Method 2 executed");
    }

    public void method3() {
        try { Thread.sleep(150); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Method 3 executed");
    }
}

public class ReflectionTimer {

    public static void main(String[] args) throws Exception {
        // The class whose methods we want to measure
        Class<?> clazz = SampleClass.class;

        // Create an instance of the class
        Object obj = clazz.getDeclaredConstructor().newInstance();

        // Get all the declared methods of the class
        Method[] methods = clazz.getDeclaredMethods();

        // Iterate over each method and measure execution time
        for (Method method : methods) {
            // Start time measurement
            long startTime = System.nanoTime();

            // Invoke the method dynamically
            method.invoke(obj);

            // End time measurement
            long endTime = System.nanoTime();

            // Calculate the execution time in milliseconds
            long duration = (endTime - startTime) / 1000000; // Convert to milliseconds

            // Display the method name and execution time
            System.out.println(method.getName() + " executed in " + duration + " ms");
        }
    }
}
