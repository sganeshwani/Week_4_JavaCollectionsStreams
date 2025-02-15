package com.junit.basicjunittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessorTest {

    FileProcessor fileProcessor = new FileProcessor();

    @TempDir
    Path tempDir;

    @Test
    public void testWriteAndReadContent() throws IOException {
        // Create file path in temporary directory
        Path filePath = tempDir.resolve("test.txt");
        String content = "Hello World";
        fileProcessor.writeToFile(filePath.toString(), content);
        String readContent = fileProcessor.readFromFile(filePath.toString());
        // Verify content is written and read correctly
        assertEquals(content, readContent);
        // Verify file exists after writing
        assertTrue(Files.exists(filePath));
    }

    @Test
    public void testReadFromNonExistentFile() {
        // File does not exist
        Path filePath = tempDir.resolve("nonexistent.txt");
        // Verify IOException is thrown when reading non-existent file
        assertThrows(IOException.class, () -> fileProcessor.readFromFile(filePath.toString()));
    }
}