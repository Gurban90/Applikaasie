/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DatabaseConnector.Connector;
import Interface.CheeseDAOInterface;
import POJO.CheesePOJO;
import java.math.BigDecimal;
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

    Logger logger = Logger.getLogger(CheeseDAOInterface.class.getName());
    private Connection connection;

    @Override
    public Integer AddCheese(CheesePOJO cheese) {
        Integer newID = 0;
        String query = "INSERT INTO Cheese (Name, Price, Stock) VALUES (?,?,?);";
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
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
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newID;

    }

    @Override
    public List<CheesePOJO> getAllCheese() {
        String query = "SELECT * FROM Cheese;";
        List<CheesePOJO> returnedCheeses = new ArrayList<>();                   //Is deze leeg nadat ik hem eerder heb gebruikt?
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CheesePOJO cheese = new CheesePOJO();               //Kan je steeds een Cheese object aanmaken genaamd cheese?
                cheese.setCheeseID(resultSet.getInt(1));
                cheese.setCheeseName(resultSet.getString(2));
                cheese.setPrice(resultSet.getBigDecimal(3));
                cheese.setStock(resultSet.getInt(4));
                returnedCheeses.add(cheese);
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedCheeses;
    }

    @Override
    public CheesePOJO getCheese(CheesePOJO cheese) {
        String query = "SELECT * FROM Cheese WHERE CheeseID=?";
        CheesePOJO foundCheese = new CheesePOJO();                      //Is deze leeg nadat ik hem eerder heb gebruikt? Moet 
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, cheese.getCheeseID());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                resultSet.next();
                foundCheese.setCheeseID(resultSet.getInt(1));
                foundCheese.setCheeseName(resultSet.getString(2));
                foundCheese.setPrice(resultSet.getBigDecimal(3));
                foundCheese.setStock(resultSet.getInt(4));
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundCheese;
    }

    @Override
    public void updateCheese(CheesePOJO cheese) {
        String query = "UPDATE Cheese SET Name = ?, Price = ?, Stock = ? WHERE CheeseID=?";
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cheese.getCheeseName());
            statement.setBigDecimal(2, cheese.getPrice());
            statement.setInt(3, cheese.getStock());
            statement.setInt(4, cheese.getCheeseID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    
    @Override
    public boolean deleteCheese(CheesePOJO cheese) {
        String query = "DELETE FROM Cheese WHERE id = ?";
        ///nog aanvullen

    }
}
