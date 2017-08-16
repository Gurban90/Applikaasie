/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AccountDAO;
import Interface.AccountDAOInterface;
import Menu.MainMenu;
import POJO.AccountPOJO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

/**
 *
 * @author Gerben
 */
public class AccountControllerTest {

    public AccountControllerTest() {
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
     * Test of login method, of class AccountController.
     */
    @Test
    public void testLogin() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of newAccount method, of class AccountController.
     */
    @Test
    public void testNewAccount() {
        AccountPOJO accountpojo = new AccountPOJO();

        String name = "Bob";
        String password = "P";
        int status = 0;
        AccountDAOInterface accountdaomock = mock(AccountDAOInterface.class);
        AccountController instance = new AccountController(accountdaomock, accountpojo);
        when(accountdaomock.addAccount(accountpojo)).thenReturn(10);

        int id = instance.newAccount(name, password, status);

        assertEquals(10, id);
    }

    /**
     * Test of removeAccount method, of class AccountController.
     */
    @Test
    public void testRemoveAccount() {
        AccountPOJO accountpojo = new AccountPOJO();
        AccountPOJO accountpojo2 = new AccountPOJO();
        accountpojo2.setAccountID(1);
        accountpojo2.setAccountPassword("Password");
        int id = 1;
        String password = "Password";

        AccountDAOInterface accountdaomock = mock(AccountDAOInterface.class);
        AccountController instance = new AccountController(accountdaomock, accountpojo);
        when(accountdaomock.getAccount(accountpojo)).thenReturn(accountpojo2);
        doNothing().when(accountdaomock).deleteAccount(accountpojo);

        assertEquals(accountpojo2.getAccountID(), id);

        instance.removeAccount(id, password);

    }

    /**
     * Test of updateAccountCheck method, of class AccountController.
     */
    @Test
    public void testUpdateAccountCheck() {
        System.out.println("updateAccountCheck");
        int id = 0;
        String password = "";
        AccountController instance = new AccountController();
        instance.updateAccountCheck(id, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateAccount method, of class AccountController.
     */
    @Test
    public void testUpdateAccount() {
        System.out.println("updateAccount");
        String name = "";
        String password = "";
        int status = 0;
        AccountController instance = new AccountController();
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editAccountName method, of class AccountController.
     */
    @Test
    public void testEditAccountName() {
        System.out.println("editAccountName");
        int id = 0;
        String name = "";
        AccountController instance = new AccountController();
        instance.editAccountName(id, name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editAccountPassword method, of class AccountController.
     */
    @Test
    public void testEditAccountPassword() {
        System.out.println("editAccountPassword");
        int id = 0;
        String password = "";
        AccountController instance = new AccountController();
        instance.editAccountPassword(id, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editAccountStatus method, of class AccountController.
     */
    @Test
    public void testEditAccountStatus() {
        System.out.println("editAccountStatus");
        int id = 0;
        int status = 0;
        AccountController instance = new AccountController();
        instance.editAccountStatus(id, status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAccount method, of class AccountController.
     */
    @Test
    public void testFindAccount() {
        AccountPOJO accountpojo = new AccountPOJO();
        AccountDAOInterface accountdaomock = mock(AccountDAOInterface.class);
        AccountController instance = new AccountController(accountdaomock);
        when(accountdaomock.getAccount(accountpojo)).thenReturn(accountpojo);
        int id = 2;
        String password = "Pass";

        
        

    }

    /**
     * Test of findAccountWithName method, of class AccountController.
     */
    @Test
    public void testFindAccountWithName() {
        System.out.println("findAccountWithName");
        int id = 0;
        String password = "";
        String name = "";
        AccountController instance = new AccountController();
        instance.findAccountWithName(id, password, name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllAccounts method, of class AccountController.
     */
    @Test
    public void testGetAllAccounts() {
        System.out.println("getAllAccounts");
        int id = 0;
        String password = "";
        AccountController instance = new AccountController();
        instance.getAllAccounts(id, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
