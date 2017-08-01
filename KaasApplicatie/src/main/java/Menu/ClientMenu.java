package Menu;

import java.util.*;
import java.util.logging.Logger;

public class ClientMenu {

    Logger logger = Logger.getLogger(ClientMenu.class.getName());

    private Scanner input;
    private int choice;

    public void clientMenu() {

        logger.info("clientMenu start");

        input = new Scanner(System.in);

        System.out.print(" Client menu: " + "\n"
                + "1. New Client" + "\n"
                + "2. Remove Client" + "\n"
                + "3. Edit Client" + "\n"
                + "4. Search Client" + "\n"
                + "5. Return to last menu" + "\n"
                + "Please enter your choice: ");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                logger.info("Open MainMenu");
                MainMenu mainmenu = new MainMenu();
                mainmenu.mainMenu();
                break;
            default:
                System.out.println("wrong number, try again");
                ClientMenu clientmenu = new ClientMenu();
                clientmenu.clientMenu();

        }
        logger.info("clientMenu end");
    }

}
