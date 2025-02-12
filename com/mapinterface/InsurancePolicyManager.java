package com.mapinterface;

import java.util.*;

class Policy {
    String policyNumber;
    String policyHolder;
    Date expiryDate;

    // Constructor
    public Policy(String policyNumber, String policyHolder, Date expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Policy{Number='" + policyNumber + "', Holder='" + policyHolder + "', Expiry=" + expiryDate + "}";
    }
}

public class InsurancePolicyManager {
    private Map<String, Policy> policyMap = new HashMap<>(); // Store by policy number
    private LinkedHashMap<String, Policy> orderedPolicies = new LinkedHashMap<>(); // Maintain insertion order
    private TreeMap<Date, Policy> sortedPolicies = new TreeMap<>(); // Sort by expiry date

    // Add a new policy
    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicies.put(policy.policyNumber, policy);
        sortedPolicies.put(policy.expiryDate, policy);
    }

    // Retrieve policy by policy number
    public Policy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List policies expiring in the next 30 days
    public List<Policy> getExpiringPolicies() {
        List<Policy> expiring = new ArrayList<>();
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date next30Days = cal.getTime();

        for (Map.Entry<Date, Policy> entry : sortedPolicies.entrySet()) {
            if (entry.getKey().after(today) && entry.getKey().before(next30Days)) {
                expiring.add(entry.getValue());
            }
        }
        return expiring;
    }

    // List all policies for a specific policyholder
    public List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyHolder.equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        Date today = new Date();
        Iterator<Map.Entry<Date, Policy>> iterator = sortedPolicies.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Date, Policy> entry = iterator.next();
            if (entry.getKey().before(today)) { // If expiry date is before today, remove
                policyMap.remove(entry.getValue().policyNumber);
                orderedPolicies.remove(entry.getValue().policyNumber);
                iterator.remove(); // Remove from TreeMap
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        // Sample policies with different expiry dates
        Calendar cal = Calendar.getInstance();

        cal.set(2025, Calendar.MARCH, 10);
        Policy p1 = new Policy("P101", "Alice", cal.getTime());

        cal.set(2024, Calendar.FEBRUARY, 25);
        Policy p2 = new Policy("P102", "Bob", cal.getTime());

        cal.set(2024, Calendar.MARCH, 5);
        Policy p3 = new Policy("P103", "Alice", cal.getTime());

        // Add policies
        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);

        // Retrieve a policy
        System.out.println("Retrieve Policy P102: " + manager.getPolicy("P102"));

        // Policies expiring within next 30 days
        System.out.println("Expiring Policies: " + manager.getExpiringPolicies());

        // List policies by holder
        System.out.println("Policies for Alice: " + manager.getPoliciesByHolder("Alice"));

        // Remove expired policies
        manager.removeExpiredPolicies();
        System.out.println("Policies after removing expired ones: " + manager.policyMap);
    }
}

