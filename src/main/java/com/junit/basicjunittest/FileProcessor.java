package com.junit.basicjunittest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileProcessor {

    // Writes content to a file
    public void writeToFile(String filename, String content) throws IOException {
        Files.write(Paths.get(filename), content.getBytes());
    }

    // Reads content from a file
    public String readFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
}