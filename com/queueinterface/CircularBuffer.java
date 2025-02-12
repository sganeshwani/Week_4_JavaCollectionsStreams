package com.queueinterface;

import java.util.*;

class CircularBuffer {
    private int[] buffer;
    private int front, rear, size, capacity;

    // Constructor to initialize buffer with given capacity
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Insert element (overwrite if full)
    public void enqueue(int value) {
        rear = (rear + 1) % capacity; // Move rear circularly
        buffer[rear] = value;

        if (size < capacity) {
            size++; // Increase size if not full
        } else {
            front = (front + 1) % capacity; // Overwrite oldest element
        }
    }

    // Remove element from front
    public int dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Buffer is empty!");
        }
        int removed = buffer[front];
        front = (front + 1) % capacity; // Move front circularly
        size--;
        return removed;
    }

    // Display buffer elements
    public void display() {
        if (size == 0) {
            System.out.println("Buffer is empty!");
            return;
        }
        System.out.print("Buffer: ");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.enqueue(1);
        cb.enqueue(2);
        cb.enqueue(3);
        cb.display();

        cb.enqueue(4);
        cb.display();

        cb.dequeue();
        cb.display();
    }
}

