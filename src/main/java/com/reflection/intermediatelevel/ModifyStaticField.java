package com.reflection.intermediatelevel;

import java.lang.reflect.Field;

class Configuration {

    // Private static field
    private static String API_KEY = "12345-OLD-API-KEY";

    // Getter for the static field (for testing)
    public static String getApiKey() {
        return API_KEY;
    }
}


public class ModifyStaticField {

    public static void main(String[] args) {
        try {
            // Access the Configuration class
            Class<?> configClass = Configuration.class;

            // Get the private static field 'API_KEY'
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Make the private field accessible
            apiKeyField.setAccessible(true);

            // Print the initial value of API_KEY
            System.out.println("Initial API_KEY: " + Configuration.getApiKey());

            // Modify the static field 'API_KEY'
            apiKeyField.set(null, "67890-NEW-API-KEY");  // Set the static field to a new value

            // Print the modified value using the getter
            System.out.println("Modified API_KEY: " + Configuration.getApiKey());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
