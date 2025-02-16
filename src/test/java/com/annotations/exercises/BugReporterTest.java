package com.annotations.exercises;

// JUnit test to verify the repeatable annotation values
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.lang.reflect.Method;

public class BugReporterTest {

    @Test
    public void testBugReportAnnotations() throws NoSuchMethodException {
        Method method = BugReporter.class.getMethod("problematicMethod");
        BugReport[] reports = method.getAnnotationsByType(BugReport.class);
        assertEquals(2, reports.length, "Should have two bug reports");
        assertEquals("Null pointer exception under certain conditions", reports[0].description(), "First description mismatch");
        assertEquals("Memory leak in loop", reports[1].description(), "Second description mismatch");
    }
}