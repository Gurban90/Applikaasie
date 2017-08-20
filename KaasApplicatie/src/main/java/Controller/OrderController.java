/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.CheeseDAO;
import Dao.ClientDAO;
import Dao.OrderDAO;
import Helper.HelpClientOrderCheese;
import POJO.CheesePOJO;
import POJO.ClientPOJO;
import POJO.OrderDetailPOJO;
import POJO.OrderPOJO;
import java.time.LocalDateTime;

/**
 *
 * @author Jasper Thielen
 */
public class OrderController {


    public OrderController() {
    }
    

    public void setOrder() {
        OrderPOJO orderPOJO = new OrderPOJO();
        OrderDAO orderDAO = new OrderDAO();
        HelpClientOrderCheese help = new HelpClientOrderCheese();
        
        orderPOJO.setOrderDate(help.getOrderDate());
        orderPOJO.setProcessedDate(help.getProcessedDate());
        orderPOJO.setTotalPrice(help.getZeroTotal());
        orderPOJO.setClient(help.getClientPOJO());
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
