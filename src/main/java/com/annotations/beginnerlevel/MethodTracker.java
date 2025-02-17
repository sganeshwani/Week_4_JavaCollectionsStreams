package com.annotations.beginnerlevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)  // Retain the annotation at runtime
@Target(ElementType.METHOD)          // Apply annotation to methods
@interface ImportantMethod {
    String level() default "HIGH";  // Optional parameter with default value "HIGH"
}

class TaskManager {

    @ImportantMethod(level = "HIGH")  // Marking this method as important with HIGH level
    public void completeCriticalTask() {
        System.out.println("Completing critical task...");
    }

    @ImportantMethod(level = "MEDIUM")  // Marking this method as important with MEDIUM level
    public void completeRoutineTask() {
        System.out.println("Completing routine task...");
    }

    @ImportantMethod  // Default level is "HIGH"
    public void completeGeneralTask() {
        System.out.println("Completing general task...");
    }
}


class ImportantMethodTracker {

    public static void displayImportantMethods(Class<?> clazz) {
        // Retrieve all methods of the class
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            // Check if the method is annotated with @ImportantMethod
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                // Retrieve the @ImportantMethod annotation
                ImportantMethod importantMethod = method.getAnnotation(ImportantMethod.class);

                // Print method details: name and importance level
                System.out.println("Method: " + method.getName());
                System.out.println("Importance Level: " + importantMethod.level());
                System.out.println("-------------------------");
            }
        }
    }
}

public class MethodTracker{
    public static void main(String[] args) {
        // Display important methods for the TaskManager class
        ImportantMethodTracker.displayImportantMethods(TaskManager.class);
    }
}
