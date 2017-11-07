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


public class RoomTest {

    private Room room1;
    private Room roomInvalid;
    private PropertyList propList = new PropertyList();


    /**
     * Set up test fixtures
     *
     * Called before every test method
     */
    @Before
    public void setUp() {

        room1 = new Room("House1", "Room1", "Double", 2, "Yes", propList);
        roomInvalid = new Room("Invalid House", "Invalid Room", "single", 4, "y", propList);


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
     * Test the constructor
     */
    @Test
    public void testConstructor() {
        assertNotNull(roomInvalid); //will test these in testGetters()
        assertEquals("1234", roomInvalid.getAddress());             //No PropertyList Defined, therefore Default value of 1234 is assigned
        assertEquals("Invalid Room", roomInvalid.getRoomName());
        assertEquals("Single", roomInvalid.getRoomSize());
        assertEquals(4, roomInvalid.getLevel());
        assertEquals("Yes", roomInvalid.getEnSuite());

    }

    /**
     * Test all getters using valid data
     */
    @Test
    public void testGetters() {
        assertEquals("1234", room1.getAddress());
        assertEquals("Room1", room1.getRoomName());
        assertEquals("Double", room1.getRoomSize());
        assertEquals(2, room1.getLevel());
        assertEquals("Yes", room1.getEnSuite());
    }

    /**
     * Test all setters for Room
     */
    @Test
    public void testSetters() {
        room1.setAddress("House1");
        assertEquals("1234", room1.getAddress());

        room1.setRoomName("Room1");
        assertEquals("Room1", room1.getRoomName());

        room1.setRoomSize("Double");
        assertEquals("Double", room1.getRoomSize());     //Validation occurs in Menu Controller
        room1.setRoomSize("Single");
        assertEquals("Single", room1.getRoomSize());
        room1.setRoomSize("s");
        assertEquals("Single", room1.getRoomSize());
        room1.setRoomSize("d");
        assertEquals("Double", room1.getRoomSize());
        Room.checkRoomSize("Double");
        assertEquals(1, Room.checkRoomSize("Double"));
        Room.checkRoomSize("Bunk");
        assertEquals(0, Room.checkRoomSize("Bunk"));

        room1.setEnSuite("Yes");
        assertEquals("Yes", room1.getEnSuite());        //Validation occurs in Menu Controller
        room1.setEnSuite("No");
        assertEquals("No", room1.getEnSuite());
        room1.setEnSuite("y");
        assertEquals("Yes", room1.getEnSuite());
        room1.setEnSuite("n");
        assertEquals("No", room1.getEnSuite());
        Room.checkEnSuite("Yeani");
        assertEquals(1, Room.checkEnSuite("Yeani"));
        Room.checkEnSuite("FGHJ");
        assertEquals(0, Room.checkEnSuite("FGHJ"));

        room1.setLevel(2);
        assertEquals(2, room1.getLevel());              //Validation occurs in Menu Controller
        room1.setLevel(8);
        assertEquals(8, room1.getLevel());
        Room.checkLevel(8);
        assertEquals(1, Room.checkLevel(8));
        Room.checkLevel(23);
        assertEquals(0, Room.checkLevel(23));
    }
}
