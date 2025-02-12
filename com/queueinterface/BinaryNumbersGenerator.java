package com.queueinterface;

import java.util.*;

public class BinaryNumbersGenerator {
    public static void generateBinaryNumbers(int N) {
        Queue<String> queue = new LinkedList<>();

        // Start with "1" in the queue
        queue.add("1");

        // Generate N binary numbers
        for (int i = 0; i < N; i++) {
            String front = queue.poll(); // Remove the front element
            System.out.print(front + " ");

            // Generate next two binary numbers and add them to the queue
            queue.add(front + "0");
            queue.add(front + "1");
        }
    }

    public static void main(String[] args) {
        int N = 5;
        generateBinaryNumbers(N);
    }
}

