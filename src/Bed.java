/**
 * Created by Daniel on 27-Sep-17.
 */
public class Bed {

    /**
     * Initialises the variables needed in this class
     */
    private PropertyList propertyList;
    private Student student;
    private String roomName;
    private String bedType;
    private float bedCost;
    private String bedName;
    private String address;
    private RoomList roomList;
    private boolean isFree;

    /**
     * Empty Constructor Class
     */
    public Bed() {
    }

    /**
     * Gets the Bed Type
     * @return Bed Type
     */
    public String getBedType() {
        return bedType;
    }

    /**
     * Sets the Bed Type
     * @param bedType = String entered by the user to define what type the bed is
     */
    public void setBedType(String bedType) {
        if((bedType.equals("Single")) || (bedType.equals("single")) || (bedType.equals("Double")) || (bedType.equals("double")) || (bedType.equals("Bunk")) || (bedType.equals("bunk"))) {
            this.bedType = bedType;
        }
        else {
            System.out.println("Error: Bed Type must be either Single, Double or Bunk");
        }
    }


    /**
     * Gets the availability of the bed
     * @return availability
     */
    public boolean getisFree() {
        return isFree;
    }

    /**
     * Sets the availability of the bed
     * @param isFree = Boolean Value entered by the user to define the availability of the bed
     */
    public void setIsFree(boolean isFree) {
        if(getStudent() == null) {
            this.isFree = true;
        } else {
            this.isFree = false;
        }
    }

    /**
     * Gets the Student associated with the bed (If any)
     * @return Student associated with the bed
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Sets the student associated with the bed
     * @param student = Student user chooses to assign to this bed
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Gets the list of rooms associated with the bed (null value)
     * @return Rooms associated with the bed (null value)
     */
    public RoomList getRoomList() {
        return roomList;
    }

    /**
     * Sets the List of rooms associated with the bed
     * @param roomList = List of rooms associated with the bed
     */
    public void setRoomList(RoomList roomList) {
        this.roomList = roomList;
    }

    /**
     * Gets the name of the bed (User Defined)
     * @return Name of bed
     */
    public String getBedName() {
        return bedName;
    }

    /**
     * Sets the name of the bed
     * @param bedName = Name user chooses to assign the bed
     */
    public void setBedName(String bedName) {
        this.bedName = bedName;
    }

    /**
     * Gets the name of the Room associated with the bed
     * @return Name associated with the bed
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Sets the name of the room associate with the bed (User Defined)
     * @param roomName = Name of Room
     */
    public void setRoomName(String roomName) {
        if(roomList.findRoom(roomName) != null) {
            this.roomName = roomName;
        }
        else {
            System.out.println("Error, Property does not exist");
            this.roomName= "1234";
        }
    }

    /**
     * Gets the cost of the bed
     * @return Cost of bed
     */
    public float getBedCost() {
        return bedCost;
    }

    /**
     * Sets the cost of the bed
     * @param bedCost = Csot user chooses to assign the Bed
     */
    public void setBedCost(int bedCost) {
        if (bedCost > 0) {
            this.bedCost = bedCost;
        }
        else {
            System.out.println("Error: Bed must cost more than 0");
        }
    }

    /**
     * Creates the Bed Object
     * @param roomName = User-Defined Room Name
     * @param bedName = User-Defined Bed Name
     * @param bedType = User-Defined Bed Type
     * @param bedCost = User-Defined Bed Cost
     * @param roomList = User-Defined Room List
     * @param student = User-Defined Student
     * @param isFree = User-Defined Availability
     */
    public Bed (String roomName, String bedName, String bedType, int bedCost, RoomList roomList, Student student, boolean isFree) {
        this.setRoomList(roomList);
        this.setRoomName(roomName);
        this.setBedName(bedName);
        this.setBedType(bedType);
        this.setBedCost(bedCost);
        this.setStudent(student);
        this.setIsFree(isFree);
    }

    /**
     * Overrides the Super's "toString()" method and prints a user-friendly version of the bed to the console
     * @return User-Friendly version of bed
     */
    @Override
    public String toString() {
        return  "\n Room Name= " + roomName +
                ",\n Bed Name= " + bedName +
                ",\n Bed Type= " + bedType +
                ",\n Bed Cost= " + bedCost +
                ",\n Student = " + student +
                ",\n Is this Bed Free = " + isFree;
    }
}
