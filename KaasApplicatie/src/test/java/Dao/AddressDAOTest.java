/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import POJO.AddressPOJO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gerben
 */
public class AddressDAOTest {
    
    public AddressDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addAddress method, of class AddressDAO.
     */
    @Test
    public void testAddAddress() {
        System.out.println("addAddress");
        AddressPOJO address = null;
        AddressDAO instance = new AddressDAO();
        Integer expResult = null;
        Integer result = instance.addAddress(address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class AddressDAO.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        AddressPOJO address = null;
        AddressDAO instance = new AddressDAO();
        AddressPOJO expResult = null;
        AddressPOJO result = instance.getAddress(address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllAddress method, of class AddressDAO.
     */
    @Test
    public void testGetAllAddress() {
        System.out.println("getAllAddress");
        AddressDAO instance = new AddressDAO();
        List<AddressPOJO> expResult = null;
        List<AddressPOJO> result = instance.getAllAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateAddress method, of class AddressDAO.
     */
    @Test
    public void testUpdateAddress() {
        System.out.println("updateAddress");
        int addressID = 0;
        int housenumber = 0;
        String houseNumberAddition = "";
        String streetname = "";
        String postalCode = "";
        String city = "";
        String deliveryHouseNumber = "";
        String deliveryStreetName = "";
        String deliveryPostalCode = "";
        String deliveryCity = "";
        AddressDAO instance = new AddressDAO();
        instance.updateAddress(addressID, housenumber, houseNumberAddition, streetname, postalCode, city, deliveryHouseNumber, deliveryStreetName, deliveryPostalCode, deliveryCity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAddress method, of class AddressDAO.
     */
    @Test
    public void testDeleteAddress() {
        System.out.println("deleteAddress");
        AddressPOJO address = null;
        AddressDAO instance = new AddressDAO();
        instance.deleteAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
