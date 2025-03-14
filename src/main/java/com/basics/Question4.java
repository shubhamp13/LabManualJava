package com.basics;

//4. Write a Java program to implement the Garbage Collector.
public class Question4 {
    int a;

    public Question4(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Question4 "+a;
    }

    @Override
    protected void finalize() throws Throwable {

        System.out.println("Finalize method called for "+this);

    }

    public static void main(String[] args){
        Question4 q1=new Question4(112);
        q1=null;
        Question4 q2=new Question4(120);
        Question4 q3=new Question4(120);
        q2=q3;
//        System.gc();
        Runtime.getRuntime().gc();

    }
}
