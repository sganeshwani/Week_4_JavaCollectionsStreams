package com.mapinterface;

import java.util.*;

public class InvertMap {

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        // Iterate through each entry in the original map
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            // If the value does not exist in the inverted map, create a new list
            invertedMap.putIfAbsent(value, new ArrayList<>());

            // Add the corresponding key to the list of keys for this value
            invertedMap.get(value).add(key);
        }
        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1); // Duplicate value (1) with a different key (C)

        // Call the invertMap function
        Map<Integer, List<String>> inverted = invertMap(inputMap);

        System.out.println("Inverted Map: " + inverted);
    }
}

