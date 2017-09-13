/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Controller.CheeseController;
import Controller.OrderController;
import Dao.CheeseDAO;
import Dao.ClientDAO;
import Dao.OrderDAO;
import Dao.OrderDetailDAO;
import DatabaseConnector.DomXML;
import Interface.CheeseDAOInterface;
import Interface.ClientDAOInterface;
import POJO.CheesePOJO;
import POJO.ClientPOJO;
import POJO.OrderDetailPOJO;
import POJO.OrderPOJO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Jasper Thielen
 */
public class HelpClientOrderCheese {

    private int clientID;
    private int orderID;
    private int returnedOrderID;
    private int orderDetailID;
    private int cheeseID;

    private int clientYear;
    private int clientMonth;
    private int clientDay;
    private int clientHour;
    private int clientMin;
    private final int sec = 0;
    private LocalDateTime processedDate;

    private int deliveryYear;
    private int deliveryMonth;
    private int deliveryDay;
    private int deliveryHour;
    private int deliveryMin;
    private LocalDateTime orderDate;

    private BigDecimal zeroTotalPrice = null;
    private BigDecimal totalPrice = new BigDecimal(0);
    private int ammountCheese;
    private BigDecimal cheesePrice;

    private OrderPOJO returnedOrderPOJO;
    private CheesePOJO returnedCheesePOJO;

    private OrderController orderController;
    private DomXML data;

    public HelpClientOrderCheese() {
        data = new DomXML();
    }

     //start first part of order
    
    public void setClientID(int clientID) {
        this.clientID = clientID;     
    }

    public LocalDateTime setNewOrderByClient(int year, int month, int day, int hour, int min) {
        clientYear = year;
        clientMonth = month;
        clientDay = day;
        clientHour = hour;
        clientMin = min;

        orderDate = LocalDateTime.of(clientYear, clientMonth, clientDay, clientHour, clientMin, sec);
        return orderDate;
    }

    public LocalDateTime setOrderDelivery(int year, int month, int day, int hour, int min) {
        deliveryYear = year;
        deliveryMonth = month;
        deliveryDay = day;
        deliveryHour = hour;
        deliveryMin = min;

        processedDate = LocalDateTime.of(deliveryYear, deliveryMonth, deliveryDay, deliveryHour, deliveryMin, sec);
        return processedDate;
    }

        public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
        public void getOrder() {

        orderController = new OrderController(DaoFactory.createOrderDao(data.getDatabaseType()), DaoFactory.createOrderDetailDao(data.getDatabaseType()));
        this.orderID = orderController.setOrder(orderDate, zeroTotalPrice, processedDate, clientID);
    }

    //end first part of order
    
    
    public void setOrderDetail(int cheeseID, int ammountCheese) {
        this.ammountCheese = ammountCheese;
        this.cheeseID = cheeseID;
    }
 
    public void getSingleCheesePrice() {
        CheeseController cheeseController = new CheeseController(DaoFactory.createCheeseDao(data.getDatabaseType()));
        
        returnedCheesePOJO = new CheesePOJO();
        returnedCheesePOJO = cheeseController.findCheese(cheeseID);
        this.cheesePrice = returnedCheesePOJO.getPrice();
    }

    public void getOrderDetail() {

        orderController = new OrderController(DaoFactory.createOrderDao(data.getDatabaseType()), DaoFactory.createOrderDetailDao(data.getDatabaseType()));
        
        //System.out.println("ShowThis!" + ammountCheese + " " +  orderID + " " + cheeseID);
        
        this.orderDetailID = orderController.setOrderDetail(ammountCheese, orderID, cheeseID);
    }

    public BigDecimal addUpCheese() {

        BigDecimal ammountCheeseBD = new BigDecimal(ammountCheese);

        totalPrice = totalPrice.add(cheesePrice.multiply(ammountCheeseBD));

        return totalPrice;

    }

    public String saveTotalPrice() {   

        OrderPOJO orderPOJO = new OrderPOJO();
        OrderDAO orderDAO = new OrderDAO();
        orderPOJO.setOrderID(orderID);
        returnedOrderPOJO = orderDAO.getOrder(orderPOJO);
        if (returnedOrderPOJO.getTotalPrice() == null) {
            returnedOrderPOJO.setTotalPrice(new BigDecimal(0));
        } else {
            returnedOrderPOJO.setTotalPrice(returnedOrderPOJO.getTotalPrice());
        }
        BigDecimal price = returnedOrderPOJO.getTotalPrice();
        price = price.add(totalPrice);
        returnedOrderPOJO.setTotalPrice(price);
        orderDAO.updateOrder(returnedOrderPOJO);

        return "total price updated";

    }

}
