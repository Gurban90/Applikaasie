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
        String query = "SELECT * FROM Address WHERE AddressID=?"; // search on id? is there a better way, maybe search on client??
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAddress(AddressPOJO address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAddress(AddressPOJO address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
