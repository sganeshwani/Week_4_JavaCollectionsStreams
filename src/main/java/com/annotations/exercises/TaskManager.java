package com.annotations.exercises;

// class using the custom annotation.
public class TaskManager {

    // annotated method with task info
    @TaskInfo(priority = 5, assignedTo = "Alice")
    public void performTask() {
        System.out.println("Performing task");
    }

    // main method to retrieve annotation details using reflection
    public static void main(String[] args) {
        try {
            // get the method object
            java.lang.reflect.Method method = TaskManager.class.getMethod("performTask");
            // check if annotation is present
            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned to: " + taskInfo.assignedTo());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}