package com.app;

import java.util.List;

public class Account {
  private long accountNumber;
   private long custId;
   private String name;
   private String username;
   private String password;
   private double balance = 0.00;
   private boolean open;
   private boolean closed;
   private boolean isValidLogin;
   private double previousTransaction;




  public Account(long custid, String name, String username, String password, long accountNumber, double balance) {
    this.custId = custid;
    this.name = name;
    this.username = username;
    this.password = password;
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

    public Account(long custid, String name, String username, String password, long accountNumber, boolean open) {
        this.custId = custid;
        this.name = name;
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
        this.open = open;
    }



    Account(long accountNumber, long custId, String name, double balance, boolean open) {
        this.accountNumber = accountNumber;
        this.custId = custId;
        this.name = name;
        this.balance = balance;
        this.open = open;
    }

   public Account (long custId, String name) {
       this.custId = custId;
       this.name = name;
    }

    public Account(String username, String password) {
      this.username = username;
      this.password = password;

    }



    public Account(long accountNumber) {
       this.accountNumber = accountNumber;
    }

    public Account() {

    }

  /*  public boolean validLogin(){
      if()
      return
    } */
    public long getAccountNumber() {
       accountNumber = ((long) (Math.random() * 98768756));
       return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getCustId() {
       custId = ((long) (Math.random() * 20303));
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        getPreviousTransaction();
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;

    }

    public boolean isClosed() {
        if (balance < 0) {
            open = false;
        }
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean isOpen() {
       if(balance >= 1.00 ) {
          open = true;
       }
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void deposit ( double amount){
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    public void withdraw (double amount){
        balance = balance + amount;
        previousTransaction = -amount;
    }
    public void getPreviousTransaction () {
        if (previousTransaction > 0) {
            System.out.println("You deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("You withdrew: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }

    public String getUsername() {
       return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
       return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public void pullFromDatabase() {

    }


    @Override
    public String toString() {
       return "Account{" +
               "custid=" + custId +
               ",name=" + name + '\'' +
               ",username=" + username + '\'' +
               ",password" + password +
               ",accountnumber" + accountNumber +
               '}';

    }



}
