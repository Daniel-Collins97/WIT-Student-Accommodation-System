import org.junit.jupiter.api.Test;

public class BedTest {

    @Test
    public void Test () {

        Property valid1 = new Property("dc1", 43, 2);
        Property valid2 = new Property("dc2", 12 , 0);
        Property valid3 = new Property("dc3", 104, 2);
        PropertyList propertyList = new PropertyList();

        propertyList.addProperty(new PropertyNode(valid1));
        propertyList.addProperty(new PropertyNode(valid2));
        propertyList.addProperty(new PropertyNode(valid3));


        Room validRoom1 = new Room("dc1", "dcr1", "Single" , 1, "yes", propertyList);
        Room validRoom2 = new Room("dc2", "dcr2", "Double" , 0 , "no", propertyList);
        Room validRoom3 = new Room("dc3", "dcr3", "single", 3, "yeah", propertyList);
        RoomList roomList = new RoomList();

        valid1.addRoom(validRoom1);
        valid2.addRoom(validRoom2);
        valid3.addRoom(validRoom3);

        Bed validBed1 = new Bed("dcr1" , "dcb1", "single", 45, roomList, null, true);
        Bed validBed2 = new Bed("dcr2" , "dcb2", "double", 25, roomList, null, true);
        Bed validBed3 = new Bed("dcr3" , "dcb3", "bunk", 643, roomList, null, true);
        BedList bedList = new BedList();

        validRoom1.addBed(validBed1);
        validRoom2.addBed(validBed2);
        validRoom3.addBed(validBed3);

        System.out.println("Done");
    }

}
