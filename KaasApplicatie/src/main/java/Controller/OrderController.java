/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class OrderController {


    Integer orderID;
    Integer orderDetailID;
    
    public OrderController() {
    }
    

    public Integer setOrder(LocalDateTime orderDate, BigDecimal totalPrice, LocalDateTime processedDate, int ClientID) {
        OrderPOJO orderPOJO = new OrderPOJO();
        OrderDAO orderDAO = new OrderDAO();
        
        
        orderPOJO.setOrderDate(orderDate);
        orderPOJO.setProcessedDate(processedDate);
        orderPOJO.setTotalPrice(totalPrice);
        orderPOJO.setClientID(ClientID);
        orderID = orderDAO.addOrder(orderPOJO);
        
        
        return orderID;
    }
    
    public Integer setOrderDetail(int quantity, int orderID, int cheeseID){
        OrderDetailPOJO orderDetailPOJO = new OrderDetailPOJO();
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        
        orderDetailPOJO.setQuantity(quantity);
        orderDetailPOJO.setOrderID(orderID);
        orderDetailPOJO.setCheeseID(cheeseID);
                
        orderDetailID = orderDetailDAO.addOrderDetail(orderDetailPOJO);
        return orderDetailID;
    }
    

    public String removeOrder(int orderID) {
        OrderPOJO orderPOJO = new OrderPOJO();
        OrderDAO orderDAO = new OrderDAO();

        orderPOJO.setOrderID(orderID);
        orderDAO.deleteOrder(orderPOJO);
        
        return "order removed: ";
    
    
    }
    
}
