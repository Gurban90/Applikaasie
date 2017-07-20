/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DatabaseConnector.Connector;
import POJO.CheesePOJO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class CheeseDAOTest {
    CheeseDAO cheesedao = new CheeseDAO();
    private Connection connection;
    public CheeseDAOTest() {
    }
    
    
    @Test
    public void testAddCheese(){ 
    CheesePOJO cheese = new CheesePOJO();
    cheese.setCheeseName("Gouda");
    cheese.setPrice(new BigDecimal("13"));
    cheese.setStock(5);
    
    
    cheesedao.addCheese(cheese);
    
    try {
            connection = Connector.getConnection();
            String query = "SELECT * FROM Cheese where Name = 'Gouda'"; 
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            resultset.next();
            assertEquals("Gouda", resultset.getString(2));
			assertEquals(new BigDecimal("13"), resultset.getBigDecimal(3));
			assertEquals(5, resultset.getInt(4));
    }
    catch (SQLException ex) {
			ex.printStackTrace();
    }
    }
            
            
    
    

    /**
     * Test of getAllCheese method, of class CheeseDAO.
     */
    @Test
    public void testGetAllCheese() {
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCheese method, of class CheeseDAO.
     */
    @Test
    public void testGetCheese() {
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCheese method, of class CheeseDAO.
     */
    @Test
    public void testUpdateCheese() {
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCheese method, of class CheeseDAO.
     */
    @Test
    public void testDeleteCheese() {
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
