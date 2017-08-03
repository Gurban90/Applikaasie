/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Controller.AccountController;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author Jasper Thielen
 */
public class LoginMenu {

    Logger logger = Logger.getLogger(LoginMenu.class.getName());
    private Scanner input;
    private int choice;
    private AccountController controller;

    public void loginMenu() {

        input = new Scanner(System.in);

        System.out.println("Welcome to Applikaasie.... " + "\n"
                + "1. press 1 to log in with an existing account " + "\n"
                + "2. press 2 to create account " + "\n"
                + "3. press 3 to update your account " + "\n"
                + "4. press 4 to remove an account " + "\n"
                + "4. press 5 to search for an account with ID" + "\n"
                + "5. press 6 to search for an account with Name" + "\n"
                + "6. press 7 to get all accounts" + "\n"
                + "5. press 8 to exit");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Please enter your account number: ");
                int id = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                String password = input.nextLine();
                controller.login(id, password);
                break;
            case 2:
                System.out.print("Insert Accountname: ");
                String name = input.next();
                input.nextLine();
                System.out.print("Insert Password: ");
                String password2 = input.nextLine();
                System.out.print("Insert Accountstatus: ");
                int status = input.nextInt();
                controller.newAccount(name, password2, status);
                break;
            case 3:
                System.out.print("AccountID please: ");
                int id4 = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                String password4 = input.nextLine();
                controller.updateAccountCheck(id4, password4);
                break;
            case 4:
                System.out.print("THIS WILL DELETE YOUR ACCOUNT! To cancel do not fill in your password. ");
                System.out.print("AccountID please: ");
                int id3 = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                String password3 = input.nextLine();
                controller.removeAccount(id3, password3);
                break;
            case 5:
                System.out.print("AccountID please: ");
                int id5 = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                String password5 = input.nextLine();
                controller.findAccount(id5, password5);
                break;
            case 6:
                System.out.print("AccountID please: ");
                int id6 = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                String password6 = input.nextLine();
                System.out.print("AccountName please: ");
                String name6 = input.next();
                controller.findAccountWithName(id6, password6, name6);
                break;
            case 7:
                System.out.print("AccountID please: ");
                int id7 = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                String password7 = input.nextLine();
                controller.getAllAccounts(id7, password7);
                break;
            case 8:
                System.out.println("goodbye...");
                System.exit(0);
            default:
                System.out.println("wrong number, try again");
                loginMenu();

        }
    }

    public void updateAccountMenu() {
        System.out.println("What do you want ot edit? " + "\n"
                + "1. press 1 to edit your accountname " + "\n"
                + "2. press 2 to edit your password " + "\n"
                + "3. press 3 to update your accountstatus " + "\n"
                + "4. press 4 to edit all " + "\n"
                + "5. press 5 to return to last menu");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Insert AccountID: ");
                int id = input.nextInt();
                System.out.print("Insert new AccountName: ");
                String name2 = input.next();
                controller.editAccountName(id, name2);
                break;
            case 2:
                System.out.print("Insert AccountID: ");
                int id2 = input.nextInt();
                System.out.print("Insert new Password: ");
                String password2 = input.next();
                controller.editAccountPassword(id2, password2);
                break;
            case 3:
                System.out.print("Insert AccountID: ");
                int id3 = input.nextInt();
                System.out.print("Insert new AccountStatus: ");
                int status2 = input.nextInt();
                controller.editAccountStatus(id3, status2);
                break;
            case 4:
                System.out.print("Insert new Accountname: ");
                String name = input.nextLine();
                System.out.print("Insert new Password: ");
                String password = input.nextLine();
                input.nextLine();
                System.out.print("Insert new Accountstatus: ");
                int status = input.nextInt();
                controller.updateAccount(name, password, status);
                break;
            case 5:
                loginMenu();
                break;
            default:
                System.out.println("wrong number, try again");
                updateAccountMenu();

        }
    }
   
}
