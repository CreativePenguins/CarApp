package comp330.com.carapp.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the vehicle settings interface in model
 */
public class VehicleSettingsTest {

    protected VehicleSettingsInterface vehicleSettings = null;

    @Before
    public void setUp() {
        vehicleSettings = new VehicleSettings();
    }

    @After
    public void tearDown() {
        vehicleSettings = null;
    }

    @Test
    public void testMileageUpdateFreq() {
        vehicleSettings.setMileageUpdateFreq(7);
        assertEquals(7, vehicleSettings.getMileageUpdateFreq());
    }

    @Test
    public void testInitialSetMaintenanceToTrack(){
        assertEquals(true, vehicleSettings.getMaintenanceToTrack().get("air filter"));
        assertEquals(true, vehicleSettings.getMaintenanceToTrack().get("brakes"));
        assertEquals(true, vehicleSettings.getMaintenanceToTrack().get("oil change"));
        assertEquals(true, vehicleSettings.getMaintenanceToTrack().get("tires"));
    }

    @Test
    public void testSetMaintenanceToTrack() {
        vehicleSettings.setMaintenanceToTrack("brakes");
        assertEquals(false, vehicleSettings.getMaintenanceToTrack().get("brakes"));
    }

}
