package com.mapinterface;

import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>(); // Stores votes (Candidate -> Vote count)
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>(); // Maintains order of voting
    private TreeMap<Integer, List<String>> sortedVotes = new TreeMap<>(Collections.reverseOrder()); // Sort results

    // Method to cast a vote
    public void castVote(String candidate) {
        // Update vote count in HashMap
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);

        // Update LinkedHashMap for vote order
        voteOrder.put(candidate, voteMap.get(candidate));
    }

    // Display votes in insertion order
    public void displayVoteOrder() {
        System.out.println("Votes in Order of Entry:");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Display sorted results
    public void displaySortedResults() {
        // Clear and rebuild the sorted TreeMap
        sortedVotes.clear();
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            sortedVotes.putIfAbsent(entry.getValue(), new ArrayList<>());
            sortedVotes.get(entry.getValue()).add(entry.getKey());
        }

        // Print results in descending order
        System.out.println("Voting Results (Sorted by Votes):");
        for (Map.Entry<Integer, List<String>> entry : sortedVotes.entrySet()) {
            for (String candidate : entry.getValue()) {
                System.out.println(candidate + " -> " + entry.getKey() + " votes");
            }
        }
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Cast votes
        votingSystem.castVote("Sahil");
        votingSystem.castVote("Honey");
        votingSystem.castVote("Sahil");
        votingSystem.castVote("Raj");
        votingSystem.castVote("Honey");
        votingSystem.castVote("Honey");

        // Display votes in order of entry
        votingSystem.displayVoteOrder();

        // Display sorted results
        votingSystem.displaySortedResults();
    }
}

