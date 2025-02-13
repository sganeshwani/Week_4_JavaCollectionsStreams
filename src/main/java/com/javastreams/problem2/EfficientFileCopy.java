package com.javastreams.problem2;

import java.io.*;

public class EfficientFileCopy {
    public static void main(String[] args) {
        String source = "C:\\Users\\HP\\Desktop\\Capgemini Training\\Week4_JavaCollectionsStreams\\Day03_JavaStreams\\src\\main\\java\\com\\javastreams\\problem2\\largefile.txt";
        String destination = "C:\\Users\\HP\\Desktop\\Capgemini Training\\Week4_JavaCollectionsStreams\\Day03_JavaStreams\\src\\main\\java\\com\\javastreams\\problem2\\copiedfile.txt";

        long startTime = System.nanoTime();

        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096];  // 4 KB buffer
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully in " + (System.nanoTime() - startTime) + " ns");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}