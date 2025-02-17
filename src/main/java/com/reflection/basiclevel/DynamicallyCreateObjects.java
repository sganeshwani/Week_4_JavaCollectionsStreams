package com.reflection.basiclevel;

import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class DynamicallyCreateObjects {
    public static void main(String[] args) {
        try {
            // Get the Class object associated with Student
            Class<Student> studentClass = Student.class;

            // Get the constructor of the Student class
            Constructor<Student> constructor = studentClass.getConstructor(String.class, int.class);

            // Create an instance of the Student class dynamically
            Student student = constructor.newInstance("Sahil", 22);

            // Display the details of the student
            student.displayDetails();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}