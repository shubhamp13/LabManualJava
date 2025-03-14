package com.advance;
class BankAccount
{
    private long accountNumber;
    private double balance;
    private String name;

    public BankAccount(long accountNumber, double balance, String name) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
    }
    public  void deposit(double amount)
    {
        if(amount>0)
        {
            balance += amount;
            System.out.println("Deposited " + amount);
            System.out.println("---------------------------");
            System.out.println("Name: " + name);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Available Balance: " + balance);
        }
        else
        {
            System.out.println("Invalid amount");
        }
    }
    public void withdraw(double amount) {
        if(amount>balance)
        {
            throw new InsufficientFundsException("Insufficient funds to withdraw");
        }
        balance -= amount;
        System.out.println("Withdrawn " + amount);
        System.out.println("---------------------------");
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Available Balance: " + balance);
    }
}
class InsufficientFundsException extends RuntimeException
{
    public InsufficientFundsException(String message) {
        super(message);
    }
}
public class Question11 {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(35637102910L, 100000.0, "Shubham Puri");
        bankAccount.deposit(500.0);
        try {

            bankAccount.withdraw(500000000.0);
        }catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Bank Transaction ends");

    }
}
