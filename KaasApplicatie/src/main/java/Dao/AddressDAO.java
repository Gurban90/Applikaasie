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
                if (resultSet.next()) {
                    newID = resultSet.getInt(1); //kijk hier vanavond nog even naar, jasper!
                    address.setAddressID(newID);
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
    public List<AddressPOJO> getAllAddress() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AddressPOJO getAddress(AddressPOJO address) {
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
