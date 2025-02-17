package com.reflection.advancedlevel;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

class Car {

    @Inject
    private Engine engine;

    public void drive() {
        engine.start();
        System.out.println("Car is driving");
    }
}

class Container {

    private Map<Class<?>, Object> container = new HashMap<>();

    // Register a class in the container
    public void register(Class<?> clazz) throws Exception {
        // Create an instance of the class and add it to the container
        Object instance = createInstance(clazz);
        container.put(clazz, instance);
    }

    // Method to create an instance of a class and inject dependencies
    private Object createInstance(Class<?> clazz) throws Exception {
        // Create a new instance of the class
        Object instance = clazz.getDeclaredConstructor().newInstance();

        // Inject dependencies by scanning fields annotated with @Inject
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                // Make the field accessible (if it's private)
                field.setAccessible(true);

                // Get the field's type (the type of the dependency)
                Class<?> fieldType = field.getType();

                // Get the dependency from the container
                Object dependency = container.get(fieldType);

                // If the dependency is not already created, create it and inject
                if (dependency == null) {
                    register(fieldType);
                    dependency = container.get(fieldType);
                }

                // Inject the dependency into the field
                field.set(instance, dependency);
            }
        }
        return instance;
    }

    // Get an instance of a class from the container
    public <T> T get(Class<T> clazz) {
        return clazz.cast(container.get(clazz));
    }
}
public class DIContainer {

    public static void main(String[] args) throws Exception {
        Container container = new Container();

        // Register classes in the container
        container.register(Engine.class);
        container.register(Car.class);

        // Get an instance of Car with injected dependencies
        Car car = container.get(Car.class);

        // Call method to test dependency injection
        car.drive();
    }
}

