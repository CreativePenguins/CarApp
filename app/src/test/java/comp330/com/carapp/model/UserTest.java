package comp330.com.carapp.model;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by aksharkumar on 3/31/16.
 */
public class UserTest {
    protected User u;
    @Before
    public void setUp() {
        u = new User();
    }

    @After
    public void tearDown() {
        u = null;
    }

    @Test
    public void testUsername() {
        u.setUsername("akumar6");
        assertEquals(u.getUsername(), "akumar6");
        assertFalse(u.getUsername() == "akumar");
    }

    @Test
    public void testPassword() {
        u.setPassword("password123");
        assertEquals(u.getPassword(), "password123");
        assertFalse(u.getPassword() == "password");
    }

    @Test
    public void testImageURL() {
        u.setImageURL("https://www.google.com/imgres?imgurl=http://automobiles.honda.com/.png" +
                "&imgrefurl=http://automobiles.honda.com/accord-sedan/price.aspx&h=450&w=550&tbnid=Gv5fwN0E" +
                "q2QyXM:&tbnh=163&tbnw=200&docid=saNb-YBMu-LQ9M&itg=1&usg=__ptyXcchw8rtHWP2ppTJxNh");
        assertEquals(u.getImageURL(), "https://www.google.com/imgres?imgurl=http://automobiles.honda.com/.png" +
                "&imgrefurl=http://automobiles.honda.com/accord-sedan/price.aspx&h=450&w=550&tbnid=Gv5fwN0E" +
                "q2QyXM:&tbnh=163&tbnw=200&docid=saNb-YBMu-LQ9M&itg=1&usg=__ptyXcchw8rtHWP2ppTJxNh");
        assertFalse(u.getImageURL() == "https://www.google.com/?gws_rd=ssl#q=honnda+accord");
    }
    @Test
    public void testExample() {
        u.setUsername("carUser");
        u.setPassword("1234");
        Vehicle v = new Vehicle();
        v.setVIN("1HGCM82633A004352");
        v.setMake("BMW");
        v.setModel("528i");
        v.setColor("Black");
        u.addVehicle(v);
        assertTrue(u.getVehicle("1HGCM82633A004352").equals(v));
    }
}

