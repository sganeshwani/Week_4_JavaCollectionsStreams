package com.annotations.beginnerlevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)  // Retain the annotation at runtime
@Target(ElementType.METHOD)  // Apply annotation to methods
@interface Todo {
    String task();            // Description of the task
    String assignedTo();      // Developer responsible for the task
    String priority() default "MEDIUM";  // Default priority is "MEDIUM"
}

class Project {

    @Todo(task = "Implement login functionality", assignedTo = "Alice", priority = "HIGH")
    public void implementLogin() {
        // Implementation pending
    }

    @Todo(task = "Create user profile page", assignedTo = "Bob")
    public void createUserProfile() {
        // Implementation pending
    }

    @Todo(task = "Set up database schema", assignedTo = "Charlie", priority = "LOW")
    public void setupDatabase() {
        // Implementation pending
    }

    public void completeFeature() {
        // This method is not a pending task, so no annotation
    }
}

class Tracker {

    public static void displayPendingTasks(Class<?> clazz) {
        // Retrieve all methods of the class
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            // Check if the method is annotated with @Todo
            if (method.isAnnotationPresent(Todo.class)) {
                // Retrieve the @Todo annotation
                Todo todo = method.getAnnotation(Todo.class);

                // Print the task details
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned to: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("Method: " + method.getName());
                System.out.println("-------------------------");
            }
        }
    }
}

public class TaskTracker {
    public static void main(String[] args) {
        // Display pending tasks for the Project class
        Tracker.displayPendingTasks(Project.class);
    }
}