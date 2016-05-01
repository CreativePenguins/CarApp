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
    protected VehicleSettingsInterface vs;

    @Before
    public void setUp() {
        vs = new VehicleSettings();
    }
    @After
    public void tearDown() {
        vs = null;
    }

    @Test
    public void testMileageUpdateFreq() {
        vs.setMileageUpdateFreq(7);
        assertTrue(vs.getMileageUpdateFreq() == 7);
    }

    @Test
    public void testSetMaintenanceToTrack(){

    }

}
