package com.exceptionsinjava;

public class MethodPropagation {
    // Method 1: Throws ArithmeticException (10 / 0)
    public static void method1() {
        System.out.println("Executing method1");
        int result = 10/0; // This will throw ArithmeticException
    }

    // Method 2: Calls method1()
    public static void method2() {
        System.out.print("Executing method2 -> ");
        method1(); // Exception propagates from method1
    }

    // Main method: Calls method2() and handles the exception
    public static void main(String[] args) {
        try {
            System.out.print("Executing main -> ");
            method2(); // Calls method2(), which calls method1()
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main: " + "Cannot divide with zero");
        }
    }
}
