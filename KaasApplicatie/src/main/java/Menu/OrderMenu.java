package Menu;

import Controller.OrderController;
import Helper.HelpClientOrderCheese;
import java.util.*;
import java.util.logging.Logger;

public class OrderMenu {

    Logger logger = Logger.getLogger(OrderMenu.class.getName());

    private Scanner input;
    private int choice;
    String anwser;

    private boolean makeOrderDetail = true;
    private OrderMenu menu;

    int clientID;
    int orderID;
    int cheeseID;
    int ammountCheese;

    int year;
    int month;
    int day;
    int hour;
    int min;
    int sec;

    HelpClientOrderCheese collection;
    OrderController orderController;

    public void orderMenu() {

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

                logger.info("newOrder start");

                System.out.print("Fill in a new order: ");
                collection = new HelpClientOrderCheese();
                System.out.println("Please select the ClientID  from the client that made the order:  ");
                clientID = input.nextInt();
                collection.setClientID(clientID);

                System.out.print("set the time of day when the order was made by the client: ");
                System.out.print("enter Year: ");
                this.year = input.nextInt();
                System.out.println("enter month: ");
                this.month = input.nextInt();
                System.out.println("enter day: ");
                this.day = input.nextInt();
                System.out.println("input next hour");
                this.hour = input.nextInt();
                System.out.println("input next min");
                this.min = input.nextInt();
                collection.setNewOrderByClient(year, month, day, hour, min);

                System.out.print("set the time of day when the order will be delivered to the client: ");
                System.out.print("enter Year: ");
                this.year = input.nextInt();
                System.out.println("enter month: ");
                this.month = input.nextInt();
                System.out.println("enter day: ");
                this.day = input.nextInt();
                System.out.println("input next hour");
                this.hour = input.nextInt();
                System.out.println("input next min");
                this.min = input.nextInt();
                collection.setOrderDelivery(year, month, day, hour, min);

                System.out.println("Activating Controller");

                while (makeOrderDetail) {
                    System.out.println("adding a orderdetail");

                    System.out.println("Select cheeseID for OrderDetail: ");
                    cheeseID = input.nextInt();

                    System.out.println("give amount of cheese");
                    ammountCheese = input.nextInt();

                    collection.setOrderDetail(cheeseID, ammountCheese);
                    input.nextLine();
                    System.out.println("Do you want to add a new order detail? ");
                    anwser = input.nextLine();

                    if (anwser.equalsIgnoreCase("no") || anwser.equalsIgnoreCase("n")) {
                        makeOrderDetail = false;
                    }

                }

                menu = new OrderMenu();
                menu.orderMenu();
                logger.info("newOrder end");

                break;

            case 2:
                logger.info("removeorder start");
                System.out.print("Enter The orderID you want to remove: ");
                orderID = input.nextInt();

                orderController.removeOrder(orderID);
                menu = new OrderMenu();
                menu.orderMenu();
                logger.info("removeorder end");
                break;
            case 3:
                logger.info("editorder start");

                logger.info("editorder end");
                break;
            case 4:
                logger.info("searchorder start");

                logger.info("searchorder end");
                break;
            case 5:
                logger.info("Open mainMenu");
                MainMenu mainmenu = new MainMenu();
                mainmenu.mainMenu();
                break;
            default:
                System.out.println("wrong number, try again");
                menu = new OrderMenu();
                menu.orderMenu();

        }
        logger.info("OrderMenu end");
    }
}
