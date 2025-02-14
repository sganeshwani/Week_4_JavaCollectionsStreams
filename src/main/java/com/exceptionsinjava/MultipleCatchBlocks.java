package com.exceptionsinjava;

import java.util.*;

public class MultipleCatchBlocks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Accepting array size
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        int[] arr = new int[size];

        // Accepting array elements
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        // Accepting index to retrieve value
        System.out.print("Enter index to retrieve value: ");
        int index = input.nextInt();

        try {
            // Retrieving and printing value at given index
            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");  // Handles invalid index
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");  // Handles null array
        }
    }
}
