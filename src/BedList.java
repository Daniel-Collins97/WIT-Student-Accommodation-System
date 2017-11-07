public class BedList {

    public BedNode head;
    private BedNode tail;

    /**
     * Adds a BedNode to the BedList
     * @param bedNode - BedNode to be added to List
     */
    public void addBed(BedNode bedNode) {

        if (tail == null) {
            head = bedNode;
            tail = bedNode;
        } else {
            tail.setNextNode(bedNode);
            tail = bedNode;
        }
    }

    /**
     * Deletes a BedNode from the BedList
     * @param bedName - BedNode to be Deleted
     */
    public void deleteBed(String bedName) {
        int foundBed = 1;
        BedNode temp = head;
        BedNode temp1 = tail;
        if ((temp.getBed().getBedName().contains(bedName)) && (temp1.getBed().getBedName().contains(bedName))) {
            System.out.println("Error, Deleting this Bed would cause the Bed List to become empty");
        } else {
                while (!findBed(bedName).getBedName().contains(bedName)) {
                    temp = temp.getNextNode();
                    foundBed++;
                }
            }
            BedNode previous = head;
            int count = 1;
            while (count < foundBed - 1) {
                previous = previous.getNextNode();
                count++;
            }
            BedNode current = previous.getNextNode();
            previous.setNextNode(current.getNextNode());
            current.setNextNode(null);
        }


    /**
     * Parses Through BedList for Specified BedNode
     * @param bedName - Name of Bed in BedNode to be found
     * @return - Found BedNode/Null if BedNode is not Found
     */
    public Bed findBed(String bedName) {

        if (head == null) {
            System.out.println("No Beds in list");
            return null;
        }
        else {
            BedNode temp = head;
            while ((temp != null) && (!temp.getBed().getBedName().equals(bedName)))
                temp = temp.getNextNode();
            return temp == null ? null : temp.getBed();
        }
    }
}