package com.listinterface.problem5;

import java.util.*;

public class NthFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();

        // Move 'first' N steps ahead
        for (int i = 0; i < n; i++) {
            if (first.hasNext()) first.next();
            else return null; // If N is greater than the list size
        }

        // Move both pointers until 'first' reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next(); // 'second' is now at the Nth node from the end
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 3;

        String result = findNthFromEnd(list, n);
        System.out.println("Nth element from the end: " + result);
    }
}

