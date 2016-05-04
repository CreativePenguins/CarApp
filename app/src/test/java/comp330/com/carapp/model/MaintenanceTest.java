package comp330.com.carapp.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        assertEquals( "Tires", maintenance.getType());
    }

    @Test
    public void testMaintValue() {
        maintenance.setValue("Tires Rotated");
        assertEquals("Tires Rotated", maintenance.getValue());
    }

    @Test
    public void testMaintDetail() {
        maintenance.setDetails("Tires Swapped (Front and Back)");
        assertEquals("Tires Swapped (Front and Back)", maintenance.getDetails());
    }

    @Test
    public void testMaintMileage() {
        mileage.setMileage(4284);
        maintenance.setMileage(mileage);
        assertEquals(4284, maintenance.getMileage().getMileage());
    }

    @Test
    public void testMaintMileageDate() {
        mileage.setDate("02/3/2016");
        maintenance.setMileage(mileage);
        assertEquals("02/3/2016", maintenance.getMileage().getDate());
    }

    @Test
    public void testMaintMileageVehicleID() {
        mileage.setVehicleID(5);
        maintenance.setMileage(mileage);
        assertEquals(5, maintenance.getMileage().getVehicleID());
    }

}