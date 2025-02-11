package com.genericsinjava.problem2;

import java.util.ArrayList;
import java.util.List;

// Base class for product categories
abstract class ProductCategory {
    private String categoryName;

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

// Specific product categories
class BookCategory extends ProductCategory {
    public BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends ProductCategory {
    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends ProductCategory {
    public GadgetCategory() {
        super("Gadgets");
    }
}

// Generic class representing a Product with a category type
class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    @Override
    public String toString() {
        return name + " [Category: " + category.getCategoryName() + ", Price: ₹" + price + "]";
    }
}

// Utility class for marketplace operations
class MarketplaceUtils {
    // Generic method to apply discounts to any product type
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
        System.out.println("Discount applied: " + product.getName() + " new price is ₹" + product.getPrice());
    }

    // Displays products in the catalog
    public static void displayCatalog(List<? extends Product<?>> products) {
        for (Product<?> product : products) {
            System.out.println(product);
        }
    }
}

// Main class
public class OnlineMarketplace {
    public static void main(String[] args) {
        // Creating product categories
        BookCategory bookCategory = new BookCategory();
        ClothingCategory clothingCategory = new ClothingCategory();
        GadgetCategory gadgetCategory = new GadgetCategory();

        // Creating products
        Product<BookCategory> book1 = new Product<>("Java Programming", 499, bookCategory);
        Product<ClothingCategory> shirt = new Product<>("Casual Shirt", 999, clothingCategory);
        Product<GadgetCategory> smartphone = new Product<>("Smartphone", 25000, gadgetCategory);

        // Adding products to catalog
        List<Product<?>> catalog = new ArrayList<>();
        catalog.add(book1);
        catalog.add(shirt);
        catalog.add(smartphone);

        // Displaying catalog
        System.out.println("Product Catalog:");
        MarketplaceUtils.displayCatalog(catalog);

        // Applying discounts
        System.out.println("\nApplying Discounts:");
        MarketplaceUtils.applyDiscount(book1, 15);
        MarketplaceUtils.applyDiscount(shirt, 20);
        MarketplaceUtils.applyDiscount(smartphone, 10);

        // Displaying updated catalog
        System.out.println("\nUpdated Product Catalog:");
        MarketplaceUtils.displayCatalog(catalog);
    }
}
