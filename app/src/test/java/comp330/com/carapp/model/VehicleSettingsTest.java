package comp330.com.carapp.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by aksharkumar on 4/2/16.
 */
public class VehicleSettingsTest {
    protected VehicleSettings vs;

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
        assertTrue(vs.getMileageUpdateFreq().equals(7));
    }

}
