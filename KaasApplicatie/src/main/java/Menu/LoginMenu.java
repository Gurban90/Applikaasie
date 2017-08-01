/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Dao.AccountDAO;
import POJO.AccountPOJO;
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

    public void loginMenu() {

        input = new Scanner(System.in);

        System.out.println("Welcome to Applikaasie.... " + "\n"
                + "1. press 1 to log in with an existing account " + "\n"
                + "2. press 2 to create account " + "\n"
                + "3. press 3 to update your account " + "\n"
                + "4. press 4 to remove an account " + "\n"
                + "5. press 5 to exit");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                newAccount();
                break;
            case 3:
                UpdateAccount();
                break;
            case 4:
                removeAccount();
                break;
            case 5:
                System.out.println("goodbye...");
                System.exit(0);
            default:
                System.out.println("wrong number, try again");
                loginMenu();

        }
    }

    public void login() {
        logger.info("login start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();
        System.out.print("Please enter your account number: ");
        accountpojo.setAccountID(input.nextInt());
        input.nextLine();
        System.out.print("Please enter your password: ");
        accountpojo.setAccountPassword(input.nextLine());

        AccountPOJO foundAccount = accountdao.getAccount(accountpojo);

        if (accountpojo.getAccountPassword().equals(foundAccount.getAccountPassword())) {
            MainMenu mainmenu = new MainMenu();
            mainmenu.mainMenu();
        } else {
            System.out.println("Wrong password or accountnumber, try again.");
            loginMenu();
        }
        logger.info("login end");
    }

    public void newAccount() {
        logger.info("newAccount start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        System.out.print("Insert Accountname: ");
        accountpojo.setAccountName(input.next());
        input.nextLine();
        System.out.print("Insert Password: ");
        accountpojo.setAccountPassword(input.nextLine());
        System.out.print("Insert Accountstatus: ");
        accountpojo.setAccountStatus(input.nextInt());

        int AccountID = accountdao.addAccount(accountpojo);
        System.out.println("Account is added and has ID: " + AccountID);
        input.nextLine();

        logger.info("newAccount end");
        loginMenu();
    }

    public void removeAccount() {
        logger.info("removeAccount start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        System.out.print("THIS WILL DELETE YOUR ACCOUNT! To cancel do not fill in your password. ");
        System.out.print("AccountID please: ");
        accountpojo.setAccountID(input.nextInt());
        input.nextLine();
        System.out.print("Please enter your password: ");
        accountpojo.setAccountPassword(input.nextLine());

        AccountPOJO foundAccount = accountdao.getAccount(accountpojo);

        if (accountpojo.getAccountPassword().equals(foundAccount.getAccountPassword())) {
            accountdao.deleteAccount(accountpojo);
            System.out.print("Account has been deleted.");
            input.nextLine();
            loginMenu();
        } else {
            System.out.println("Wrong password or accountnumber, try again.");
            input.nextLine();
            loginMenu();
        }
        logger.info("removeAccount end");
    }

    public void UpdateAccount() {
        logger.info("UpdateAccount start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        System.out.print("AccountID please: ");
        accountpojo.setAccountID(input.nextInt());
        input.nextLine();
        System.out.print("Please enter your password: ");
        accountpojo.setAccountPassword(input.nextLine());

        AccountPOJO foundAccount = accountdao.getAccount(accountpojo);

        if (accountpojo.getAccountPassword().equals(foundAccount.getAccountPassword())) {
            System.out.print("Insert new Accountname: ");
            accountpojo.setAccountName(input.nextLine());
            System.out.print("Insert new Password: ");
            accountpojo.setAccountPassword(input.nextLine());
            input.nextLine();
            System.out.print("Insert new Accountstatus: ");
            accountpojo.setAccountStatus(input.nextInt());

            accountdao.updateAccount(accountpojo);
            System.out.print("Account has been updated.");
            input.nextLine();
            loginMenu();
        } else {
            System.out.println("Wrong password or accountnumber, try again.");
            input.nextLine();
            loginMenu();
        }
        logger.info("UpdateAccount end");

    }
}
