/**
 * Created by Daniel on 06-Oct-17.
 */
public class PropertyNode {

    Property property;
    PropertyNode nextNode;

    /**
     * Property to be added to PropertyNode
     * @param property - User Specified Property to be added to PropertyNode
     */
    public PropertyNode(Property property) {
        this.property = property;
    }

    /**
     * Gets User Specified Property
     * @return - User Specified Property
     */
    public Property getProperty() {
        return property;
    }

    /**
     * Sets User Specified Property
     * @param property - User Specified Property
     */
    public void setProperty(Property property) {
        this.property = property;
    }

    /**
     * Gets the Next Node in the PropertyList
     * @return - Next Node in PropertyList
     */
    public PropertyNode getNextNode() {
        return nextNode;
    }

    /**
     * Sets the Next Node in the PropertyList
     * @param nextNode - Node to be set as Next Node in Property List
     */
    public void setNextNode(PropertyNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return property.toString();
    }
}
