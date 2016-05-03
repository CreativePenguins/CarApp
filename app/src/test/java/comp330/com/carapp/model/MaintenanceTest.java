package comp330.com.carapp.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import comp330.com.carapp.model.Maintenance;
import comp330.com.carapp.model.MaintenanceInterface;
import comp330.com.carapp.model.Mileage;
import comp330.com.carapp.model.MileageInterface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the maintenance interface in model
 */

public class MaintenanceTest {
    protected MaintenanceInterface m;
    MileageInterface mileage = new Mileage();
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

    @Test
    public void testMileage() {
        mileage.setMileage(4284);
        mileage.setDate("02/3/2016");
        mileage.setVehicleID("1HGCM82633A004352");
        assertEquals(mileage.getMileage(), 4284);
        assertFalse(mileage.getMileage().equals(5867));
        assertEquals(mileage.getDate(), "02/3/2016");
        assertFalse(mileage.getDate().equals("05/13/2016"));
        assertEquals(mileage.getVehicleID(), "1HGCM82633A004352");
        assertFalse(mileage.getVehicleID().equals("4R8JG49SAQ21G9LO6"));

    }
}