package Menu;

import Controller.OrderController;
import DatabaseConnector.DomXML;
import Helper.DaoFactory;
import Helper.HelpClientOrderCheese;
import Helper.IDCheck;
import Helper.Validator;
import POJO.ClientPOJO;
import POJO.OrderPOJO;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Logger;

public class OrderMenu {

    Logger logger = Logger.getLogger(OrderMenu.class.getName());

    private Scanner input;
    private boolean makeOrderDetail;
    private int choice;
    private String choiceNumber;
    private String anwser;
    private String outputString;
    private String clientID;
    private int clientIDint;
    private String orderID;
    private int orderIDint;
    private String orderDetailID;
    private int orderDetailIDint;
    private String cheeseAmmount;
    private int cheeseAmmountint;
    private String cheeseID;
    private int cheeseIDint;
    private String year;
    private String month;
    private String day;
    private String hour;
    private String min;
    private int yearint;
    private int monthint;
    private int dayint;
    private int hourint;
    private int minint;
    private HelpClientOrderCheese collection;
    private OrderController orderController;
    private LocalDateTime returnedLocalDateTime;
    private DomXML data;
    private OrderController controller;
    private Validator validator;

    public void orderMenu() {

        data = new DomXML();
        controller = new OrderController(DaoFactory.createOrderDao(data.getDatabaseType()), DaoFactory.createOrderDetailDao(data.getDatabaseType()));
        validator = new Validator();
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

        choiceNumber = input.nextLine();
        if (validator.menuValidator(choiceNumber)) {

            choice = Integer.parseInt(choiceNumber);

            switch (choice) {
                case 1:

                    logger.info("newOrder start");

                    System.out.print("Fill in a new order: ");
                    collection = new HelpClientOrderCheese();
                    System.out.println("Please select the ClientID  from the client that made the order:  ");
                    clientID = input.nextLine();
                    if (validator.idValidator(this.clientID)) {
                        this.clientIDint = Integer.parseInt(this.clientID);
                            IDCheck idCheck = new IDCheck();
                            Boolean boo = idCheck.checkClientID(clientIDint);
                             if(boo){
                                System.out.println("no client with this id found");
                                orderMenu();
                                }
                    } else {
                        System.out.println("clientID must have a value. ");
                        orderMenu();
                    }

                    System.out.print("set the time of day when the order was made by the client: ");
                    System.out.print("enter Year: ");
                    this.year = input.nextLine();
                    if (validator.yearValidator(this.year)) {
                        this.yearint = Integer.parseInt(this.year);
                    } else {
                        System.out.println("year must have a correct value. ");
                        orderMenu();
                    }

                    System.out.println("enter month: ");
                    this.month = input.nextLine();
                    if (validator.monthValidator(this.month)) {
                        this.monthint = Integer.parseInt(this.month);
                    } else {
                        System.out.println("month must have a value. ");
                        orderMenu();
                    }

                    System.out.println("enter day: ");
                    this.day = input.nextLine();
                    if (validator.dayValidator(this.day)) {
                        this.dayint = Integer.parseInt(this.day);
                    } else {
                        System.out.println("day must have a correct value. ");
                        orderMenu();
                    }

                    System.out.println("input next hour");
                    this.hour = input.nextLine();
                    if (validator.hourValidator(this.hour)) {
                        this.hourint = Integer.parseInt(this.hour);
                    } else {
                        System.out.println("hour must have a correct value. ");
                        orderMenu();
                    }

                    System.out.println("input next min");
                    this.min = input.nextLine();
                    if (validator.minValidator(this.min)) {
                        this.minint = Integer.parseInt(this.min);
                    } else {
                        System.out.println("min must have a correct value. ");
                        orderMenu();
                    }

                    collection.setNewOrderByClient(yearint, monthint, dayint, hourint, minint);

                    System.out.print("set the time of day when the order will be delivered to the client: ");
                    System.out.print("enter Year: ");
                    this.year = input.nextLine();
                    if (validator.yearValidator(this.year)) {
                        this.yearint = Integer.parseInt(this.year);
                    } else {
                        System.out.println("year must have a correct value. ");
                        orderMenu();
                    }

                    System.out.println("enter month: ");
                    this.month = input.nextLine();
                    if (validator.monthValidator(this.month)) {
                        this.monthint = Integer.parseInt(this.month);
                    } else {
                        System.out.println("month must have a value. ");
                        orderMenu();
                    }

                    System.out.println("enter day: ");
                    this.day = input.nextLine();
                    if (validator.dayValidator(this.day)) {
                        this.dayint = Integer.parseInt(this.day);
                    } else {
                        System.out.println("day must have a correct value. ");
                        orderMenu();
                    }

                    System.out.println("input next hour");
                    this.hour = input.nextLine();
                    if (validator.hourValidator(this.hour)) {
                        this.hourint = Integer.parseInt(this.hour);
                    } else {
                        System.out.println("hour must have a correct value. ");
                        orderMenu();
                    }

                    System.out.println("input next min");
                    this.min = input.nextLine();
                    if (validator.minValidator(this.min)) {
                        this.minint = Integer.parseInt(this.min);
                    } else {
                        System.out.println("min must have a correct value. ");
                        orderMenu();
                    }
                    collection.setOrderDelivery(yearint, monthint, dayint, hourint, minint);

                    collection.getOrder();
                    
                    makeOrderDetail = true;
                    while (makeOrderDetail) {

                        System.out.println("Select cheeseID for OrderDetail: ");
                        cheeseID = input.nextLine();
                        if (validator.idValidator(this.cheeseID)) {
                            this.cheeseIDint = Integer.parseInt(this.cheeseID);
                            IDCheck idCheck = new IDCheck();
                            Boolean boo = idCheck.checkCheeseID(cheeseIDint);
                             if(boo){
                                System.out.println("no cheese with this id found");
                                orderMenu();
                                }
                        } else {
                            System.out.println("cheeseID must have a value. ");
                            orderMenu();
                        }
                       

                        System.out.println("give amount of cheese");
                        cheeseAmmount = input.nextLine();
                        if (validator.stockValidator(this.cheeseAmmount)) {
                            this.cheeseAmmountint = Integer.parseInt(this.cheeseAmmount);
                        } else {
                            System.out.println("cheeseAmmount must have a value. ");
                            orderMenu();
                        }

                        collection.setOrderDetail(cheeseIDint, cheeseAmmountint);
                        collection.getSingleCheesePrice();
                        collection.getOrderDetail();
                        collection.addUpCheese();

                        
                        System.out.println("Do you want to add a new order detail? ");
                        anwser = input.nextLine();

                        if (validator.stringValidator(anwser)) {
                            if (validator.yesnoValidator(anwser)) {
                                makeOrderDetail = false;
                                collection.saveTotalPrice();
                            }

                        } else {
                            System.out.println("please enter Yes or No");
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
                    orderID = input.nextLine();
                    if (validator.idValidator(this.orderID)) {
                        this.orderIDint = Integer.parseInt(this.orderID);
                    } else {
                        System.out.println("orderID must have a value. ");
                        orderMenu();
                    }

                    makeOrderDetail = true;

                    while (makeOrderDetail) {
                        System.out.println("adding an orderdetail");

                        System.out.println("Select cheeseID for OrderDetail: ");
                        cheeseID = input.nextLine();
                        if (validator.idValidator(this.cheeseID)) {
                            this.cheeseIDint = Integer.parseInt(this.cheeseID);
                        } else {
                            System.out.println("cheeseID must have a value. ");
                            orderMenu();
                        }

                        System.out.println("give amount of cheese");
                        cheeseAmmount = input.nextLine();
                        if (validator.stockValidator(this.cheeseAmmount)) {
                            this.cheeseAmmountint = Integer.parseInt(this.cheeseAmmount);
                        } else {
                            System.out.println("cheeseAmmount must have a value. ");
                            orderMenu();
                        }

                        collection.setOrderDetail2(cheeseIDint, cheeseAmmountint, orderIDint);
                        collection.getSingleCheesePrice();
                        collection.getOrderDetail();
                        collection.addUpCheese();

                        input.nextLine(); //extra enter

                        System.out.println("Do you want to add a new order detail? ");
                        anwser = input.nextLine();

                        if (validator.stringValidator(anwser)) {
                            if (validator.yesnoValidator(anwser)) {
                                makeOrderDetail = false;
                                collection.saveTotalPrice();
                            }

                        } else {
                            System.out.println("please enter Yes or No");
                        }
                    }
                    orderMenu();
                    logger.info("new OrderDetail end");
                    break;

                case 3:
                    logger.info("removeorder start");
                    orderController = new OrderController();
                    System.out.print("Enter The orderID you want to remove: ");
                    orderID = input.nextLine();
                    if (validator.idValidator(this.orderID)) {
                        this.orderIDint = Integer.parseInt(this.orderID);
                    } else {
                        System.out.println("orderID must have a value. ");
                        orderMenu();
                    }
                    outputString = orderController.removeOrder(orderIDint);

                    System.out.println(outputString);

                    orderMenu();
                    logger.info("removeorder end");
                    break;

                case 4:
                    logger.info("removeorderdetail start");
                    orderController = new OrderController();
                    System.out.print("Enter The orderDetailID you want to remove: ");
                    orderDetailID = input.nextLine();
                    if (validator.idValidator(this.orderDetailID)) {
                        this.orderDetailIDint = Integer.parseInt(this.orderDetailID);
                    } else {
                        System.out.println("orderDetailID must have a value. ");
                        editOrderDetailMenu();
                    }

                    outputString = orderController.removeOrderDetail(orderDetailIDint);
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
                    orderID = input.nextLine();
                    if (validator.idValidator(this.orderID)) {
                        this.orderIDint = Integer.parseInt(this.orderID);
                    } else {
                        System.out.println("orderID must have a value. ");
                        orderMenu();
                    }
                    OrderPOJO returnedOrder = orderController.searchOrder(orderIDint);

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
                    orderDetailID = input.nextLine();
                    if (validator.idValidator(this.orderDetailID)) {
                        this.orderDetailIDint = Integer.parseInt(this.orderDetailID);
                    } else {
                        System.out.println("orderDetailID must have a value. ");
                        editOrderMenu();
                    }
                    System.out.println(orderController.searchOrderDetail(orderDetailIDint));

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
        } else {
            System.out.println("Choice must be an integer. ");
            orderMenu();
        }
    }

    public void editOrderMenu() {
        logger.info("editOrdereMenu start");
        System.out.print(" What do you want to edit? " + "\n"
                + "1. Edit Original order time" + "\n"
                + "2. edit Delivery Date" + "\n"
                + "3. return to order menu " + "\n"
                + "Please enter your choice: ");

        choiceNumber = input.nextLine();
        if (validator.menuValidator(choiceNumber)) {

            choice = Integer.parseInt(choiceNumber);

            switch (choice) {
                case 1:
                    System.out.print("Edit order: ");
                    collection = new HelpClientOrderCheese();
                    orderController = new OrderController();
                    System.out.println("Please select the OrderID from the order you want to change:  ");
                    orderID = input.nextLine();
                    if (validator.idValidator(this.orderID)) {
                        this.orderIDint = Integer.parseInt(this.orderID);
                    } else {
                        System.out.println("orderID must have a value. ");
                        editOrderDetailMenu();
                    }
                    collection.setOrderID(orderIDint);

                    System.out.print("set the time of day when the order was made by the client: ");
                    System.out.print("enter Year: ");
                    this.year = input.nextLine();
                    if (validator.yearValidator(this.year)) {
                        this.yearint = Integer.parseInt(this.year);
                    } else {
                        System.out.println("year must have a correct value. ");
                        editOrderMenu();
                    }

                    System.out.println("enter month: ");
                    this.month = input.nextLine();
                    if (validator.monthValidator(this.month)) {
                        this.monthint = Integer.parseInt(this.month);
                    } else {
                        System.out.println("month must have a value. ");
                        editOrderMenu();
                    }

                    System.out.println("enter day: ");
                    this.day = input.nextLine();
                    if (validator.dayValidator(this.day)) {
                        this.dayint = Integer.parseInt(this.day);
                    } else {
                        System.out.println("day must have a correct value. ");
                        editOrderMenu();
                    }

                    System.out.println("input next hour");
                    this.hour = input.nextLine();
                    if (validator.hourValidator(this.hour)) {
                        this.hourint = Integer.parseInt(this.hour);
                    } else {
                        System.out.println("hour must have a correct value. ");
                        editOrderMenu();
                    }

                    System.out.println("input next min");
                    this.min = input.nextLine();
                    if (validator.minValidator(this.min)) {
                        this.minint = Integer.parseInt(this.min);
                    } else {
                        System.out.println("min must have a correct value. ");
                        editOrderMenu();
                    }

                    this.returnedLocalDateTime = collection.setNewOrderByClient(yearint, monthint, dayint, hourint, minint);
                    orderController.editOrderTime(orderIDint, returnedLocalDateTime);

                    editOrderMenu();
                    break;

                case 2:
                    orderController = new OrderController();
                    System.out.print("Edit order: ");
                    collection = new HelpClientOrderCheese();
                    System.out.println("Please select the OrderID from the order you want to change:  ");
                    orderID = input.nextLine();
                    if (validator.idValidator(this.orderID)) {
                        this.orderIDint = Integer.parseInt(this.orderID);
                    } else {
                        System.out.println("orderID must have a value. ");
                        editOrderDetailMenu();
                    }
                    collection.setOrderID(orderIDint);

                    System.out.print("set the time of day when the order will be delivered to the client: ");
                    System.out.print("enter Year: ");
                    System.out.print("enter Year: ");
                    this.year = input.nextLine();
                    if (validator.yearValidator(this.year)) {
                        this.yearint = Integer.parseInt(this.year);
                    } else {
                        System.out.println("year must have a correct value. ");
                        editOrderMenu();
                    }

                    System.out.println("enter month: ");
                    this.month = input.nextLine();
                    if (validator.monthValidator(this.month)) {
                        this.monthint = Integer.parseInt(this.month);
                    } else {
                        System.out.println("month must have a value. ");
                        editOrderMenu();
                    }

                    System.out.println("enter day: ");
                    this.day = input.nextLine();
                    if (validator.dayValidator(this.day)) {
                        this.dayint = Integer.parseInt(this.day);
                    } else {
                        System.out.println("day must have a correct value. ");
                        editOrderMenu();
                    }

                    System.out.println("input next hour");
                    this.hour = input.nextLine();
                    if (validator.hourValidator(this.hour)) {
                        this.hourint = Integer.parseInt(this.hour);
                    } else {
                        System.out.println("hour must have a correct value. ");
                        editOrderMenu();
                    }

                    System.out.println("input next min");
                    this.min = input.nextLine();
                    if (validator.minValidator(this.min)) {
                        this.minint = Integer.parseInt(this.min);
                    } else {
                        System.out.println("min must have a correct value. ");
                        editOrderMenu();
                    }

                    this.returnedLocalDateTime = collection.setOrderDelivery(yearint, monthint, dayint, hourint, minint);

                    orderController.editOrderDeliverTime(orderIDint, returnedLocalDateTime);

                    editOrderMenu();
                    break;
                case 3:
                    orderMenu();
                    break;
                default:
                    System.out.println("wrong number, try again");
                    editOrderMenu();
            }
        } else {
            System.out.println("Choice must be an integer. ");
            orderMenu();
        }
    }

    private void editOrderDetailMenu() {

        logger.info("editOrdereMenu start");
        System.out.print(" What do you want to edit? " + "\n"
                + "1. Edit orderDetailCheese" + "\n"
                + "2. edit order DetailQuantity of cheese" + "\n"
                + "3. return to order menu " + "\n"
                + "Please enter your choice: ");

        choiceNumber = input.nextLine();
        if (validator.menuValidator(choiceNumber)) {

            choice = Integer.parseInt(choiceNumber);

            switch (choice) {
                case 1:
                    System.out.print("Edit orderDetail Cheese: ");
                    OrderController controller = new OrderController();
                    System.out.println("Please select the OrderDetailID from the order you want to change:  ");
                    orderDetailID = input.nextLine();
                    if (validator.idValidator(this.orderDetailID)) {
                        this.orderDetailIDint = Integer.parseInt(this.orderDetailID);
                    } else {
                        System.out.println("orderDetailID must have a value. ");
                        editOrderDetailMenu();
                    }
                    System.out.println("enter the new id of the cheese");
                    cheeseID = input.nextLine();
                    if (validator.idValidator(this.cheeseID)) {
                        this.cheeseIDint = Integer.parseInt(this.cheeseID);
                    } else {
                        System.out.println("cheeseID must have a value. ");
                        editOrderDetailMenu();
                    }
                    outputString = controller.editOrderDetailCheese(orderDetailIDint, cheeseIDint);
                    System.out.print(outputString);

                    editOrderDetailMenu();
                    break;

                case 2:
                    System.out.print("Edit orderDetail Cheese Ammount: ");
                    controller = new OrderController();
                    System.out.println("Please select the OrderDetailID from the order you want to change:  ");
                    orderDetailID = input.nextLine();
                    if (validator.idValidator(this.orderDetailID)) {
                        this.orderDetailIDint = Integer.parseInt(this.orderDetailID);
                    } else {
                        System.out.println("orderDetail must have a value. ");
                        editOrderDetailMenu();
                    }
                    System.out.println("enter the new ammount of cheese");
                    cheeseAmmount = input.nextLine();
                    if (validator.stockValidator(this.cheeseAmmount)) {
                        this.cheeseAmmountint = Integer.parseInt(this.cheeseAmmount);
                    } else {
                        System.out.println("cheeseAmmoun must have a value. ");
                        editOrderDetailMenu();
                    }
                    outputString = controller.editOrderDetailAmmount(orderDetailIDint, cheeseAmmountint);
                    System.out.print(outputString);

                    editOrderDetailMenu();
                    break;
                case 3:
                    orderMenu();
                    break;
                default:
                    System.out.println("wrong number, try again");
                    editOrderDetailMenu();
            }
        } else {
            System.out.println("Choice must be an integer. ");
            editOrderDetailMenu();
        }
    }

}
