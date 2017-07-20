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
    public void testAddCheese() {
        CheesePOJO cheese = new CheesePOJO();
        cheese.setCheeseName("Gouda");
        cheese.setPrice(new BigDecimal("13"));
        cheese.setStock(5);

        cheesedao.addCheese(cheese);

        try {
            connection = Connector.getConnection();
            String query = "SELECT * FROM Cheese";
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            resultset.next();
            assertEquals("Gouda", resultset.getString(2));
            assertEquals(new BigDecimal("13"), resultset.getBigDecimal(3));
            assertEquals(5, resultset.getInt(4));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Test of getAllCheese method, of class CheeseDAO.
     */
    @Test
    public void testGetAllCheese() {
        cheesedao.getAllCheese();

        try {
            connection = Connector.getConnection();
            String query = "SELECT * FROM Cheese";
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            resultset.next();
            assertEquals("Gouda", resultset.getString(2));
            assertEquals(new BigDecimal("13"), resultset.getBigDecimal(3));
            assertEquals(5, resultset.getInt(4));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Test of getCheese method, of class CheeseDAO.
     */
    @Test
    public void testGetCheese() {
        CheesePOJO cheese2 = new CheesePOJO();
        cheese2.setCheeseName("Bobo");
        cheese2.setPrice(new BigDecimal("14"));
        cheese2.setStock(6);

        cheesedao.getCheese(cheese2);

        try {
            connection = Connector.getConnection();
            String query = "SELECT * FROM Cheese WHERE Name = Bobo";
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            resultset.next();
            assertEquals("Bobo", resultset.getString(2));
            assertEquals(new BigDecimal("14"), resultset.getBigDecimal(3));
            assertEquals(6, resultset.getInt(4));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testUpdateCheese() {
        CheesePOJO cheese3 = new CheesePOJO();
        cheese3.setCheeseID(2);
        cheese3.setCheeseName("Gobo");
        cheese3.setPrice(new BigDecimal("14"));
        cheese3.setStock(6);

        cheesedao.updateCheese(cheese3);

        try {
            connection = Connector.getConnection();
            String query = "SELECT * FROM Cheese WHERE CheeseID = 2";
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            resultset.next();
            assertEquals("Gobo", resultset.getString(2));
            assertEquals(new BigDecimal("14"), resultset.getBigDecimal(3));
            assertEquals(6, resultset.getInt(4));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testDeleteCheese() {

        CheesePOJO cheese4 = new CheesePOJO();
        cheese4.setCheeseID(2);

        cheesedao.deleteCheese(cheese4);
        
        try {
            connection = Connector.getConnection();
            String query = "SELECT * FROM Cheese WHERE CheeseID = 2";
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            resultset.next();
            assertEquals(null, resultset.getString("Name"));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
