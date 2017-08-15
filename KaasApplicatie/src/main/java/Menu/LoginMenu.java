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
 * @author Gerben
 */
public class LoginMenu {

    Logger logger = Logger.getLogger(LoginMenu.class.getName());
    private Scanner input;
    private int choice;
    private AccountController controller;
    private LoginMenu menu;
    private int id;
    private String name;
    private String password;
    private int status;

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
                this.id = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                this.password = input.nextLine();

                controller = new AccountController();
                if (controller.login(id, password)) {
                    MainMenu mainmenu = new MainMenu();
                    mainmenu.mainMenu();
                } else {
                    System.out.println("Wrong password or accountnumber, try again.");
                    menu = new LoginMenu();
                    menu.loginMenu();
                }
                break;
            case 2:
                System.out.print("Insert Accountname: ");
                this.name = input.next();
                input.nextLine();
                System.out.print("Insert Password: ");
                this.password = input.nextLine();
                System.out.print("Insert Accountstatus: ");
                this.status = input.nextInt();

                controller = new AccountController();
                int accountid = controller.newAccount(name, password, status);
                System.out.println("Account is added and has ID: " + accountid);
                input.nextLine();
                menu = new LoginMenu();
                menu.loginMenu();
                break;
            case 3:
                System.out.print("AccountID please: ");
                this.id = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                this.password = input.nextLine();

                controller = new AccountController();
                if (controller.updateAccountCheck(id, password)) {
                    updateAccountMenu();
                } else {
                    System.out.println("Wrong password or accountnumber, returning to LoginMenu.");
                    menu = new LoginMenu();
                    menu.loginMenu();
                }
                break;
            case 4:
                System.out.println("THIS WILL DELETE YOUR ACCOUNT! To cancel do not fill in your password. ");
                System.out.print("AccountID please: ");
                this.id = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                this.password = input.nextLine();

                controller = new AccountController();
                if (controller.removeAccount(id, password)) {
                    System.out.print("Account has been deleted.");
                    menu = new LoginMenu();
                    menu.loginMenu();
                } else {
                    System.out.println("Wrong password or accountnumber, try again.");
                    menu = new LoginMenu();
                    menu.loginMenu();
                }
                break;
            case 5:
                System.out.print("AccountID please: ");
                this.id = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                this.password = input.nextLine();
                System.out.print("AccountID of the account you want to find please: ");
                int findId = input.nextInt();

                controller = new AccountController();
                if (controller.findAccount(id, password, findId) == null) {
                    System.out.println("Wrong password or accountnumber, returning to LoginMenu.");
                    menu = new LoginMenu();
                    menu.loginMenu();
                } else {
                    AccountPOJO returnedAccount = controller.findAccount(id, password, findId);
                    System.out.println(returnedAccount);
                    menu = new LoginMenu();
                    menu.loginMenu();
                }
                break;
            case 6:
                System.out.print("AccountID please: ");
                this.id = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                this.password = input.nextLine();
                System.out.print("AccountName of the account you want to find please: ");
                this.name = input.next();

                controller = new AccountController();
                if (controller.findAccountWithName(id, password, name) == null) {
                    System.out.println("Wrong password or accountnumber, returning to LoginMenu.");
                    menu = new LoginMenu();
                    menu.loginMenu();
                } else {
                    List<AccountPOJO> returnedAccounts = controller.findAccountWithName(id, password, name);
                    System.out.println(returnedAccounts);
                    menu = new LoginMenu();
                    menu.loginMenu();
                }
                break;
            case 7:
                System.out.print("AccountID please: ");
                this.id = input.nextInt();
                input.nextLine();
                System.out.print("Please enter your password: ");
                this.password = input.nextLine();

                controller = new AccountController();
                if (controller.getAllAccounts(id, password) == null) {
                    System.out.println("Wrong password or accountnumber, returning to LoginMenu.");
                    menu = new LoginMenu();
                    menu.loginMenu();
                } else {
                    List<AccountPOJO> returnedAccounts = controller.getAllAccounts(id, password);
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
                this.id = input.nextInt();
                System.out.print("Insert new AccountName: ");
                this.name = input.next();

                controller = new AccountController();
                System.out.println(controller.editAccountName(id, name));
                input.nextLine();
                menu = new LoginMenu();
                menu.loginMenu();
                break;
            case 2:
                System.out.print("Insert AccountID: ");
                this.id = input.nextInt();
                System.out.print("Insert new Password: ");
                String password2 = input.next();

                controller = new AccountController();
                System.out.println(controller.editAccountPassword(id, password2));
                input.nextLine();
                menu = new LoginMenu();
                menu.loginMenu();
                break;
            case 3:
                System.out.print("Insert AccountID: ");
                this.id = input.nextInt();
                System.out.print("Insert new AccountStatus: ");
                this.status = input.nextInt();

                controller = new AccountController();
                System.out.println(controller.editAccountStatus(id, status));
                input.nextLine();
                menu = new LoginMenu();
                menu.loginMenu();
                break;
            case 4:
                System.out.print("Insert AccountID: ");
                this.id = input.nextInt();
                System.out.print("Insert new Accountname: ");
                this.name = input.nextLine();
                input.nextLine();
                System.out.print("Insert new Password: ");
                this.password = input.nextLine();
                System.out.print("Insert new Accountstatus: ");
                this.status = input.nextInt();

                controller = new AccountController();
                System.out.println(controller.updateAccount(id, name, password, status));
                input.nextLine();
                menu = new LoginMenu();
                menu.loginMenu();
                break;
            case 5:
                menu.loginMenu();
                break;
            default:
                System.out.println("wrong number, try again");
                updateAccountMenu();

        }
    }

}
