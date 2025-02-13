package com.javastreams.problem4;

import java.io.*;
import java.util.*;

class Employee implements Serializable {
    // Ensures compatibility during deserialization
    private static final long serialVersionUID = 1L;

    int id;
    String name, department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
    }
}

public class SerializeEmployees {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "IT", 60000));
        employees.add(new Employee(102, "Bob", "HR", 50000));
        employees.add(new Employee(103, "Charlie", "Finance", 70000));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}





