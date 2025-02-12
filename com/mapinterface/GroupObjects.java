package com.mapinterface;

import java.util.*;

class Employee {
    String name;
    String department;

    // Constructor
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name; // Print only the employee name in output
    }
}

public class GroupObjects {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        // Create a map to store grouped employees
        Map<String, List<Employee>> groupedMap = new HashMap<>();

        // Iterate through each employee
        for (Employee emp : employees) {
            // If department is not in map, add a new list
            groupedMap.putIfAbsent(emp.department, new ArrayList<>());

            // Add employee to their respective department list
            groupedMap.get(emp.department).add(emp);
        }

        return groupedMap; // Return the grouped map
    }

    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR"),
                new Employee("Sahil", "IT")
        );

        // Group employees by department
        Map<String, List<Employee>> groupedEmployees = groupByDepartment(employees);

        // Print the grouped map
        for (Map.Entry<String, List<Employee>> entry : groupedEmployees.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

