/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package lk.jiat.ims.validate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ayomal Kaushalya
 */
public class ValidatorTest {
    
    public ValidatorTest() {
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
     * Test of isEmailValid method, of class Validator.
     */
    @Test
    public void testIsEmailValid() {
        System.out.println("isEmailValid");
        String value = "";
        boolean expResult = false;
        boolean result = Validator.isEmailValid(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isMobielValid method, of class Validator.
     */
    @Test
    public void testIsMobielValid() {
        System.out.println("isMobielValid");
        String value = "";
        boolean expResult = false;
        boolean result = Validator.isMobielValid(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPasswordValid method, of class Validator.
     */
    @Test
    public void testIsPasswordValid() {
        System.out.println("isPasswordValid");
        String value = "";
        boolean expResult = false;
        boolean result = Validator.isPasswordValid(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
