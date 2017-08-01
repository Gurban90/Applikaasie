package Menu;

import Dao.CheeseDAO;
import POJO.CheesePOJO;
import java.util.*;
import java.util.logging.Logger;

public class CheeseMenu {

    Logger logger = Logger.getLogger(CheeseMenu.class.getName());

    private Scanner input;
    private int choice;

    public void cheeseMenu() {

        logger.info("CheeseMenu start");

        input = new Scanner(System.in);

        System.out.print(" Cheese menu: " + "\n"
                + "1. New Cheese" + "\n"
                + "2. Remove Cheese" + "\n"
                + "3. Edit Cheese" + "\n"
                + "4. Search Cheese" + "\n"
                + "5. Get All Cheeses" + "\n"
                + "6. Return to last menu" + "\n"
                + "Please enter your choice: ");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                logger.info("New Cheese in this menu");
                newCheese();
                break;
            case 2:
                logger.info("Remove Cheese in this menu");
                removeCheese();
                break;
            case 3:
                logger.info("Edit Cheese in this menu");
                editCheese();
                break;
            case 4:
                logger.info("Find Cheese in this menu");
                findCheese();
                break;
            case 5:
                logger.info("Find all Cheese in this menu");
                findAllCheese();
                break;
            case 6:
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

    public void findAllCheese() {
        logger.info("FindallCheese start");
        CheeseDAO cheesedao = new CheeseDAO();
        List<CheesePOJO> returnedCheeses = cheesedao.getAllCheese();
        System.out.println(returnedCheeses);

        logger.info("FindallCheese end");
        cheeseMenu();
    }

    public void findCheese() {
        logger.info("findCheese start");
        CheeseDAO cheesedao = new CheeseDAO();
        CheesePOJO cheesepojo = new CheesePOJO();

        System.out.print("CheeseID please: ");
        cheesepojo.setCheeseID(input.nextInt());
        CheesePOJO returnedcheese = cheesedao.getCheese(cheesepojo);

        System.out.println(returnedcheese);

        logger.info("findCheese start");
        cheeseMenu();
    }

    public void newCheese() {
        logger.info("newCheese start");
        CheesePOJO cheesepojo = new CheesePOJO();
        CheeseDAO cheesedao = new CheeseDAO();

        System.out.print("Insert CheeseName: ");
        String name = input.next();
        cheesepojo.setCheeseName(name);
        input.nextLine();
        System.out.print("Insert Price: ");
        cheesepojo.setPrice(input.nextBigDecimal());
        input.nextLine();
        System.out.print("Insert Stock: ");
        cheesepojo.setStock(input.nextInt());

        int CheeseID = cheesedao.addCheese(cheesepojo);
        System.out.println("Cheese is added and has ID: " + CheeseID);

        logger.info("newCheese end");
        cheeseMenu();
    }

    public void removeCheese() {
        logger.info("removeCheese start");
        CheesePOJO cheesepojo = new CheesePOJO();
        CheeseDAO cheesedao = new CheeseDAO();

        System.out.print("CheeseID please: ");
        cheesepojo.setCheeseID(input.nextInt());

        cheesedao.deleteCheese(cheesepojo);

        logger.info("removeCheese end");
        cheeseMenu();
    }

    public void editCheese() {
        logger.info("editCheese start");
        CheesePOJO cheesepojo = new CheesePOJO();
        CheeseDAO cheesedao = new CheeseDAO();

        System.out.print("Insert CheeseID: ");
        cheesepojo.setCheeseID(input.nextInt());
        input.nextLine();
        System.out.print("Insert CheeseName: ");
        cheesepojo.setCheeseName(input.nextLine());
        System.out.print("Insert Price: ");
        cheesepojo.setPrice(input.nextBigDecimal());
        input.nextLine();
        System.out.print("Insert Stock: ");
        cheesepojo.setStock(input.nextInt());

        cheesedao.updateCheese(cheesepojo);
        

        System.out.println("Cheese has been edited: ");

        logger.info("editCheese end");
        cheeseMenu();
    }

}
