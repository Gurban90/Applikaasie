/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applikaasie;

import java.util.Scanner;

/**
 *
 * @author Jasper Thielen
 */
public class OpeningScreen {

    private final boolean loopmenu = true;
    private Scanner input;
    private int choice;

    public void OpeningScreen() {

        input = new Scanner(System.in);

        while (loopmenu) {

            System.out.println("Welcome to Applikaasie...."
                    + "/n" + "1. press 1 if personel member."
                    + "/n" + "2. press 2 if client "
                    + "/n" + "3. press 3 to exit");

            choice = input.nextInt();

            switch (choice) {
                case 1:  // Ask for id?
                    break;
                case 2: //open as client?? (what is the acceslevel of a client?
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
