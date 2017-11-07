import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PropertyList {

    PropertyNode head;
    private PropertyNode tail;

    /**
     * Adds User Specified PropertyNode to the PropertyList
     * @param propertyNode - User Specified PropertyNode to be added to PropertyList
     */
    public void addProperty (PropertyNode propertyNode) {

        if(tail == null) {
            head = propertyNode;
            tail = propertyNode;
        }
        else {
            tail.setNextNode(propertyNode);
            tail = propertyNode;
        }
    }

    /**
     * Deletes User Specified PropertyNode from PropertyList
     * @param address - User Specified Address of PropertyNode to be Deleted
     * @return - 0 if Deleting the Found Property would result in an Error
     *           1 if the Property was Successfully Deleted
     */
    public int deleteProperty(String address) {
        int foundProp = 1;
        PropertyNode temp = head;
        PropertyNode temp1 = tail;
        if ((temp.getProperty().getAddress().contains(address)) && (temp1.getProperty().getAddress().contains(address))) {
            System.out.println("Error, Deleting this Property would cause the Property List to become empty");
            return 0;
        } else {
            while (!findProperty(address).getAddress().contains(address)) {
                temp = temp.getNextNode();
                foundProp++;
            }
            PropertyNode previous = head;
            int count = 1;
            while (count < foundProp - 1) {
                previous = previous.getNextNode();
                count++;
            }
            PropertyNode current = previous.getNextNode();
            previous.setNextNode(current.getNextNode());
            current.setNextNode(null);
            return 1;
        }
    }

    /**
     * Finds User Specified Property
     * @param address - User Specified Address of Property to be found
     * @return - Null if Property cannot be found
     *           Found Property Object if Property is Found
     */
    public Property findProperty (String address) {

        if (head == null) {
            System.out.println("No Properties in list");
            return null;
        }
        else {
            PropertyNode temp = head;
            while ((temp != null) && (!temp.getProperty().getAddress().equals(address)))
                temp = temp.getNextNode();
            return temp == null ? null : temp.getProperty();
        }

    }

    /**
     * Saves Created PropertyList to CSV File
     * @param address - User Specified Property Address
     * @param distance - User Specified Distance to WIT
     * @param carSpaces - User Specified Number of Car Spaces Available
     */
    public static void saveProperty(String address, double distance, int carSpaces) {
        String fileSrc = "src\\data\\property.txt";

        try {
            FileWriter fw = new FileWriter(fileSrc, true);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println("Address = " + address + ", " + "Distance to WIT = " + distance + ", " + "Car Spaces Available = " + carSpaces);
            pw.flush();
            pw.close();

            System.out.println("Done!");
        } catch (Exception e) {
            System.out.println("Error writing to File; " + e);
        }
    }
}
