package com.setinterface.problem2;

import java.util.*;

public class SetOperations {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println("Union: " + getUnion(set1, set2));
        System.out.println("Intersection: " + getIntersection(set1, set2));
    }

    // Check the union of two sets
    public static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2); // Adds all elements from set2
        return union;
    }

    // Check the intersection of two sets
    public static Set<Integer> getIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2); // Keeps only common elements
        return intersection;
    }
}

