/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DatabaseConnector.Connector;
import Interface.CheeseDAOInterface;
import Interface.EMailDAOInterface;
import POJO.EMailPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Gerben
 */
public class EMailDAO implements EMailDAOInterface {
    Logger logger = Logger.getLogger(CheeseDAOInterface.class.getName());
    private Connection connection;

    @Override
    public Integer addEMail(EMailPOJO email) {
        logger.info("addCheese Start");
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
        logger.info("addCheese end");
        return newID;

    }

    @Override
    public List<EMailPOJO> getAllEMial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EMailPOJO getEMail(EMailPOJO email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateEMail(EMailPOJO email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEMail(EMailPOJO email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
