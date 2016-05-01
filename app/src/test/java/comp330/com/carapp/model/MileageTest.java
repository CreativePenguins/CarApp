package comp330.com.carapp.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import comp330.com.carapp.model.Maintenance;
import comp330.com.carapp.model.Mileage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the mileage interface in model
 */

public class MileageTest {
    protected MileageInterface m;
    @Before
    public void setUp() {
        m = new Mileage();
    }

    @After
    public void tearDown() {
        m = null;
    }

    @Test
    public void testDate() {
        m.setDate("02/3/2016");
        assertEquals(m.getDate(), "02/3/2016");
        assertFalse(m.getDate().equals("01/01/2014"));
    }

    @Test
    public void testMileage() {
        m.setMileage(4284);
        assertEquals(m.getMileage(), 4284);
        assertFalse(m.getMileage() == 2019);
    }

}