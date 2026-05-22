/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registration;

import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class LoginTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testRegisterAndLogin() {
        String simulatedInput = "myUser\nStrongPass123\n0123456789\n"; // username, password, phone
        Scanner sc = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        
        Login login = new Login();
        login.register(sc);
        
        assertTrue(login.isUserRegistered("myUser"));
        
        // simulate login
        String loginInput = "myUser\nStrongPass123\n";
        Scanner scLogin = new Scanner(new ByteArrayInputStream(loginInput.getBytes()));
        login.login(scLogin);
        
        assertTrue(login.isLoggedIn());
    }

    @Test
    public void testCheckPassword() {
        Login login = new Login();
        assertFalse(login.checkPassword("short"));
        assertTrue(login.checkPassword("LongEnough123"));
    }

    @Test
    public void testCheckPhone() {
        Login login = new Login();
        assertFalse(login.checkPhone("123")); // too short
        assertTrue(login.checkPhone("0123456789")); // correct
    }

    @Test
    public void testCheckUserName() {
        Login login = new Login();
        assertFalse(login.checkUserName("a")); // too short
        assertTrue(login.checkUserName("abc123")); // correct
    }

    /**
     * Test of register method, of class Login.
     */
    @org.junit.Test
    public void testRegister() {
        System.out.println("register");
        Scanner sc = null;
        Login instance = new Login();
        instance.register(sc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class Login.
     */
    @org.junit.Test
    public void testLogin() {
        System.out.println("login");
        Scanner sc = null;
        Login instance = new Login();
        instance.login(sc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isUserRegistered method, of class Login.
     */
    @org.junit.Test
    public void testIsUserRegistered() {
        System.out.println("isUserRegistered");
        String username = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.isUserRegistered(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isLoggedIn method, of class Login.
     */
    @org.junit.Test
    public void testIsLoggedIn() {
        System.out.println("isLoggedIn");
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.isLoggedIn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}