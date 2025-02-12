package com.mapinterface;

import java.util.*;

public class MaxValueKeyFinder {
    public static String findMaxKey(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return null; // Return null if the map is empty
        }

        String maxKey = null; // Variable to store the key with the highest value
        int maxValue = Integer.MIN_VALUE; // Initialize with the smallest possible value

        // Iterate through the map entries
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) { // Check if current value is greater
                maxValue = entry.getValue(); // Update max value
                maxKey = entry.getKey(); // Update corresponding key
            }
        }

        return maxKey; // Return the key with the highest value
    }

    public static void main(String[] args) {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);

        // Find the key with the highest value
        String maxKey = findMaxKey(inputMap);

        System.out.println("Key with the highest value: " + maxKey);
    }
}

