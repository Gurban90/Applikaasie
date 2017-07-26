/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 *
 * @author Gerben
 */
//ORDERPOJO
public class OrderPOJO {
    
    private int orderID;
    private OrderDetailPOJO orderDetail;
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
    
    
    //tryout zou eigenlijk een apparte class moeten zijn?
    
    public LocalDateTime convertDate(java.sql.Date x){
        
       Instant y = x.toInstant();
       LocalDateTime z = LocalDateTime.ofInstant(y , ZoneOffset.UTC);
        
        return z;
    }
    
    public java.sql.Date convertLocalDateTime(LocalDateTime x)  {
        
        Instant y = x.toInstant(ZoneOffset.UTC);
        Date z = (java.sql.Date)Date.from(y);
        
        
        return z;

    }
    
}
    
