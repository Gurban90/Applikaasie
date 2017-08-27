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
        private int clientSec;
        private LocalDateTime processedDate;
        
        private int deliveryYear;
        private int deliveryMonth;
        private int deliveryDay;
        private int deliveryHour;
        private int deliveryMin;
        private int deliverySec;
        private LocalDateTime orderDate;
        
        private BigDecimal zeroTotalPrice = null;
        private int ammountCheese;
    
        private OrderPOJO orderpojo;
        private ClientPOJO returnedClientPOJO;
        private ClientPOJO clientPOJO;
        private ClientDAO clientDAO;
        private OrderController orderController;
                

    
    public HelpClientOrderCheese(){

    }
    
  //first part start
    
    public void setClientID(int clientID) {
        
        clientPOJO = new ClientPOJO();
        returnedClientPOJO = new ClientPOJO();
        clientDAO = new ClientDAO();
        orderpojo = new OrderPOJO();
        
        this.clientID = clientID;
        orderpojo.setClientID(clientID);
        clientPOJO.setClientID(clientID);
        orderpojo.setClient(clientPOJO);
        returnedClientPOJO = clientDAO.getClient(clientPOJO);

    }

    public void setNewOrderByClient(int year, int month, int day, int hour, int min, int sec) {
        clientYear = year;
        clientMonth = month;
        clientDay = day;
        clientHour = hour;
        clientMin = min;
        clientSec = sec;
        
        processedDate = LocalDateTime.of(clientYear, clientMonth, clientDay, clientHour, clientMin, clientSec);

    }
    
    public void setOrderDelivery(int year, int month, int day, int hour, int min, int sec) {
        deliveryYear = year;
        deliveryMonth = month;       
        deliveryDay = day;
        deliveryHour = hour; 
        deliveryMin = min;
        deliverySec = sec;
        
        orderDate = LocalDateTime.of(deliveryYear, deliveryMonth, deliveryDay, deliveryHour, deliveryMin, deliverySec);
    
    }
    
    //first part close
    
    public void setOrderDetail(int cheeseID, int ammountCheese){
        this.ammountCheese = ammountCheese;
        this.cheeseID = cheeseID;
    }
    
    public void setOrderID(int orderID) {
       this.orderID = orderID;
    }

  public void getOrder(){
    
    orderController = new OrderController(); 
    returnedOrderID = orderController.setOrder(orderDate, zeroTotalPrice, processedDate, clientID);
  }
  
  public void getOrderDetail(){
      
      orderController = new OrderController();
      orderDetailID  = orderController.setOrderDetail(ammountCheese, returnedOrderID, cheeseID);
  }
  
}
