package com.annotations.exercises;

// JUnit test to verify the annotation details
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskManagerTest {

    @Test
    public void testTaskInfoAnnotation() throws NoSuchMethodException {
        // retrieve the method to test
        Method method = TaskManager.class.getMethod("performTask");
        // get the TaskInfo annotation
        TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
        // check that annotation is present
        assertNotNull(taskInfo, "Annotation should be present");
        // verify annotation values
        assertEquals(5, taskInfo.priority(), "Priority should be 5");
        assertEquals("Alice", taskInfo.assignedTo(), "Assigned to should be Alice");
    }
}