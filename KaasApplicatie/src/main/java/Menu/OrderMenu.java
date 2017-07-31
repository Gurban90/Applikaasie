package Menu;

import java.util.*;
import java.util.logging.Logger;

public class OrderMenu {

    Logger logger = Logger.getLogger(OrderMenu.class.getName());

    private Scanner input;
    private int choice;

    public void OrderMenu() {

        input = new Scanner(System.in);

        System.out.print(" Order menu: " + "\n"
                + "1. New Order" + "\n"
                + "2. Remove Order" + "\n"
                + "3. Edit Order" + "\n"
                + "4. Search Order" + "\n"
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
                logger.info("Open mainMenu");
                MainMenu mainmenu = new MainMenu();
                mainmenu.mainMenu();
                break;
            default:
                System.out.println("wrong number, try again");
                OrderMenu ordermenu = new OrderMenu();
                ordermenu.OrderMenu();

        }
        logger.info("OrderMenu end");
    }

}
