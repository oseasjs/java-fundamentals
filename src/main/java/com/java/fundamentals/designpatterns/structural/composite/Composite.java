package com.java.fundamentals.designpatterns.structural.composite;

import java.util.*;

/**
 * Composite pattern is used where we need to treat a group of objects in similar way as a single object.
 * Composite pattern composes objects in term of a tree structure to represent part as well as whole hierarchy.
 * This type of design pattern comes under structural pattern as this pattern creates a tree structure of group of objects.
 *
 * This pattern creates a class that contains group of its own objects. This class provides ways to modify its group of same objects.
 */
public class Composite {
    public static void main(String[] args) {

        Employee ceo = new Employee("John", "CEO", 10000);

        Employee headSales = new Employee("Mary", "Sales", 5000);
        Employee saleExecutive1 = new Employee("Bob", "Sales", 3000);
        Employee saleExecutive2 = new Employee("Jeff", "Sales", 2000);

        headSales.add(saleExecutive1);
        headSales.add(saleExecutive2);

        Employee headEngineering = new Employee("Mark", "Engineering", 5000);
        Employee engineer1 = new Employee("Lana", "Engineering", 3000);
        Employee engineer2 = new Employee("Nancy", "Engineering", 2000);

        headEngineering.add(engineer1);
        headEngineering.add(engineer2);

        ceo.add(headSales);
        ceo.add(headEngineering);

        System.out.println(ceo);
        printSubordinate(ceo);

    }

    public static void printSubordinate(Employee employee) {
        for (Employee e: employee.getSubordinates()) {
            System.out.println(e);
            if (employee.getSubordinates() != null) {
                printSubordinate(e);
            }
        }
    }
}

class Employee {
    private String name;
    private String dept;
    private double salary;
    private List<Employee> subordinates;

    public Employee(String name, String dept, double salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.subordinates = new ArrayList<>();
    }

    public void add(Employee employee) {
        this.subordinates.add(employee);
    }

    public void remove(Employee employee) {
        this.subordinates.remove(employee);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return ("Employee : [Name: " + name + ", Department: " + dept + ", Salary: " + salary + "]");
    }
}
