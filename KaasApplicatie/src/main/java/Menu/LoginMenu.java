/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Controller.AccountController;
import DatabaseConnector.DomXML;
import Helper.DaoFactory;
import Helper.Validator;
import POJO.AccountPOJO;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author Gerben
 */
public class LoginMenu { //TESTEN

    Logger logger = Logger.getLogger(LoginMenu.class.getName());
    private Scanner input;
    private int choice;
    private int id;
    private String name;
    private String password;
    private int status;
    private String accountIdString;
    private String accounStatusString;
    private DomXML data;
    private AccountController controller;
    private Validator validator;

    public void loginMenu() {

        data = new DomXML();
        controller = new AccountController(DaoFactory.createAccountDao(data.getDatabaseType()));
        validator = new Validator();
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

        String choiceNumber = input.nextLine();
        if (validator.menuValidator(choiceNumber)) {

            choice = Integer.parseInt(choiceNumber);

            switch (choice) {
                case 1:
                    System.out.print("Please enter your account number: ");
                    this.accountIdString = input.nextLine();
                    if (validator.idValidator(this.accountIdString)) {
                        this.id = Integer.parseInt(this.accountIdString);
                        System.out.print("Please enter your password: ");
                        this.password = input.nextLine();
                        if (validator.stringValidator(this.password)) {
                            if (controller.login(id, password)) {
                                MainMenu mainmenu = new MainMenu();
                                mainmenu.mainMenu();
                            } else {
                                System.out.println("Wrong password or accountnumber, try again.");
                                loginMenu();
                            }
                        } else {
                            System.out.println("Password must have a value. ");
                            loginMenu();
                        }
                    } else {
                        System.out.println("AccountID must be an integer and between 1 and 1000. ");
                        loginMenu();
                    }
                    break;
                case 2:
                    System.out.print("Insert Accountname: ");
                    this.name = input.nextLine();
                    if (validator.stringValidator(this.name)) {
                        System.out.print("Insert Password: ");
                        this.password = input.nextLine();
                        if (validator.stringValidator(this.password)) {
                            System.out.print("Insert Accountstatus: ");
                            this.accounStatusString = input.nextLine();
                            if (validator.statusValidator(this.accounStatusString)) {
                                this.status = Integer.parseInt(this.accounStatusString);

                                int accountid = controller.newAccount(name, password, status);
                                System.out.println("Account is added and has ID: " + accountid);
                                loginMenu();
                            } else {
                                System.out.println("Status must be an integer and between 0 and 5. ");
                                loginMenu();
                            }
                        } else {
                            System.out.println("Password must have a value. ");
                            loginMenu();
                        }
                    } else {
                        System.out.println("Accountname must have a value. ");
                        loginMenu();
                    }
                    break;
                case 3:
                    System.out.print("AccountID please: ");
                    this.accountIdString = input.nextLine();
                    if (validator.idValidator(this.accountIdString)) {
                        this.id = Integer.parseInt(this.accountIdString);
                        System.out.print("Please enter your password: ");
                        this.password = input.nextLine();
                        if (validator.stringValidator(this.password)) {

                            if (controller.updateAccountCheck(id, password)) {
                                updateAccountMenu();
                            } else {
                                System.out.println("Wrong password or accountnumber, returning to LoginMenu.");
                                loginMenu();
                            }
                        } else {
                            System.out.println("Password must have a value. ");
                            loginMenu();
                        }
                    } else {
                        System.out.println("AccountID must be an integer and between 1 and 1000. ");
                        loginMenu();
                    }
                    break;
                case 4:
                    System.out.println("THIS WILL DELETE YOUR ACCOUNT! To cancel do not fill in your password. ");
                    System.out.print("AccountID please: ");
                    this.accountIdString = input.nextLine();
                    if (validator.idValidator(this.accountIdString)) {
                        this.id = Integer.parseInt(this.accountIdString);
                        System.out.print("Please enter your password: ");
                        this.password = input.nextLine();
                        if (validator.stringValidator(this.password)) {
                            if (controller.removeAccount(id, password)) {
                                System.out.print("Account has been deleted.");
                                input.nextLine();
                                loginMenu();
                            } else {
                                System.out.println("Wrong password or accountnumber, try again.");
                                loginMenu();
                            }
                        } else {
                            System.out.println("Password must have a value. ");
                            loginMenu();
                        }
                    } else {
                        System.out.println("AccountID must be an integer and between 1 and 1000. ");
                        loginMenu();
                    }
                    break;
                case 5:
                    System.out.print("AccountID please: ");
                    this.accountIdString = input.nextLine();
                    if (validator.idValidator(this.accountIdString)) {
                        this.id = Integer.parseInt(this.accountIdString);
                        System.out.print("Please enter your password: ");
                        this.password = input.nextLine();
                        if (validator.stringValidator(this.password)) {
                            System.out.print("AccountID of the account you want to find please: ");
                            this.accountIdString = input.nextLine();
                            if (validator.idValidator(this.accountIdString)) {
                                int findId = Integer.parseInt(this.accountIdString);
                                if (controller.findAccount(id, password, findId) == null) {
                                    System.out.println("Wrong password or accountnumber, returning to LoginMenu.");
                                    loginMenu();
                                } else {
                                    AccountPOJO returnedAccount = controller.findAccount(id, password, findId);
                                    System.out.println(returnedAccount);
                                    loginMenu();
                                }
                            } else {
                                System.out.println("AccountID must be an integer and between 1 and 1000. ");
                                loginMenu();
                            }
                        } else {
                            System.out.println("Password must have a value. ");
                            loginMenu();
                        }
                    } else {
                        System.out.println("AccountID must be an integer and between 1 and 1000. ");
                        loginMenu();
                    }
                    break;
                case 6:
                    System.out.print("AccountID please: ");
                    this.accountIdString = input.nextLine();
                    if (validator.idValidator(this.accountIdString)) {
                        this.id = Integer.parseInt(this.accountIdString);
                        System.out.print("Please enter your password: ");
                        this.password = input.nextLine();
                        if (validator.stringValidator(this.password)) {
                            System.out.print("AccountName of the account you want to find please: ");
                            this.name = input.nextLine();
                            if (validator.stringValidator(this.name)) {
                                if (controller.findAccountWithName(id, password, name) == null) {
                                    System.out.println("Wrong password or accountnumber, returning to LoginMenu.");
                                    loginMenu();
                                } else {
                                    List<AccountPOJO> returnedAccounts = controller.findAccountWithName(id, password, name);
                                    System.out.println(returnedAccounts);
                                    loginMenu();
                                }
                            } else {
                                System.out.println("AccountName must have a value. ");
                                loginMenu();
                            }
                        } else {
                            System.out.println("Password must have a value. ");
                            loginMenu();
                        }
                    } else {
                        System.out.println("AccountID must be an integer and between 1 and 1000. ");
                        loginMenu();
                    }
                    break;
                case 7:
                    System.out.print("AccountID please: ");
                    this.accountIdString = input.nextLine();
                    if (validator.idValidator(this.accountIdString)) {
                        this.id = Integer.parseInt(this.accountIdString);
                        System.out.print("Please enter your password: ");
                        this.password = input.nextLine();
                        if (validator.stringValidator(this.password)) {
                            if (controller.getAllAccounts(id, password) == null) {
                                System.out.println("Wrong password or accountnumber, returning to LoginMenu.");
                                loginMenu();
                            } else {
                                List<AccountPOJO> returnedAccounts = controller.getAllAccounts(id, password);
                                System.out.println(returnedAccounts);
                                loginMenu();
                            }
                        } else {
                            System.out.println("Password must have a value. ");
                            loginMenu();
                        }
                    } else {
                        System.out.println("AccountID must be an integer and between 1 and 1000. ");
                        loginMenu();
                    }
                    break;
                case 8:
                    System.out.println("goodbye...");
                    System.exit(0);
                default:
                    System.out.println("wrong number, try again");
                    loginMenu();
            }
        } else {
            System.out.println("Choice must be an integer. ");
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

        String choiceNumber2 = input.nextLine();
        if (validator.menuValidator(choiceNumber2)) {

            int choice2 = Integer.parseInt(choiceNumber2);

            switch (choice2) {
                case 1:
                    System.out.print("Insert AccountID: ");
                    this.accountIdString = input.nextLine();
                    if (validator.idValidator(this.accountIdString)) {
                        this.id = Integer.parseInt(this.accountIdString);
                        System.out.print("Insert new AccountName: ");
                        this.name = input.nextLine();
                        if (validator.stringValidator(this.name)) {
                            System.out.println(controller.editAccountName(id, name));
                            loginMenu();
                        } else {
                            System.out.println("Name must have a value. ");
                            updateAccountMenu();
                        }
                    } else {
                        System.out.println("AccountID must be an integer and between 1 and 1000. ");
                        updateAccountMenu();
                    }
                    break;
                case 2:
                    System.out.print("Insert AccountID: ");
                    this.accountIdString = input.nextLine();
                    if (validator.idValidator(this.accountIdString)) {
                        this.id = Integer.parseInt(this.accountIdString);
                        System.out.print("Insert new password: ");
                        String password2 = input.nextLine();
                        if (validator.stringValidator(password2)) {
                            System.out.println(controller.editAccountPassword(id, password2));
                            loginMenu();
                        } else {
                            System.out.println("Password must have a value. ");
                            updateAccountMenu();
                        }
                    } else {
                        System.out.println("AccountID must be an integer and between 1 and 1000. ");
                        updateAccountMenu();
                    }
                    break;
                case 3:
                    System.out.print("Insert AccountID: ");
                    this.accountIdString = input.nextLine();
                    if (validator.idValidator(this.accountIdString)) {
                        this.id = Integer.parseInt(this.accountIdString);
                        System.out.print("Insert new AccountStatus: ");
                        this.accounStatusString = input.nextLine();
                        if (validator.statusValidator(this.accounStatusString)) {
                            this.status = Integer.parseInt(this.accounStatusString);
                            System.out.println(controller.editAccountStatus(id, status));
                            loginMenu();
                        } else {
                            System.out.println("Status must be an integer and between 0 and 5.  ");
                            updateAccountMenu();
                        }
                    } else {
                        System.out.println("AccountID must be an integer and between 1 and 1000. ");
                        updateAccountMenu();
                    }
                    break;
                case 4:
                    System.out.print("Insert AccountID: ");
                    this.accountIdString = input.nextLine();
                    if (validator.idValidator(this.accountIdString)) {
                        this.id = Integer.parseInt(this.accountIdString);
                        System.out.print("Insert new Accountname: ");
                        this.name = input.nextLine();
                        if (validator.stringValidator(this.name)) {
                            System.out.print("Insert new Password: ");
                            this.password = input.nextLine();
                            if (validator.stringValidator(this.password)) {
                                System.out.print("Insert new Accountstatus: ");
                                this.accounStatusString = input.nextLine();
                                if (validator.statusValidator(this.accounStatusString)) {
                                    this.status = Integer.parseInt(this.accounStatusString);
                                    System.out.println(controller.updateAccount(id, name, password, status));
                                    loginMenu();
                                } else {
                                    System.out.println("Status must be an integer and between 0 and 5. ");
                                    updateAccountMenu();
                                }
                            } else {
                                System.out.println("Password must have a value. ");
                                updateAccountMenu();
                            }
                        } else {
                            System.out.println("Accountname must have a value. ");
                            updateAccountMenu();
                        }
                    } else {
                        System.out.println("AccountID must be an integer and between 1 and 1000. ");
                        updateAccountMenu();
                    }
                    break;
                case 5:
                    loginMenu();
                    break;
                default:
                    System.out.println("wrong number, try again");
                    updateAccountMenu();
            }
        } else {
            System.out.println("Choice must be an integer. ");
            updateAccountMenu();
        }
    }

}
