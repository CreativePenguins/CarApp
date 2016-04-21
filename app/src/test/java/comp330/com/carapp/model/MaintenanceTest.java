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
    protected Maintenance m;
    @Before
    public void setUp() { m = new Maintenance(); }

    @After
    public void tearDown() {
        m = null;
    }

    @Test
    public void testType() {
        m.setType("Oil Change");
        assertEquals(m.getType(), "Oil Change");
        assertFalse(m.getType() == "Inspection");

    }

    @Test
    public void testValue() {

    }

    @Test
    public void testDetail() {

    }
}