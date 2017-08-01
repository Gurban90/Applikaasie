/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DatabaseConnector.Connector;
import Interface.AddressDAOInterface;
import POJO.AddressPOJO;
import POJO.AddressTypePOJO;
import POJO.ClientPOJO;
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
        ClientPOJO client = new ClientPOJO();
        AddressTypePOJO addresstype = new AddressTypePOJO();
        String query = "INSERT INTO Address (HouseNumber, HouseNumberAddition, StreetName , PostalCode, City, Client_ClientID, AddressType_AddressTypeID ) VALUES (?,?,?,?,?,?,?);";
        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, address.getHouseNumber());
            statement.setString(2, address.getHouseNumberAddition());
            statement.setString(3, address.getStreetName());
            statement.setString(4, address.getPostalCode());
            statement.setString(5, address.getCity());
            statement.setInt(6, client.getClientID());
            statement.setInt(6, addresstype.getAddressTypeID());
            statement.executeUpdate();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) { //skips to next row
                    newID = resultSet.getInt(1); //selects number from first column of database in row
                    address.setAddressID(newID); // sets Id
                } else {
                    throw new SQLException("Creating Address failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connect.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        log.info("addAddress end");
        return newID;

    }

    @Override
    public AddressPOJO getAddress(AddressPOJO address) {
        log.info("getAddress Start");
        String query = "SELECT * FROM Address WHERE AddressID=?";

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
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        log.info("getAddress end");
        return foundAddress;

    }

    @Override
    public List<AddressPOJO> getAddressWithClient(ClientPOJO client) {
        log.info("getAddresswithClient Start");
        String query = "SELECT * FROM Address WHERE Client_ClientID=?";

        List<AddressPOJO> returnedAddress = new ArrayList<>();

        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setObject(1, client.getClientID());
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
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        log.info("getAddresswithclient end");
        return returnedAddress;
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
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        log.info("getAllCheese end");
        return returnedAddress;
    }

    @Override
    public void updateAddress(AddressPOJO address) {
        log.info("updateAddress Start");
        ClientPOJO client = new ClientPOJO();
        AddressTypePOJO addresstype = new AddressTypePOJO();
        String query = "UPDATE Address SET HouseNumber = ?, HouseNumberAddition =? StreetName =? , PostalCode = ?, City =? Client_ClientID =? AddressType_AddressTypeID =?  WHERE AdressID=?";
        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setInt(1, address.getHouseNumber());
            statement.setString(2, address.getHouseNumberAddition());
            statement.setString(3, address.getStreetName());
            statement.setString(4, address.getPostalCode());
            statement.setString(5, address.getCity());
            statement.setInt(6, client.getClientID());
            statement.setInt(7, addresstype.getAddressTypeID());
            statement.setInt(8, address.getAddressID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        log.info("updateAccount end");
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
        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        log.info("deleteAdress stop");

    }

    @Override
    public Integer addAddressType(AddressTypePOJO address) {
        Integer newID = 0;

        log.info("addaddresstype Start");
        String insertOrder = "INSERT INTO addressType"
                + "(type) VALUES "
                + "(?);";
        try {
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
        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        log.info("addaddresstype end");
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
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        log.info("getaddressType end");
        return foundAddressType;
    }

    @Override
    public void updateAddressType(AddressTypePOJO address) {
        log.info("updateAddressType Start");

        String query = "UPDATE AddressType SET Type = ?, WHERE AddressTypeID=?"; 
        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setString(1, address.getAddressType());
            statement.setInt(2, address.getAddressTypeID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        log.info("updateAddressType end");
    }

    @Override
    public void deleteAddressType(AddressTypePOJO address) {
        log.info("deleteaddresstype Start");
        String query = "select * from Address where AddressType_AddressTypeID = ?";
        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setInt(1, address.getAddressTypeID());
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                query = "select * from AddressType where AddressTypeID = ?";
                statement = connect.prepareStatement(query);
                statement.setInt(1, address.getAddressTypeID());
                statement.executeUpdate();
            } else {
                System.out.println("AddressType is currently in use, delete not possible.");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        log.info("deleteaddresstype end");
    }

}
