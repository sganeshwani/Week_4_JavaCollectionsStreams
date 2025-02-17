package com.reflection.advancedlevel;

import java.lang.reflect.*;

interface Greeting {
    void sayHello(String name);
    void sayGoodbye(String name);
}

class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    @Override
    public void sayGoodbye(String name) {
        System.out.println("Goodbye, " + name + "!");
    }
}

public class LoggingProxy {

    public static void main(String[] args) {
        // Create the original object (GreetingImpl)
        Greeting greeting = new GreetingImpl();

        // Create the logging proxy for the Greeting interface
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),         // Class loader
                new Class<?>[]{Greeting.class},          // Interfaces to implement
                new InvocationHandler() {                 // Custom handler for method invocation
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // Log the method name before execution
                        System.out.println("Logging: Calling method: " + method.getName());

                        // Invoke the actual method on the original object
                        return method.invoke(greeting, args);
                    }
                });

        // Now, use the proxy instance and observe logging behavior
        proxyInstance.sayHello("John");
        proxyInstance.sayGoodbye("John");
    }
}
