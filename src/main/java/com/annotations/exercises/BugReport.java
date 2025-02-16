package com.annotations.exercises;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
// Custom interface
public @interface BugReport {
    String description();
}