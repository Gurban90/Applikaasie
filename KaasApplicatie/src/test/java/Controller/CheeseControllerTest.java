/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interface.AccountDAOInterface;
import Interface.CheeseDAOInterface;
import POJO.AccountPOJO;
import POJO.CheesePOJO;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Gerben
 */
public class CheeseControllerTest {
    
    public CheeseControllerTest() {
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
     * Test of findAllCheese method, of class CheeseController.
     */
    @Test
    public void testFindAllCheese() {
          CheesePOJO cheesepojo = new CheesePOJO();
        CheeseDAOInterface cheesedaoMock = mock(CheeseDAOInterface.class);
                List<CheesePOJO> expResult = null;
        CheeseController instance = new CheeseController(cheesedaoMock);
        when(cheesedaoMock.getAllCheese()).thenReturn(expResult);
        
        List<CheesePOJO> result = instance.findAllCheese();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findCheese method, of class CheeseController.
     */
    @Test
    public void testFindCheese() {
        System.out.println("findCheese");
        int ID = 0;
        CheeseController instance = new CheeseController();
        CheesePOJO expResult = null;
        CheesePOJO result = instance.findCheese(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCheeseWithName method, of class CheeseController.
     */
    @Test
    public void testFindCheeseWithName() {
        System.out.println("findCheeseWithName");
        String name = "";
        CheeseController instance = new CheeseController();
        CheesePOJO expResult = null;
        CheesePOJO result = instance.findCheeseWithName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newCheese method, of class CheeseController.
     */
    @Test
    public void testNewCheese() {
        CheesePOJO cheesepojo = new CheesePOJO();
        CheeseDAOInterface cheesedaoMock = mock(CheeseDAOInterface.class);
        
        
        String name = "GG";
        BigDecimal price = null;
        int stock = 3;
        CheeseController instance = new CheeseController(cheesedaoMock, cheesepojo);
        when(cheesedaoMock.addCheese(cheesepojo)).thenReturn(10);
        
        int id = instance.newCheese(name, price, stock);
        assertEquals(10, id);
        
    }

    /**
     * Test of removeCheese method, of class CheeseController.
     */
    @Test
    public void testRemoveCheese() {
        System.out.println("removeCheese");
        int ID = 0;
        CheeseController instance = new CheeseController();
        instance.removeCheese(ID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editCheese method, of class CheeseController.
     */
    @Test
    public void testEditCheese() {
        System.out.println("editCheese");
        int id = 0;
        String name = "";
        BigDecimal price = null;
        int stock = 0;
        CheeseController instance = new CheeseController();
        String expResult = "";
        String result = instance.editCheese(id, name, price, stock);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editCheeseName method, of class CheeseController.
     */
    @Test
    public void testEditCheeseName() {
        System.out.println("editCheeseName");
        int id = 0;
        String name = "";
        CheeseController instance = new CheeseController();
        String expResult = "";
        String result = instance.editCheeseName(id, name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editCheesePrice method, of class CheeseController.
     */
    @Test
    public void testEditCheesePrice() {
        System.out.println("editCheesePrice");
        int id = 0;
        BigDecimal price = null;
        CheeseController instance = new CheeseController();
        String expResult = "";
        String result = instance.editCheesePrice(id, price);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editCheeseStock method, of class CheeseController.
     */
    @Test
    public void testEditCheeseStock() {
        System.out.println("editCheeseStock");
        int id = 0;
        int stock = 0;
        CheeseController instance = new CheeseController();
        String expResult = "";
        String result = instance.editCheeseStock(id, stock);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
