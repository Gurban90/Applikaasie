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
    private OrderDetailPOJO orderDetail;
    private CheesePOJO cheese;
    private ClientPOJO client;
    private BigDecimal totalPrice;
    private LocalDateTime orderDate;
    private LocalDateTime processedDate;


    public OrderPOJO(){
           
    }
    
    
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public OrderDetailPOJO getOrderDetail() { 
        return orderDetail;
    }

    public void setOrderDetail(OrderDetailPOJO orderDetail) {
        this.orderDetail = orderDetail;
    }

    public CheesePOJO getCheese() {
        return cheese;
    }

    public void setCheese(CheesePOJO cheese) {
        this.cheese = cheese;
    }

    public ClientPOJO getClient() {
        return client;
    }

    public void setClient(ClientPOJO client) {
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
    
    public LocalDateTime getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(LocalDateTime processedDate) {
        this.processedDate = processedDate;
    }
    
        
    }
    
    
