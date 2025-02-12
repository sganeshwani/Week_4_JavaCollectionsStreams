package com.setinterface.problem3;

import java.util.*;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println("Symmetric Difference: " + getSymmetricDifference(set1, set2));
    }

    // Computes the symmetric difference of two sets
    public static Set<Integer> getSymmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> symDiff = new HashSet<>(set1);
        symDiff.addAll(set2);  // Union of both sets

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2); // Common elements

        symDiff.removeAll(intersection); // Remove common elements
        return symDiff;
    }
}