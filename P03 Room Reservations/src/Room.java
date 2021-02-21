import java.util.ArrayList;

//////////////// Room class (INCLUDE IN EVERY FILE) //////////////////////////
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
 *         This is Room class
 */
public class Room {
  private static ArrayList<String> names = new ArrayList<String>(10); // an ArrayList of Strings
  // containing the currently-used
  // name identifiers across all
  // instances of Room objects
  private String name; // a String representing the name of the Room, which must be unique
  private Person[] occupants; // a​ perfect-size​ array of Persons currently in the Room, with
                              // social distancing
                              // enforced: Person objects may only occupy elements with even
                              // indexes, all odd indexes must
                              // always contain null
  private int currentOccupancy; // an int counting the current number of Persons in the Room


  /**
   * class method
   * 
   * @return the current list of Room names as an array of Strings
   */
  public static String[] getNames() {
    String[] nameString = new String[names.size()];
    for (int i = 0; i < names.size(); i++) {
      nameString[i] = names.get(i);
    }
    return nameString;
  }


  /**
   * A two-argument constructor, which initializes the instance variables for the object ○ Note that
   * capacity is the maximum number of Persons who can occupy the room without ​social distancing
   * enforced ○ If the provided capacity is 0 or less, or if the name is already in use by another
   * Room object, this constructor should throw an IllegalArgumentException with a descriptive error
   * message; do not make any changes to the Room.names ArrayList ○ If the Room is created
   * successfully, add its name to the Room.names ArrayList
   * 
   * @param name
   * @param capactity
   */
  public Room(String name, int capacity) throws IllegalArgumentException {
    // check name used or not
    this.name = name.trim();
    boolean isUsed = false;
    for (int i = 0; i < names.size(); i++) {
      if (name == names.get(i)) {
        isUsed = true;
      }
    }

    if (capacity <= 0 || isUsed) {
      throw new IllegalArgumentException(
          "Error! Provided capacity is 0 or less, or if the name is already in use by another "
              + "Room object");
    }
    this.occupants = new Person[capacity];
    this.names.add(this.name);
  }

  // a bunch of instance methods
  // 1) constructor
  /**
   * 
   * @return the name of this Room
   */
  public String getName() {
    return this.name;
  }

  // 2) accessor
  /**
   * the current number of people in the Room
   * 
   * @return
   */
  public int getOccupancy() {
    return this.currentOccupancy;
  }

  /**
   * 
   * @return the number of people allowed in the Room under COVID protocols, defined for our
   *         purposes as ​half of normal capacity
   */
  public int getCOVIDCapacity() {
    return (this.occupants.length + 1) / 2;
  }

  /**
   * 
   * @return the number of people allowed in the Room under normal conditions
   */
  public int getCapacity() {
    return this.occupants.length;
  }

  /**
   * 
   * @param p
   * @return true if and only if the provided Person is present in the Room’s occupants array
   */
  public boolean contains(Person p) throws IllegalArgumentException{
    boolean isContained = false;
    if (p == null) {
      throw new IllegalArgumentException("Error! Person is NULL!");
    }
    for (Person per : occupants) {
      if (p.equals(per)) {
        isContained = true;
      }
    }
    return isContained;
  }


  // 3) mutator
  /**
   * 
   * @param in
   * @return returns true if and only if the provided Person was successfully added to the room.
   */
  public boolean checkIn(Person in) throws IllegalArgumentException {
    boolean isCheckin = false;
    if (in == null) {
      throw new IllegalArgumentException("Error! Person is NULL!");
    }
    if(in.isWaiting() == false) {
      throw new IllegalArgumentException("Sorry, person already in the room!");
    }
    if (this.currentOccupancy == this.getCOVIDCapacity()) {
      System.out.println("Sorry, current COVID capacity full!");
      return isCheckin;
    }
    
    // occupants = 9 or 10; COVIDCapacity = 5; person index = 0,2,4,6,8
    for (int idx = 0; idx < this.getCOVIDCapacity(); idx++) {
      if (this.occupants[2 * idx] == null) {
        this.occupants[2 * idx] = in;
        in.toggleWaiting();
        this.currentOccupancy++;
        isCheckin = true;
        break;
      }
    }

    return isCheckin;
  }

  /**
   * 
   * @param out
   * @return returns true if and only if the provided Person was successfully removed from the Room.
   */
  public boolean checkOut(Person out) throws IllegalArgumentException {
    boolean isOut = false;
    if (out == null) {
      throw new IllegalArgumentException("Error! Person is NULL!");
    }
    if(!this.contains(out)) {
      System.out.println("Sorry, did not find the person in the room!");
      return isOut;
    }

    for (int idx = 0; idx < this.getCOVIDCapacity(); idx++) {
      if (out.equals(this.occupants[idx])) {
        this.occupants[idx] = null;
        out.toggleWaiting();
        this.currentOccupancy--;
        isOut = true;
        break;
      }
    }
    return isOut;
  }

  /**
   * @return a String representation of this Room and its occupants
   */
  public String toString() {
    String repre = "";
    repre += this.name + "\n===\n";

    for (int i = 0; i < this.getCapacity(); i++) {
      if (this.occupants[i] == null) {
        repre += "-\n";
      } else {
        repre += this.occupants[i].getName() + "\n";
      }
    }
    return repre;
  }


  /*
   * public static void main(String[] Args) { 
   * //System.out.println(names.size()); 
   * try { 
   * Room key = new Room("key", 2); 
   * System.out.println(key.getCapacity());
   * 
   * String repre = ""; 
   * repre += key.getName() +"\n 1"; 
   * repre += "==="; System.out.println(repre);
   * 
   * } 
   * catch(IllegalArgumentException except) { System.out.println(except.getMessage()); }
   * 
   * 
   * 
   * 
   * //System.out.println(Marry.equals(Sam)); }
   */

}


