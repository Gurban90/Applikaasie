/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DatabaseConnector.Connector;
import Interface.CheeseDAOInterface;
import Interface.OrderDetailDAOInterface;
import POJO.CheesePOJO;
import POJO.OrderDetailPOJO;
import POJO.OrderPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Gerben
 */
public class OrderDetailDAO implements OrderDetailDAOInterface {

    Logger logger = Logger.getLogger(CheeseDAOInterface.class.getName());
    private Connection connection;

    @Override
    public Integer addOrderDetail(OrderDetailPOJO orderDetail) {

        logger.info("addOrderDetail Start");
        Integer newID = 0;
        CheesePOJO cheese = orderDetail.getCheese();
        OrderPOJO order = orderDetail.getOrder();
        String query = "select * from Cheese where CheeseID = ?";
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cheese.getCheeseID());
            ResultSet resultSet = statement.executeQuery();//Check of Cheese wel bestaat.
            if (resultSet.next()) {
                query = "select * from Order where OrderID = ?";
                statement = connection.prepareStatement(query);
                statement.setInt(1, order.getOrderID());
                ResultSet resultSet2 = statement.executeQuery();//Check of Order wel bestaat.
                if (resultSet2.next()) {
                    query = "INSERT INTO OrderDetail (Quantity, Cheese_CheeseID, Order_OrderID) VALUES (?,?,?);";
                    statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                    statement.setInt(1, orderDetail.getQuantity());
                    statement.setInt(2, cheese.getCheeseID());
                    statement.setInt(3, order.getOrderID());
                    statement.executeUpdate();
                    try (ResultSet resultSet3 = statement.getGeneratedKeys()) {
                        if (resultSet3.next()) {
                            newID = resultSet3.getInt(1);
                            orderDetail.setOrderDetailID(newID);
                        } else {
                            throw new SQLException("Creating OrderDetail failed, no ID obtained.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Check order , has to exist in database");
                }
            } else {
                System.out.println("Check cheese, has to exist in database");
            }

            connection.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("addOrderDetail end");
        return newID;

    }

    @Override
    public List<OrderDetailPOJO> getAllOrderDetail() {
        logger.info("getAllOrderDetail Start");
        String query = "SELECT * FROM OrderDetail;";
        List<OrderDetailPOJO> returnedOrderDetail = new ArrayList<>();
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                OrderDetailPOJO orderDetail = new OrderDetailPOJO();
                orderDetail.setOrderDetailID(resultSet.getInt(1));
                orderDetail.setQuantity(resultSet.getInt(2));
                orderDetail.setCheeseID(resultSet.getInt(3));
                orderDetail.setOrderID(resultSet.getInt(4));
                returnedOrderDetail.add(orderDetail);
            }
            connection.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("getAllOrderDetail end");
        return returnedOrderDetail;
    }

    @Override
    public List<OrderDetailPOJO> getOrderDetail(Integer orderID
    ) {
        logger.info("getOrderDetail Start");
        String query = "SELECT * FROM OrderDetail WHERE Order_OrderID =?";
        List<OrderDetailPOJO> returnedOrderDetail = new ArrayList<>();
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                OrderDetailPOJO orderDetail = new OrderDetailPOJO();
                orderDetail.setOrderDetailID(resultSet.getInt(1));
                orderDetail.setQuantity(resultSet.getInt(2));
                orderDetail.setCheeseID(resultSet.getInt(3));
                orderDetail.setOrderID(resultSet.getInt(4));
                returnedOrderDetail.add(orderDetail);
            }
            connection.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("getOrderDetail end");
        return returnedOrderDetail;
    }

    public void updateOrderDetail(OrderDetailPOJO orderDetail) {
        logger.info("updateOrderDetail Start");
        CheesePOJO cheese = orderDetail.getCheese();
        OrderPOJO order = orderDetail.getOrder();
        String query = "select * from Cheese where CheeseID = ?";
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cheese.getCheeseID());
            ResultSet resultSet = statement.executeQuery();//Check of Cheese wel bestaat.
            if (resultSet.next()) {
                query = "select * from Order where OrderID = ?";
                statement = connection.prepareStatement(query);
                statement.setInt(1, order.getOrderID());
                ResultSet resultSet2 = statement.executeQuery();//Check of Order wel bestaat.
                if (resultSet2.next()) {
                    query = "UPDATE OrderDetail (Quantity, Cheese_CheeseID, Order_OrderID) VALUES (?,?,?);";
                    statement = connection.prepareStatement(query);
                    statement.setInt(1, orderDetail.getQuantity());
                    statement.setInt(2, cheese.getCheeseID());
                    statement.setInt(3, order.getOrderID());
                    statement.executeUpdate();
                } else {
                    System.out.println("Check order , has to exist in database");
                }
            } else {
                System.out.println("Check cheese, has to exist in database");
            }

            connection.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("updateOrderDetail end");

    }

    @Override
    public void updateOrderDetail(int OrderDetailID, int quantity) {
        logger.info("updateOrderDetail Start");
        String query = "UPDATE OrderDetail SET Quantity = ? WHERE OrderDetailID=?";
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, quantity);
            statement.setInt(2, OrderDetailID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        logger.info("updateOrderDetail end");
    }
    
    public void updateOrderDetail(int OrderDetailID, OrderPOJO order) {
        logger.info("updateOrderDetail Start");
        String query = "select * from Order where OrderID = ?";
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, order.getOrderID());
            ResultSet resultSet = statement.executeQuery();//Check of Order wel bestaat.
           if (resultSet.next()) {
                    query = "UPDATE OrderDetail SET Order_OrderID = ?,WHERE OrderDetailID=?"; 
                    statement = connection.prepareStatement(query);
                    statement.setInt(1, order.getOrderID());
                    statement.setInt(2, OrderDetailID);
                    statement.executeUpdate();
                } else {
                    System.out.println("Check order , has to exist in database");
                }
            connection.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("updateOrderDetail end");

    }
    
     public void updateOrderDetail(int OrderDetailID, CheesePOJO cheese) {
        logger.info("updateOrderDetail Start");
        String query = "select * from Order where OrderID = ?";
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cheese.getCheeseID());
            ResultSet resultSet = statement.executeQuery();//Check of Order wel bestaat.
           if (resultSet.next()) {
                    query = "UPDATE OrderDetail SET Cheese_CheeseID = ?,WHERE OrderDetailID=?"; 
                    statement = connection.prepareStatement(query);
                    statement.setInt(1, cheese.getCheeseID());
                    statement.setInt(2, OrderDetailID);
                    statement.executeUpdate();
                } else {
                    System.out.println("Check cheese , has to exist in database");
                }
            connection.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("updateOrderDetail end");

    }

    @Override
    public void deleteOrderDetail(OrderDetailPOJO orderdetail
    ) {
        logger.info("deleteOrderDetail Start");
        String query = "DELETE FROM OrderDetail WHERE OrderDetailID = ?";
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, orderdetail.getOrderDetailID());
            statement.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        logger.info("deleteOrderDetail end");
    }

}
