/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Helper.Converter;

import DatabaseConnector.Connector;
import Interface.ClientDAOInterface;
import Interface.OrderDAOInterface;
import POJO.ClientPOJO;
import POJO.OrderPOJO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
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
    private Converter convert;

    @Override
    public Integer addOrder(OrderPOJO order) {
        Integer newID = 0;
        convert = new Converter();
        log.info("addorder Start");
        String insertOrder = "INSERT INTO `order` (`OrderDate`, `TotalPrice`, `ProcessedDate`, `Client_ClientID`) VALUES (?,?,?,?);";
        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, convert.convertLocalDateTime(order.getOrderDate()));
            statement.setBigDecimal(2, order.getTotalPrice());
            statement.setString(3, convert.convertLocalDateTime(order.getProcessedDate()));
            statement.setInt(4, order.getClientID());
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

        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
            }
        }

        log.info("addorder end");
        return newID;
    }

    @Override
    public List<OrderPOJO> getAllOrder() {
        log.info("getAllOrder Start");
        String query = "SELECT * FROM `order`;";

        List<OrderPOJO> returnedOrder = new ArrayList<>();
        convert = new Converter();

        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                OrderPOJO foundOrder = new OrderPOJO();

                foundOrder.setOrderID(resultSet.getInt(1));
                foundOrder.setOrderDate(convert.convertDate(resultSet.getString(2)));
                foundOrder.setTotalPrice(resultSet.getBigDecimal(3));
                foundOrder.setProcessedDate(convert.convertDate(resultSet.getString(4)));
                returnedOrder.add(foundOrder);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
            }
        }

        log.info("getAllOrder end");
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
        String query = "SELECT * FROM `order` WHERE OrderID=?";
        OrderPOJO foundOrder = new OrderPOJO();
        convert = new Converter();

        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setObject(1, order.getOrderID());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                resultSet.next();
                foundOrder.setOrderID(resultSet.getInt(1));
                foundOrder.setOrderDate(convert.convertDate(resultSet.getString(2)));
                foundOrder.setTotalPrice(resultSet.getBigDecimal(3));
                foundOrder.setProcessedDate(convert.convertDate(resultSet.getString(4)));

            }
            connect.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
            }
        }

        log.info("getorder end");
        return foundOrder;
    }

    @Override
    public List<OrderPOJO> getOrderWithClient(ClientPOJO client) {
        log.info("getAllAddress Start");
        String query = "SELECT * FROM Order WHERE Client_ClientID=?";

        List<OrderPOJO> returnedAddress = new ArrayList<>();
        convert = new Converter();

        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setObject(1, client.getClientID());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                OrderPOJO foundOrder = new OrderPOJO();

                foundOrder.setOrderID(resultSet.getInt(1));
                foundOrder.setOrderDate(convert.convertDate(resultSet.getString(2)));
                foundOrder.setTotalPrice(resultSet.getBigDecimal(3));
                foundOrder.setProcessedDate(convert.convertDate(resultSet.getString(4)));
                returnedAddress.add(foundOrder);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        log.info("getAllCheese end");
        return returnedAddress;
    }

    @Override
    public void updateOrder(OrderPOJO order) {
        log.info("updateOrder Start");
        String query = "UPDATE Order SET  WHERE OrderID=?";
        convert = new Converter();

        try {
            connect = Connector.getConnection();
            PreparedStatement updateOrder = connect.prepareStatement(query);
            updateOrder.setInt(1, order.getOrderID());
            updateOrder.setString(2, convert.convertLocalDateTime(order.getOrderDate()));
            updateOrder.setBigDecimal(3, order.getTotalPrice());
            updateOrder.setString(4, convert.convertLocalDateTime(order.getProcessedDate()));

            updateOrder.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
            }
        }

        log.info("updateOrder end");
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

        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
            }
        }

        log.info("deleteOrder end");
    }
    public static void main(String[] args) {
        OrderPOJO order = new OrderPOJO();
        OrderDAO dao = new OrderDAO();

        order.setOrderDate(LocalDateTime.now());
        order.setTotalPrice(new BigDecimal(3.0));
        order.setProcessedDate(LocalDateTime.now());
        order.setClientID(1);
        

       System.out.println(dao.getAllOrder());

       

    }

}
