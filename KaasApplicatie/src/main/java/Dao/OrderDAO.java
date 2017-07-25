/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DatabaseConnector.Connector;
import Interface.ClientDAOInterface;
import Interface.OrderDAOInterface;
import POJO.OrderPOJO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Jasper Thielen
 */
public class OrderDAO implements OrderDAOInterface {
    Logger log = Logger.getLogger(ClientDAOInterface.class.getName());
    private Connection connect;
    
    @Override
    public Integer addOrder(OrderPOJO order) {
        Integer newID = 0;
        
        log.info("trying to convert date");
        LocalDateTime inODate = order.getOrderDate();
        LocalDateTime inPDate = order.getProcessedDate();
        Instant instantO = inODate.atZone(ZoneId.systemDefault()).toInstant();
        Instant instantP = inPDate.atZone(ZoneId.systemDefault()).toInstant();     
        Date outODate = (Date) Date.from(instantO); //Hier gaat het van Date.java naar (Date).sql maar het geeft geen error meer
        Date outPDate = (Date) Date.from(instantP); //
        log.info("converting date succesfull??");
        
        log.info("addorder Start");
        String insertOrder = "INSERT INTO Order" 
                + "(OrderDate, totalPrice, ProcessedDate) VALUES "
                + "(?,?,?);";
        try{
        connect = Connector.getConnection();
        PreparedStatement statement = connect.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS);
        statement.setDate(1, outODate);
        statement.setBigDecimal(2, order.getTotalPrice());
        statement.setDate(3, outPDate);       
        statement.executeUpdate();
        
        try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    newID = resultSet.getInt(1);
                    order.setOrderID(newID);
                } else {
                    throw new SQLException("Inserting order failed, no ID retrieved.");
                }
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        
        log.info("addorder end");
        
        
        }
        return newID;
    }
    @Override
    public List<OrderPOJO> getAllOrder() {
        log.info("getAllAddress Start");
        String query = "SELECT * FROM Address;";
        
        List<OrderPOJO> returnedOrder = new ArrayList<>();
        
        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                
                OrderPOJO foundOrder = new OrderPOJO();
                
                foundOrder.setOrderID(resultSet.getInt(1));
                foundOrder.setOrderDate(resultSet.getDate(2));
                foundOrder.setTotalPrice(resultSet.getBigDecimal(3));
                foundOrder.setProcessedDate(resultSet.getDate(4));
                returnedOrder.add(foundOrder);
            }
            connect.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("getAllAddress end");
        return returnedOrder;
    }
    
     /*
    LocalDateTime orderDate;
    BigDecimal totalPrice;
    LocalDateTime processedDate;
    */
    

    @Override
    public OrderPOJO getOrder(OrderPOJO order) {
        log.info("getOrder Start");
        String query = "SELECT * FROM order WHERE orderID=?";
        OrderPOJO foundOrder = new OrderPOJO();
        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setObject(1, order.getOrderID());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                resultSet.next();
                foundOrder.setOrderID(resultSet.getInt(1));
                foundOrder.setOrderDate(resultSet.getDate(2));
                foundOrder.setTotalPrice(resultSet.getBigDecimal(3));
                foundOrder.setProcessedDate(resultSet.getDate(4));

            }
            connect.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("getorder end");
        return foundOrder;
    }
    

    @Override
    public void updateOrder(OrderPOJO order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void deleteOrder(OrderPOJO order) {
        log.info("deleteOrder Start");
        
        String query = "select * from Order where OrderID = ?";
        
        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setInt(1, order.getOrderID());
            ResultSet resultSet = statement.executeQuery();

           connect.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        log.info("deleteOrder end");
}
    
}
