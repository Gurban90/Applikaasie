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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Gerben
 */
public class ClientDAO implements ClientDAOInterface {

    Logger logger = Logger.getLogger(ClientDAOInterface.class.getName());
    private Connection connection;

    @Override
    public Integer addClient(ClientPOJO client) {
        logger.info("addClient Start");
        Integer newID = 0;

        String insertClient = "INSERT INTO Client (FirstName, LastName, E-mail) VALUES(?,?,?);";
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(insertClient, Statement.RETURN_GENERATED_KEYS);

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

    
        }finally{
                try { connection.close(); } catch (SQLException e) {}
            }          
        
        logger.info("addClient end");
        return newID;
        
        
    }

    @Override
    public List<ClientPOJO> getAllClient() {
        logger.info("getAllClient Start");
        String query = "SELECT * FROM Client;";
        List<ClientPOJO> returnedClients = new ArrayList<>();
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClientPOJO client = new ClientPOJO();
                client.setClientID(resultSet.getInt(1));
                client.setFirstName(resultSet.getString(2));
                client.setLastName(resultSet.getString(3));
                client.setEMail(resultSet.getString(4));
                returnedClients.add(client);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
                try { connection.close(); } catch (SQLException e) {}
            }
        
        logger.info("getAllClient end");
        return returnedClients;
    }


    public ClientPOJO getClient(ClientPOJO client) {
        logger.info("getClient Start");
        String query = "SELECT * FROM Client WHERE ClientID=?";
        ClientPOJO foundClient = new ClientPOJO();
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, client.getClientID());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                resultSet.next();
                foundClient.setClientID(resultSet.getInt(1));
                foundClient.setFirstName(resultSet.getString(2));
                foundClient.setLastName(resultSet.getString(3));
                foundClient.setEMail(resultSet.getString(4));
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
        logger.info("getClient end");
        return foundClient;
    }
    @Override
    public List<ClientPOJO> getClientWithFirstName(String FirstName) {
        logger.info("getClientWithName Start");
        String query = "SELECT * FROM Client WHERE FirstName=?";
        List<ClientPOJO> returnedClients = new ArrayList<>();
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, FirstName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClientPOJO client = new ClientPOJO();
                client.setClientID(resultSet.getInt(1));
                client.setFirstName(resultSet.getString(2));
                client.setLastName(resultSet.getString(3));
                client.setEMail(resultSet.getString(4));
                returnedClients.add(client);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
                try { connection.close(); } catch (SQLException e) {}
            }
        
        logger.info("getClientWithName end");
        return returnedClients;
    }

    @Override
    public List<ClientPOJO> getClientWithLastName(String LastName) {
        logger.info("getClientWithLastName Start");
        String query = "SELECT * FROM Client WHERE LastName=?";
        List<ClientPOJO> returnedClients = new ArrayList<>();
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, LastName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClientPOJO client = new ClientPOJO();
                client.setClientID(resultSet.getInt(1));
                client.setFirstName(resultSet.getString(2));
                client.setLastName(resultSet.getString(3));
                client.setEMail(resultSet.getString(4));
                returnedClients.add(client);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
                try { connection.close(); } catch (SQLException e) {}
            }
        
        logger.info("getClientWithLastName end");
        return returnedClients;
    }

    @Override
    public List<ClientPOJO> getClientWithEmail(String eMail) {
        logger.info("getClientWithEmail Start");
        String query = "SELECT * FROM Client WHERE E-mail=?";
        List<ClientPOJO> returnedClients = new ArrayList<>();
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, eMail);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClientPOJO client = new ClientPOJO();
                client.setClientID(resultSet.getInt(1));
                client.setFirstName(resultSet.getString(2));
                client.setLastName(resultSet.getString(3));
                client.setEMail(resultSet.getString(4));
                returnedClients.add(client);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
                try { connection.close(); } catch (SQLException e) {}
            }
        
        logger.info("getClientWithEmail end");
        return returnedClients;
    }

    @Override
    public void updateClient(ClientPOJO client) {
        logger.info("updateClient Start");
        String query = "UPDATE Client SET FirstName = ?, LastName = ?, E-mail = ? WHERE ClientID=?";
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getEMail());
            statement.setInt(4, client.getClientID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }finally{
                try { connection.close(); } catch (SQLException e) {}
            }
        
        logger.info("updateClient end");
    }

    @Override
    public void deleteClient(ClientPOJO client) {
        logger.info("deleteClient Start");
        String query = "select * from OrderDetail where Client_ClientID = ?";
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, client.getClientID());
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                query = "DELETE FROM Client WHERE ClientID = ?";
                statement = connection.prepareStatement(query);
                statement.setInt(1, client.getClientID());
                statement.executeUpdate();
            } else {
                System.out.println("Client is currently ordering, delete not possible.");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }finally{
                try { connection.close(); } catch (SQLException e) {}
            }
        logger.info("deleteClient end");
    }

}
