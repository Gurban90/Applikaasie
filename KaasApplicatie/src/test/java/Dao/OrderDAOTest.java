/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DatabaseConnector.Connector;
import POJO.ClientPOJO;
import POJO.OrderPOJO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class OrderDAOTest {
    
    LocalDateTime nowTime = LocalDateTime.now();
    LocalDateTime setTime = LocalDateTime.of(2000, 2, 20, 20, 02);
    LocalDateTime newSetTime = LocalDateTime.of(2112, 12, 21, 21, 12);
    BigDecimal number = new BigDecimal(2000.0002);
    
    
    public OrderDAOTest() {
    }

    OrderDAO OrderDAO = new OrderDAO();
    private Connection connect;
    
    @Before
    public void before() {
        try {
            connect = Connector.getConnection();
            String query = "INSERT INTO Order () VALUES ()";
            Statement statement = connect.createStatement();

            statement.executeUpdate(query);
            connect.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @After
    public void after() {
        try {
            Connection connect = Connector.getConnection();

            Statement statement = connect.createStatement();
            String query = "DELETE FROM Order";
            String query2 = "ALTER TABLE Order AUTO_INCREMENT = 1";
            statement.addBatch(query);
            statement.addBatch(query2);
            statement.executeBatch();
            //connect.commit(); is autocommit on?
            connect.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testAddOrder() {
        ClientPOJO client = new ClientPOJO();
        client.setClientID(2);
       
        OrderPOJO order = new OrderPOJO();
        order.setOrderDate(setTime);
        order.setTotalPrice(number);
        order.setProcessedDate(nowTime);
        order.setClient(client);
        OrderDAO.addOrder(order);
       
        try {
            connect = Connector.getConnection();
            String query = "SELECT * FROM Order WHERE orderID = 2";
            Statement statement = connect.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            resultset.next();
            
            assertNotNull(resultset.getObject(1));
            assertNotNull(resultset.getObject(2));
            assertNotNull(resultset.getObject(3));
            assertNotNull(resultset.getObject(4));
            //cannot compare localdatetime or integer?
            
            
            connect.close();
            resultset.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testGetAllOrder() {
    OrderDAO.getAllOrder();

        try {
            connect = Connector.getConnection();
            String query = "SELECT * FROM Order";
            Statement statement = connect.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            
            resultset.next();

            connect.close();
            resultset.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public void testGetOrder() {
        OrderPOJO order = new OrderPOJO();
        order.setOrderID(1);
        OrderPOJO test = OrderDAO.getOrder(order);

        assertEquals(1, test.getOrderID());

    }

    @Test
    public void testGetOrderWithClient() {
        ClientPOJO client = new ClientPOJO();
        client.setClientID(2);
        
      
        OrderDAO.getOrderWithClient(client);
        
        try {
            connect = Connector.getConnection();
            String query = "SELECT * FROM Order WHERE Client_ClientID = 2";
            Statement statement = connect.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            resultset.next();
            
            //find another testing methode? whaaaaaaaa:(
            
            connect.close();
            resultset.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testUpdateOrder() {
        OrderPOJO order = new OrderPOJO();
        order.setOrderID(1);
        order.setOrderDate(newSetTime);

        OrderDAO.updateOrder(order);

        try {
            connect = Connector.getConnection();
            String query = "SELECT * FROM Address WHERE AddressID = 1";
            Statement statement = connect.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            resultset.next();
            
            //ofcourse also error!
                     
            connect.close();
            resultset.close();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testDeleteOrder() {
        OrderPOJO order = new OrderPOJO();
        order.setOrderID(1);

        OrderDAO.deleteOrder(order);

        try {
            connect = Connector.getConnection();
            String query = "SELECT * FROM Order WHERE addressID = 1";
            Statement statement = connect.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            resultset.next();
            
            assertEquals(null, resultset.getString(1));
            
            connect.close();
            resultset.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
