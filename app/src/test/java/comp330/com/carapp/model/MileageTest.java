package comp330.com.carapp.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the mileage interface in model
 */

public class MileageTest {

    protected MileageInterface mileage = null;
    
    @Before
    public void setUp() {
        mileage = new Mileage();
    }

    @After
    public void tearDown() {
        mileage = null;
    }

    @Test
    public void testDate() {
        mileage.setDate("02/3/2016");
        assertEquals("02/3/2016", mileage.getDate());
    }

    @Test
    public void testMileage() {
        mileage.setMileage(4284);
        assertEquals(4284, mileage.getMileage());
    }

    @Test
    public void testMileageVehicleID() {
        mileage.setVehicleID(7);
        assertEquals(7, mileage.getVehicleID());
    }
}