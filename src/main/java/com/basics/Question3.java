package com.basics;
//3. Write a Java program to demonstrate multiple inheritance using interfaces. Create two
//interfaces A and B, each with a method. Implement these interfaces in a class and display
//        output.
interface A
{
    public void print();
}
interface B
{
    public void print();
}
public class Question3 implements A, B
{
    @Override
    public void print() {
        System.out.println("Multiple Inheritance");
    }
    public static void main(String[] args) {
        A a=new Question3();
        B b=new Question3();
        a.print();
        b.print();
    }
}
