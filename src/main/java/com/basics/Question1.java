package com.basics;
//1. Write a Java program to create an abstract class Shape with the following:  An abstract method calculateArea().  A concrete method display() that displays the type of shape.  Create two subclasses: Circle and Rectangle.  Implement the calculateArea() method in both subclasses and display the areas.
  abstract class Shape
{
    public abstract  void calculateArea();
    public  void display()
    {
        System.out.println("Shape");
    }
}
class Rectangle extends Shape
{
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void calculateArea() {
        double area = length * width;
        System.out.println("Area of Rectangle is " + area);
    }

    @Override
    public void display() {
        System.out.println("Shape is rectangle");
    }
}
class Circle extends Shape
{
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        double area =Math.PI*radius * radius;
        System.out.println("Area of Circle is " + area);
    }

    @Override
    public void display() {
        System.out.println("Shape is Circle");
    }
}
public  class Question1
{
    public static void main(String[] args)
    {
        Shape circle=new Circle(5);
        Shape rectangle=new Rectangle(10,20);
        circle.display();
        rectangle.display();
        circle.calculateArea();
        rectangle.calculateArea();
    }
}
