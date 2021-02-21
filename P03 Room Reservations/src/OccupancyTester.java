import java.util.ArrayList;

//////////////// OccupancyTester class (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: (descriptive title of the program making use of this file)
// Course: CS 300 Fall 2020
//
// Author: Zhuoyan Xu
// Email: zxu444@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: Hobbes LeGault
// Online Sources: zybook + piazza
//
///////////////////////////////////////////////////////////////////////////////
/**
 * 
 * @author Zhuoyan Xu
 * 
 *         This is OccupancyTester function
 */
public class OccupancyTester {
  private static ArrayList<Person> peopleList = new ArrayList<Person>();
  private static ArrayList<Room> roomsList = new ArrayList<Room>();

  /**
   * test the constructor, accessors, mutator, and equals method of your ​Person ​class
   * 
   * @return
   */
  public static boolean testPerson() {
    boolean isWorked = true;
    Person Sam = new Person("Sam");
    Person Oliver = new Person("Oliver");
    Person Maddie = new Person("Maddie");
    Person[] people = new Person[] {Sam, Oliver, Maddie};
    String[] names = new String[] {"Sam", "Oliver", "Maddie"};

    // added to total peopleList
    peopleList.add(Sam);
    peopleList.add(Oliver);
    peopleList.add(Maddie);

    // check getName(
    for (int i = 0; i < people.length; i++) {
      if (!people[i].getName().equals(names[i])) {
        System.out.println("Error in getName()! Expected to get " + names[i] + ", but got "
            + people[i].getName() + " instead.");
        isWorked = false;
      }
    }

    // check toggleWaiting()
    for (int i = 0; i < people.length; i++) {
      people[i].toggleWaiting();
      if (people[i].isWaiting() != false) {
        System.out.println("Error in toggleWaiting()!");
        isWorked = false;
      }

      people[i].toggleWaiting();
      if (people[i].isWaiting() == false) {
        System.out.println("Error in toggleWaiting() back!");
        isWorked = false;
      }

    }

    // check equal
    if (Sam.equals(Oliver) || !Sam.equals(Sam) || Sam.equals(names[0])) {
      isWorked = false;
    }

    return isWorked;
  }

  /**
   * test the constructor of your Room ​class
   * 
   * @return
   */
  public static boolean testRoomConstructor() {
    boolean isWorked = true;
    Room Stat = new Room("Stat", 8);

    // added to total roomsList
    roomsList.add(Stat);

    // Try creating two ​Rooms ​with the same name. Make sure you can’t.
    try {
      Room Stat2 = new Room("Stat", 9);
    } catch (IllegalArgumentException except) {
      System.out.println(except.getMessage() + "\nSpecifically: room name already used");
    }

    return isWorked;
  }

  /**
   * test the accessor methods of your Room ​class -- this includes both the static ​AND​ instance
   * accessor methods!
   * 
   * @return
   */
  public static boolean testRoomAccessors() {
    boolean isWorked = true;
    Room Econ = new Room("Econ", 8);
    Room CS = new Room("CS", 20);
    Room Math = new Room("Math", 5);
    Room[] rooms = new Room[] {Econ, CS, Math};
    String[] roomNames = new String[] {"Stat", "Econ", "CS", "Math"};
    int[] roomsCapacity = new int[] {8, 20, 5};

    // added to total roomsList
    roomsList.add(Econ);
    roomsList.add(CS);
    roomsList.add(Math);


    // check getName() and getCapacity()
    for (int i = 0; i < rooms.length; i++) {
      if (!rooms[i].getName().equals(roomNames[i + 1])) {
        System.out.println("Error in getName()! Expected to get " + roomNames[i + 1] + ", but got "
            + rooms[i].getName() + " instead.");
        isWorked = false;
      }
      if (!(rooms[i].getCapacity() == roomsCapacity[i])) {
        System.out.println("Error in getOccupancy()! Expected to get " + roomsCapacity[i]
            + ", but got " + rooms[i].getCapacity() + " instead.");
        isWorked = false;
      }
    }

    // check Array names in order
    String[] names = Room.getNames();
    for (int i = 0; i < roomNames.length; i++) {
      if (!names[i].equals(roomNames[i])) {
        System.out.println("Error in static method Room.getNames()! Expected to get " + roomNames[i]
            + ", but got " + names[i] + " instead.");
        isWorked = false;
      }
    }

    return isWorked;
  }

  /**
   * ​to test the check-in functionality and its effects on both the ​Room ​and the ​Person ​being
   * checked in
   * 
   * @return
   */
  public static boolean testRoomCheckIn() {
    boolean isWorked = true;
    Room Stat = roomsList.get(0);
    Stat.checkIn(peopleList.get(0)); // add Sam
    Stat.checkIn(peopleList.get(1)); // add Oliver
    Stat.checkIn(peopleList.get(2)); // add Maddie
    

    roomsList.set(0, Stat);

    // peopleList.add(new Person("Leo"));
    // Stat.checkIn(peopleList.get(3));

    // check whether toggleWaiting() works
    for (int i = 0; i < peopleList.size(); i++) {
      if (peopleList.get(i).isWaiting() == true) {
        isWorked = false;
      }
    }

    // check thrown exception if check-in null
    try {
      Stat.checkIn(null);
    } catch (IllegalArgumentException except) {
      System.out.println(except.getMessage());
    }

    // System.out.println(Stat.toString());
    return isWorked;
  }

  /**
   * to test the check-out functionality and its effects on both the Room and the Person being
   * checked out
   * 
   * @return
   */
  public static boolean testRoomCheckOut() {
    boolean isWorked = true;
    // from last function, we have Stat has three people Sam, Oliver and Maddie
    Room Stat = roomsList.get(0);
    Stat.checkOut(peopleList.get(1)); // remove Oliver only

    // check whether toggleWaiting() works
    if (peopleList.get(1).isWaiting() != true) {
      isWorked = false;
    }

    // check thrown exception if check-out null
    try {
      Stat.checkOut(null);
    } catch (IllegalArgumentException except) {
      System.out.println(except.getMessage());
    }


    // System.out.println(Stat.toString());
    return isWorked;
  }

  /**
   * to verify the result of ​Room’​stoString method
   * 
   * @return
   */
  public static boolean testRoomToString() {
    boolean isWorked = false;
    Room Stat = roomsList.get(0);
    String printedString = Stat.toString();

    String correctString = "";
    correctString += "Stat\n===\n";
    for (int i = 0; i < Stat.getCapacity(); i++) {
      if (i == 0) {
        correctString += "Sam\n";
      } else if (i == 4) {
        correctString += "Maddie\n";

      } else {
        correctString += "-\n";
      }
    }
    if (printedString.equals(correctString)) {
      isWorked = true;
    }
    return isWorked;
  }



  public static void main(String[] args) {
    System.out.println("Result of testPerson(): " + testPerson());
    System.out.println("Result of testRoomConstructor(): " + testRoomConstructor());
    System.out.println("Result of testRoomAccessors(): " + testRoomAccessors());
    System.out.println("Result of testRoomCheckIn(): " + testRoomCheckIn());
    System.out.println("Result of testRoomCheckOut(): " + testRoomCheckOut());
    System.out.println("Result of testRoomToString(): " + testRoomToString());
  }

}
