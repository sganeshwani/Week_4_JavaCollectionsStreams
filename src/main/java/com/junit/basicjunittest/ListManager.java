package com.junit.basicjunittest;

import java.util.List;

public class ListManager {

    // Adds an element to the provided list
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    // Removes the first occurrence of the element from the list
    public void removeElement(List<Integer> list, int element) {
        // Using Integer.valueOf to remove the element by its value, not by index
        list.remove(Integer.valueOf(element));
    }

    // Returns the current size of the list
    public int getSize(List<Integer> list) {
        return list.size();
    }
}