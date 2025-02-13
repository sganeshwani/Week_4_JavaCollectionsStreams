package com.javastreams.problem9;

import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        // Replace with your file path
        String filePath = "C:\\Users\\HP\\Desktop\\Capgemini Training\\Week4_JavaCollectionsStreams\\Day03_JavaStreams\\src\\main\\java\\com\\javastreams\\problem9\\largefile.txt";

        readErrorLines(filePath);
    }

    private static void readErrorLines(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) { // Case-insensitive check
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

