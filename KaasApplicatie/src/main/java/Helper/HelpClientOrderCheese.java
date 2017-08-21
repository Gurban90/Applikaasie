/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Helper;

import Controller.OrderController;
import Dao.ClientDAO;
import POJO.ClientPOJO;
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
   
        ClientPOJO clientPOJO;
        ClientPOJO returnedPOJO;
        ClientDAO clientDAO;
        OrderController orderController;
                

    
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
      
      orderController.setOrder(clientPOJO, totalPrice, processedDate, orderDate);
      
  }
}
