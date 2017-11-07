/**
 * Created by Daniel on 06-Oct-17.
 */
public class RoomNode {

    Room room;
    RoomNode nextNode;

    /**
     * Add User Specified Room to RoomNode
     * @param room - User Specified Room
     */
    public RoomNode(Room room) {
        this.room = room;
    }

    /**
     * Gets User Specified Room
     * @return - User Specified Room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Sets User Specified Room
     * @param room - User Specified Room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Gets the Next Node in the RoomList
     * @return - Next Node in RoomList
     */
    public RoomNode getNextNode() {
        return nextNode;
    }

    /**
     * Sets the Next Node in the RoomList
     * @param nextNode - Node to be Set as Next Node
     */
    public void setNextNode(RoomNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return room.toString();
    }
}
