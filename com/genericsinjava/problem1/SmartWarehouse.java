package com.genericsinjava.problem1;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing a Warehouse item
abstract class WarehouseItem {
    private String name;
    private double price;

    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Returns a string representation of the item
    @Override
    public String toString() {
        return getClass().getSimpleName() + " [Name: " + name + ", Price: ₹" + price + "]";
    }
}

// Electronics, Groceries, and Furniture extend WarehouseItem
class Electronics extends WarehouseItem {
    public Electronics(String name, double price) {
        super(name, price);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name, double price) {
        super(name, price);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name, double price) {
        super(name, price);
    }
}

// Generic class to store items safely
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

// Utility class with a wildcard method to display any type of items
class WarehouseUtils {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

// Main class to test the Smart Warehouse System
public class SmartWarehouse {
    public static void main(String[] args) {
        // Storage instances for different item types
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Adding items to each storage
        electronicsStorage.addItem(new Electronics("Laptop", 59000));
        electronicsStorage.addItem(new Electronics("Smartphone", 25000));

        groceriesStorage.addItem(new Groceries("Apples", 50));
        groceriesStorage.addItem(new Groceries("Milk", 25.5));

        furnitureStorage.addItem(new Furniture("Chair", 1500));
        furnitureStorage.addItem(new Furniture("Table", 3000));

        // Display stored items using the wildcard method
        System.out.println("Electronics:");
        WarehouseUtils.displayItems(electronicsStorage.getItems());

        System.out.println("\nGroceries:");
        WarehouseUtils.displayItems(groceriesStorage.getItems());

        System.out.println("\nFurniture:");
        WarehouseUtils.displayItems(furnitureStorage.getItems());
    }
}

