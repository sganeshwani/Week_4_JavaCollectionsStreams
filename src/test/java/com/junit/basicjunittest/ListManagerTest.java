package com.junit.basicjunittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ListManagerTest {

    // Instance of ListManager for testing
    ListManager manager = new ListManager();

    // Test that elements are correctly added and the size is updated
    @Test
    public void testAddElement() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 5);
        // Check that the element 5 is in the list
        assertTrue(list.contains(5));
        // Check that the size of the list is now 1
        assertEquals(1, list.size());
    }

    // Test that elements are correctly removed and the size is updated
    @Test
    public void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        manager.removeElement(list, 10);
        // Verify that 10 is no longer in the list
        assertFalse(list.contains(10));
        // Verify that 20 is still in the list
        assertTrue(list.contains(20));
        // Check that the size of the list is now 1
        assertEquals(1, list.size());
    }

    // Test that getSize returns the correct size
    @Test
    public void testGetSize() {
        List<Integer> list = new ArrayList<>();
        // Initially the list is empty
        assertEquals(0, manager.getSize(list));
        // Add two elements.
        manager.addElement(list, 15);
        manager.addElement(list, 25);
        // Size should be 2
        assertEquals(2, manager.getSize(list));
        // Remove one element
        manager.removeElement(list, 15);
        // Size should now be 1
        assertEquals(1, manager.getSize(list));
    }
}