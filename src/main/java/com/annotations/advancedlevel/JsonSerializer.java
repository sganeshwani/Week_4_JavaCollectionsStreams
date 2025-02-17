package com.annotations.advancedlevel;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();  // Define the custom name for the field in JSON
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "user_email")
    private String email;

    // Constructor
    public User(String username, int age, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}

class Serializer {

    public static String serialize(Object object) throws IllegalAccessException {
        // Create a Map to hold the field names and values for JSON
        Map<String, Object> jsonMap = new HashMap<>();

        // Get all fields from the class
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            // Check if the field has @JsonField annotation
            if (field.isAnnotationPresent(JsonField.class)) {
                // Make the field accessible if it's private
                field.setAccessible(true);

                // Get the custom name from the annotation
                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonKey = annotation.name();

                // Get the value of the field
                Object value = field.get(object);

                // Put the value in the map with the custom key
                jsonMap.put(jsonKey, value);
            }
        }

        // Convert the map to a JSON string
        StringBuilder jsonString = new StringBuilder("{");
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            jsonString.append("\"").append(entry.getKey()).append("\": \"")
                    .append(entry.getValue()).append("\", ");
        }

        // Remove the last comma and space
        if (!jsonMap.isEmpty()) {
            jsonString.setLength(jsonString.length() - 2);
        }

        jsonString.append("}");
        return jsonString.toString();
    }
}

public class JsonSerializer {

    public static void main(String[] args) {
        // Create a User object
        User user = new User("john_doe", 30, "john.doe@example.com");

        // Serialize the User object to JSON
        try {
            String json = Serializer.serialize(user);
            System.out.println("Serialized JSON: " + json);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}