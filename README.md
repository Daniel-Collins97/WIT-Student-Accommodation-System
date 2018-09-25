# WIT-Student-Accommodation-System

This Project is based on an automated accommodation system for students, having rooms, and beds etc and displaying if they are occupied or not.

### Prerequisites

For this project, I used the Intellij IDEA Java IDE, which allowed me to write the programme and also run the code, including running the tests

### The Project Contents

This project involved using a custom made linked list and a CSV file to initialise some data. The Linked List has been constructed using Nodes, where every object is first created, then inserted into their respective Node templates, and each node is then added to a linked list (essentially having each node "point" to a different node)
I had 4 core objects, "Bed", "Property", "Room", and "Student", with each of these having their respective Node Templates and Linked List Structure.
I implemented some CRUD abilities to all of the list structures, which were called through the Menu Controller. These CRUD abilities included;
- Adding a Bed, Property, Room, and Student
- Adding a Room to a Property
- Adding a Bed to a Room
- Adding a Student to a Bed
- Listing all Properties
- Lisitng all Rooms in a particular Property
- Lisitng all Beds in a particular Room
- Listing all Students assigned to a particular Bed (1 max)
- Adding a group of Properties using a CSV file
- Adding a group of Beds using a CSV file
- Removing a Student from a Bed
- Deleting a Bed, Property, Room, and Student


## Tests

I have included 6 JUnit tests in this project. 
BedTest;
      This test attempts to add a newly created Bed to a Room in a Property. If said Property and/or Room does not exist, the programme will catch this and give the user an error message and ask them to try again. It also tests that the adding to the list function works by creating multiple properties and rooms and adding them to their specific lists.
      
PropertyListTest;
      This test simply checks that adding to a list works, by creating multiple Property objects and adding them to a Property List. The validation then does a search of certain addresses in the list to ensure the properties have been added.
      

StudentListTest;
      This test does the same as the PropertyListTest above, but for Students
      
      
PropertyTest;
      This test checks the construstor and the getters and setters for creating a Property Object, ensureing proper validation techniques have been implemented.
      
      
RoomTest;
      This test does the same as the Property Test above, but for Room Objects
      
StudentTest;
      This test does the same as both the PropertyTest and RoomTest above, but for Students.


## Built With

* [Intellij IDEA](https://www.jetbrains.com/idea/) - The IDE environment used
* [Github](https://github.com/) - Version Control System used


## Authors

* **Daniel Collins**

This was a solo project completed as part of my studies in the WIT I.o.T Degreee
