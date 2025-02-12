package com.setinterface;

import java.util.*;

class Policy implements Comparable<Policy> {
    int policyNumber;
    String policyholderName;
    Date expiryDate;
    String coverageType;
    double premiumAmount;

    // Constructor
    public Policy(int policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Override equals & hashCode for HashSet uniqueness (based on policy number)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return policyNumber == policy.policyNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    // Compare policies based on expiry date (for TreeSet sorting)
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    // Display policy details
    @Override
    public String toString() {
        return "Policy{" +
                "Number: " + policyNumber +
                ", Holder: '" + policyholderName + '\'' +
                ", Expiry: " + expiryDate +
                ", Type: '" + coverageType + '\'' +
                ", Premium: ₹" + premiumAmount +
                '}';
    }
}

public class InsurancePolicySystem {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    // Add a policy to all sets
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Retrieve all unique policies
    public void displayAllPolicies() {
        System.out.println("\nAll Policies:");
        for (Policy policy : hashSetPolicies) {
            System.out.println(policy);
        }
    }

    // Retrieve policies expiring within 30 days
    public void displayExpiringPolicies() {
        System.out.println("\nPolicies Expiring in Next 30 Days:");
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date threshold = cal.getTime();

        for (Policy policy : treeSetPolicies) {
            if (policy.expiryDate.before(threshold)) {
                System.out.println(policy);
            }
        }
    }

    // Retrieve policies by coverage type
    public void displayPoliciesByType(String type) {
        System.out.println("\nPolicies of Type: " + type);
        for (Policy policy : hashSetPolicies) {
            if (policy.coverageType.equalsIgnoreCase(type)) {
                System.out.println(policy);
            }
        }
    }

    // Find duplicate policies based on policy number
    public void displayDuplicatePolicies() {
        System.out.println("\nDuplicate Policies:");
        Map<Integer, Integer> policyCount = new HashMap<>();

        for (Policy policy : hashSetPolicies) {
            policyCount.put(policy.policyNumber, policyCount.getOrDefault(policy.policyNumber, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : policyCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Policy Number " + entry.getKey() + " appears " + entry.getValue() + " times.");
            }
        }
    }

    // Compare performance of different sets
    public void comparePerformance() {
        System.out.println("\nPerformance Comparison:");

        // Measure time for adding policies
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            hashSetPolicies.add(new Policy(i, "User" + i, new Date(), "Health", 1000.0));
        }
        long hashSetTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedHashSetPolicies.add(new Policy(i, "User" + i, new Date(), "Health", 1000.0));
        }
        long linkedHashSetTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            treeSetPolicies.add(new Policy(i, "User" + i, new Date(), "Health", 1000.0));
        }
        long treeSetTime = System.nanoTime() - start;

        System.out.println("HashSet Add Time: " + hashSetTime / 1e6 + " ms");
        System.out.println("LinkedHashSet Add Time: " + linkedHashSetTime / 1e6 + " ms");
        System.out.println("TreeSet Add Time: " + treeSetTime / 1e6 + " ms");
    }

    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();

        // Sample policies
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 10);
        Policy p1 = new Policy(101, "Rahul", cal.getTime(), "Health", 500.0);

        cal.add(Calendar.DAY_OF_YEAR, 25);
        Policy p2 = new Policy(102, "Sahil", cal.getTime(), "Auto", 1200.0);

        cal.add(Calendar.DAY_OF_YEAR, -40);
        Policy p3 = new Policy(103, "Mayur", cal.getTime(), "Home", 800.0);

        // Adding policies
        system.addPolicy(p1);
        system.addPolicy(p2);
        system.addPolicy(p3);

        // Display all policies
        system.displayAllPolicies();

        // Display expiring policies
        system.displayExpiringPolicies();

        // Display policies by coverage type
        system.displayPoliciesByType("Health");

        // Display duplicate policies
        system.displayDuplicatePolicies();

        // Compare performance
        system.comparePerformance();
    }
}

