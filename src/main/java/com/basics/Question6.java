package com.basics;

//6. Write a program to demonstrate runtime polymorphism:  Create a base class Bank with a method getRateOfInterest().  Create subclasses SBI, ICICI, and Axis that override getRateOfInterest().  Use a reference of the base class to call the overridden methods
class Bank
{
    private final  double rateOfInterest=6.14;
    public  double getRateOfInterest()
    {
        return rateOfInterest;
    }
}
class SBI extends Bank
{
    private final  double rateOfInterest=7.14;

    @Override
    public double getRateOfInterest() {
        System.out.print("SBI Rate Of Interest: ");
        return rateOfInterest;
    }
}
class ICICI extends Bank
{
    private final  double rateOfInterest=8.14;

    @Override
    public double getRateOfInterest() {
        System.out.print("ICICI Rate Of Interest: ");
        return rateOfInterest;
    }
}
public class Question6 {
    public static void main(String[] args) {
        Bank sbi=new SBI();
        Bank icici=new ICICI();
        double rateOfInterestSbi = sbi.getRateOfInterest();
        System.out.println(rateOfInterestSbi);
        double rateOfInterestIcici = icici.getRateOfInterest();
        System.out.println(rateOfInterestIcici);

    }
}
