/**
 * Created by Daniel on 06-Oct-17.
 */
public class BedNode {

    Bed bed;
    BedNode nextNode;

    /**
     * Puts a Bed in a BedNode
     * @param bed - Bed to be Put in BedNode
     */
    public BedNode(Bed bed) {
        this.bed = bed;
    }

    /**
     * Gets User Specified Bed
     * @return - User Specified Bed
     */
    public Bed getBed() {
        return bed;
    }

    /**
     * Sets User Specified Bed
     * @param bed - User Specified Bed
     */
    public void setBed(Bed bed) {
        this.bed = bed;
    }

    /**
     * Gets The Next Node in the BedList
     * @return - Next Node in BedList
     */
    public BedNode getNextNode() {
        return nextNode;
    }

    /**
     * Sets Next Node in BedList
     * @param nextNode - Node to be Set as Next Node
     */
    public void setNextNode(BedNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return bed.toString();
    }
}
