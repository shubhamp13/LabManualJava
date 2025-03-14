package com.advance;

//9. Write a program to create three threads and set their priorities to MIN_PRIORITY, NORM_PRIORITY, and MAX_PRIORITY. Observe the execution order and explain the
//outcome.
public class Question9
{
    public static void main(String[] args) {
        Thread minPriority = new Thread(()->{
            System.out.println( "Thread 1" );
        });
        Thread normalPriority = new Thread(()->{
            System.out.println( "Thread 2" );
        });
        Thread highPriority = new Thread(()->{
            System.out.println( "Thread 3" );
        });
        minPriority.setPriority(Thread.MIN_PRIORITY);
        normalPriority.setPriority(Thread.NORM_PRIORITY);
        highPriority.setPriority(Thread.MAX_PRIORITY);
        highPriority.start();
        minPriority.start();
        normalPriority.start();


    }
}
