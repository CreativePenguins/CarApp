package comp330.com.carapp.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import comp330.com.carapp.model.Maintenance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by rohangrover on 4/20/16.
 */

public class MaintenanceTest {
    protected MaintenanceInterface m;
    @Before
    public void setUp() { m = new Maintenance(); }

    @After
    public void tearDown() {
        m = null;
    }

    @Test
    public void testType() {
        m.setType("Tires");
        assertEquals(m.getType(), "Tires");
        assertFalse(m.getType().equals("Oil Change"));
    }

    @Test
    public void testValue() {
        m.setValue("Tires Rotated");
        assertEquals(m.getValue(), "Tires Rotated");
        assertFalse(m.getValue().equals("Standard Oil"));
    }

    @Test
    public void testDetail() {
        m.setDetails("Tires Swapped (Front and Back)");
        assertEquals(m.getDetails(), "Tires Swapped (Front and Back)");
        assertFalse(m.getDetails().equals("Brakes Check"));
    }
}