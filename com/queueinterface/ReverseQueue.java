package com.queueinterface;

import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(); // Made Queue
        // Add elements in queue
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Original Queue: " + queue);

        Stack<Integer> stack = new Stack<>(); // Made Stack
        while(!queue.isEmpty()) {
            stack.push(queue.poll()); // Remove queue elements and push it into stack
        }
        while(!stack.isEmpty()) {
            queue.add(stack.pop()); // Remove stack elements and push it back in queue
        }
        System.out.println("Reversed Queue: " + queue);
    }
}
