/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Controller.OrderController;
import Dao.CheeseDAO;
import Dao.ClientDAO;
import Dao.OrderDAO;
import Dao.OrderDetailDAO;
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

    private OrderPOJO orderPOJO;
    private OrderPOJO returnedOrderPOJO;
    private OrderDAO orderDAO;
    private ClientPOJO returnedClientPOJO;
    private CheesePOJO returnedCheesePOJO;
    private ClientPOJO clientPOJO;
    private ClientDAO clientDAO;
    private OrderController orderController;

    public HelpClientOrderCheese() {

    }

    //first part start
    public void setClientID(int clientID) {

        clientPOJO = new ClientPOJO();
        returnedClientPOJO = new ClientPOJO();
        clientDAO = new ClientDAO();
        orderPOJO = new OrderPOJO();

        this.clientID = clientID;
        orderPOJO.setClientID(clientID);
        clientPOJO.setClientID(clientID);
        orderPOJO.setClient(clientPOJO);
        returnedClientPOJO = clientDAO.getClient(clientPOJO);

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

    //first part close
    public void setOrderDetail(int cheeseID, int ammountCheese) {
        this.ammountCheese = ammountCheese;
        this.cheeseID = cheeseID;
    }

    public void setOrderDetail2(int cheeseID, int ammountCheese, int orderID) {
        this.ammountCheese = ammountCheese;
        this.cheeseID = cheeseID;
        this.orderID = orderID;
    }

    public void getSingleCheesePrice() {
        CheeseDAO cheeseDAO = new CheeseDAO();
        CheesePOJO cheesePOJO = new CheesePOJO();

        cheesePOJO.setCheeseID(cheeseID);
        returnedCheesePOJO = cheeseDAO.getCheese(cheesePOJO);

        this.cheesePrice = returnedCheesePOJO.getPrice();

    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void getOrder() {

        orderController = new OrderController();
        this.orderID = orderController.setOrder(orderDate, zeroTotalPrice, processedDate, clientID);
    }

    public void getOrderDetail() {

        orderController = new OrderController();
        orderDetailID = orderController.setOrderDetail(ammountCheese, orderID, cheeseID);
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
