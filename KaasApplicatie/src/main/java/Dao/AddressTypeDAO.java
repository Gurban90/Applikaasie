/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DatabaseConnector.Connector;
import Interface.AddressTypeDAOInterface;
import Interface.ClientDAOInterface;
import POJO.AddressTypePOJO;
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
 * @author Jasper Thielen
 */
public class AddressTypeDAO implements AddressTypeDAOInterface {

    Logger log = Logger.getLogger(ClientDAOInterface.class.getName());
    private Connection connect;
    
    @Override
    public Integer addAddressType(AddressTypePOJO address) {
                Integer newID = 0;
        
        log.info("addaddresstype Start");
        String insertOrder = "INSERT INTO addressType" 
                + "(type) VALUES "
                + "(?);";
        try{
        connect = Connector.getConnection();
        PreparedStatement statement = connect.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, address.getAddressType());      
        statement.executeUpdate();
        
        try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    newID = resultSet.getInt(1);
                    address.setAddressTypeID(newID);
                } else {
                    throw new SQLException("Inserting order failed, no ID retrieved.");
                }
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        
        log.info("addaddresstype end");
        
        
        }
        return newID;
    }

    @Override
    public List<AddressTypePOJO> getAllAddressType() {
        log.info("getAllAddressType Start");
        String query = "SELECT * FROM AddressType;";
        List<AddressTypePOJO> GetAllAddressType = new ArrayList<>();
        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                AddressTypePOJO AddressType = new AddressTypePOJO();
                AddressType.setAddressTypeID(resultSet.getInt(1));
                AddressType.setAddressType(resultSet.getString(2));
                GetAllAddressType.add(AddressType);
            }
            connect.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("getAllAdressType end");
        return GetAllAddressType;
    }

    @Override
    public AddressTypePOJO getAddressType(AddressTypePOJO address) {
        log.info("getAddressType Start");
        String query = "SELECT * FROM AddressType WHERE AddressTypeID=?";
        AddressTypePOJO foundAddressType = new AddressTypePOJO();
        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setObject(1, address.getAddressTypeID());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                resultSet.next();
                foundAddressType.setAddressTypeID(resultSet.getInt(1));
                foundAddressType.setAddressType(resultSet.getString(2));

            }
            connect.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("getaddressType end");
        return foundAddressType;
    }

    @Override
    public void updateAddressType(Integer AddressTypeID, String AddressType) {
        log.info("updateAddressType Start");
        
        String query = "UPDATE AddressType SET Type = ?, WHERE AddressTypeID=?"; //this is ok?
        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setString(1, AddressType );
            statement.setInt(2, AddressTypeID );
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        log.info("updateAddressType end");
    }
    

    @Override
    public void deleteAddressType(AddressTypePOJO address) {
       log.info("deleteaddresstype Start");
        String query = "select * from AddressType where AddressTypeID = ?";
        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setInt(1, address.getAddressTypeID());
            ResultSet resultSet = statement.executeQuery();
            
            connect.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        log.info("deleteaddresstype end");
    }
    
}
