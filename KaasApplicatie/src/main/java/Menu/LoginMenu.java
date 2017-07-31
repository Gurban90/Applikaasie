/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.util.Scanner;

/**
 *
 * @author Jasper Thielen
 */
public class LoginMenu {

    private final boolean loopmenu = true;
    private Scanner input;
    private int choice;
    private int accountNumber;
    private String password;

    public void LoginMenu() {

        input = new Scanner(System.in);

        while (loopmenu) {

            System.out.println("Welcome to Applikaasie...."
                    + "/n" + "1. press 1 to log with a existing account "
                    + "/n" + "2. press 2 if client "
                    + "/n" + "3. press 3 to exit");

            choice = input.nextInt();

            switch (choice) {
                case 1:  // Gegevens invullen en controleren, naar Main.
                    
                    
                    //accounts class material?
                    System.out.print("please enter your account number: ");
                    this.accountNumber = input.nextInt();
                    
                    System.out.print("please enter your password");
                    this.password = input.nextLine();
                    
                    break;
                case 2: //Nu niet nodig?
                    break;
                case 3:
                    System.out.println("goodbye...");
                    System.exit(0);
                default:
                    System.out.println("wrong number");

            }
        }
    }
}
// Limit access on base of created classes? At login create the classes someone has access to??
