package com.mapinterface;

import java.util.*;

public class MergeTwoMaps {
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        // Create a new map to store the merged result
        Map<String, Integer> mergedMap = new HashMap<>(map1); // Copy all values from map1

        // Iterate through map2 and merge values
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            // If key already exists, sum the values; otherwise, add new key-value pair
            mergedMap.put(key, mergedMap.getOrDefault(key, 0) + value);
        }

        return mergedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge the maps
        Map<String, Integer> mergedResult = mergeMaps(map1, map2);

        System.out.println("Merged Map: " + mergedResult);
    }
}

