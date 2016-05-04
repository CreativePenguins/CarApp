package comp330.com.carapp.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the maintenance interface in model
 */

public class MaintenanceTest {
    protected MaintenanceInterface maintenance;
    protected MileageInterface mileage;

    @Before
    public void setUp() {
        maintenance = new Maintenance();
        mileage = new Mileage();
    }

    @After
    public void tearDown() {
        maintenance = null;
        mileage = null;
    }

    @Test
    public void testType() {
        maintenance.setType("Tires");
        assertEquals(maintenance.getType(), "Tires");
        assertFalse(maintenance.getType().equals("Oil Change"));
    }

    @Test
    public void testValue() {
        maintenance.setValue("Tires Rotated");
        assertEquals(maintenance.getValue(), "Tires Rotated");
        assertFalse(maintenance.getValue().equals("Standard Oil"));
    }

    @Test
    public void testDetail() {
        maintenance.setDetails("Tires Swapped (Front and Back)");
        assertEquals(maintenance.getDetails(), "Tires Swapped (Front and Back)");
        assertFalse(maintenance.getDetails().equals("Brakes Check"));
    }

    @Test
    public void testMileage() {
        mileage.setMileage(4284);
        mileage.setDate("02/3/2016");
        mileage.setVehicleID(5);
        maintenance.setMileage(mileage);
        assertEquals(maintenance.getMileage().getMileage(), 4284);
        assertFalse(maintenance.getMileage().getMileage() == (5867));
        assertEquals(maintenance.getMileage().getDate(), "02/3/2016");
        assertFalse(maintenance.getMileage().getDate().equals("05/13/2016"));
        assertEquals(maintenance.getMileage().getVehicleID(), 5);
        assertFalse(maintenance.getMileage().getVehicleID() == 9);
    }
}