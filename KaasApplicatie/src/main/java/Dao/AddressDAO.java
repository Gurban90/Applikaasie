/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DatabaseConnector.Connector;
import Interface.AddressDAOInterface;
import POJO.AddressPOJO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.logging.Logger;
import java.util.List;

/**
 *
 * @author Jasper Thielen
 */
public class AddressDAO implements AddressDAOInterface {
    
    Logger log = Logger.getLogger(AddressDAOInterface.class.getName());
    
    private Connection connect;

    @Override
    public Integer addAddress(AddressPOJO address) {
        log.info("addAddress Start");
        Integer newID = 0;
        String query = "INSERT INTO Address (HouseNumber, StreetName , PostalCode, City, DeliveryHouseNumber, DeliveryStreetname, DeliveryPostalCode, DeliveryCity  ) VALUES (?,?,?,?,?,?,?,?);"; 
//database is nog niet geheel ingevuld, naamgeving is belangrijk?
        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, address.getHouseNumber());
            statement.setString(2, address.getStreetName());
            statement.setString(3, address.getPostalCode());
            statement.setString(4, address.getCity());
            statement.setString(5, address.getDeliveryHouseNumber());
            statement.setString(6, address.getDeliveryPostalCode());
            statement.setString(7, address.getDeliveryCity());
            statement.setString(8, address.getDeliveryCity());
            statement.executeUpdate();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) { //skips to next row
                    newID = resultSet.getInt(1); //selects number from first column of database in row
                    address.setAddressID(newID); // sets Id
                } else {
                    throw new SQLException("Creating Address failed, no ID obtained.");
                }
            }
            connect.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("addAddress end");
        return newID;

    }

        @Override
    public AddressPOJO getAddress(AddressPOJO address) {
        log.info("getAddress Start");
        String query = "SELECT * FROM Address WHERE Client_ClientID=?"; // search on clientID??
        
        AddressPOJO foundAddress = new AddressPOJO();
        
        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setObject(1, address.getAddressID());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                resultSet.next();
                foundAddress.setAddressID(resultSet.getInt(1));
                foundAddress.setHouseNumber(resultSet.getString(2));
                foundAddress.setStreetName(resultSet.getString(3));
                foundAddress.setPostalCode(resultSet.getString(4));
                foundAddress.setCity(resultSet.getString(5));
                foundAddress.setDeliveryHouseNumber(resultSet.getString(6));
                foundAddress.setDeliveryStreetName(resultSet.getString(7));
                foundAddress.setDeliveryPostalCode(resultSet.getString(8));
                foundAddress.setDeliveryCity(resultSet.getString(9));
                //works because we dont have to add names to string if all are given?

            }
            connect.close();
            resultSet.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        log.info("getAddress end");
        return foundAddress;
        
    }
    
    @Override
    public List<AddressPOJO> getAllAddress() {
        log.info("getAllAddress Start");
        String query = "SELECT * FROM Address;";
        
        List<AddressPOJO> returnedAddress = new ArrayList<>();
        
        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                
                AddressPOJO foundAddress = new AddressPOJO();
                
                foundAddress.setAddressID(resultSet.getInt(1));
                foundAddress.setHouseNumber(resultSet.getString(2));
                foundAddress.setStreetName(resultSet.getString(3));
                foundAddress.setPostalCode(resultSet.getString(4));
                foundAddress.setCity(resultSet.getString(5));
                foundAddress.setDeliveryHouseNumber(resultSet.getString(6));
                foundAddress.setDeliveryStreetName(resultSet.getString(7));
                foundAddress.setDeliveryPostalCode(resultSet.getString(8));
                foundAddress.setDeliveryCity(resultSet.getString(9));
                returnedAddress.add(foundAddress);
            }
            connect.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("getAllCheese end");
        return returnedAddress;
    }
    

    @Override
    public void updateAddress(AddressPOJO address) {
       log.info("updateAddress Start");
        String query = "UPDATE Address SET HouseNumber = ?, StreetName =? , PostalCode = ?, City =?, DeliveryHouseNumber =?, DeliveryStreetname =?, DeliveryPostalCode =?, DeliveryCity=?  WHERE AdressID=?";
        try {
            connect = Connector.getConnection();
            PreparedStatement updateAdress = connect.prepareStatement(query);
                updateAdress.setAddressID(1, address.getAddressID());
                updateAdress.setHouseNumber(2, address.getHouseNumber());
                updateAdress.setStreetName(3,getStreetName());
                updateAdress.setPostalCode(4, getPostalCode());
                updateAdress.setCity(5, getCity());
                updateAdress.setDeliveryHouseNumber(6,getDeliveryHouseNumber());
                updateAdress.setDeliveryStreetName(7,getDeliveryStreetName());
                updateAdress.setDeliveryPostalCode(8,getDeliveryPostalCode());
                updateAdress.setDeliveryCity(9, getDeliveryCity());
            updateAdress.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        log.info("updateAddress end");
    }

    @Override
    public void deleteAddress(AddressPOJO address) {
        log.info("deleteAddress Start");
        String query = "delete * from Address where Client_Clientid = ?";
        
        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setInt(1, address.getAddressID());
            ResultSet resultSet = statement.executeQuery();
            
           connect.close();
            resultSet.close();
        
        } catch (SQLException e) {
            e.printStackTrace();
        
        log.info("deleteAdress stop");
     
    }
  
}
}