/**
 * Created by Daniel on 06-Oct-17.
 */
public class StudentList {

    StudentNode head;
    StudentNode tail;

    /**
     * Adds a StudentNode to the StudentList
     * @param studentNode - StudentNode to be Added to StudentList
     */
    public void addStudent(StudentNode studentNode) {

        if (tail == null) {
            head = studentNode;
            tail = studentNode;
        } else {
            tail.setNextNode(studentNode);
            tail = studentNode;
        }
    }

    /**
     * Deletes a StudentNode from the StudentList
     * @param studentID - Student ID Number of Student to be Deleted
     */
    public void deleteStudent(int studentID) {
        int foundStudent = 1;
        StudentNode temp = head;
        StudentNode temp1 = tail;
        if ((temp.getStudent().getStudentID() == studentID) && (temp1.getStudent().getStudentID() == studentID)) {
            System.out.println("Error, Deleting this Student would cause the Student List to become empty");
        } else {
            while (findStudent(studentID).getStudentID() != studentID) {
                temp = temp.getNextNode();
                foundStudent++;
            }
            StudentNode previous = head;
            int count = 1;
            while (count < foundStudent - 1) {
                previous = previous.getNextNode();
                count++;
            }
            StudentNode current = previous.getNextNode();
            previous.setNextNode(current.getNextNode());
            current.setNextNode(null);
        }
    }

    /**
     * Finds a Student in the StudentList
     * @param studentID - Student ID Number of Student to be Found
     * @return - null if Student is not Found
     *           Student Object if Student is Found
     */
    public Student findStudent (long studentID) {

        if (head == null) {
            System.out.println("No Students in list");
            return null;
        }
        else {
            StudentNode temp = head;
            while ((temp != null) && (temp.getStudent().getStudentID() != studentID ))
                temp = temp.getNextNode();
            return temp == null ? null : temp.getStudent();
        }
    }
}
