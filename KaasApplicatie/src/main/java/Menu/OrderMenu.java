package Menu;


import Controller.OrderController;
import Helper.HelpClientOrderCheese;
import Helper.OrderDetailCheeseCompiler;
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

             
                while(makeOrderDetail){
                System.out.println("adding a orderdetail");
                OrderDetailCheeseCompiler compiler = new OrderDetailCheeseCompiler();
                
                System.out.println("Select cheeseID for OrderDetail: ");
                cheeseID = input.nextInt(); 
                
                 System.out.println("give amount of cheese");
                ammountCheese = input.nextInt();
                     
               compiler.setData(cheeseID, ammountCheese);
                
                System.out.println("Do you want to add a new order detail? ");        
                anwser = input.nextLine();
                
                if(anwser.equalsIgnoreCase("no")|| anwser.equalsIgnoreCase("n")){    
                    makeOrderDetail = false;
                    }

                }
                
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
        
   
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//eerst order voordat men order detail kan aanmaken


/*
    private void newOrder() {
        logger.info("newOrder start");
     
       
        
        //setTotalPrice(BigDecimal totalPrice) //total price is nice but can only be set last, start at 0
        //setOrderDate(LocalDateTime orderDate)                         --
        //setClient(ClientPOJO client)                                  --
        //setProcessedDate(LocalDateTime processedDate) // set last.    -
        //setOrderDetail(OrderDetailPOJO orderDetail)``                 -
            //Different kind of cheese added to the order. Diferent menu?
            //setOrderID(int orderID) (automatic!!)
            //setCheeseID                   --
            //setCheese(CheesePOJO cheese)  --
            //setQuantity(int quantity)     --
            //setOrder(OrderPOJO order)     -

            boolean orderdetail = true;
            BigDecimal totalSum = new BigDecimal("0");
            
        
            System.out.print("Creating a new order");
            OrderPOJO orderPOJO = new OrderPOJO();
            OrderDAO orderDAO = new OrderDAO();
            
            System.out.println("Creating a order date...");
            LocalDateTime today = LocalDateTime.now();
            System.out.println("current date today is: " + today);        
            orderPOJO.setOrderDate(today);
            System.out.println("Setting proccesed date to order creation...");
            orderPOJO.setProcessedDate(today);
            
            System.out.println("set total price to zero...");
            BigDecimal zero = new BigDecimal("0");
            orderPOJO.setTotalPrice(zero);
            
            System.out.println("select clientID that concerns the order: ");
            ClientDAO clientDAO = new ClientDAO();
            ClientPOJO clientPOJO = new ClientPOJO();
            
            int inputClientID = input.nextInt();
            clientPOJO.setClientID(inputClientID);
            
            List<ClientPOJO> listClientPOJO = clientDAO.getClient(clientPOJO);
            System.out.print(listClientPOJO);
            

      
                    //set delivery date
            System.out.print("Finaly set the delivery date: ");
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
            this.sec = 00;       
            LocalDateTime entered = LocalDateTime.of(year, month, day, hour, min, sec);
            orderPOJO.setProcessedDate(entered);
            
            
           
            System.out.println("adding Order");
            orderDAO.addOrder(orderPOJO);
        
                             
            while(orderdetail){
                
                BigDecimal sum;
            
                System.out.println("Adding order detail and cheesePOJO...");
                OrderDetailPOJO orderDetailPOJO = new OrderDetailPOJO();

                                    
                System.out.println("Select cheeseID for OrderDetail: ");
                int cheeseID = input.nextInt();
                orderDetailPOJO.setCheeseID(cheeseID); //why if cheesepojo?

                cheesePOJO.setCheeseID(cheeseID);
                orderDetailPOJO.setCheese(cheesePOJO);
                
               CheesePOJO returnprice = pricecheese.getCheese(cheesePOJO);
               sum = returnprice.getPrice();
               returnprice.getStock();
                
                System.out.println("give amount of cheese");
                int ammountCheese = input.nextInt();
                orderDetailPOJO.setQuantity(ammountCheese);
                BigDecimal ammountBD = new BigDecimal(ammountCheese);

                System.out.print("set orderdetailpojo orderpojo...");
                orderDetailPOJO.setOrder(orderPOJO);
                
                System.out.println("adding orderdetailDAO");
                OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
                orderDetailDAO.addOrderDetail(orderDetailPOJO);
            
                            
                System.out.println("recalculating sum");
                sum = sum.add(sum);
                totalSum = sum.multiply(ammountBD);
                
                
                System.out.println("Do you want to add a new order detail? ");        
                String anwser = input.nextLine();
                    

                if (anwser.equalsIgnoreCase("yes") || anwser.equalsIgnoreCase("y")){
                    orderdetail = true;
                }
                else{
                    orderdetail = false;
                }
            }
            
            //does this work, it shoudnt??
            orderPOJO.setTotalPrice(totalSum);
       
        logger.info("newOrder end");
        orderMenu(); 
    }

    
    
    
    
    
    
    private void removeOrder() {
        logger.info("removeorder start");
        OrderPOJO orderPOJO = new OrderPOJO();
        OrderDAO orderDAO = new OrderDAO();

                    System.out.print("Enter The orderID you want to remove: ");
                int orderID = input.nextInt();    
        
        System.out.println("Are You Sure you want to remove OrderID: " + orderID + "  enter Yes "  );
        String anwser = input.next();
        
        if(anwser.equals("Y")||anwser.equals("Yes")||anwser.equals("y")||anwser.equals("yes")){
        orderPOJO.setOrderID(orderID);
        orderDAO.deleteOrder(orderPOJO);
        
        }
        else{
            System.out.println("order not removed");
            removeOrder();
        }


        logger.info("removeorder end");
        orderMenu();
    }
    

    private void editOrder() {
        
    }

    private void searchOrder() {
     logger.info("findOrder start");
        OrderPOJO orderPOJO = new OrderPOJO();
        OrderDAO orderDAO = new OrderDAO();

        //show all orders to look for id!
        List<OrderPOJO> orderList = orderDAO.getAllOrder();
        
        for (OrderPOJO rippedlist : orderList){
            System.out.print(rippedlist.getOrderID()+  " "
            + rippedlist.getClient() + " "
            + rippedlist.getProcessedDate() + " "
            + rippedlist.getOrderDate() + " "  
            + rippedlist.getOrderDetail() + " "        
            + rippedlist.getTotalPrice()+ " /n ");
        }       
        
        System.out.print("Enter OrderID : ");
        orderPOJO.setOrderID(input.nextInt());
        OrderPOJO order = orderDAO.getOrder(orderPOJO);
                  
        System.out.print(order);
        
        logger.info("findOrder start");
        orderMenu(); 
        }

    
  */  

