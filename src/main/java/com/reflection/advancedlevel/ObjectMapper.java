package com.reflection.advancedlevel;
import java.lang.reflect.*;
import java.util.*;

class Person {
    private String name;
    private int age;
    private double salary;

    // Constructor
    public Person() {}

    // Method to display Person details
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Salary: " + salary);
    }
}

public class ObjectMapper {

    // Method to populate an object with properties from a map
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws IllegalAccessException, InstantiationException {
        // Create a new instance of the class
        T obj = clazz.newInstance();

        // Get all declared fields of the class
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            // Check if the map contains the key matching the field name
            if (properties.containsKey(field.getName())) {
                // Set the field accessible if it's private or protected
                field.setAccessible(true);

                // Get the value from the map
                Object value = properties.get(field.getName());

                // Set the field value in the object
                field.set(obj, value);
            }
        }

        return obj;
    }

    public static void main(String[] args) {
        // Create a map of properties to set in the object
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "Alice");
        properties.put("age", 30);
        properties.put("salary", 55000.50);

        try {
            // Use reflection to populate the Person object
            Person person = toObject(Person.class, properties);

            // Display the populated Person object
            person.displayInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
