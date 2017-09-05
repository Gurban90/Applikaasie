/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DatabaseConnector.Connector;
import DatabaseConnector.DomXML;
import Helper.ConnectionFactory;

import Interface.CheeseDAOInterface;
import POJO.CheesePOJO;

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
public class CheeseDAO implements CheeseDAOInterface {

    private Logger LOGGER = Logger.getLogger(CheeseDAOInterface.class.getName());
    private DomXML data = new DomXML();
    private ConnectionFactory connectionfactory = new ConnectionFactory();
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String query;

    @Override
    public Integer addCheese(CheesePOJO cheese) {
        LOGGER.info("addCheese Start");
        Integer newID = 0;
        query = "INSERT INTO Cheese (Name, Price, Stock) VALUES (?,?,?);";
        try {
            connection = connectionfactory.getConnection(data.getConnectionType());
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, cheese.getCheeseName());
            statement.setBigDecimal(2, cheese.getPrice());
            statement.setInt(3, cheese.getStock());
            statement.executeUpdate();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    newID = resultSet.getInt(1);
                    cheese.setCheeseID(newID);
                } else {
                    throw new SQLException("Creating Cheese failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("addCheese end");
        return newID;

    }

    @Override
    public List<CheesePOJO> getAllCheese() {
        LOGGER.info("getAllCheese Start");
        query = "SELECT * FROM Cheese;";
        List<CheesePOJO> returnedCheeses = new ArrayList<>();
        
        try {
            connection = connectionfactory.getConnection(data.getConnectionType());
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CheesePOJO cheese = new CheesePOJO();
                cheese.setCheeseID(resultSet.getInt(1));
                cheese.setCheeseName(resultSet.getString(2));
                cheese.setPrice(resultSet.getBigDecimal(3));
                cheese.setStock(resultSet.getInt(4));
                returnedCheeses.add(cheese);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("getAllCheese end");
        return returnedCheeses;
    }

    @Override
    public CheesePOJO getCheese(CheesePOJO cheese) {
        LOGGER.info("getCheese Start");
        query = "SELECT * FROM Cheese WHERE CheeseID=?";
        CheesePOJO foundCheese = new CheesePOJO();
        try {
            connection = connectionfactory.getConnection(data.getConnectionType());
            statement = connection.prepareStatement(query);
            statement.setObject(1, cheese.getCheeseID());
            resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                resultSet.next();
                foundCheese.setCheeseID(resultSet.getInt(1));
                foundCheese.setCheeseName(resultSet.getString(2));
                foundCheese.setPrice(resultSet.getBigDecimal(3));
                foundCheese.setStock(resultSet.getInt(4));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("getCheese end");
        return foundCheese;
    }
    
    @Override
    public CheesePOJO getCheeseWithName(CheesePOJO cheese){
        LOGGER.info("getCheeseWithName Start");
        query = "SELECT * FROM Cheese WHERE Name=?";
        CheesePOJO foundCheese = new CheesePOJO();
        try {
            connection = connectionfactory.getConnection(data.getConnectionType());
            statement = connection.prepareStatement(query);
            statement.setObject(1, cheese.getCheeseName());
            resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                resultSet.next();
                foundCheese.setCheeseID(resultSet.getInt(1));
                foundCheese.setCheeseName(resultSet.getString(2));
                foundCheese.setPrice(resultSet.getBigDecimal(3));
                foundCheese.setStock(resultSet.getInt(4));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("getCheeseWithName end");
        return foundCheese;
    
    }

    @Override
    public void updateCheese(CheesePOJO cheese) {
        LOGGER.info("updateCheese Start");
        query = "UPDATE Cheese SET Name = ?, Price = ?, Stock = ? WHERE CheeseID=?";
        try {
            connection = connectionfactory.getConnection(data.getConnectionType());
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cheese.getCheeseName());
            statement.setBigDecimal(2, cheese.getPrice());
            statement.setInt(3, cheese.getStock());
            statement.setInt(4, cheese.getCheeseID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("updateCheese end");
    }

    @Override
    public void deleteCheese(CheesePOJO cheese) {
        LOGGER.info("deleteCheese Start");
        query = "select * from OrderDetail where Cheese_CheeseID = ?";
        try {
            connection = connectionfactory.getConnection(data.getConnectionType());
            statement = connection.prepareStatement(query);
            statement.setInt(1, cheese.getCheeseID());
            resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                query = "DELETE FROM Cheese WHERE CheeseID = ?";
                statement = connection.prepareStatement(query);
                statement.setInt(1, cheese.getCheeseID());
                statement.executeUpdate();
                System.out.println("Cheese is deleted");
            } else {
                System.out.println("Cheese is currently being ordered, delete not possible.");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("deleteCheese end");
    }
    
    
    
}
