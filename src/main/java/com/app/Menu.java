package com.app;

/* Note to self *** Use regex to make simple username and password requirements and then use .equals method
** to compare the input of the username and my programmer defined acceptable inputs that I will store in
 */

import com.app.dao.CustomerDAO;
import com.app.dao.impl.Customer;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {


    public void showMenu() throws BusinessException, SQLException {
        int options = 0;
        double deposit;
        double withdraw;

        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        CustomerDAO dao = new Customer();
      //  account = dao.updateDatabase(account);
        do {
            System.out.println("Welcome to bank login!" + account.getName() +  " How may we help you today?");
            System.out.println("\n");
            System.out.println("1) Check Balance");
            System.out.println("2) Deposit");
            System.out.println("3) Withdraw");
            System.out.println("4) Previous transaction");
            System.out.println("5) Exit");
            System.out.println("*********************************************");
            System.out.println("Enter an option");
            try {
                options = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){}
            options = scanner.nextInt();

        } while (options != 5);
        switch (options) {
            case 1:
                account = dao.checkBalance(account);
                System.out.println("Your balance is " + account);
              //  account.getBalance();
                break;

            case 2:
                System.out.println("Enter an amount to deposit");
                deposit = scanner.nextInt();
                account.deposit(deposit);
                break;

            case 3:
                System.out.println("Enter an amount to withdraw");
                withdraw = scanner.nextInt();
                account.withdraw(withdraw);
                break;

            case 4:
                account.getPreviousTransaction();
                System.out.println();
                break;
        }
    }


    public void loginValidation() throws BusinessException, SQLException {
        boolean isLoggedIn = false;
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        CustomerDAO customerDAO = new Customer();
        System.out.println("Please enter your username");
        String username = scanner.nextLine();
        account.setUsername(username);
        System.out.println("Please enter your password");
        String password = scanner.nextLine();
        account.setPassword(password);
        account = customerDAO.pullFromDatabase(account);
        if (account != null) {
            isLoggedIn = true;
            showMenu();
        } else {

        }
    }
}







/*  public static void databaseInsert() {
        Account account;

        account = new Account();
        Scanner sc = new Scanner(System.in);

        // showMenu();

        System.out.println("Welcome ");
        System.out.println("Enter your customer id");
        account.setCustId(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter your name");
        account.setName(sc.nextLine());
        System.out.println("Enter your username: ");
        account.setUsername(sc.nextLine());
        System.out.println("Enter your password: ");
        account.setPassword(sc.nextLine());
        System.out.println("Enter your account number");
        account.setAccountNumber(Integer.parseInt(sc.nextLine()));
        // System.out.println("your custid is \n" + account.getCustId() + "your name is \n " + account.getName() + "your username is \n" + account.getUsername() +
        //      "your password is \n " +  account.getPassword() + "your account number is \n " + account.getAccountNumber());
        //  showMenu();


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

    }    */



/*   public static void main(String[] args) throws BusinessException, SQLException {

        boolean login = false;


    }*/
