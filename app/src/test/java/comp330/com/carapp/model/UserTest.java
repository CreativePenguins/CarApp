package comp330.com.carapp.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the user interface in model
 */
public class UserTest {

    protected UserInterface user;

    @Before
    public void setUp() {
        user = new User();
    }

    @After
    public void tearDown() {
        user = null;
    }

    @Test
    public void testUsername() {
        user.setUsername("akumar6");
        assertEquals(user.getUsername(), "akumar6");
    }

    @Test
    public void testPassword() {
        user.setPassword("password123");
        assertEquals(user.getPassword(), "password123");
    }

    @Test
    public void testVehicle() {
        user.setUsername("carUser");
        user.setPassword("1234");
        VehicleInterface v = new Vehicle();
        v.setVIN("1HGCM82633A004352");
        v.setMake("BMW");
        v.setModel("528i");
        v.setColor("Black");
        user.addVehicle(v);
        assertTrue(user.getVehicle("1HGCM82633A004352").equals(v));
    }
}