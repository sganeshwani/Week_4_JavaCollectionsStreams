package com.setinterface.problem4;

import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        System.out.println("Sorted List: " + convertToSortedList(set));
    }

    // Converts a HashSet to a sorted list
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set); // Convert set to list
        Collections.sort(sortedList); // Sort list in ascending order
        return sortedList;
    }
}

