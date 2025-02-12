package com.queueinterface;

import java.util.*;

class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push element onto stack
    public void push(int x) {
        queue1.add(x);
    }

    // Removes the top element and returns it
    public int pop() {
        if (queue1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }

        // Move all elements except last to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        int topElement = queue1.poll(); // Get the last element

        // Swap queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Returns the top element without removing it
    public int top() {
        if (queue1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        int topElement = queue1.peek(); // Get last element
        queue2.add(queue1.poll()); // Move it to queue2

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Returns true if stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
    }
}

