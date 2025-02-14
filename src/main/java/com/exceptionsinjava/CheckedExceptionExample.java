package com.exceptionsinjava;

import java.io.IOException;
import java.io.FileReader;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        // filepath
        String filepath = "C:\\Users\\HP\\Desktop\\Capgemini Training\\Week4_JavaCollectionsStreams\\Day04_Exceptions\\data.txt";

        try (FileReader fr = new FileReader(filepath)){
            int i;
            while((i=fr.read())!=-1) { // read file
                System.out.print((char)i);
            }
        } catch(IOException e) { // executes if file not found
            System.out.println("File not found");
        }
    }
}
