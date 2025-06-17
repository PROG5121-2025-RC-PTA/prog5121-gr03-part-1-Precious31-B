/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package loginandsignup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author masho
 */
public class LoginandSignUpIT {
    
    public LoginandSignUpIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setFirstName method, of class LoginandSignUp.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String fname = "";
        LoginandSignUp.setFirstName(fname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class LoginandSignUp.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "";
        String result = LoginandSignUp.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserName method, of class LoginandSignUp.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String username = "";
        LoginandSignUp.setUserName(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserName method, of class LoginandSignUp.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        String expResult = "";
        String result = LoginandSignUp.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class LoginandSignUp.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String passw0rd = "";
        LoginandSignUp.setPassword(passw0rd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class LoginandSignUp.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String expResult = "";
        String result = LoginandSignUp.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastname method, of class LoginandSignUp.
     */
    @Test
    public void testSetLastname() {
        System.out.println("setLastname");
        String lname = "";
        LoginandSignUp.setLastname(lname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastname method, of class LoginandSignUp.
     */
    @Test
    public void testGetLastname() {
        System.out.println("getLastname");
        String expResult = "";
        String result = LoginandSignUp.getLastname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCellNumber method, of class LoginandSignUp.
     */
    @Test
    public void testSetCellNumber() {
        System.out.println("setCellNumber");
        String cellphonenumber = "";
        LoginandSignUp.setCellNumber(cellphonenumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCellNumber method, of class LoginandSignUp.
     */
    @Test
    public void testGetCellNumber() {
        System.out.println("getCellNumber");
        String expResult = "";
        String result = LoginandSignUp.getCellNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class LoginandSignUp.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        LoginandSignUp.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
