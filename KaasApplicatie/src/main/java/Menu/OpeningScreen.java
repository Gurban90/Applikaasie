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
                case 1:  //Naar InlogMenu
                    break;
                case 2: //Create Account? Wijzig Account etc.
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
