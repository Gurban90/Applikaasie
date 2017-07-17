/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Gerben
 */
//ORDERPOJO
public class OrderPOJO {
    
    private int orderID;
    private Object orderDetail;
    private Object cheese;
    private Object client;
    private BigDecimal totalPrice;
    private LocalDateTime orderDate;


    public OrderPOJO(){
           
    }
    
    
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Object getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(Object orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Object getCheese() {
        return cheese;
    }

    public void setCheese(Object cheese) {
        this.cheese = cheese;
    }

    public Object getClient() {
        return client;
    }

    public void setClient(Object client) {
        this.client = client;
    }

  

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    
    
        
    }
    
    
