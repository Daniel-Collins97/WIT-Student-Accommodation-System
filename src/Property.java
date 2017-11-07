/**
 * Created by Daniel on 27-Sep-17.
 */
public class Property {

    private String address;
    private double distance;
    private int carSpaces;
    private RoomList roomList = new RoomList();


    /**
     * Empty Constructor
     */
    public Property() {
    }

    /**
     * Gets User Specified RoomList
     * @return - User Specified Room List
     */
    public RoomList getRoomList() {
        return roomList;
    }

    /**
     * Sets RoomList For this Property
     * @param roomList - RoomList for this Property
     */
    public void setRoomList(RoomList roomList) {
        this.roomList = roomList;
    }

    /**
     * Gets Address for this Property
     * @return - Address for this Property
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets Property Distance to WIT
     * @return - Distance to WIT
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Gets How many Car Spaces this Property Has
     * @return - Number of Car Spaces at this Property
     */
    public int getCarSpaces() {
        return carSpaces;
    }

    /**
     * Sets Address of this Property
     * @param address - User Specified Address of Property
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets Distance of Property from WIT
     * @param distance - Distance to WIT
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Sets the Number of Car Spaces Available at this Property
     * @param carSpaces - User Specified Number of Car Spaces Available
     */
    public void setCarSpaces(int carSpaces) {
        this.carSpaces = carSpaces;
    }

    /**
     * Checks to see if the User Specified Number of Car Spaces entered Complies with Validation Rules
     * @param carSpaces - User Specified Number of Car Spaces
     * @return - 1 if Data entered complies with Validation Rules
     *           2 if Data entered is Invalid (i.e. If Data does not comply with Validation Rules)
     */
    public static int checkCarSpaces (int carSpaces) {
        int b = carSpaces;
        if ((b >= 0) && (b <= 3)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Adds a Room to this Property
     * @param room - User Specified Room to be Added to this Property
     */
    public void addRoom(Room room) {
        RoomNode roomNode = new RoomNode(room);
        roomList.addRoom(roomNode);
    }

    /**
     * Creates the Property Object
     * @param address - User Specified Address
     * @param distance - User Specified Distance to WIT
     * @param carSpaces - User Specified Number of Car Spaces Available
     */
    public Property(String address, double distance, int carSpaces) {
        this.setAddress(address);
        this.setDistance(distance);
        this.setCarSpaces(carSpaces);
    }

    /**
     * Converts Property Object to User-Friendly Format
     * @return - User Friendly Format of the Property Object
     */
    @Override
    public String toString() {
        return "\n Address= " + address +
                ",\n Distance= " + distance +
                ",\n Car Spaces Available= " + carSpaces;
    }
}
