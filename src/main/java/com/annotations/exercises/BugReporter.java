package com.annotations.exercises;

// class with a method annotated with multiple bug reports
public class BugReporter {

    @BugReport(description = "Null pointer exception under certain conditions")
    @BugReport(description = "Memory leak in loop")
    public void problematicMethod() {
        System.out.println("Executing problematic method");
    }

    // main method to retrieve and print all bug reports using reflection
    public static void main(String[] args) {
        try {
            java.lang.reflect.Method method = BugReporter.class.getMethod("problematicMethod");
            BugReport[] reports = method.getAnnotationsByType(BugReport.class);
            for (BugReport report : reports) {
                System.out.println("Bug: " + report.description());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}