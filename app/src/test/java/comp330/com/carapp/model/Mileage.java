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
 * Created by rohangrover on 4/20/16.
 */

public class MileageTest {
    protected Mileage m;
    @Before
    public void setUp() { m = new Mileage(); }

    @After
    public void tearDown() { m = null; }

    @Test
    public void testDate() {
        m.setDate("02/3/2016");
        assertEquals(m.getDate(), "02/3/2016");
        assertFalse(m.getDate() == "01/01/2014");
    }

    @Test
    public void testMileage() {
        m.setMileage("4284");
        assertEquals(m.getMileage(), "4284");
        assertFalse(m.getMileage() == "2019");
    }

    @Test
    public void testVehicleID() {
        m.setVehicleID("2G5HK690LS3949HUQ");
        assertEquals(m.getVehicleID(), "2G5HK690LS3949HUQ");
        assertFalse(m.setVehicleID() == "2XMI10RK5Y6FIWHR3");

    }





}