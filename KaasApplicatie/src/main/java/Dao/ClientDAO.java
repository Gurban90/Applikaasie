/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DatabaseConnector.Connector;
import Interface.ClientDAOInterface;
import POJO.ClientPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Jasper Thielen
 */
public class ClientDAO implements ClientDAOInterface {
    
    Logger log = Logger.getLogger(ClientDAOInterface.class.getName());
    private Connection connect;
    
    @Override
    public Integer AddClient(ClientPOJO client) {
        Integer newID = 0;
        
        log.info("addClient Start");
        String insertClient = "INSERT INTO Client" 
                + "(FirstName, LastName, Email) VALUES "
                + "(?,?,?);";
        try{
        connect = Connector.getConnection();
        PreparedStatement statement = connect.prepareStatement(insertClient);
        
        statement.setString(1, client.getFirstName());
        statement.setString(2, client.getLastName());
        statement.setString(3, client.getEMail());
        statement.executeUpdate();
        
        try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    newID = resultSet.getInt(1);
                    client.setClientID(newID);
                } else {
                    throw new SQLException("Inserting Client failed, no ID retrieved.");
                }
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        
        log.info("addClient end");
        
        
        }
        return newID;
    }
    
    
    
    
    
    
    
    
    
    @Override
    public List<ClientPOJO> getAllClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClientPOJO getClient(ClientPOJO client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateClient(ClientPOJO client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteClient(ClientPOJO client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
