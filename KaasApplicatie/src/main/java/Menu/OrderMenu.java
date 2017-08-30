package Menu;

import Controller.OrderController;
import Helper.HelpClientOrderCheese;
import Helper.Validator;
import POJO.OrderDetailPOJO;
import POJO.OrderPOJO;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Logger;

public class OrderMenu {

    Logger logger = Logger.getLogger(OrderMenu.class.getName());

    private Scanner input;
    private int choice;
    private String anwser;
    private String outputString;

    private boolean makeOrderDetail;

    private OrderMenu menu;

    int clientID;
    int orderID;
    int orderDetailID;
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

    Validator validator = new Validator();

    public void orderMenu() {

        input = new Scanner(System.in);

        System.out.print(" Order menu: " + "\n"
                + "1. New Order" + "\n"
                + "2. new OrderDetail" + "\n"
                + "3. Remove Order" + "\n"
                + "4. Remove OrderDetail" + "\n"
                + "5. Edit OrderMenu" + "\n"
                + "6. edit OrderDetailMenu" + "\n"
                + "7. Search Order" + "\n"
                + "8. Get All Orders" + "\n"
                + "9. Search orderDetail" + "\n"
                + "10. Return to last menu" + "\n"
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
                System.out.println("input next sec");
                this.sec = input.nextInt();
                collection.setNewOrderByClient(year, month, day, hour, min, sec);

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
                System.out.println("input next sec");
                this.sec = input.nextInt();
                collection.setOrderDelivery(year, month, day, hour, min, sec);

                collection.getOrder();
                makeOrderDetail = true;

                while (makeOrderDetail) {
                    System.out.println("adding an orderdetail");

                    System.out.println("Select cheeseID for OrderDetail: ");
                    cheeseID = input.nextInt();
                    input.nextLine();
                    System.out.println("give amount of cheese");
                    ammountCheese = input.nextInt();

                    collection.setOrderDetail(cheeseID, ammountCheese);
                    collection.getSingleCheesePrice();
                    collection.getOrderDetail();
                    collection.addUpCheese(); //dp i want to use a return?

                    input.nextLine();
                    System.out.println("Do you want to add a new order detail? ");
                    anwser = input.nextLine();

                    if (anwser.equalsIgnoreCase("no") || anwser.equalsIgnoreCase("n")) {
                        makeOrderDetail = false;
                        collection.saveTotalPrice();
                    }

                }

                orderMenu();
                logger.info("newOrder end");

                break;

            case 2:
                logger.info("new OrderDetail start");
                orderController = new OrderController();
                collection = new HelpClientOrderCheese();
                System.out.println("Input orderID for adding new orderdetail to order");
                this.orderID = input.nextInt();
                makeOrderDetail = true;
                while (makeOrderDetail) {
                    System.out.println("adding an orderdetail");

                    System.out.println("Select cheeseID for OrderDetail: ");
                    cheeseID = input.nextInt();

                    System.out.println("give amount of cheese");
                    ammountCheese = input.nextInt();

                    collection.setOrderDetail2(cheeseID, ammountCheese, orderID);
                    collection.getSingleCheesePrice();
                    collection.getOrderDetail();
                    collection.addUpCheese(); //dp i want to use a return?

                    input.nextLine();
                    System.out.println("Do you want to add a new order detail? ");
                    anwser = input.nextLine();

                    if (anwser.equalsIgnoreCase("no") || anwser.equalsIgnoreCase("n")) {
                        makeOrderDetail = false;
                        collection.saveTotalPrice();
                    }
                }
                orderMenu();
                logger.info("new OrderDetail end");
                break;

            case 3:
                logger.info("removeorder start");
                orderController = new OrderController();
                System.out.print("Enter The orderID you want to remove: ");
                orderID = input.nextInt();

                outputString = orderController.removeOrder(orderID);
                System.out.println(outputString);

                orderMenu();
                logger.info("removeorder end");
                break;

            case 4:
                logger.info("removeorderdetail start");
                orderController = new OrderController();
                System.out.print("Enter The orderDetailID you want to remove: ");
                orderDetailID = input.nextInt();

                outputString = orderController.removeOrderDetail(orderDetailID);
                System.out.print(outputString);

                orderMenu();
                logger.info("removeorderdetail end");
                break;
            case 5:

                //go to editordermenu
                editOrderMenu();

                break;
            case 6:

                //goto edit orderdetailmenu
                editOrderDetailMenu();

                break;
            case 7:
                logger.info("searchorder start");
                orderController = new OrderController();

                System.out.print("enter the order id of the order you want to search: ");
                orderID = input.nextInt();
                OrderPOJO returnedOrder = orderController.searchOrder(orderID);

                System.out.print(returnedOrder);

                orderMenu();
                logger.info("searchorder end");
                break;
            case 8:
                logger.info("searchallorder start");
                orderController = new OrderController();
                orderController.getAllOrders();
                System.out.println(orderController.getAllOrders());
                orderMenu();
                logger.info("searchallorder end");
                break;
            case 9:
                logger.info("searchorderdetail start");
                orderController = new OrderController();

                System.out.print("enter the order id of the orderDetail you want to search: ");
                orderDetailID = input.nextInt();
                System.out.println(orderController.searchOrderDetail(orderDetailID));

                orderMenu();
                logger.info("searchorderdetail end");
                break;
            case 10:
                logger.info("Open mainMenu");
                MainMenu mainmenu = new MainMenu();
                mainmenu.mainMenu();
                break;
            default:
                System.out.println("wrong number, try again");
                orderMenu();

        }
        logger.info("OrderMenu end");
    }

    public void editOrderMenu() {
        logger.info("editOrdereMenu start");
        System.out.print(" What do you want to edit? " + "\n"
                + "1. Edit Original order time" + "\n"
                + "2. edit Delivery Date" + "\n"
                + "3. return to order menu " + "\n"
                + "Please enter your choice: ");

        int choice2 = input.nextInt();

        switch (choice2) {
            case 1:
                System.out.print("Edit order: ");
                collection = new HelpClientOrderCheese();
                orderController = new OrderController();
                System.out.println("Please select the OrderID from the order you want to change:  ");
                orderID = input.nextInt();
                collection.setOrderID(orderID);

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
                System.out.println("input next sec");
                this.sec = input.nextInt();
                LocalDateTime x = collection.setNewOrderByClient(year, month, day, hour, min, sec);
                
                orderController.editOrderTime(orderID, x);

                editOrderMenu();
                break;
            case 2:
                orderController = new OrderController();
                System.out.print("Edit order: ");
                collection = new HelpClientOrderCheese();
                System.out.println("Please select the OrderID from the order you want to change:  ");
                orderID = input.nextInt();
                collection.setOrderID(orderID);

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
                System.out.println("input next sec");
                this.sec = input.nextInt();
                LocalDateTime y =collection.setOrderDelivery(year, month, day, hour, min, sec);
                
                orderController.editOrderDeliverTime(orderID, y);
                
                editOrderMenu();
                break;
            case 3:
                orderMenu();
                break;
            default:
                System.out.println("wrong number, try again");
                editOrderMenu();
        }

    }

    private void editOrderDetailMenu() {

        logger.info("editOrdereMenu start");
        System.out.print(" What do you want to edit? " + "\n"
                + "1. Edit orderDetailCheese" + "\n"
                + "2. edit order DetailQuantity of cheese" + "\n"
                + "3. return to order menu " + "\n"
                + "Please enter your choice: ");

        int choice2 = input.nextInt();

        switch (choice2) {
            case 1:
                System.out.print("Edit orderDetail Cheese: ");
                OrderController controller = new OrderController();
                System.out.println("Please select the OrderDetailID from the order you want to change:  ");
                orderDetailID = input.nextInt();
                System.out.println("enter the new id of the cheese");
                cheeseID = input.nextInt();
                outputString = controller.editOrderDetailCheese(orderDetailID, cheeseID);
                System.out.print(outputString);

                editOrderMenu();
                break;
            case 2:

                System.out.print("Edit orderDetail Cheese Ammount: ");
                controller = new OrderController();
                System.out.println("Please select the OrderDetailID from the order you want to change:  ");
                orderDetailID = input.nextInt();
                System.out.println("enter the new ammount of cheese");
                int cheeseAmmount = input.nextInt();
                outputString = controller.editOrderDetailAmmount(orderDetailID, cheeseAmmount);
                System.out.print(outputString);

                editOrderMenu();
                break;
            case 3:
                orderMenu();
                break;
            default:
                System.out.println("wrong number, try again");
                editOrderMenu();
        }

    }
}
