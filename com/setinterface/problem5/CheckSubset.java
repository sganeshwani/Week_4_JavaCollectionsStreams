package com.setinterface.problem5;

import java.util.*;

public class CheckSubset {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        System.out.println("Is Set1 a subset of Set2? ");
        if(isSubset(set1, set2)) {
            System.out.println("Yes, Set1 is a subset of Set2");
        } else {
            System.out.println("Set1 is not a subset of Set2");
        }
    }

    // Checks if set1 is a subset of set2
    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2) {
        return set2.containsAll(set1);
    }
}

