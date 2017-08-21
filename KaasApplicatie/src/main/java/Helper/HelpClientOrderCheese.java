/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Helper;

import Controller.OrderController;
import Dao.ClientDAO;
import Dao.OrderDetailDAO;
import POJO.ClientPOJO;
import POJO.OrderDetailPOJO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Jasper Thielen
 */
public class HelpClientOrderCheese {

        private int clientID;
        
        private int clientYear;
        private int clientMonth;
        private int clientDay;
        private int clientHour;
        private int clientMin;
        private int clientSec;
        private LocalDateTime processedDate;
        
        private int deliveryYear;
        private int deliveryMonth;
        private int deliveryDay;
        private int deliveryHour;
        private int deliveryMin;
        private int deliverySec;
        private LocalDateTime orderDate;
        
        private BigDecimal totalPrice = null;
    
   
        private ClientPOJO clientPOJO;
        private ClientPOJO returnedPOJO;
        private ClientDAO clientDAO;
        private OrderDetailDAO orderDetailDAO;
        private OrderDetailPOJO orderDetailPOJO;
        private OrderController orderController;
                

    
    public HelpClientOrderCheese(){
         clientPOJO = new ClientPOJO();
         returnedPOJO = new ClientPOJO();
         clientDAO = new ClientDAO();
    }
    
    
    
    
    
    
    
    
    public void setClientID(int clientID) {

        
        
        this.clientID = clientID;
        
        clientPOJO.setClientID(clientID);
        returnedPOJO = clientDAO.getClient(clientPOJO);
        
        
  
    }

    public void setNewOrderByClient(int year, int month, int day, int hour, int min) {
        clientYear = year;
        clientMonth = month;
        clientDay = day;
        clientHour = hour;
        clientMin = min;
        
   processedDate = LocalDateTime.of(clientYear, clientMonth, clientDay, clientHour, clientMin, clientSec);
         
   
  

    }
    
    public void setOrderDelivery(int year, int month, int day, int hour, int min) {
        deliveryYear = year;
        deliveryMonth = month;       
        deliveryDay = day;
        deliveryHour = hour; 
        deliveryMin = min;
        
        orderDate = LocalDateTime.of(deliveryYear, deliveryMonth, deliveryDay, deliveryHour, deliveryMin, deliverySec);
      
   
            
    }

  public void getOrder(){
      
      orderController = new OrderController();
      orderDetailPOJO = new OrderDetailPOJO();
      
      orderController.setOrder(clientPOJO, totalPrice, processedDate, orderDate, orderDetailPOJO);
      
  }
}
