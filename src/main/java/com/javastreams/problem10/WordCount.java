package com.javastreams.problem10;

import java.io.*;
import java.util.*;

public class WordCount {
    public static void countWordsInFile(String filePath) {
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split(" "); // Split words by space
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z0-9]", ""); // Remove punctuation
                    if (!word.isEmpty()) {
                        if (wordCountMap.containsKey(word)) {
                            wordCountMap.put(word, wordCountMap.get(word) + 1);
                        } else {
                            wordCountMap.put(word, 1);
                        }
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }

        // Convert map to list and sort by value in descending order
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordCountMap.entrySet());
        Collections.sort(wordList, (a, b) -> b.getValue() - a.getValue());

        // Display the top 5 most frequently occurring words
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, wordList.size()); i++) {
            System.out.println(wordList.get(i).getKey() + ": " + wordList.get(i).getValue());
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\HP\\Desktop\\Capgemini Training\\Week4_JavaCollectionsStreams\\Day03_JavaStreams\\src\\main\\java\\com\\javastreams\\problem10\\largefile.txt"; // Specify the file path
        countWordsInFile(filePath); // Call the method to count words
    }
}
