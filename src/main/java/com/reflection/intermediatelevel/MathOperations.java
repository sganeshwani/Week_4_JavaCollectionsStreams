package com.reflection.intermediatelevel;

import java.lang.reflect.Method;
import java.util.Scanner;

public class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

class DynamicMethodInvocation {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Create an instance of MathOperations
            MathOperations mathOperations = new MathOperations();

            // Get user input for method name and parameters
            System.out.print("Enter the method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();
            System.out.print("Enter the first parameter (int): ");
            int param1 = scanner.nextInt();
            System.out.print("Enter the second parameter (int): ");
            int param2 = scanner.nextInt();

            // Access the method dynamically using reflection
            Method method = MathOperations.class.getMethod(methodName, int.class, int.class);

            // Invoke the method dynamically
            int result = (int) method.invoke(mathOperations, param1, param2);
            System.out.println("Result of " + methodName + ": " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
