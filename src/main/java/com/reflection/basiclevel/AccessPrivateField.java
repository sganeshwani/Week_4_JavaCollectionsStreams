package com.reflection.basiclevel;

import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

public class AccessPrivateField {
    public static void main(String[] args) {
        try {
            // Create an instance of Person
            Person person = new Person(22);

            // Access the private field age using reflection
            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true);

            // Modify the value of the private field age
            ageField.setInt(person, 24);
            System.out.println("Modified age: " + person.getAge());

            // Retrieve the value of the private field age
            int ageValue = ageField.getInt(person);
            System.out.println("Retrieved age: " + ageValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

