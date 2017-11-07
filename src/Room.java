public class Room {

    private String address;
    private String roomName;
    private String roomSize;
    private int level;
    private String enSuite;
    private PropertyList propertyList;
    private BedList bedList = new BedList();

    /**
     * Empty Constructor
     */
    public Room() {
    }

    /**
     * Gets the Property List associated with this Room
     * @return - PropertyList associated with this Room
     */
    public PropertyList getPropertyList() {
        return propertyList;
    }

    /**
     * Sets the property List for this specific room
     * @param propertyList - Selected Property List
     */
    private void setPropertyList(PropertyList propertyList) {
        this.propertyList = propertyList;
    }

    /**
     * Gets Bedlist associated with Room
     * @return - Bedlist
     */
    public BedList getBedList() {
        return bedList;
    }

    /**
     * Sets BedList to be used with this room
     * @param bedList - Selected BedList
     */
    public void setBedList(BedList bedList) {
        this.bedList = bedList;
    }

    /**
     * Gets Name of the Room
     * @return - User Specified Room Name
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Sets the Room name using User Specified Data
     * @param roomName - User Specified Room Name
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * Gets Room Address
     * @return - User Specified Address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets Room Address using User Specified Data
     * @param address - User Specified Address
     *                  Address must be contained in Property List
     */
    public void setAddress(String address) {
        if(propertyList.findProperty(address) != null) {
            this.address = address;
        }
        else {
            System.out.println("Error, Property does not exist");
            this.address = "1234";
        }
    }

    /**
     * Gets Size of Room
     * @return - User Specified Room Size
     */
    public String getRoomSize() {
        return roomSize;
    }

    /**
     * Sets Room Size using User Specified Date
     * @param roomSize - User Specified Room Size
     */
    public void setRoomSize(String roomSize) {
        if ((roomSize.contains("s")) || (roomSize.contains("S"))) {
            this.roomSize = "Single";
        }
        else if ((roomSize.contains("d")) || (roomSize.contains("D"))) {
            this.roomSize = "Double";
        }
    }

    /**
     * Checks to see if the User Specified Room size Data entered Complies with Validation Rules
     * @param roomSize - User Specified Room Size
     * @return - 1 if Data entered complies with Validation Rules
     *           2 if Data entered is Invalid (i.e. Does not Comply with Validation Rules)
     */
    public static int checkRoomSize(String roomSize) {
        if ((roomSize.contains("S")) || (roomSize.contains("D")) || (roomSize.contains("s")) || (roomSize.contains("d"))) {
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * Gets Room Level
     * @return - User Specified Room Level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets Room Level Using User Specified Data
     * @param level - User Specified Room Level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Checks to see if the User Specified Room Level Data entered Complies with Validation Rules
     * @param level - User Specified Room Level
     * @return - 1 if Data entered complies with Validation Rules
     *           2 if Data entered is Invalid (i.e Does not comply with Validation Rules)
     */
    public static int checkLevel(int level) {
        if ((level >= 0) && (level <= 10)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Gets EnSuite Value for Room
     * @return - EnSuite Value
     */
    public String getEnSuite() {
        return enSuite;
    }

    /**
     * Sets the EnSuite value using User Specified Data
     * @param enSuite - User Specified EnSuite Value
     */
    public void setEnSuite(String enSuite) {
        if ((enSuite.contains("y")) || (enSuite.contains("Y"))) {
            this.enSuite = "Yes";
        } else if ((enSuite.contains("n")) || (enSuite.contains("N"))) {
            this.enSuite = "No";
        }
    }

    /**
     * Checks to see if the User Specified Room size Data entered Complies with Validation Rules
     * @param enSuite - User Specified EnSuite Value
     * @return - 1 if Data entered complies with Validation Rules
     *           2 if Data entered is Invalid (i.e. Does not comply with Validation Rules)
     */
    public static int checkEnSuite(String enSuite) {
        if ((enSuite.contains("y")) || (enSuite.contains("Y")) || (enSuite.contains("n")) || (enSuite.contains("N"))) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Adds a Bed to this Rooms BedList
     * @param bed - Bed to be Added
     */
    public void addBed(Bed bed) {
        BedNode bedNode = new BedNode(bed);
        bedList.addBed(bedNode);
    }

    /**
     * Constructor that creates the Room
     * @param address - User Specified Address
     * @param roomName - User Specified Room Name
     * @param roomSize - User Specified Room Size
     * @param level - User Specified Room Level
     * @param enSuite - User Specified EnSuite Value
     * @param propertyList - Property List Associated with this Room
     */
    public Room (String address, String roomName, String roomSize, int level, String enSuite, PropertyList propertyList) {
        this.setPropertyList(propertyList);
        this.setRoomName(roomName);
        this.setAddress(address);
        this.setRoomSize(roomSize);
        this.setLevel(level);
        this.setEnSuite(enSuite);
    }

    /**
     * Presents Room in User Friendly View
     * @return - Room in String Data
     */
    @Override
    public String toString() {
        return  "\n Address= " + address +
                ",\n Room Name= " + roomName +
                ",\n Room Size= " + roomSize +
                ",\n Level= " + level +
                ",\n EnSuite= " + enSuite;
    }
}
