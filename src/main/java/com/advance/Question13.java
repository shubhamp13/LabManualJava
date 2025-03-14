package com.advance;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//13. Create a program to manage a collection of employees using a HashSet.  Each employee should have an ID, name, and department.  Add, remove, and display employees without duplicates
class Employee
{
    private String name;
    private int id;
    private String departmentName;

    public Employee(String name, int id, String departmentName) {
        this.name = name;
        this.id = id;
        this.departmentName = departmentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o==null)return false;
        if(!(o instanceof Employee))return false;
        Employee employee = (Employee)o;
        return id==employee.id;
    }

    @Override
    public int hashCode() {
        return  id;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Id: " + id + ", Department: " + departmentName;
    }
}
public class Question13
{
    public static void main(String[] args) {
        Set<Employee> employees = new HashSet<>();
        employees.add(new Employee( "Shubham Puri", 252, "Software Engineer"));
        employees.add(new Employee( "Shrikant Surve", 262, "Support Engineer"));
        employees.add(new Employee( "Shubham Puri", 252, "Software Engineer"));
        employees.add(new Employee( "Shrikant Surve", 262, "Support Engineer"));
        employees.remove(new Employee( "Shrikant Surve", 262, "Support Engineer"));
        employees.forEach(System.out::println);

    }
}
