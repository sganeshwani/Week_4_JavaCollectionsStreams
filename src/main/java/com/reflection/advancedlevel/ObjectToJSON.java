package com.reflection.advancedlevel;

import java.lang.reflect.Field;

class Address {
    private String street;
    private String city;

    // Constructor
    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    // Getter methods
    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{street='" + street + "', city='" + city + "'}";
    }
}
class Boy {
    private String name;
    private int age;
    private Address address;

    // Constructor
    public Boy(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", address=" + address + "}";
    }
}


public class ObjectToJSON {

    // Method to convert an object to a JSON-like string
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        // Get all fields of the class (including private fields)
        Field[] fields = obj.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);  // Make private fields accessible

            try {
                // Get the field name and value
                String fieldName = field.getName();
                Object fieldValue = field.get(obj);

                // Add the field and value to the JSON string
                json.append("\"").append(fieldName).append("\": ");

                if (fieldValue == null) {
                    json.append("null");
                } else if (fieldValue instanceof String) {
                    json.append("\"").append(fieldValue).append("\"");
                } else if (isPrimitiveOrWrapper(fieldValue.getClass())) {
                    json.append(fieldValue);
                } else {
                    // If it's a nested object, recursively call toJson()
                    json.append(toJson(fieldValue));
                }

                // Add a comma if it's not the last field
                if (i < fields.length - 1) {
                    json.append(", ");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }

    // Helper method to check if a field is of a primitive or wrapper type
    private static boolean isPrimitiveOrWrapper(Class<?> clazz) {
        return clazz.isPrimitive() || clazz == Integer.class || clazz == Boolean.class
                || clazz == Character.class || clazz == Byte.class || clazz == Short.class
                || clazz == Long.class || clazz == Double.class || clazz == Float.class;
    }

    public static void main(String[] args) {
        // Create an Address object
        Address address = new Address("123 Main St", "Springfield");

        // Create a Person object with the Address object
        Boy person = new Boy("John Doe", 30, address);

        // Convert the Person object to a JSON-like string
        String jsonString = toJson(person);

        // Print the JSON-like string
        System.out.println(jsonString);
    }
}
