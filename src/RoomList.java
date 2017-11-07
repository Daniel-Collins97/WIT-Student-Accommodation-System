/**
 * Created by Daniel on 06-Oct-17.
 */
public class RoomList {

    RoomNode head;
    RoomNode tail;

    /**
     * Adds User Specified RoomNode to the RoomList
     * @param roomNode - User Specified RoomNode to be Added to List
     */
    public void addRoom (RoomNode roomNode) {

        if(tail == null) {
            head = roomNode;
            tail = roomNode;

        }
        else {
            tail.setNextNode(roomNode);
            tail = roomNode;
        }
    }

    /**
     * Deleted
     * @param roomName
     */
    public void deleteRoom(String roomName) {
        int foundRoom = 1;
        RoomNode temp = head;
        RoomNode temp1 = tail;
        if ((temp.getRoom().getRoomName().contains(roomName)) && (temp1.getRoom().getRoomName().contains(roomName))) {
            System.out.println("Error, Deleting this Bed would cause the Bed List to become empty");
        } else {
            while (!findRoom(roomName).getRoomName().contains(roomName)) {
                temp = temp.getNextNode();
                foundRoom++;
            }
        }
        RoomNode previous = head;
        int count = 1;
        while (count < foundRoom - 1) {
            previous = previous.getNextNode();
            count++;
        }
        RoomNode current = previous.getNextNode();
        previous.setNextNode(current.getNextNode());
        current.setNextNode(null);
    }


    public Room findRoom (String roomName) {

        if (head == null) {
            System.out.println("No Rooms in Property");
            return null;
        }
        else {
            RoomNode temp = head;
            while ((temp != null) && (!temp.getRoom().getRoomName().equals(roomName)))
                temp = temp.getNextNode();
            return temp == null ? null : temp.getRoom();
        }

    }
}
