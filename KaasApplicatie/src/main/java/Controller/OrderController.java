/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.OrderDAO;
import POJO.ClientPOJO;
import POJO.OrderPOJO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Jasper Thielen
 */
public class OrderController {


    public OrderController() {
    }
    

    public void setOrder(ClientPOJO client, BigDecimal totalPrice, LocalDateTime processedDate, LocalDateTime orderDate) {
        OrderPOJO orderPOJO = new OrderPOJO();
        OrderDAO orderDAO = new OrderDAO();
        
        
        orderPOJO.setOrderDate(orderDate);
        orderPOJO.setProcessedDate(processedDate);
        orderPOJO.setTotalPrice(totalPrice);
        orderPOJO.setClient(client);
        orderDAO.addOrder(orderPOJO);
        
    }
    

    public String removeOrder(int orderID) {
        OrderPOJO orderPOJO = new OrderPOJO();
        OrderDAO orderDAO = new OrderDAO();

        orderPOJO.setOrderID(orderID);
        orderDAO.deleteOrder(orderPOJO);
        
        return "order removed: ";
    
    
    }




    


    
    
}
