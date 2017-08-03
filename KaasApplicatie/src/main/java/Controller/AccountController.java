/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AccountDAO;
import Menu.LoginMenu;
import Menu.MainMenu;
import POJO.AccountPOJO;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author Gerben
 */
public class AccountController {

    private Scanner input = new Scanner(System.in);
    Logger logger = Logger.getLogger(AccountController.class.getName());
    private LoginMenu menu;

    public void login(int id, String password) {
        logger.info("login start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountID(id);
        accountpojo.setAccountPassword(password);
        AccountPOJO foundAccount = accountdao.getAccount(accountpojo);

        if (accountpojo.getAccountPassword().equals(foundAccount.getAccountPassword())) {
            MainMenu mainmenu = new MainMenu();
            mainmenu.mainMenu();
        } else {
            System.out.println("Wrong password or accountnumber, try again.");
            menu.loginMenu();
        }
        logger.info("login end");
    }

    public void newAccount(String name, String password, int status) {
        logger.info("newAccount start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountName(name);
        accountpojo.setAccountPassword(password);
        accountpojo.setAccountStatus(status);

        int AccountID = accountdao.addAccount(accountpojo);
        System.out.println("Account is added and has ID: " + AccountID);
        input.nextLine();
        logger.info("newAccount end");
        menu.loginMenu();
    }

    public void removeAccount(int id, String password) {
        logger.info("removeAccount start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountID(id);
        accountpojo.setAccountPassword(password);
        AccountPOJO foundAccount = accountdao.getAccount(accountpojo);

        if (accountpojo.getAccountPassword().equals(foundAccount.getAccountPassword())) {
            accountdao.deleteAccount(accountpojo);
            System.out.print("Account has been deleted.");
            input.nextLine();
            menu.loginMenu();
        } else {
            System.out.println("Wrong password or accountnumber, try again.");
            input.nextLine();
            menu.loginMenu();
        }
        logger.info("removeAccount end");
    }

    public void updateAccountCheck(int id, String password) {
        logger.info("updateAccountMenu start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountID(id);
        accountpojo.setAccountPassword(password);
        AccountPOJO foundAccount = accountdao.getAccount(accountpojo);

        if (accountpojo.getAccountPassword().equals(foundAccount.getAccountPassword())) {
            menu.updateAccountMenu();
        } else {
            System.out.println("Wrong password or accountnumber, returning to LoginMenu.");
            menu.loginMenu();
        }
        logger.info("updateAccountMenu end");
    }

    public void updateAccount(String name, String password, int status) {
        logger.info("UpdateAccount start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountName(name);
        accountpojo.setAccountPassword(password);
        accountpojo.setAccountStatus(status);
        accountdao.updateAccount(accountpojo);

        System.out.println("Account has been updated.");
        input.nextLine();
        menu.loginMenu();
        logger.info("UpdateAccount end");
    }

    public void editAccountName(int id, String name) {
        logger.info("editAccountName start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountID(id);
        AccountPOJO accountpojo2 = accountdao.getAccount(accountpojo);
        accountpojo2.setAccountName(name);
        accountdao.updateAccount(accountpojo2);

        System.out.println("Account has been updated.");
        input.nextLine();
        menu.loginMenu();
        logger.info("editAccountName end");
    }

    public void editAccountPassword(int id, String password) {
        logger.info("editAccountPassword start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountID(id);
        AccountPOJO accountpojo2 = accountdao.getAccount(accountpojo);
        accountpojo2.setAccountPassword(password);
        accountdao.updateAccount(accountpojo2);

        System.out.println("Account has been updated.");
        input.nextLine();
        menu.loginMenu();
        logger.info("editAccountPassword end");
    }

    public void editAccountStatus(int id, int status) {
        logger.info("editAccountStatus start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountID(id);
        AccountPOJO accountpojo2 = accountdao.getAccount(accountpojo);
        accountpojo2.setAccountStatus(status);
        accountdao.updateAccount(accountpojo2);

        System.out.println("Account has been updated.");
        input.nextLine();
        menu.loginMenu();
        logger.info("editAccountStatus end");
    }

    public void findAccount(int id, String password) {
        logger.info("findAccount start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountID(id);
        accountpojo.setAccountPassword(password);
        AccountPOJO foundAccount = accountdao.getAccount(accountpojo);

        if (accountpojo.getAccountPassword().equals(foundAccount.getAccountPassword())) {
            AccountPOJO returnedcheese = accountdao.getAccount(accountpojo);
            System.out.println(returnedcheese);
            menu.loginMenu();
        } else {
            System.out.println("Wrong password or accountnumber, returning to LoginMenu.");
            menu.loginMenu();
        }
        logger.info("findAccount end");
    }

    public void findAccountWithName(int id, String password, String name) {
        logger.info("findAccountWithName start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountID(id);
        accountpojo.setAccountPassword(password);
        AccountPOJO foundAccount = accountdao.getAccount(accountpojo);

        if (accountpojo.getAccountPassword().equals(foundAccount.getAccountPassword())) {
            accountpojo.setAccountName(name);
            input.nextLine();
            List<AccountPOJO> returnedAccounts = accountdao.getAccountWithName(accountpojo);
            System.out.println(returnedAccounts);
            menu.loginMenu();
        } else {
            System.out.println("Wrong password or accountnumber, returning to LoginMenu.");
            menu.loginMenu();
        }
        logger.info("findAccountWithName end");
    }

    public void getAllAccounts(int id, String password) {
        logger.info("GetAllAccounts start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountID(id);
        accountpojo.setAccountPassword(password);
        AccountPOJO foundAccount = accountdao.getAccount(accountpojo);

        if (accountpojo.getAccountPassword().equals(foundAccount.getAccountPassword())) {
            List<AccountPOJO> returnedAccounts = accountdao.getAllAccount();
            System.out.println(returnedAccounts);
            menu.loginMenu();
        } else {
            System.out.println("Wrong password or accountnumber, returning to LoginMenu.");
            menu.loginMenu();
        }
        logger.info("GetAllAccounts end");
    }
}
