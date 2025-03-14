package com.advance;

import java.util.Collections;
import java.util.List;

import java.util.Vector;

//10. Using Vector collection, Write a Java Program to accept student names. Also display
//students list in reverse order.
public class Question10 {

    public static void main(String[] args) {
        Vector<String> students = new Vector<>();
        students.add("Shubham");
        students.add("Amit");
        students.add("Sonia");
        students.add("Rahul");
        students.add("Suresh");
        students.add("Neha");
        Collections.reverse(students);
        students.forEach(System.out::println);

    }
}
