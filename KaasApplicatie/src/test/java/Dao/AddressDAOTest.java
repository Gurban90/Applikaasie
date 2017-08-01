    //adds before  addressid 1 (Houtwal, 12,  ,1234AB , Vlissingen)
    //adds addressid 2 (telderslaan, 62, ,3527KH, Utrecht) 




package Dao;

import DatabaseConnector.Connector;
import POJO.AddressPOJO;
import POJO.AddressTypePOJO;
import POJO.ClientPOJO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jasper Thielen
 */
public class AddressDAOTest {
    
    public AddressDAOTest() {
    }

    AddressDAO AddressDAO = new AddressDAO(); 
    private Connection connect;

    
    
    @Before
    public void before() {
       
        try {
            connect = Connector.getConnection();
            Statement statement = connect.createStatement();
            String query = "INSERT INTO Address (Streetname , HouseNumber, HouseNumberAddition, PostalCode, City) VALUES (Houtwal, 12 ,  , 1234AB , Vlissingen)";
            statement.executeUpdate(query);
            connect.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    @After
    public void after() {
        try {
            connect = Connector.getConnection();
            Statement statement = connect.createStatement();
            String query = "DELETE FROM Address";
            String query2 = "ALTER TABLE Address AUTO_INCREMENT = 1";   //why......? (tells the program to keep skipping to next id?)
            statement.addBatch(query);
            statement.addBatch(query2);
            statement.executeBatch();
            //connect.commit(); is autocommit on?
            connect.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public void testAddAddress() {
        
        AddressPOJO Address = new AddressPOJO();
        ClientPOJO client = new ClientPOJO();
        AddressTypePOJO type = new AddressTypePOJO();
        
        
        //client
        client.setClientID(2);
        
        //addresstype
        type.setAddressTypeID(1);
        
      
        Address.setStreetName("telderslaan");
        Address.setHouseNumber(62);
        Address.setHouseNumberAddition("");
        Address.setPostalCode("3527 KH");
        Address.setCity("Utrecht");
        Address.setClient(client);
        Address.setAddresstype(type);
        
        AddressDAO.addAddress(Address);
       
        try {
            connect = Connector.getConnection();
            String query = "SELECT * FROM Address WHERE AddressID = 2";
            Statement statement = connect.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            resultset.next();
            assertEquals("telderslaan" , resultset.getString(2));
            assertEquals(62 , resultset.getInt(3));
            assertEquals("", resultset.getString(4));
            assertEquals("3527 KH", resultset.getString(5));
            assertEquals("Utrecht", resultset.getString(6));
            
            connect.close();
            resultset.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testGetAddress() {
        AddressPOJO address = new AddressPOJO();
        address.setAddressID(2);
        AddressPOJO test = AddressDAO.getAddress(address);
        

        assertEquals(2, test.getAddressID());
        assertEquals("telderslaan" , test.getStreetName());
        assertEquals(62 , test.getHouseNumber());
        assertEquals("", test.getHouseNumberAddition());
        assertEquals("3527 KH", test.getPostalCode());
        assertEquals("Utrecht", test.getCity());
    }

    @Test
    public void testGetAddressWithClient() {

        
        ClientPOJO client = new ClientPOJO();
        client.setClientID(2);
        /*List<AddressPOJO> test */ 
        AddressDAO.getAddressWithClient(client);
        
        try {
            connect = Connector.getConnection();
            String query = "SELECT * FROM Address WHERE Client_ClientID = 2";
            Statement statement = connect.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            resultset.next();
            
            assertEquals(1 , resultset.getInt(1)); 
            assertEquals("telderslaan" , resultset.getString(2));
            assertEquals(62 , resultset.getInt(3));
            assertEquals("", resultset.getString(4));
            assertEquals("3527 KH", resultset.getString(5));
            assertEquals("Utrecht", resultset.getString(6));
            
            connect.close();
            resultset.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
    
    @Test
    public void testGetAllAddress() {
        AddressDAO.getAllAddress();

        try {
            connect = Connector.getConnection();
            String query = "SELECT * FROM Address";
            Statement statement = connect.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            resultset.next();
            
            //iff not correct, increase count assertEquals 1 klopt wel rest niet?
            assertEquals(1 , resultset.getInt(1)); 
            assertEquals("telderslaan" , resultset.getString(2));
            assertEquals(62 , resultset.getInt(3));
            assertEquals("", resultset.getString(4));
            assertEquals("3527 KH", resultset.getString(5));
            assertEquals("Utrecht", resultset.getString(6));
            
            connect.close();
            resultset.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }

    @Test
    public void testUpdateAddress() {
        AddressPOJO address = new AddressPOJO();
        address.setAddressID(1);
        address.setPostalCode("4321BA");


        AddressDAO.updateAddress(address);

        try {
            connect = Connector.getConnection();
            String query = "SELECT * FROM Address WHERE AddressID = 1";
            Statement statement = connect.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            resultset.next();
            
            assertEquals("4321BA", resultset.getString(4));

            
            connect.close();
            resultset.close();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testDeleteAddress() {
    
        AddressPOJO address = new AddressPOJO();
        address.setAddressID(2);

        AddressDAO.deleteAddress(address);

        try {
            connect = Connector.getConnection();
            String query = "SELECT * FROM address WHERE addressID = 2";
            Statement statement = connect.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            resultset.next();
            
            assertEquals(null, resultset.getString(1));
            
            connect.close();
            resultset.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }     
    

    @Test
    public void testAddAddressType() {
    
    
    }

    @Test
    public void testGetAllAddressType() {
    }


    @Test
    public void testGetAddressType() {
    }

    @Test
    public void testUpdateAddressType() {
    }

    @Test
    public void testDeleteAddressType() {
        AddressPOJO address = new AddressPOJO();
        address.setAddressID(2);

        AddressDAO.deleteAddress(address);

        try {
            connect = Connector.getConnection();
            String query = "SELECT * FROM address WHERE addressID = 2";
            Statement statement = connect.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            resultset.next();
            
            assertEquals(null, resultset.getString(1));
            
            connect.close();
            resultset.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
