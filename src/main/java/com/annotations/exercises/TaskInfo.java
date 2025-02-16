package com.annotations.exercises;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // available at runtime
@Target(ElementType.METHOD)         // applies to methods
public @interface TaskInfo {
    int priority() default 1;         // task priority
    String assignedTo() default "unknown"; // assigned person
}

