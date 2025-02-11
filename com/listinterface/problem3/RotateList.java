package com.listinterface.problem3;

import java.util.*;

public class RotateList {
    public static <T> List<T> rotateList(List<T> list, int rotateBy) {
        int size = list.size();
        rotateBy = rotateBy % size; // Handles cases where rotateBy > size

        List<T> rotated = new ArrayList<>();
        rotated.addAll(list.subList(rotateBy, size)); // Part from rotateBy to end
        rotated.addAll(list.subList(0, rotateBy)); // Part from start to rotateBy

        return rotated;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 22, 33, 44, 55);
        int rotateBy = 2;

        List<Integer> rotatedList = rotateList(numbers, rotateBy);
        System.out.println("Rotated List: " + rotatedList);
    }
}

