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

    public boolean login(int id, String password) {
        logger.info("login start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountID(id);
        accountpojo.setAccountPassword(password);
        AccountPOJO foundAccount = accountdao.getAccount(accountpojo);

        if (accountpojo.getAccountPassword().equals(foundAccount.getAccountPassword())) {
            logger.info("login end");
            return true;
        } else {
            logger.info("login end");
            return false;
        }
    }

    public int newAccount(String name, String password, int status) {
        logger.info("newAccount start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountName(name);
        accountpojo.setAccountPassword(password);
        accountpojo.setAccountStatus(status);
        logger.info("newAccount end");
        return accountdao.addAccount(accountpojo);
    }

    public boolean removeAccount(int id, String password) {
        logger.info("removeAccount start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountID(id);
        accountpojo.setAccountPassword(password);
        AccountPOJO foundAccount = accountdao.getAccount(accountpojo);

        if (accountpojo.getAccountPassword().equals(foundAccount.getAccountPassword())) {
            accountdao.deleteAccount(accountpojo);
            logger.info("removeAccount end");
            return true;
        } else {
            logger.info("removeAccount end");
            return false;
        }
    }

    public boolean updateAccountCheck(int id, String password) {
        logger.info("updateAccountCheck start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountID(id);
        accountpojo.setAccountPassword(password);
        AccountPOJO foundAccount = accountdao.getAccount(accountpojo);

        if (accountpojo.getAccountPassword().equals(foundAccount.getAccountPassword())) {
            logger.info("updateAccountCheck end");
            return true;
        } else {
            logger.info("updateAccountCheck end");
            return false;
        }
    }

    public String updateAccount(String name, String password, int status) {
        logger.info("updateAccount start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountName(name);
        accountpojo.setAccountPassword(password);
        accountpojo.setAccountStatus(status);
        accountdao.updateAccount(accountpojo);
        logger.info("updateAccount end");
        return "Account has been updated.";
    }

    public String editAccountName(int id, String name) {
        logger.info("editAccountName start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountID(id);
        AccountPOJO accountpojo2 = accountdao.getAccount(accountpojo);
        accountpojo2.setAccountName(name);
        accountdao.updateAccount(accountpojo2);
        logger.info("editAccountName end");
        return "Account has been updated.";
    }

    public String editAccountPassword(int id, String password) {
        logger.info("editAccountPassword start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountID(id);
        AccountPOJO accountpojo2 = accountdao.getAccount(accountpojo);
        accountpojo2.setAccountPassword(password);
        accountdao.updateAccount(accountpojo2);
        logger.info("editAccountPassword end");
        return "Account has been updated.";
    }

    public String editAccountStatus(int id, int status) {
        logger.info("editAccountStatus start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountID(id);
        AccountPOJO accountpojo2 = accountdao.getAccount(accountpojo);
        accountpojo2.setAccountStatus(status);
        accountdao.updateAccount(accountpojo2);
        logger.info("editAccountStatus end");
        return "Account has been updated.";
    }

    public AccountPOJO findAccount(int id, String password) {
        logger.info("findAccount start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountID(id);
        accountpojo.setAccountPassword(password);
        AccountPOJO foundAccount = accountdao.getAccount(accountpojo);

        if (accountpojo.getAccountPassword().equals(foundAccount.getAccountPassword())) {
            AccountPOJO returnedAccount = accountdao.getAccount(accountpojo);
            logger.info("findAccount end");
            return returnedAccount;
        } else {
            logger.info("findAccount end");
            return null;
        }
    }

    public List<AccountPOJO> findAccountWithName(int id, String password, String name) {
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
            logger.info("findAccountWithName end");
            return returnedAccounts;
        } else {
            logger.info("findAccountWithName end");
            return null;
        }
    }

    public List<AccountPOJO> getAllAccounts(int id, String password) {
        logger.info("GetAllAccounts start");
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAO accountdao = new AccountDAO();

        accountpojo.setAccountID(id);
        accountpojo.setAccountPassword(password);
        AccountPOJO foundAccount = accountdao.getAccount(accountpojo);

        if (accountpojo.getAccountPassword().equals(foundAccount.getAccountPassword())) {
            List<AccountPOJO> returnedAccounts = accountdao.getAllAccount();
            logger.info("GetAllAccounts end");
            return returnedAccounts;

        } else {
            logger.info("GetAllAccounts end");
            return null;
        }
    }
}
