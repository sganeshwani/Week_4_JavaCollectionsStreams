package com.listinterface.problem1;

import java.util.*;

public class ReverseList {
    // Method to reverse a list
    public static <T> List<T> reverseList(List<T> list) {
        List<T> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i)); // Add elements from end to start
        }
        return reversed;
    }

    public static void main(String[] args) {
        // ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        List<Integer> reversedArrayList = reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + reversedArrayList);

        // LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 5, 7, 2, 3));
        List<Integer> reversedLinkedList = reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + reversedLinkedList);
    }
}

