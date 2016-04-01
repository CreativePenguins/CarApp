package comp330.com.carapp.model;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
}

