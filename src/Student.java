/**
 * Created by Daniel on 27-Sep-17.
 */
public class Student {

    private String name;
    private String gender;
    private String car;
    private int studentID;

    /**
     * Empty Constructor
     */
    public Student () {
    }

    /**
     * Gets User Specified Name
     * @return - User Specified Name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Name of Student using User Specified Data
     * @param name - User Specified Name
     */
    public void setName(String name) {
        int maxLength = 30;
        if (name.length() > maxLength) {
            name = name.substring(0, maxLength);
        }
        this.name  = name;
    }

    /**
     * Gets User Specified Gender
     * @return - User Specified Gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets Gender of Student using User Specified Data
     * @param gender - User Specified Gender
     */
    public void setGender(String gender) {
        if ((gender.equals("f")) || (gender.equals("F")) || (gender.equals("Female")) || (gender.equals("female"))) {
            this.gender = "Female";
        } else if ((gender.equals("m")) || (gender.equals("M")) || (gender.equals("Male")) || (gender.equals("male"))) {
            this.gender = "Male";
        }
    }

    /**
     * Gets the Car value for Student
     * @return - Car Value for Student
     */
    public String getCar() {
        return car;
    }

    /**
     * Sets the Car Value for Student using User Specified Data
     * @param car - User Specified Car Value
     */
    public void setCar(String car) {
        if ((car.contains("y")) || (car.contains("Y"))) {
            this.car = "Yes";
        }
        else if ((car.contains("n")) || (car.contains("N"))) {
            this.car = "No";
        }
    }

    /**
     * Gets the User Specified Student ID
     * @return - User Specified Student ID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Sets the Student ID of the Student using User Specified Data
     * @param studentID - User Specified Student ID
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * Checks to see if the User Specified Student ID Number entered Complies with Validation Rules
     * @param studentID - User Specified Student ID Number
     * @return - 1 if Data entered complies with Validation Rules
     *           2 if Data entered is Invalid (i.e. Data does not comply with Validation Rules)
     */
    public static int checkID (int studentID) {
        int b = Integer.valueOf(studentID).toString().length();
        if ((b >= 4) && (b <= 8)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Creates the Student Object
     * @param name - User Specified Name
     * @param gender - User Specified Gender
     * @param car - User Specified Car Value
     * @param studentID - User Specified Student ID Number
     */
    public Student(String name, String gender, String car, int studentID) {
        this.setName(name);
        this.setGender(gender);
        this.setCar(car);
        this.setStudentID(studentID);
    }

    @Override
    public String toString() {
        return  "\n Name = " + name +
                ",\n Gender = " + gender +
                ",\n Car = " + car +
                ",\n Student ID = " + studentID;
    }
}
