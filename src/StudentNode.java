/**
 * Created by Daniel on 06-Oct-17.
 */
public class StudentNode {

     Student student;
     StudentNode nextNode;

    /**
     * Sets the Student Object to be Put in a StudentNode
     * @param student - Student to be put in StudentNode
     */
    public StudentNode(Student student) {
        this.student = student;
    }

    /**
     * Gets user Specified Student
     * @return - User Specified Student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Sets User Specified Student
     * @param student - Gets User Specified Student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Gets the NextNode in the StudentList
     * @return - NextNode in StudentList
     */
    public StudentNode getNextNode() {
        return nextNode;
    }

    /**
     * Sets the NextNode in the StudentList
     * @param nextNode - StudentNode to be Set as NextNode in StudentList
     */
    public void setNextNode(StudentNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return student.toString();
    }
}
