/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSvier;

import java.math.BigDecimal;
/**
 *
 * @author Gerben
 */
//ORDERDETAILPOJO
public class OrderDetailPOJO {
    private int orderDetailID;
    private Object cheese;
    private int quantity;
    private BigDecimal price;
    
    
    public OrderDetailPOJO(){}

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public Object getCheese() {
        return cheese;
    }

    public void setCheese(Object cheese) {
        this.cheese = cheese;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
}
