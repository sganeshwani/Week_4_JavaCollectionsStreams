package com.exceptionsinjava;

import java.io.*;

public class TryWithResources {
    public static void main(String[] args) {
        // Using try-with-resources to ensure file is closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\Desktop\\Capgemini Training\\Week4_JavaCollectionsStreams\\Day04_Exceptions\\info.txt"))) {
            // Reading and printing the first line of the file
            String firstLine = reader.readLine();
            System.out.println(firstLine);
        } catch (IOException e) {
            System.out.println("Error reading file");  // Handling IOException
        }
    }
}
