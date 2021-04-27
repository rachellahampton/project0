package com.app;

public class Account {
  private int accountNumber;
   private int custId;
   private String name;
   private String username;
   private String password;
   private int balance = 0;
   private boolean open;
   private boolean closed;
   private double previousTransaction;



  public Account(int custid, String name, String username, String password, int accountNumber) {
    this.custId = custid;
    this.name = name;
    this.username = username;
    this.password = password;
    this.accountNumber = accountNumber;
  }



    Account(int accountNumber, int custId, String name, int balance, boolean open) {
        this.accountNumber = accountNumber;
        this.custId = custId;
        this.name = name;
        this.balance = balance;
        this.open = open;
    }

   public Account (int custId, String name) {
       this.custId = custId;
       this.name = name;
    }

    public Account(int accountNumber) {
       this.accountNumber = accountNumber;
    }

    public Account() {

    }


    public int getAccountNumber() {
    //   accountNumber = ((int) (Math.random() * 9876));
       return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCustId() {
   //    custId = ((int) (Math.random() * 20303));
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        getPreviousTransaction();
        return balance;
    }

    public void setBalance(int balance) {
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
       if(balance >= 0 ) {
          open = true;
       }
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void deposit ( int amount){
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    public void withdraw ( int amount){
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
