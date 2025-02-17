package com.annotations.advancedlevel;

import java.lang.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.*;
import java.util.Arrays;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}


class Manager {

    private static final Map<String, Object> cache = new HashMap<>();

    // Method to get the cached result
    public static Object get(String key) {
        return cache.get(key);
    }

    // Method to store the computed result in the cache
    public static void put(String key, Object result) {
        cache.put(key, result);
    }
}

class ExpensiveComputation {

    @CacheResult
    public int expensiveMethod(int input) {
        // Simulate expensive computation
        try {
            Thread.sleep(2000);  // Simulating long computation (e.g., 2 seconds)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return input * input;  // Return square of the input as an example
    }
}

class CacheInterceptor {

    public static Object invokeWithCache(Object target, Method method, Object[] args) throws Exception {
        // Check if the method is annotated with @CacheResult
        if (method.isAnnotationPresent(CacheResult.class)) {
            // Create a key for caching based on the method name and arguments
            String key = method.getName() + Arrays.toString(args);

            // Check if the result is already cached
            Object cachedResult = Manager.get(key);
            if (cachedResult != null) {
                System.out.println("Returning cached result for: " + key);
                return cachedResult;
            }

            // If not cached, invoke the method and store the result
            Object result = method.invoke(target, args);
            Manager.put(key, result);
            return result;
        }

        // If no caching is needed, just invoke the method normally
        return method.invoke(target, args);
    }
}

public class CacheManager {

    public static void main(String[] args) throws Exception {
        ExpensiveComputation computation = new ExpensiveComputation();

        // Invoke the method with different inputs
        System.out.println("First call (computation with input 5): " +
                CacheInterceptor.invokeWithCache(computation,
                        computation.getClass().getMethod("expensiveMethod", int.class), new Object[]{5}));

        // The second call should hit the cache
        System.out.println("Second call (computation with input 5, cached result): " +
                CacheInterceptor.invokeWithCache(computation,
                        computation.getClass().getMethod("expensiveMethod", int.class), new Object[]{5}));

        // The third call should compute again with a new input
        System.out.println("Third call (computation with input 10): " +
                CacheInterceptor.invokeWithCache(computation,
                        computation.getClass().getMethod("expensiveMethod", int.class), new Object[]{10}));
    }
}