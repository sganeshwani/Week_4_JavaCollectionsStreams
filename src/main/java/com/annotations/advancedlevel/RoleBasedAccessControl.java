package com.annotations.advancedlevel;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the @RoleAllowed annotation to mark methods requiring specific roles
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();  // The role required to access the method
}

// User class with a role
class UserPerson {
    private String role;

    public UserPerson(String role) {
        this.role = role;
    }

    // Method to get the user's role
    public String getRole() {
        return role;
    }
}

// Access Control class to check roles and invoke methods
class AccessControl {

    public static void checkAccessAndInvoke(Object target, Method method, UserPerson user, Object[] args) throws Exception {
        // Check if the method is annotated with @RoleAllowed
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            // Get the role required to access the method
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            String requiredRole = roleAllowed.value();

            // Check if the user's role matches the required role
            if (user.getRole().equals(requiredRole)) {
                // If the user has the required role, invoke the method
                method.invoke(target, args);
            } else {
                // If the user doesn't have the required role, deny access
                System.out.println("Access Denied!");
            }
        } else {
            // If the method isn't annotated, just invoke it
            method.invoke(target, args);
        }
    }
}

// AdminService class with methods annotated with @RoleAllowed
class AdminService {

    @RoleAllowed("ADMIN")  // Only users with "ADMIN" role can access this
    public void viewAdminPage() {
        System.out.println("Welcome to the Admin Page!");
    }

    @RoleAllowed("USER")  // Only users with "USER" role can access this
    public void viewUserPage() {
        System.out.println("Welcome to the User Page!");
    }
}

// Main class to test the role-based access control
public class RoleBasedAccessControl {

    public static void main(String[] args) throws Exception {
        // Create instances of users with different roles
        UserPerson adminUser = new UserPerson("ADMIN");
        UserPerson regularUser = new UserPerson("USER");

        // Create the AdminService instance
        AdminService adminService = new AdminService();

        // Get the method references from the AdminService class
        Method viewAdminPageMethod = AdminService.class.getMethod("viewAdminPage");
        Method viewUserPageMethod = AdminService.class.getMethod("viewUserPage");

        // Test access control
        System.out.println("Testing access with ADMIN user:");
        AccessControl.checkAccessAndInvoke(adminService, viewAdminPageMethod, adminUser, null);  // Should allow
        AccessControl.checkAccessAndInvoke(adminService, viewUserPageMethod, adminUser, null);  // Should allow

        System.out.println("\nTesting access with USER user:");
        AccessControl.checkAccessAndInvoke(adminService, viewAdminPageMethod, regularUser, null);  // Should deny
        AccessControl.checkAccessAndInvoke(adminService, viewUserPageMethod, regularUser, null);  // Should allow
    }
}