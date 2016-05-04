package comp330.com.carapp.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the mileage interface in model
 */

public class MileageTest {

    protected MileageInterface mileage;
    
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
        assertEquals(mileage.getDate(), "02/3/2016");
        assertFalse(mileage.getDate().equals("01/01/2014"));
    }

    @Test
    public void testMileage() {
        mileage.setMileage(4284);
        assertEquals(mileage.getMileage(), 4284);
        assertFalse(mileage.getMileage() == 2019);
    }
}