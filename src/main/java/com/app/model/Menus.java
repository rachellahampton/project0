package com.app.model;

import com.app.Account;
import com.app.BusinessException;
import com.app.Menu;
import com.app.dao.CustomerDAO;
import com.app.dao.impl.Customer;

import java.sql.SQLException;
import java.util.Scanner;

public class Menus {

    public static void welcomeNewCustomer(){
        String name;
        String username;
        double startAmount;
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the bank of Rachella!");
        System.out.println("Please enter your name");
        name = scanner.nextLine();
        account.setName(name);
        System.out.println(name + " Please enter your desired username");
        username = scanner.nextLine();
        account.setUsername(username);
        System.out.println("Please enter your desired password");
        String password = scanner.nextLine();
        account.setPassword(password);
        System.out.println("Please enter a starting deposit amount");
        startAmount = scanner.nextDouble();
        account.deposit(startAmount);
        long newAccountNumber = account.getAccountNumber();
        long custid = account.getCustId();
        double newAccountStartingBalance = account.getBalance();
        account.setAccountNumber(newAccountNumber);
        account.setBalance(startAmount);
      boolean newAccount = account.isOpen();
      account.setOpen(true);

        System.out.println("Thank you " + name + "Your account is open" + " I have stored your information for " + username);
        System.out.println(" With account number " + newAccountNumber + " and customer id number " + custid);
        System.out.println(" Your starting balance is " + newAccountStartingBalance );

        try {
            Customer customer = new Customer();
            CustomerDAO customerDAO = new Customer();

            account = customerDAO.createAccount(account);

            if (account.getCustId() != 0) {
                System.out.println("You did it and here is it the details");
                System.out.println(account);
            }

        } catch (SQLException | BusinessException e) {
            System.out.println("it didnt work" + e);
            e.printStackTrace();
        }

    }





    public static void main(String[] args) throws BusinessException, SQLException {
       Account account = new Account();


        CustomerDAO customerDAO = new Customer();
        Scanner scanner = new Scanner(System.in);

        //welcomeNewCustomer();

        Menu menu = new Menu();
        menu.loginValidation();

      //  account = customerDAO.updateDatabase(account);
    }
}
