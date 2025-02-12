package com.mapinterface;

import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>(); // Stores product prices
    private LinkedHashMap<String, Double> cart = new LinkedHashMap<>(); // Maintains order of added items
    private TreeMap<Double, List<String>> sortedCart = new TreeMap<>(); // Sorts items by price

    // Method to add a product to the cart
    public void addProduct(String product, double price) {
        // Store product price in HashMap
        productPrices.put(product, price);

        // Add product to LinkedHashMap for insertion order
        cart.put(product, price);
    }

    // Display cart in order of addition
    public void displayCartInOrder() {
        System.out.println("Shopping Cart (Order of Addition):");
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " -> $" + entry.getValue());
        }
    }

    // Display cart sorted by price
    public void displayCartSortedByPrice() {
        // Clear and rebuild the sorted TreeMap
        sortedCart.clear();
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            sortedCart.putIfAbsent(entry.getValue(), new ArrayList<>());
            sortedCart.get(entry.getValue()).add(entry.getKey());
        }

        // Print products sorted by price
        System.out.println("Shopping Cart (Sorted by Price):");
        for (Map.Entry<Double, List<String>> entry : sortedCart.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " -> ₹" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Add products
        cart.addProduct("Laptop", 50000);
        cart.addProduct("Mouse", 500);
        cart.addProduct("Keyboard", 1000);
        cart.addProduct("Monitor", 4000);
        cart.addProduct("USB Drive", 300);

        // Display cart in order of addition
        cart.displayCartInOrder();

        // Display cart sorted by price
        cart.displayCartSortedByPrice();
    }
}

