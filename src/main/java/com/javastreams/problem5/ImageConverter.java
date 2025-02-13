package com.javastreams.problem5;

import java.io.*;

public class ImageConverter {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\HP\\Desktop\\Capgemini Training\\Week4_JavaCollectionsStreams\\Day03_JavaStreams\\src\\main\\java\\com\\javastreams\\problem5\\input.jpg";
        String outputFile = "C:\\Users\\HP\\Desktop\\Capgemini Training\\Week4_JavaCollectionsStreams\\Day03_JavaStreams\\src\\main\\java\\com\\javastreams\\problem5\\output.jpg";

        byte[] imageData = readImage(inputFile);
        if (imageData != null) {
            writeImage(imageData, outputFile);
        }
    }

    private static byte[] readImage(String path) {
        try (FileInputStream fis = new FileInputStream(path);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            bos.writeBytes(fis.readAllBytes());
            return bos.toByteArray();
        } catch (IOException e) {
            System.out.println("Error reading image: " + e.getMessage());
            return null;
        }
    }

    private static void writeImage(byte[] data, String path) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(data);
            System.out.println("Image converted successfully!");
        } catch (IOException e) {
            System.out.println("Error writing image: " + e.getMessage());
        }
    }
}