package com.basics;

//2. Implement a program to demonstrate hierarchical inheritance:  Base class Vehicle with fields make and model.  Derived classes Car and Bike that extend Vehicle.  Add unique methods to both derived classes and display their features
class Vehicle {
    private String brand;
    private String model;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
    }
}

class Car extends Vehicle {
    private final String color;
    private final int engineCapacity;

    public Car(String brand, String model, String color, int engineCapacity) {
        super(brand, model);
        this.color = color;
        this.engineCapacity = engineCapacity;
    }

    public void carInfo() {
        super.display();
        System.out.println("Color: " + color);
        System.out.println("Engine Capacity: " + engineCapacity);
        System.out.println("----------------------------------------");


    }
}

class Bike extends Vehicle {
    private String color;
    private int bikeCapacity;

    public Bike(String brand, String model, String color, int bikeCapacity) {
        super(brand, model);
        this.color = color;
        this.bikeCapacity = bikeCapacity;
    }
    public void bikeInfo() {
        super.display();
        System.out.println("Color: " + color);
        System.out.println("Bike Capacity: " + bikeCapacity);
        System.out.println("----------------------------------------");
    }
}

public class Question2 {
    public static void main(String[] args) {
        Bike bike=new Bike("Honda","CB Hornet","Red",160);
        Car car=new Car("Volkswagen","Taigun","Green",1000);
        bike.bikeInfo();
        car.carInfo();
    }
}

