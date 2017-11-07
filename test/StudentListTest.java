import org.junit.jupiter.api.Test;

/**
 * Created by Daniel on 06-Oct-17.
 */
public class StudentListTest {

    @Test
    public void Test () {

        Student valid1 = new Student("Joe Soap", "Male" , "yes" , 20076240);
        Student valid2 = new Student("Mark Soap", "Male" , "yeah" , 20075240);
        Student valid3 = new Student("Frank Soap", "Male" , "no" , 20077240);
        Student invalid2 = new Student("abcdefghijklmnopqrstuvwxyz" , "none" , "mhm" , 34);
        StudentList list = new StudentList();

        list.addStudent(new StudentNode(valid1));
        list.addStudent(new StudentNode(valid2));
        list.addStudent(new StudentNode(valid3));

        System.out.println("Does Joe exist? " + list.findStudent(20076240));
        System.out.println("Does Mark exist? " + list.findStudent(20075240));
        System.out.println("Does Frank exist? " + list.findStudent(20077240));
        System.out.println("Does Derek exist? " + list.findStudent(20078924));

        System.out.println("Done");
    }

}
