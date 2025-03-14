package com.advance;
//12. Write a program to create a custom exception class InvalidAgeException.  The exception should be thrown if the user's age is less than 18.  Test the exception by taking the user's age as input.

import java.util.Scanner;

class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Question12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Age:");
        int age = sc.nextInt();
        try {

            if (age < 18) {
                throw new InvalidAgeException("Invalid Age");
            }

        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Main Ends");
    }
}
