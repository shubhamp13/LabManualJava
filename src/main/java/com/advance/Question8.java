package com.advance;

//8. Write a program to demonstrate inter-thread communication using wait(), notify(), and
//notifyAll(). Simulate a scenario where a producer notifies the consumer when an item is
//produced.
class SharedResource {
    int data;
    boolean isAvailable;

    public synchronized void consume() {
        try {
            while (!isAvailable) {
                wait();
            }
            isAvailable = false;
            System.out.println("Consumed: " + data);
            notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void produce(int data) {
        try {
            while (isAvailable) {
                wait();
            }
            isAvailable = true;
            this.data = data;
            System.out.println("Produced:" + data);
            notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
class Producer implements Runnable {
    private SharedResource sharedResource;
    Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    public void run() {
        for(int i=0;i<=20;i++)
        {
            try {
                sharedResource.produce(i);
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
         }
    }
}
class Consumer implements Runnable {
    private SharedResource sharedResource;
    Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    public void run() {
        for (int i=0;i<=20;i++)
        {
            try {
                sharedResource.consume();
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Question8 {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
