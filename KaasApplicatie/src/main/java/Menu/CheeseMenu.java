package Menu;

import Controller.CheeseController;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

public class CheeseMenu {

    Logger logger = Logger.getLogger(CheeseMenu.class.getName());

    private Scanner input;
    private int choice;
    CheeseController controller = new CheeseController();

    public void cheeseMenu() {

        logger.info("CheeseMenu start");

        input = new Scanner(System.in);

        System.out.print(" Cheese menu: " + "\n"
                + "1. New Cheese" + "\n"
                + "2. Remove Cheese" + "\n"
                + "3. Edit Cheese" + "\n"
                + "4. Search Cheese with ID" + "\n"
                + "5. Search Cheese with CheeseName" + "\n"
                + "6. Get All Cheese" + "\n"
                + "7. Return to last menu" + "\n"
                + "Please enter your choice: ");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Insert CheeseName: ");
                String name = input.next();
                input.nextLine();
                System.out.print("Insert Price: ");
                BigDecimal price = input.nextBigDecimal();
                input.nextLine();
                System.out.print("Insert Stock: ");
                int stock = input.nextInt();
                controller.newCheese(name, price, stock);
                break;
            case 2:
                System.out.print("CheeseID please: ");
                int ID1 = input.nextInt();
                controller.removeCheese(ID1);
                break;
            case 3:
                editCheeseMenu();
                break;
            case 4:
                System.out.print("CheeseID please: ");
                int ID = input.nextInt();
                controller.findCheese(ID);
                break;
            case 5:
                System.out.print("CheeseName please: ");
                String searchName = input.next();
                controller.findCheeseWithName(searchName);
                break;
            case 6:
                controller.findAllCheese();
                break;
            case 7:
                logger.info("Open MainMenu");
                MainMenu mainmenu = new MainMenu();
                mainmenu.mainMenu();
                break;
            default:
                System.out.println("wrong number, try again");
                CheeseMenu cheesemenu = new CheeseMenu();
                cheesemenu.cheeseMenu();

        }
        logger.info("CheeseMenu end");
    }

    public void editCheeseMenu() {
        logger.info("editCheeseMenu start");
        System.out.print(" What do you want to edit? " + "\n"
                + "1. Name" + "\n"
                + "2. Price" + "\n"
                + "3. Stock" + "\n"
                + "4. All" + "\n"
                + "5. Return to last menu" + "\n"
                + "Please enter your choice: ");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Insert CheeseID: ");
                int id1 = input.nextInt();
                System.out.print("Insert new CheeseName: ");
                String name1 = input.next();
                controller.editCheeseName(id1, name1);
                break;
            case 2:
                System.out.print("Insert CheeseID: ");
                int id2 = input.nextInt();
                System.out.print("Insert new CheesePrice: ");
                BigDecimal price2 = input.nextBigDecimal();
                controller.editCheesePrice(id2, price2);
                break;
            case 3:
                System.out.print("Insert CheeseID: ");
                int id3 = input.nextInt();
                System.out.print("Insert new CheeseStock: ");
                int stock2 = input.nextInt();
                controller.editCheeseStock(id3, stock2);
                break;
            case 4:
                System.out.print("Insert CheeseID: ");
                int id = input.nextInt();
                input.nextLine();
                System.out.print("Insert CheeseName: ");
                String name = input.nextLine();
                System.out.print("Insert Price: ");
                BigDecimal price = input.nextBigDecimal();
                input.nextLine();
                System.out.print("Insert Stock: ");
                int stock = input.nextInt();
                controller.editCheese(id, name, price, stock);
                break;
            case 5:
                cheeseMenu();
                break;
            default:
                System.out.println("wrong number, try again");
                editCheeseMenu();
        }
        logger.info("editCheeseMenu start");
    }

}
