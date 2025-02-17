package com.reflection.basiclevel;

import java.lang.reflect.*;
import java.util.*;

public class ClassInfo {

    // Accepts a class name and displays its fields, methods, and constructors
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the class name: ");
        String className = input.nextLine();

        try {
            Class<?> clazz = Class.forName(className);

            System.out.println("Fields:");
            Field[] fields = clazz.getDeclaredFields(); //
            for (Field field : fields) { // iterates for each field in the class
                System.out.println(field); // print all fields
            }

            System.out.println("\nMethods:");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) { // iterates for each method in the class
                System.out.println(method); // print all methods
            }

            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) { // iterates for each constructor
                System.out.println(constructor); // prints the constructor
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
    }
}