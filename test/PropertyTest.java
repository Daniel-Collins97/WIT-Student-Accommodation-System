import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Property Test Class
 *
 * @author Daniel Collins
 *
 */


public class PropertyTest {

    private Property prop1;
    private Property propInvalid;


    /**
     * Set up test fixtures
     *
     * Called before every test method
     */
    @Before
    public void setUp() {

        prop1 = new Property("7 Private Drive", 43, 2);
        propInvalid = new Property("knuyftfcghvjyfitucf", 222, 67);
    }

    /**
     * Teardown test fixtures
     *
     * Called after each test method
     */
    @After
    public void tearDown() {

    }

    /**
     * Test the contsructor
     */
    @Test
    public void testConstructor() {
        assertNotNull(propInvalid); //will test these in testGetters()
        assertEquals("knuyftfcghvjyfitucf", propInvalid.getAddress());
        assertEquals(222, propInvalid.getDistance(), 0);
        assertEquals(67, propInvalid.getCarSpaces());
    }

    /**
     * Test all getters using valid data
     */
    @Test
    public void testGetters() {
        assertEquals("7 Private Drive", prop1.getAddress());
        assertEquals(43, prop1.getDistance(), 0);
        assertEquals(2, prop1.getCarSpaces());
    }

    /**
     * Test all setters for Property
     */
    @Test
    public void testSetters() {
        prop1.setAddress("7 Private Drive");
        assertEquals("7 Private Drive", prop1.getAddress());

        prop1.setDistance(34);
        assertEquals(34, prop1.getDistance(), 0);

        prop1.setCarSpaces(2);
        assertEquals(2, prop1.getCarSpaces());
        Property.checkCarSpaces(2);                  //Property must have between 0 and 3 car spaces
        assertEquals(1, Property.checkCarSpaces(2));
        Property.checkCarSpaces(65);                 //Property must have between 0 and 3 car spaces
        assertEquals(0, Property.checkCarSpaces(65));

    }
}
