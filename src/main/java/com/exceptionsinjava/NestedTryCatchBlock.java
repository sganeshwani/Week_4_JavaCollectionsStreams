package com.exceptionsinjava;

import java.util.*;

public class NestedTryCatchBlock {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            // Take an array and divisor as input
            System.out.print("Enter the length of array: ");
            int n = input.nextInt(); // length of array
            int[] arr = new int[n];
            System.out.println("Enter the " + n + " elements of array: ");
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }

            // Nested try block
            try {
                System.out.print("Enter Divisor: ");
                int divisor = input.nextInt();
                System.out.print("Enter index to be divided: ");
                int index = input.nextInt();

                // May give an array out of bounds or an arithmetic exception
                System.out.println("Result: " + arr[index] / divisor);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            } catch (ArrayIndexOutOfBoundsException e) { // Handling index exception inside nested try
                System.out.println("Invalid array index!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numbers only.");
        }
    }
}