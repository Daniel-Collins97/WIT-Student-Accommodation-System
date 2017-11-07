import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Student Test Class
 *
 * @author Daniel Collins
 *
 */


public class StudentTest {

    private Student stud1;
    private Student studInvalid;


    /**
     * Set up test fixtures
     *
     * Called before every test method
     */
    @Before
    public void setUp() {

        stud1 = new Student("Joe Soap", "Male" , "yes" , 20076240);
        studInvalid = new Student("abcdefghijklmnopqrstuvwxyz1234567890" , "none" , "mhm" , 34);
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
        assertNotNull(studInvalid); //will test these in testGetters()
        assertEquals("abcdefghijklmnopqrstuvwxyz1234", studInvalid.getName());
        assertEquals(null, studInvalid.getGender());
        assertEquals(null, studInvalid.getCar());
        assertEquals(34, studInvalid.getStudentID());
    }

    /**
     * Test all getters using valid data
     */
    @Test
    public void testGetters() {
        assertEquals("Joe Soap", stud1.getName());
        assertEquals("Male", stud1.getGender());
        assertEquals("Yes", stud1.getCar());
        assertEquals(20076240, stud1.getStudentID());
    }

    /**
     * Test all setters for Student
     */
    @Test
    public void testSetters() {
        stud1.setName("Joe Soap");
        assertEquals("Joe Soap", stud1.getName());
        stud1.setName("This name is far too long for the validation rules");        //Validation rules cut name off at 30 characters
        assertEquals("This name is far too long for ", stud1.getName());

        stud1.setGender("Male");
        assertEquals("Male", stud1.getGender());
        stud1.setGender("Female");
        assertEquals("Female", stud1.getGender());
        stud1.setGender("m");                               //small "m" gives "Male" value
        assertEquals("Male", stud1.getGender());
        stud1.setGender("M");                               //Large "M" gives "Male" value
        assertEquals("Male", stud1.getGender());
        stud1.setGender("f");                               //small "f" gives "Female" value
        assertEquals("Female", stud1.getGender());
        stud1.setGender("F");                               //Large "F" gives "Female" value
        assertEquals("Female", stud1.getGender());

        stud1.setCar("Yes");
        assertEquals("Yes", stud1.getCar());
        stud1.setCar("No");
        assertEquals("No", stud1.getCar());
        stud1.setCar("n");                               //small "n" gives "No" value
        assertEquals("No", stud1.getCar());
        stud1.setCar("N");                               //Large "N" gives "No" value
        assertEquals("No", stud1.getCar());
        stud1.setCar("y");                               //small "y" gives "Yes" value
        assertEquals("Yes", stud1.getCar());
        stud1.setCar("Y");                               //Large "Y" gives "Yes" value
        assertEquals("Yes", stud1.getCar());

        stud1.setStudentID(20076240);
        assertEquals(20076240, stud1.getStudentID());
        Student.checkID(20076240);                  //Student ID must be between 4 and 8 numbers
        assertEquals(1, Student.checkID(20076240));
        Student.checkID(267);
        assertEquals(0, Student.checkID(267));

    }
}
