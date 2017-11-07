import org.junit.jupiter.api.Test;

/**
 * Created by Daniel on 06-Oct-17.
 */
public class PropertyListTest {

    @Test
    public void Test () {

        Property valid1 = new Property("7 Private Drive", 43, 2);
        Property valid2 = new Property("12 Glenview Close", 12 , 0);
        Property valid3 = new Property("43 Pares Close", 104, 1);
        //Property invalid1 = new Property("knuyftfcghvjyfitucf", 222, 67);
        PropertyList list = new PropertyList();

        list.addProperty(new PropertyNode(valid1));
        list.addProperty(new PropertyNode(valid2));
        list.addProperty(new PropertyNode(valid3));

        System.out.println("Does " + valid1.getAddress() + " exist? " + list.findProperty("7 Private Drive").getAddress());
        System.out.println("Does " + valid2.getAddress() + " exist? " + list.findProperty("12 Glenview Close").getAddress());
        System.out.println("Does " + valid3.getAddress() + " exist? " + list.findProperty("43 Pares Close").getAddress());
        System.out.println("Does this one exist? " + list.findProperty("not here"));

        System.out.println("Done");
    }

}
