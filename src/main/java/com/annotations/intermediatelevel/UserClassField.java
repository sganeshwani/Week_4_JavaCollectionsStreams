package com.annotations.intermediatelevel;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();  // The maximum length allowed for the field
}


class User {

    @MaxLength(10)  // Maximum length for the username is 10
    private String username;

    public User(String username) {
        // Validate the length of the username field
        try {
            // Get the field with the @MaxLength annotation
            Field usernameField = this.getClass().getDeclaredField("username");

            // Check if the field has the @MaxLength annotation
            if (usernameField.isAnnotationPresent(MaxLength.class)) {
                // Get the maximum length value from the annotation
                MaxLength maxLength = usernameField.getAnnotation(MaxLength.class);
                int maxLengthValue = maxLength.value();

                // Check if the username length exceeds the maximum allowed length
                if (username.length() > maxLengthValue) {
                    throw new IllegalArgumentException("Username cannot exceed " + maxLengthValue + " characters.");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        // If valid, assign the username
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{username='" + username + "'}";
    }
}

public class UserClassField {
    public static void main(String[] args) {
        try {
            // Valid username
            User validUser = new User("JohnDoe");
            System.out.println(validUser);

            // Invalid username (exceeds maximum length of 10)
            User invalidUser = new User("LongUsername123");  // This should throw an exception
            System.out.println(invalidUser);
        } catch (IllegalArgumentException e) {
            // Catch the exception and print the error message
            System.out.println("Error: " + e.getMessage());
        }
    }
}
