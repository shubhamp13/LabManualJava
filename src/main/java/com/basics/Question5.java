package com.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

//5. Create a list of Employee objects (with name and salary fields) and sort them by
//salary in ascending order using a lambda expression.
class Employee
{

    private  int empId;
    private String name;
    private double salary;

    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null) return false;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId && Double.compare(salary, employee.salary) == 0 && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, name, salary);
    }
    public String toString() {
        return "Employee Id "+empId+" Employee Name: " + name + " Salary: " + salary;
    }
}
public class Question5
{
    public static void main(String[] args) {
        List<Employee> employees=new ArrayList<Employee>();
        employees.add(new Employee(1,"Alex",10000.00));
        employees.add(new Employee(2,"Bob",200.00));
        employees.add(new Employee(3,"Charlie",11300.00));
        employees.add(new Employee(4,"David",400.00));
        employees.add(new Employee(5,"Jack",5000.00));
        employees.add(new Employee(6,"Lily",600.00));
        employees.add(new Employee(7,"Mary",7100.00));
        employees.add(new Employee(8,"Peter",2800.00));
        employees.add(new Employee(9,"Jack",9100.00));
        employees.add(new Employee(10,"Jack",900.00));
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        employees.forEach(System.out::println);
        Collections.sort(employees,(a,b)->Double.compare(a.getSalary(),b.getSalary()));
    }
}
