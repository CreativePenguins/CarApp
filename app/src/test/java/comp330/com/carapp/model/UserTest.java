package comp330.com.carapp.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by aksharkumar on 3/31/16.
 */
public class UserTest {
    protected UserInterface u;

    @Before
    public void setUp() {
        u = new User();
    }

    @After
    public void tearDown() {
        u = null;
    }

    @Test
    public void testUsername() {
        u.setUsername("akumar6");
        assertEquals(u.getUsername(), "akumar6");
    }

    @Test
    public void testPassword() {
        u.setPassword("password123");
        assertEquals(u.getPassword(), "password123");
    }

    @Test
    public void testExample() {
        u.setUsername("carUser");
        u.setPassword("1234");
        VehicleInterface v = new Vehicle();
        v.setVIN("1HGCM82633A004352");
        v.setMake("BMW");
        v.setModel("528i");
        v.setColor("Black");
        u.addVehicle(v);
        assertTrue(u.getVehicle("1HGCM82633A004352").equals(v));
    }
}