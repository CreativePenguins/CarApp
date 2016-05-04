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
    protected MaintenanceInterface maintenance = null;
    protected MileageInterface mileage = null;

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
    public void testMaintType() {
        maintenance.setType("Tires");
        assertEquals(maintenance.getType(), "Tires");
    }

    @Test
    public void testMaintValue() {
        maintenance.setValue("Tires Rotated");
        assertEquals(maintenance.getValue(), "Tires Rotated");
    }

    @Test
    public void testMaintDetail() {
        maintenance.setDetails("Tires Swapped (Front and Back)");
        assertEquals(maintenance.getDetails(), "Tires Swapped (Front and Back)");
    }

    @Test
    public void testMaintMileage() {
        mileage.setMileage(4284);
        maintenance.setMileage(mileage);
        assertEquals(maintenance.getMileage().getMileage(), 4284);
    }

    @Test
    public void testMaintMileageDate() {
        mileage.setDate("02/3/2016");
        maintenance.setMileage(mileage);
        assertEquals(maintenance.getMileage().getDate(), "02/3/2016");
    }

    @Test
    public void testMaintMileageVehicleID() {
        mileage.setVehicleID(5);
        maintenance.setMileage(mileage);
        assertEquals(maintenance.getMileage().getVehicleID(), 5);
    }

}