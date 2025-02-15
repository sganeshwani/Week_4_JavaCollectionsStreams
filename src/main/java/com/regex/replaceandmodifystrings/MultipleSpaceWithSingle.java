package com.regex.replaceandmodifystrings;

public class MultipleSpaceWithSingle {
    public static void main(String[] args) {
        // Example input
        String input = "This             is   an    example    with    multiple  spaces.";

        // Use regex to replace multiple spaces with a single space
        String output = input.replaceAll("\\s+", " ");

        // Output the result
        System.out.println(output);
    }
}
