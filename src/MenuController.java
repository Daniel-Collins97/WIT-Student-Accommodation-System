import java.util.InputMismatchException;
import java.util.Scanner;


public class MenuController {

    /**
     * Initializes the variables needed in this class
     */
    private Scanner input;
    private PropertyList propertyList = new PropertyList();
    private RoomList roomList = new RoomList();
    private BedList bedList = new BedList();
    private StudentList studentList = new StudentList();

    /**
     * Menu Controller Constructor
     */
    private MenuController() {
        input = new Scanner(System.in);
    }

    /**
     * Starts the Application
     * @param args Starts the Menu Controller Class
     */
    public static void main(String args[]) {
        MenuController app = new MenuController();
        app.runMenu();
    }

    /*public void loadCSV() {
        String csvFile = "cdsdc";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] imported = line.split(cvsSplitBy);
                propertyList.addProperty(imported[3]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

    /**
     * Prints the Main Menu to the console for the user to interact with
     * @return The selected option's menu
     */
    private int startMenu() {
        System.out.println("		    WELCOME				  ");
        System.out.println("                                  ");
        System.out.println("----------------------------------");
        System.out.println("What would you like to do?");
        System.out.println("1) Add a new Property");
        System.out.println("2) Add a new Room to Property");
        System.out.println("3) Add a Bed to a Room");
        System.out.println("4) Add a Student");
        System.out.println("5) List all Properties");
        System.out.println("6) List all Rooms in a Property");
        System.out.println("7) List all Students");
        System.out.println("8) List All Beds");
        System.out.println("9) List Free Beds");
        System.out.println("10) Open Deletion menu");
        System.out.println("----------------------------------");
        System.out.println("11) Add a group of Properties using CVS file");
        System.out.println("12) Add a group of Beds using CVS file");
        System.out.println("----------------------------------");
        System.out.println("13) Assign a Student to a bed");
        System.out.println("14) Remove Student Assignment");
        System.out.println("----------------------------------");
        System.out.println("15) Income Generated from Property through Occupied Beds");
        System.out.println("----------------------------------");
        System.out.println("0) Exit");
        System.out.print("==>> ");
        int option = 0;
        try {
            option = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input was not a number please try again");
            //need this to consume the incorrect input
            input.next();
            startMenu();
        }
        if ((option >= 0) && (option <= 15)) {
            return option;
        } else {
            System.out.println("Invalid Index selected. Please Try again");
            return startMenu();
        }
    }

    /**
     * Opens the Deletion Menu
     * @return - User Selected Option
     */
    private int deletionMenu() {
        System.out.println("		    WELCOME TO THE DELETION MENU				  ");
        System.out.println("                                  ");
        System.out.println("----------------------------------");
        System.out.println("What would you like to do?");
        System.out.println("----------------------------------");
        System.out.println("1) Delete a Property");
        System.out.println("2) Delete a Room");
        System.out.println("3) Delete a Bed");
        System.out.println("4) Delete a Student");
        System.out.println("----------------------------------");
        System.out.println("5) Return to Start Menu");
        System.out.println("----------------------------------");
        System.out.println("0) Exit");
        System.out.print("==>> ");
        int option = 0;
        try {
            option = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input was not a number please try again");
            //need this to consume the incorrect input
            input.next();
            startMenu();
        }
        if ((option >= 0) && (option <= 5)) {
            return option;
        } else {
            System.out.println("Invalid Index selected. Please Try again");
            return deletionMenu();
        }
    }

    /**
     * Opens the "Add Property" menu
     * @return The new Property added
     */
    private Property addPropertyMenu() {
        try {
            System.out.println("Enter Property Address; ");
            System.out.print("==>> ");
            String address1;
            address1 = input.nextLine();
            if (propertyList.findProperty(address1) == null) {
                System.out.println("How far is the Property From WIT (in km); ");
                System.out.print("==>> ");
                double distance;
                distance = input.nextDouble();
                System.out.println("How many Car Spaces does this Property have; ");
                System.out.print("==>> ");
                int carSpaces;
                carSpaces = input.nextInt();
                if(Property.checkCarSpaces(carSpaces) == 1) {

                    Property property = new Property(address1, distance, carSpaces);
                    PropertyNode propertyNode = new PropertyNode(property);
                    propertyList.addProperty(propertyNode);
                    System.out.println(propertyList.findProperty(address1).toString());
                    try {
                        PropertyList.saveProperty(address1, distance, carSpaces);
                    } catch (Exception e) {
                        System.out.println("Error writing to File; " + e);
                    }
                    return property;
                } else {
                    System.out.println("Error, Property must have between 0 and 3 car spaces.\n Please Try again");
                    input.nextLine();
                    return addPropertyMenu();
                }
            } else {
                System.out.println("Error: Property already Exists. Please try again.");
                input.nextLine();
                return addPropertyMenu();
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect value entered please start again");
            input.next();
            return addPropertyMenu();
        }
    }

    /**
     * Opens the "Add Room to a Property" menu
     * @return The new Room added
     */
    private Room addRoomToPropertyMenu() {
        try {
            input.nextLine();
            System.out.println("Enter Property Address; ");
            System.out.print("==>> ");
            String address;
            address = input.nextLine();
            if (propertyList.findProperty(address) != null) {
                System.out.println("What would you like to call this Room?");
                System.out.print("==>> ");
                String roomName;
                roomName = input.nextLine();
                if (propertyList.findProperty(address).getRoomList().findRoom(roomName) == null) {
                    System.out.println("What is the size of this room? (Single or Double); ");
                    System.out.print("==>> ");
                    String roomSize;
                    roomSize = input.nextLine();
                    if (Room.checkRoomSize(roomSize) == 1) {
                        System.out.println("What level is this Room on? ");
                        System.out.print("==>> ");
                        int level;
                        level = input.nextInt();
                        input.nextLine();
                        if (Room.checkLevel(level) == 1) {
                            System.out.println("Does this room have an EnSuite? (Y/N) ");
                            System.out.print("==>> ");
                            String enSuite;
                            enSuite = input.nextLine();
                            if (Room.checkEnSuite(enSuite) == 1) {

                                Room room = new Room(address, roomName, roomSize, level, enSuite, propertyList);
                                RoomNode roomNode = new RoomNode(room);
                                Property property = propertyList.findProperty(address);
                                property.addRoom(room);
                                roomList.addRoom(roomNode);
                                System.out.println(roomList.findRoom(roomName).toString());
                                return room;
                            } else {
                                System.out.println("Error, Requires a Yes or No answer.\n Please try again");
                                return addRoomToPropertyMenu();
                            }
                        } else {
                            System.out.println("Error, Room Level must be between 0 and 10.\n Please try again");
                            return addRoomToPropertyMenu();
                        }
                    } else {
                        System.out.println("Error, Room Size must be Single or Double.\n Please try again");
                        return addRoomToPropertyMenu();
                    }
                } else {
                    System.out.println("Error, Room Already Exists with this Name.\n Please Try again");
                    return addRoomToPropertyMenu();
                }
            } else {
                System.out.println("Error. Property Does not Exist. Please try again");
                return addRoomToPropertyMenu();
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect value entered please start again");
            input.next();
            return addRoomToPropertyMenu();
        }
    }

    /**
     * Opens the "Add Bed to a Room" menu
     * @return The new Bed added
     */
    private Bed addBedToRoomMenu() {
        try {
            input.nextLine();
            System.out.println("Enter Property Address; ");
            System.out.print("==>> ");
            String address;
            address = input.nextLine();
            if (propertyList.findProperty(address) != null) {
                System.out.println("Enter Room Name; ");
                System.out.print("==>> ");
                String roomName;
                roomName = input.nextLine();
                if (roomList.findRoom(roomName) != null) {
                    System.out.println("What would you like to call this Bed?");
                    System.out.print("==>> ");
                    String bedName;
                    bedName = input.nextLine();
                    if (bedList.findBed(bedName) == null) {
                        System.out.println("What type of Bed is this? (Single, Double, Bunk) ");
                        System.out.print("==>> ");
                        String bedType;
                        bedType = input.nextLine();
                        System.out.println("How much does this Bed Cost? ");
                        System.out.print("==>> ");
                        int bedCost;
                        bedCost = input.nextInt();
                        input.nextLine();
                        Student student = null;
                        boolean isFree = true;

                        Bed bed = new Bed(roomName, bedName, bedType, bedCost, roomList, student, isFree);
                        BedNode bedNode = new BedNode(bed);
                        Room room = roomList.findRoom(roomName);
                        room.addBed(bed);
                        bedList.addBed(bedNode);
                        System.out.println(bedList.findBed(bedName).toString());
                        return bed;
                    } else {
                        System.out.println("Error, Bed with this Name already Exists in this Room.\n Please Try again\n");
                        return addBedToRoomMenu();
                    }
                } else {
                    System.out.println("Error. Room Does not Exist. Please try again");
                    return addBedToRoomMenu();
                }
            } else {
                System.out.println("Error. Property Does not Exist. Please try again");
                return addBedToRoomMenu();
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect value entered please start again");
            input.next();
            return addBedToRoomMenu();
        }
    }

    /**
     * Opens the "Add Student" menu
     * @return The new Student added
     */
    private Student addStudentMenu() {
        try {
            System.out.println("Enter Student ID Number; ");
            System.out.print("==>> ");
            int studentID;
            studentID = input.nextInt();
            if (Student.checkID(studentID) == 1) {
                input.nextLine();
                if (studentList.findStudent(studentID) == null) {
                    System.out.println("Enter Student Name; ");
                    System.out.println("==>> ");
                    String name;
                    name = input.nextLine();
                    System.out.println("Enter Student Gender; (M/F)");
                    System.out.print("==>> ");
                    String gender;
                    gender = input.nextLine();
                    System.out.println("Does this Student have a car? (y/n) ");
                    System.out.print("==>> ");
                    String car;
                    car = input.nextLine();

                    Student student = new Student(name, gender, car, studentID);
                    if ((student.getName() != null) && (student.getGender() != null) && (student.getCar() != null)) {
                        StudentNode studentNode = new StudentNode(student);
                        studentList.addStudent(studentNode);
                        System.out.println(studentList.findStudent(studentID));
                        return student;
                    } else {
                        System.out.println("Error, one or more values entered were invalid, please try again");
                        return addStudentMenu();
                    }
                } else {
                    System.out.println("Error: Student ID already Exists. Please try again.");
                    input.nextLine();
                    return addStudentMenu();
                }
            } else {
                System.out.println("Error, Student ID must be between 4 and 8 numbers.\n Please try again");
                input.nextLine();
                return addStudentMenu();
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect value entered please start again");
            input.next();
            return addStudentMenu();
        }
    }

    /**
     * Prints a list of all of the Properties to the Console
     */
    private void listAllProperties() {
        int count = 1;
        if (propertyList.head == null) {
            System.out.println("No Properties in list");
        } else {
            PropertyNode temp = propertyList.head;
            while (temp != null) {
                System.out.println("Property " + count + ")\n" + temp.getProperty().toString());
                temp = temp.getNextNode();
                count++;
                System.out.println("\n");
            }
        }
    }

    /**
     * Lists All Students in the System
     */
    private void listAllStudents() {
        int count = 1;
        if (studentList.head == null) {
            System.out.println("No Students in list");
        } else {
            StudentNode temp = studentList.head;
            while (temp != null) {
                System.out.println("Student " + count + ")\n" + temp.getStudent().toString());
                temp = temp.getNextNode();
                count++;
                System.out.println("\n");
            }
        }
    }

    /**
     * Prints a list of all of the Beds to the Console
     */
    private void listAllBeds() {
        int count = 1;
        BedNode beList = bedList.head;
        PropertyNode propList = propertyList.head;
        RoomNode roList = roomList.head;
        if (propertyList.head == null) {
            System.out.println("No Properties in list");
        } else {
            while (propList != null) {
                System.out.println();
                if (propList.getProperty().getRoomList().head == null) {
                    System.out.println("Error, No Rooms in this property");
                } else {
                    while (roList != null) {
                        if (roList.getRoom().getBedList().head == null) {
                            System.out.println("Error, No Beds in this Room");
                        } else {
                            while (beList != null) {
                                System.out.println("Bed " + count + ")\n" + beList.getBed().toString());
                                beList = beList.getNextNode();
                                count++;
                                System.out.println("\n");
                            }
                        }
                        roList = roList.getNextNode();
                    }
                }
                propList = propList.getNextNode();
            }
        }
    }

    /**
     * Prints a list of all of the Rooms to the Console
     */
    private void listAllRoomsInProperty() {
        int count = 1;
        if (propertyList.head == null) {
            System.out.println("No Properties in list");
        } else {
            input.nextLine();
            System.out.println("Enter Property Address; ");
            System.out.println("==> ");
            String address;
            address = input.nextLine();
            if (propertyList.findProperty(address) != null) {
                if (propertyList.findProperty(address).getRoomList().head != null) {
                    RoomNode temp = propertyList.findProperty(address).getRoomList().head;
                    while (temp != null) {
                        System.out.println("Property Address = " + address + "\n\n" + "Room " + count + ")\n" + temp.getRoom().toString());
                        temp = temp.getNextNode();
                        count++;
                        System.out.println("\n");
                    }
                } else {
                    System.out.println("No Rooms in Property");
                }
            }
        }
    }

    /**
     * Opens the "Assign Student to Bed" menu
     */
    private void assignStudentBedMenu() {
        System.out.println("Enter Property address; ");
        System.out.println("==>> ");
        String address;
        address = input.nextLine();
        if (propertyList.findProperty(address) != null) {
            System.out.println("Enter Room Name; ");
            System.out.println("==>> ");
            String roomName;
            roomName = input.nextLine();
            if (propertyList.findProperty(address).getRoomList().findRoom(roomName) != null) {
                System.out.println("Enter Bed Name; ");
                System.out.println("==>> ");
                String bedName;
                bedName = input.nextLine();
                if ((propertyList.findProperty(address).getRoomList().findRoom(roomName).getBedList().findBed(bedName) != null) && (propertyList.findProperty(address).getRoomList().findRoom(roomName).getBedList().findBed(bedName).getStudent() == null)) {
                    System.out.println("Enter Student ID of the Student you wish to add to this Bed; ");
                    System.out.println("==>> ");
                    int studentID;
                    studentID = input.nextInt();
                    input.nextLine();
                    if (studentList.findStudent(studentID) != null) {
                        propertyList.findProperty(address).getRoomList().findRoom(roomName).getBedList().findBed(bedName).setStudent(studentList.findStudent(studentID));
                        propertyList.findProperty(address).getRoomList().findRoom(roomName).getBedList().findBed(bedName).setIsFree(false);
                        System.out.println(propertyList.findProperty(address).getRoomList().findRoom(roomName).getBedList().findBed(bedName).toString());
                    }
                } else {
                    System.out.println("Error, Bed does not exist or a Student is already assigned to this bed. Please try another");
                    assignStudentBedMenu();
                }
            } else {
                System.out.println("Error. Room does not exist, please try another");
                assignStudentBedMenu();
            }
        } else {
            System.out.println("Error. No Properties in list");
        }
    }

    /**
     * Opens the "Remove Student from Bed" menu
     */
    private void removeStudentFromBedMenu() {
        System.out.println("Enter Property address; ");
        System.out.println("==>> ");
        String address;
        address = input.nextLine();
        if (propertyList.findProperty(address) != null) {
            System.out.println("Enter Room Name; ");
            System.out.println("==>> ");
            String roomName;
            roomName = input.nextLine();
            if (propertyList.findProperty(address).getRoomList().findRoom(roomName) != null) {
                System.out.println("Enter Bed Name; ");
                System.out.println("==>> ");
                String bedName;
                bedName = input.nextLine();
                if ((propertyList.findProperty(address).getRoomList().findRoom(roomName).getBedList().findBed(bedName) != null) && (propertyList.findProperty(address).getRoomList().findRoom(roomName).getBedList().findBed(bedName).getStudent() != null)) {
                    System.out.println("Enter Student ID of Student assigned to this Bed; ");
                    System.out.println("==>> ");
                    int studentID;
                    studentID = input.nextInt();
                    input.nextLine();
                    if (propertyList.findProperty(address).getRoomList().findRoom(roomName).getBedList().findBed(bedName).getStudent().getStudentID() == studentID) {
                        propertyList.findProperty(address).getRoomList().findRoom(roomName).getBedList().findBed(bedName).setStudent(null);
                        propertyList.findProperty(address).getRoomList().findRoom(roomName).getBedList().findBed(bedName).setIsFree(true);
                        System.out.println(propertyList.findProperty(address).getRoomList().findRoom(roomName).getBedList().findBed(bedName).toString());
                        System.out.println("\n Congratulations, you have removed this Student, \n " + studentList.findStudent(studentID) + ",\n\n from this Bed, \n" + propertyList.findProperty(address).getRoomList().findRoom(roomName).getBedList().findBed(bedName).toString());
                    }
                } else {
                    System.out.println("Error, Bed does not exist or no Student is assigned to this bed. Please try another");
                    removeStudentFromBedMenu();
                }
            } else {
                System.out.println("Error. Room does not exist, please try another");
                removeStudentFromBedMenu();
            }
        } else {
            System.out.println("Error. No Properties in list");
        }
    }

    /**
     * Deletes User Specified Bed From the System
     */
    private void deleteBed() {
        System.out.println("Enter Property Address; ");
        System.out.println("==>> ");
        String address;
        address = input.nextLine();
        if(propertyList.findProperty(address) != null) {
            System.out.println("Enter Room Name; ");
            System.out.println("==>> ");
            String roomName;
            roomName = input.nextLine();
            if(propertyList.findProperty(address).getRoomList().findRoom(roomName) != null) {
                BedNode beList = propertyList.findProperty(address).getRoomList().findRoom(roomName).getBedList().head;
                while (beList != null) {
                    System.out.println(beList.toString());
                    beList = beList.getNextNode();
                }
                System.out.println("Enter Name of Bed to be Deleted");
                System.out.println("==>> ");
                String bedName;
                bedName = input.nextLine();
                System.out.println("Deleting \n" + bedList.findBed(bedName).toString());
                bedList.deleteBed(bedName);
                System.out.println("Deleted!");
            }
        }
    }

    /**
     * Deletes User Specified Property From the System
     */
    private void deleteProperty() {
        System.out.println("Enter Address of Property to be Deleted; ");
        System.out.println("==>> ");
        String address;
        address = input.nextLine();
        if (propertyList.findProperty(address) != null) {
            System.out.println("Deleting \n" + propertyList.findProperty(address).toString());
            propertyList.deleteProperty(address);
            if (propertyList.deleteProperty(address) == 1) {
                System.out.println("Deleted!");
            }
        } else {
            System.out.println("Error, Property does not exist. Please try again");
            deletionMenu();
        }
    }

/*    private void incomeMenu() {
        BedNode beList = bedList.head;
        PropertyNode propList = propertyList.head;
        RoomNode roList = roomList.head;
        int propCounter = 1;
        int roCounter = 1;
        int beCounter = 1;
        System.out.println("Enter Property Address; ");
        System.out.println("==>> ");
        String address;
        address = input.nextLine();
        if (propertyList.head == null) {
            System.out.println("No Properties in list");
        } else if (propertyList.findProperty(address) == null) {
            System.out.println("Property Does not exits");
            startMenu();
        } else if (propertyList.findProperty(address) != null) {
            propertyList.findProperty(address).getRoomList();
            while (
                    != null) {
                roList.getRoom().getBedList();
                while (beList != null) {
                    if (beList.getBed().getisFree() == false) {
                        System.out.println("Income generated = " + beList.getBed().getBedCost());
                        beList = beList.getNextNode();
                    }
                }
                roList = roList.getNextNode();
            }
        }
    }*/


    /**
     * Lists all Beds in System with the "Free" Status
     */
    private void listFreeBeds() {
        BedNode beList = bedList.head;
        PropertyNode propList = propertyList.head;
        RoomNode roList = roomList.head;
        int propCounter = 1;
        int roCounter = 1;
        int beCounter = 1;
        if (propertyList.head == null) {
            System.out.println("No Properties in list");
        } else {
            System.out.println();
            while (propList != null) {
                System.out.println("Property " + propCounter + ")");
                if (propList.getProperty().getRoomList().head == null) {
                    System.out.println("Error, No Rooms in this property");
                } else {
                    System.out.println();
                    while (roList != null) {
                        System.out.println("Room " + roCounter + ")");
                        if (roList.getRoom().getBedList().head == null) {
                            System.out.println("Error, No Beds in this Room");
                        } else {
                            System.out.println();
                            while (beList != null) {
                                if(beList.getBed().getisFree()) {
                                    System.out.println("Bed " + beCounter + ")");
                                    System.out.println(beList.getBed().toString());
                                    beList = beList.getNextNode();
                                }
                            }
                        }
                        roCounter++;
                        roList = roList.getNextNode();
                    }
                }
                propCounter++;
                propList = propList.getNextNode();
            }
        }
    }

    /**
     * Deletes User Specified Student From the System
     */
    private void deleteStudent() {
        System.out.println("Enter Student ID Number; ");
        System.out.println("==>> ");
        int studentID;
        studentID = input.nextInt();
        input.nextLine();
        if (studentList.findStudent(studentID) != null) {
            System.out.println("Are you sure you want to delete this student? (y/n)\n" + studentList.findStudent(studentID).toString());
            String confirmation;
            confirmation = input.nextLine();
            if ((confirmation.contains("y")) || (confirmation.contains("Y"))) {
                System.out.println("Deleting \n" + studentList.findStudent(studentID).toString());
                studentList.deleteStudent(studentID);
                System.out.println("Deleted!");
            }
            else if ((confirmation.contains("n")) || (confirmation.contains("N"))) {
                startMenu();
            }
            }
        }

    /**
     * Deletes User Specified Room From System
     */
    private void deleteRoom() {
        System.out.println("Enter Property Address; ");
        System.out.println("==>> ");
        String address;
        address = input.nextLine();
        if(propertyList.findProperty(address) != null) {
                RoomNode roList = propertyList.findProperty(address).getRoomList().head;
                while (roList != null) {
                    System.out.println(roList.toString());
                    roList = roList.getNextNode();
                }
                System.out.println("Enter Name of Room to be Deleted");
                System.out.println("==>> ");
                String roomName;
                roomName = input.nextLine();
                System.out.println("Deleting \n" + roomList.findRoom(roomName).toString());
                roomList.deleteRoom(roomName);
                System.out.println("Deleted!");
            }
        }

    /**
     * Controls the Menus and moves between different menus depending on the user input
     */
    private void runMenu() {
        try {
            int option = startMenu();
            //needed to consume the enter character
            input.nextLine();
            while (option != 0) {
                switch (option) {
                    case 1:
                        input.nextLine();  //will not let user enter address for additional properties created unless this read is there
                        addPropertyMenu();
                        break;
                    case 2:
                        addRoomToPropertyMenu();
                        break;
                    case 3:
                        addBedToRoomMenu();
                        break;
                    case 4:
                        addStudentMenu();
                        break;
                    case 5:
                        listAllProperties();
                        break;
                    case 6:
                        listAllRoomsInProperty();
                        break;
                    case 7:
                        listAllStudents();
                        break;
                    case 8:
                        listAllBeds();
                        break;
                    case 9:
                        listFreeBeds();
                        break;
                    case 10:
                        int option8 = deletionMenu();
                            switch (option8) {
                                case 1:
                                    input.nextLine();
                                    deleteProperty();
                                    break;
                                case 2:
                                    input.nextLine();
                                    deleteRoom();
                                    break;
                                case 3:
                                    input.nextLine();
                                    deleteBed();
                                    break;
                                case 4:
                                    deleteStudent();
                                    break;
                                case 5:
                                    startMenu();
                                    break;
                                default:
                                    System.out.println("Invalid option Entered " + option8);
                                    break;
                            }
                        break;/*
                    case 11:
                        groupPropertiesCVSMenu();
                        break;
                    case 12:
                        groupBedsCVSMenu();
                        break;*/
                    case 13:
                        input.nextLine();
                        assignStudentBedMenu();
                        break;
                    case 14:
                        input.nextLine();
                        removeStudentFromBedMenu();
                        break;/*
                    case 15:
                        input.nextLine();
                        incomeMenu();
                        break;*/
                    default:
                        System.out.println("Invalid option entered: " + option);
                        break;
                }

                //pause the program so that the user can read what we just printed to the terminal window
                System.out.println("\nPress any key to continue...");
                input.nextLine();
                input.nextLine();  //this second read is required - bug in Scanner class; a String read is ignored straight after reading an int.

                //display the main menu again
                option = startMenu();
            }

            //the user chose option 0, so exit the program
            System.out.println("Exiting... bye");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();  //this second read is required - bug in Scanner class; a String read is ignored straight after reading an int.

            //display the main menu again
            startMenu();
        }
    }
}