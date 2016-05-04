package comp330.com.carapp.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Tests for the vehicle interface in model
 */
public class VehicleTest {

    protected VehicleInterface vehicle = null;

    @Before
    public void setUp() {
        vehicle = new Vehicle();
    }

    @After
    public void tearDown() {
        vehicle = null;
    }

    @Test
    public void testName() {
        vehicle.setName("MyNissan");
        assertEquals("MyNissan", vehicle.getName());
    }

    @Test
    public void testMake() {
        vehicle.setMake("Nissan");
        assertEquals(vehicle.getMake(), "Nissan");
    }

    @Test
    public void testModel() {
        vehicle.setModel("Altima");
        assertEquals(vehicle.getModel(), "Altima");
    }

    @Test
    public void testYear() {
        vehicle.setYear(1994);
        assertTrue(vehicle.getYear() == 1994);
    }

    @Test
    public void testVIN() {
        vehicle.setVIN("1HGCM82633A004352");
        assertTrue(vehicle.getVIN().equals("1HGCM82633A004352"));
    }

    @Test
    public void testColor(){
        vehicle.setColor("Red");
        assertTrue(vehicle.getColor().equals("Red"));
    }

    @Test
    public void testLicensePlate() {
        vehicle.setLicensePlate("0000000");
        assertEquals("0000000", vehicle.getLicensePlate());
    }
}
