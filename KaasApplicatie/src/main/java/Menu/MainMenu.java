/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Helper.Validator;
import java.util.*;
import java.util.logging.Logger;

public class MainMenu {

    Logger logger = Logger.getLogger(MainMenu.class.getName());

    private Scanner input;
    private int choice;
    Validator validator = new Validator();

    public void mainMenu() {
        logger.info("mainMenu start");

        input = new Scanner(System.in);

        System.out.print(" Main menu: " + "\n"
                + "1. Orders" + "\n"
                + "2. Cheeses" + "\n"
                + "3. Clients" + "\n"
                + "4. Exit" + "\n"
                + "Please enter your choice: ");

        String choiceNumber = input.next();
        if (validator.menuValidator(choiceNumber)) {

            choice = Integer.parseInt(choiceNumber);

        switch (choice) {
            case 1:
                logger.info("Open OrderMenu");
                OrderMenu ordermenu = new OrderMenu();
                ordermenu.orderMenu();
                break;
            case 2:
                logger.info("Open CheeseMenu");
                CheeseMenu cheesemenu = new CheeseMenu();
                cheesemenu.cheeseMenu();
                break;
            case 3:
                logger.info("Open ClientMenu");
                ClientMenu clientmenu = new ClientMenu();
                clientmenu.clientMenu();
                break;
            case 4:
                System.out.println("goodbye...");
                System.exit(0);
            default:
                System.out.println("wrong number, try again");
                MainMenu mainmenu = new MainMenu();
                mainmenu.mainMenu();
        }
        } else {
            System.out.println("Choice must be an integer. ");
            MainMenu mainmenu = new MainMenu();
            mainmenu.mainMenu();
        }

        logger.info("mainMenu end");
    }

}
