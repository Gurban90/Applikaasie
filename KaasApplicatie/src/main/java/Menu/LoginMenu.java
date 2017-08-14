/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Controller.AccountController;
import POJO.AccountPOJO;
import java.util.List;
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
    private LoginMenu menu;

    public void loginMenu() {

        input = new Scanner(System.in);

        System.out.println("Welcome to Applikaasie.... " + "\n"
                + "1. press 1 to log in with an existing account " + "\n"
                + "2. press 2 to create account " + "\n"
                + "3. press 3 to update your account " + "\n"
                + "4. press 4 to remove an account " + "\n"
                + "5. press 5 to search for an account with ID" + "\n"
                + "6. press 6 to search for an account with Name" + "\n"
                + "7. press 7 to get all accounts" + "\n"
                + "8. press 8 to exit");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Please enter your account number: ");
                int id = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                String password = input.nextLine();

                controller = new AccountController();
                if (controller.login(id, password)) {
                    MainMenu mainmenu = new MainMenu();
                    mainmenu.mainMenu();
                } else {
                    System.out.println("Wrong password or accountnumber, try again.");
                    loginMenu();
                }
                break;
            case 2:
                System.out.print("Insert Accountname: ");
                String name = input.next();
                input.nextLine();
                System.out.print("Insert Password: ");
                String password2 = input.nextLine();
                System.out.print("Insert Accountstatus: ");
                int status = input.nextInt();

                controller = new AccountController();
                int accountid = controller.newAccount(name, password2, status);
                System.out.println("Account is added and has ID: " + accountid);
                input.nextLine();
                menu = new LoginMenu();
                menu.loginMenu();
                break;
            case 3:
                System.out.print("AccountID please: ");
                int id4 = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                String password4 = input.nextLine();

                controller = new AccountController();
                if (controller.updateAccountCheck(id4, password4)) {
                    updateAccountMenu();
                } else {
                    System.out.println("Wrong password or accountnumber, returning to LoginMenu.");
                    menu = new LoginMenu();
                    menu.loginMenu();
                }
                break;
            case 4:
                System.out.print("THIS WILL DELETE YOUR ACCOUNT! To cancel do not fill in your password. ");
                System.out.print("AccountID please: ");
                int id3 = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                String password3 = input.nextLine();

                controller = new AccountController();
                if (controller.removeAccount(id3, password3)) {
                    System.out.print("Account has been deleted.");
                    input.nextLine();
                    menu = new LoginMenu();
                    menu.loginMenu();
                } else {
                    System.out.println("Wrong password or accountnumber, try again.");
                    input.nextLine();
                    menu = new LoginMenu();
                    menu.loginMenu();
                }
                break;
            case 5:
                System.out.print("AccountID please: ");
                int id5 = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                String password5 = input.nextLine();

                controller = new AccountController();
                if (controller.findAccount(id5, password5) == null) {
                    System.out.println("Wrong password or accountnumber, returning to LoginMenu.");
                    menu = new LoginMenu();
                    menu.loginMenu();
                } else {
                    AccountPOJO returnedAccount = controller.findAccount(id5, password5);
                    System.out.println(returnedAccount);
                    menu = new LoginMenu();
                    menu.loginMenu();
                }
                break;
            case 6:
                System.out.print("AccountID please: ");
                int id6 = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                String password6 = input.nextLine();
                System.out.print("AccountName please: ");
                String name6 = input.next();

                controller = new AccountController();
                if (controller.findAccountWithName(id6, password6, name6) == null) {
                    System.out.println("Wrong password or accountnumber, returning to LoginMenu.");
                    menu = new LoginMenu();
                    menu.loginMenu();
                } else {
                    List<AccountPOJO> returnedAccounts = controller.findAccountWithName(id6, password6, name6);
                    System.out.println(returnedAccounts);
                    menu = new LoginMenu();
                    menu.loginMenu();
                }
                break;
            case 7:
                System.out.print("AccountID please: ");
                int id7 = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                String password7 = input.nextLine();

                controller = new AccountController();
                if (controller.getAllAccounts(id7, password7) == null) {
                    System.out.println("Wrong password or accountnumber, returning to LoginMenu.");
                    menu = new LoginMenu();
                    menu.loginMenu();
                } else {
                    List<AccountPOJO> returnedAccounts = controller.getAllAccounts(id7, password7);
                    System.out.println(returnedAccounts);
                    menu = new LoginMenu();
                    menu.loginMenu();
                }
                break;
            case 8:
                System.out.println("goodbye...");
                System.exit(0);
            default:
                System.out.println("wrong number, try again");
                menu = new LoginMenu();
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
                controller = new AccountController();
                System.out.println(controller.editAccountName(id, name2));
                input.nextLine();
                menu = new LoginMenu();
                menu.loginMenu();
                break;
            case 2:
                System.out.print("Insert AccountID: ");
                int id2 = input.nextInt();
                System.out.print("Insert new Password: ");
                String password2 = input.next();
                controller = new AccountController();
                System.out.println(controller.editAccountPassword(id2, password2));
                input.nextLine();
                menu = new LoginMenu();
                menu.loginMenu();
                break;
            case 3:
                System.out.print("Insert AccountID: ");
                int id3 = input.nextInt();
                System.out.print("Insert new AccountStatus: ");
                int status2 = input.nextInt();
                controller = new AccountController();
                System.out.println(controller.editAccountStatus(id3, status2));
                input.nextLine();
                menu = new LoginMenu();
                menu.loginMenu();
                break;
            case 4:
                System.out.print("Insert new Accountname: ");
                String name = input.nextLine();
                input.nextLine();
                System.out.print("Insert new Password: ");
                String password = input.nextLine();
                input.nextLine();
                System.out.print("Insert new Accountstatus: ");
                int status = input.nextInt();
                controller = new AccountController();
                System.out.println(controller.updateAccount(name, password, status));
                input.nextLine();
                menu = new LoginMenu();
                menu.loginMenu();
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
