package lk.jiat.ims.validate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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

    // ── Username Tests ──────────────────────────────────────────────────────

    @Test
    public void testIsUsernameValid_emptyInput() {
        // Empty string should fail validation
        boolean result = Validator.isUsernameValid("");
        assertFalse(result);
    }

    @Test
    public void testIsUsernameValid_validUsername() {
        // Valid username should pass
        boolean result = Validator.isUsernameValid("ayomal111");
        assertTrue(result);
    }

    @Test
    public void testIsUsernameValid_tooShort() {
        // Less than 4 characters should fail
        boolean result = Validator.isUsernameValid("ab");
        assertFalse(result);
    }

    @Test
    public void testIsUsernameValid_specialCharsNotAllowed() {
        // Special characters like @ should fail
        boolean result = Validator.isUsernameValid("user@123");
        assertFalse(result);
    }

    // ── Mobile Tests ─────────────────────────────────────────────────────────

    @Test
    public void testIsMobielValid_emptyInput() {
        boolean result = Validator.isMobielValid("");
        assertFalse(result);
    }

    @Test
    public void testIsMobielValid_validNumber() {
        boolean result = Validator.isMobielValid("0771234567");
        assertTrue(result);
    }

}