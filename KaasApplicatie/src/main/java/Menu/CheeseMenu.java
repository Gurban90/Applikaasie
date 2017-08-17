package Menu;

import Controller.CheeseController;
import POJO.CheesePOJO;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

public class CheeseMenu {

    static final Logger LOGGER = Logger.getLogger(CheeseMenu.class.getName());

    private Scanner input;
    private int choice;
    private CheeseController controller;
    private CheeseMenu menu;
    private int id;
    private String name;
    private BigDecimal price;
    private int stock;

    public void cheeseMenu() {

        LOGGER.info("CheeseMenu start");

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
                this.name = input.next();
                input.nextLine();
                System.out.print("Insert Price: ");
                this.price = input.nextBigDecimal();
                input.nextLine();
                System.out.print("Insert Stock: ");
                this.stock = input.nextInt();

                controller = new CheeseController();
                int cheeseID = controller.newCheese(name, price, stock);
                System.out.println("Cheese is added and has ID: " + cheeseID);
                menu = new CheeseMenu();
                menu.cheeseMenu();
                break;
            case 2:
                System.out.print("CheeseID please: ");
                this.id = input.nextInt();

                controller = new CheeseController();
                controller.removeCheese(id);
                menu = new CheeseMenu();
                menu.cheeseMenu();
                break;
            case 3:
                editCheeseMenu();
                break;
            case 4:
                System.out.print("CheeseID please: ");
                this.id = input.nextInt();

                controller = new CheeseController();
                CheesePOJO returnedcheese = controller.findCheese(id);
                System.out.println(returnedcheese);
                menu = new CheeseMenu();
                menu.cheeseMenu();
                break;
            case 5:
                System.out.print("CheeseName please: ");
                this.name = input.next();

                controller = new CheeseController();
                CheesePOJO returnedcheese2 = controller.findCheeseWithName(name);
                System.out.println(returnedcheese2);
                menu = new CheeseMenu();
                menu.cheeseMenu();
                break;
            case 6:
                controller = new CheeseController();
                controller.findAllCheese();
                System.out.println(controller.findAllCheese());
                menu = new CheeseMenu();
                menu.cheeseMenu();
                break;
            case 7:
                LOGGER.info("Open MainMenu");
                MainMenu mainmenu = new MainMenu();
                mainmenu.mainMenu();
                break;
            default:
                System.out.println("wrong number, try again");
                menu = new CheeseMenu();
                menu.cheeseMenu();

        }
        LOGGER.info("CheeseMenu end");
    }

    public void editCheeseMenu() {
        LOGGER.info("editCheeseMenu start");
        System.out.print(" What do you want to edit? " + "\n"
                + "1. Name" + "\n"
                + "2. Price" + "\n"
                + "3. Stock" + "\n"
                + "4. All" + "\n"
                + "5. Return to last menu" + "\n"
                + "Please enter your choice: ");

        int editchoice = input.nextInt();

        switch (editchoice) {
            case 1:
                System.out.print("Insert CheeseID: ");
                this.id = input.nextInt();
                System.out.print("Insert new CheeseName: ");
                this.name = input.next();

                controller = new CheeseController();
                System.out.println(controller.editCheeseName(id, name));
                menu = new CheeseMenu();
                menu.cheeseMenu();
                break;
            case 2:
                System.out.print("Insert CheeseID: ");
                this.id = input.nextInt();
                System.out.print("Insert new CheesePrice: ");
                this.price = input.nextBigDecimal();

                controller = new CheeseController();
                System.out.println(controller.editCheesePrice(id, price));
                menu = new CheeseMenu();
                menu.cheeseMenu();
                break;
            case 3:
                System.out.print("Insert CheeseID: ");
                this.id = input.nextInt();
                System.out.print("Insert new CheeseStock: ");
                this.stock = input.nextInt();

                controller = new CheeseController();
                System.out.println(controller.editCheeseStock(id, stock));
                menu = new CheeseMenu();
                menu.cheeseMenu();
                break;
            case 4:
                System.out.print("Insert CheeseID: ");
                this.id = input.nextInt();
                input.nextLine();
                System.out.print("Insert CheeseName: ");
                this.name = input.nextLine();
                System.out.print("Insert Price: ");
                this.price = input.nextBigDecimal();
                input.nextLine();
                System.out.print("Insert Stock: ");
                this.stock = input.nextInt();

                controller = new CheeseController();
                System.out.println(controller.editCheese(id, name, price, stock));
                menu = new CheeseMenu();
                menu.cheeseMenu();
                break;
            case 5:
                menu = new CheeseMenu();
                menu.cheeseMenu();
                break;
            default:
                System.out.println("wrong number, try again");
                editCheeseMenu();
        }
        LOGGER.info("editCheeseMenu start");
    }

}
