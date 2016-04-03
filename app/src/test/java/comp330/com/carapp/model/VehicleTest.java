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
public class VehicleTest {
    protected Vehicle v;

    @Before
    public void setUp() {
        v = new Vehicle();
    }

    @After
    public void tearDown() { v = null; }

    @Test
    public void testMake() {
        v.setMake("Nissan");
        assertEquals(v.getMake(), "Nissan");
        assertFalse(v.getMake().equals("Honda"));
    }

    @Test
    public void testModel() {
        v.setModel("Altima");
        assertEquals(v.getModel(), "Altima");
        assertFalse(v.getModel().equals("Accord"));
    }

    @Test
    public void testYear() {
        v.setYear(1994);
        assertTrue(v.getYear().equals(1994));
    }

    @Test
    public void testVIN() {
        v.setVIN("1HGCM82633A004352");
        assertTrue(v.getVIN().equals("1HGCM82633A004352"));
    }

    @Test
    public void testColor(){
        v.setColor("Red");
        assertTrue(v.getColor().equals("Red"));
    }
}