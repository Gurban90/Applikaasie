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
        String query = "INSERT INTO Address (HouseNumber, HouseNumberAddition, StreetName , PostalCode, City, ) VALUES (?,?,?,?,?);"; 

        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, address.getHouseNumber());
            statement.setString(2,address.getHouseNumberAddition());
            statement.setString(3, address.getStreetName());
            statement.setString(4, address.getPostalCode());
            statement.setString(5, address.getCity());
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
                foundAddress.setHouseNumber(resultSet.getInt(2));
                foundAddress.setHouseNumberAddition(resultSet.getString(3));
                foundAddress.setStreetName(resultSet.getString(4));
                foundAddress.setPostalCode(resultSet.getString(5));
                foundAddress.setCity(resultSet.getString(6));


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
                foundAddress.setHouseNumber(resultSet.getInt(2));
                foundAddress.setHouseNumberAddition(resultSet.getString(3));
                foundAddress.setStreetName(resultSet.getString(4));
                foundAddress.setPostalCode(resultSet.getString(5));
                foundAddress.setCity(resultSet.getString(6));
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
    public void updateAddress(int addressID, int housenumber, String houseNumberAddition, String streetname, String postalCode, String city, String deliveryHouseNumber, String deliveryStreetName, String deliveryPostalCode, String deliveryCity) {
        log.info("updateAddress Start");
        String query = "UPDATE Address SET HouseNumber = ?, HouseNumberAddition =? StreetName =? , PostalCode = ?, City =?  WHERE AdressID=?";
        try {
            connect = Connector.getConnection();
            PreparedStatement updateAddress = connect.prepareStatement(query);
                updateAddress.setInt(1, addressID );
                updateAddress.setInt(2, housenumber );
                updateAddress.setString(3, houseNumberAddition );
                updateAddress.setString(3, streetname);
                updateAddress.setString(4, postalCode);
                updateAddress.setString(5, city);

            updateAddress.executeUpdate();
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