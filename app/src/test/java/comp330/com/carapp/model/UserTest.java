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

    protected UserInterface user = null;
    protected VehicleInterface usersVehicle = null;
    protected VehicleInterface newVehicle = null;

    @Before
    public void setUp() {
        user = new User();
        usersVehicle = new Vehicle();
        usersVehicle.setVIN("1HGCM82633A004351");
        user.addVehicle(usersVehicle);

        //vehicle to be added in test
        newVehicle = new Vehicle();
    }

    @After
    public void tearDown() {
        user = null;
        usersVehicle = null;
    }

    @Test
    public void testName() {
        user.setName("Akshar");
        assertEquals("Akshar", user.getName());
    }

    @Test
    public void testUsername() {
        user.setUsername("akumar6");
        assertEquals("akumar6", user.getUsername());
    }

    @Test
    public void testPassword() {
        user.setPassword("password123");
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testLicenseNo() {
        user.setLicNo("K1234567890");
        assertEquals("K1234567890", user.getLicNo());
    }

    @Test
    public void testImageURL() {
        user.setImageURL("www.google.com/images");
        assertEquals("www.google.com/images", user.getImageURL());
    }

    @Test
    public void testAddVehicle() {
        newVehicle.setVIN("2HGCM82633A004352");
        user.addVehicle(newVehicle);
        assertEquals(newVehicle, user.getVehicles().get("2HGCM82633A004352"));
    }

    @Test
    public void testRemoveVehicle() {
        user.removeVehicle(usersVehicle);
        assertEquals(0, user.getVehicles().size());
    }
}