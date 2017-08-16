/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.CheeseDAO;
import Dao.ClientDAO;
import Dao.OrderDAO;
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
public class OrderController {
    
        BigDecimal sum = new BigDecimal("0");
        BigDecimal totalSum = new BigDecimal("0");
        LocalDateTime today = LocalDateTime.now();
        
        boolean orderdetail = true;

        int orderID;
        int clientID;
    
        int year;
        int month;
        int day;
        int hour;
        int min;
        int sec= (0);
        

    public OrderController() {
    }

    public String removeOrder(int orderID) {
        OrderPOJO orderPOJO = new OrderPOJO();
        OrderDAO orderDAO = new OrderDAO();

        orderPOJO.setOrderID(orderID);
        orderDAO.deleteOrder(orderPOJO);
        
        return "order removed: ";
    
    
    }

    public void newOrder(int clientID, int year, int month, int day, int hour, int min) {
        
        OrderPOJO orderPOJO = new OrderPOJO();
        ClientPOJO clientPOJO = new ClientPOJO();
        OrderDAO orderDAO = new OrderDAO();
        ClientDAO clientDAO = new ClientDAO();
        CheesePOJO cheesePOJO = new CheesePOJO();
        CheeseDAO pricecheese = new CheeseDAO();
        OrderDetailPOJO orderDetailPOJO = new OrderDetailPOJO();
        
            //System.out.println("current date today is: " + today);        
            orderPOJO.setOrderDate(today);
            //System.out.println("Setting proccesed date to order creation...");
            orderPOJO.setProcessedDate(today);
            //System.out.println("set total price to zero...");
            orderPOJO.setTotalPrice(totalSum);
       
        clientPOJO.setClientID(clientID);
        
        LocalDateTime entered = LocalDateTime.of(year, month, day, hour, min, sec);
        orderPOJO.setProcessedDate(entered);
        orderDAO.addOrder(orderPOJO);
        

        
    
    }

    public void newOrderDetail(int cheeseID, int ammountCheese, String anwser ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
