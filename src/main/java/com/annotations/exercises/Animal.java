package com.annotations.exercises;

// Parent class Animal
public class Animal {
    // Method to be overridden
    public void makeSound() {
        System.out.println("Animal make sound");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();
    }
}

// Child class Dog that extends Parent class Animal
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}