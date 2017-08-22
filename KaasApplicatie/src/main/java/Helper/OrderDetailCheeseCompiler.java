/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Dao.CheeseDAO;
import Dao.OrderDAO;
import POJO.CheesePOJO;
import POJO.OrderDetailPOJO;
import POJO.OrderPOJO;

/**
 *
 * @author Nelleke
 */
public class OrderDetailCheeseCompiler {
    
    
    OrderDetailPOJO orderDetail; 
    CheesePOJO cheesePOJO;
    CheesePOJO returnedCheesePOJO;
    OrderPOJO orderPOJO;
    CheeseDAO cheeseDAO;
    OrderDAO orderDAO;
    Integer orderID; //In helpclientordercheese
    
    public OrderDetailCheeseCompiler(){    
    }

    public void setData(int cheeseID, int ammountCheese) {
        cheesePOJO = new CheesePOJO();
        orderPOJO = new OrderPOJO();
        orderDetail = new OrderDetailPOJO();
        cheeseDAO = new CheeseDAO();
        orderDAO = new OrderDAO();
        
        
        cheesePOJO.setCheeseID(cheeseID);
        returnedCheesePOJO = cheeseDAO.getCheese(cheesePOJO);
        
        orderPOJO.setOrderID(orderID);
        
        
        orderDetail.setCheese(returnedCheesePOJO);
        orderDetail.setOrder(order);
        
    
    }
}
