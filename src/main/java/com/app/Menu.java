package com.app;

/* Note to self *** Use regex to make simple username and password requirements and then use .equals method
** to compare the input of the username and my programmer defined acceptable inputs that I will store in
 */

import com.app.dao.CustomerDAO;
import com.app.dao.impl.Customer;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {


    public static void main(String[] args) throws BusinessException, SQLException {

        boolean login = false;

        Account account;

        account = new Account();
        Scanner sc = new Scanner(System.in);
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
    //    System.out.println("your custid is " + account.getCustId() + account.getName() + account.getUsername() +
     //           account.getPassword() + account.getAccountNumber());
        //  showMenu();

       CustomerDAO customerDAO = new Customer();
       try {
            account = customerDAO.createAccount(account);
            if(account.getCustId() != 0) {
                System.out.println("You did it and here is it the details");
                System.out.println(account);
            }
          // customerDAO.createAccount(account);
       } catch (SQLException | BusinessException e) {
           System.out.println("it didnt work" + e);
           e.printStackTrace();
       }

      //  account = customerDAO.createAccount(account.getCustId(), account.getName(), account.getUsername(), account.getPassword(), account.getAccountNumber());
    //    System.out.println(account);

       /* try {

            account = customerDAO.createAccount(account.getCustId(), account.getName(), account.getUsername(), account.getPassword(), account.getAccountNumber());
            if (account.getCustId() != 0) {
                System.out.println("Customer registered successfully with below details");
                System.out.println(account);
            }
        } catch (SQLException | BusinessException e) {
            System.out.println("Internal error occured...Please contact SYSADMIN " + e);
        }
    }


        /*  if (username && password .equals()) {
         I set the boolean login to false until it passes a validation of some sort
           if (login = true) {

       System.out.println("\n");
              } else {
                 System.out.println("Incorrect login");

*/
   /*





        public static void showMenu () {
            int options;
            int deposit;
            int withdraw;
            Scanner scanner = new Scanner(System.in);
            Account account = new Account();
            do {
                System.out.println("Welcome to bank login! How may we help you today?");
                System.out.println("\n");
                System.out.println("1) Check Balance");
                System.out.println("2) Deposit");
                System.out.println("3) Withdraw");
                System.out.println("4) Previous transaction");
                System.out.println("5) Exit");
                System.out.println("*********************************************");
                System.out.println("Enter an option");
                options = scanner.nextInt();

            } while (options != 4);
            switch (options) {
                case 0:
                    account.getBalance();
                    break;

                case 1:
                    System.out.println("Enter an amount to deposit");
                    deposit = scanner.nextInt();
                    account.deposit(deposit);
                    break;

                case 2:
                    System.out.println("Enter an amount to withdraw");
                    withdraw = scanner.nextInt();
                    account.withdraw(withdraw);
                    break;

                case 3:
                    account.getPreviousTransaction();
                    System.out.println();
                    break;
            }
*/
        }



    }

