package com.reflection.intermediatelevel;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)  // Ensure it's available at runtime
@Target(ElementType.TYPE)  // Apply it to classes
@interface Author {
    String name();  // Element to hold the author's name
}


// Applying @Author annotation to the Book class
@Author(name = "John Doe")
class Book {
    private String title;
    private String publisher;

    // Constructor
    public Book(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    // Method to display book details
    public void displayInfo() {
        System.out.println("Title: " + title + ", Publisher: " + publisher);
    }
}

public class AnnotationDemo {

    public static void main(String[] args) {
        try {
            // Get the Class object for the Book class
            Class<?> clazz = Book.class;

            // Step 3: Check if the class is annotated with @Author
            if (clazz.isAnnotationPresent(Author.class)) {
                // Retrieve the @Author annotation
                Author authorAnnotation = clazz.getAnnotation(Author.class);

                // Display the value of the 'name' element from the annotation
                System.out.println("Author: " + authorAnnotation.name());
            } else {
                System.out.println("No @Author annotation present.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
