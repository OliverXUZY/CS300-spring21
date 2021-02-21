//////////////// Person class (INCLUDE IN EVERY FILE) //////////////////////////
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
 *         This is Person class
 */
public class Person {
  // private field
  private String name;
  private boolean isWaiting;

  /**
   * one parameter constructor
   * 
   * @param name
   */
  public Person(String name) {
    this.name = name;
    this.isWaiting = true;
  }

  /**
   * accessor for name
   * 
   * @return
   */
  public String getName() {
    return this.name;
  }

  /**
   * accessor for isWaiting
   * 
   * @return
   */
  public boolean isWaiting() {
    return this.isWaiting;
  }

  /**
   * Sets isWaiting to true if it is currently false, and to false if it is currently true
   */
  public void toggleWaiting() {
    if (this.isWaiting) {
      this.isWaiting = false;
    } else {
      this.isWaiting = true;
    }
  }

  /**
   * test whether two objects have the same name
   */
  public boolean equals(Object o) {
    if (o instanceof Person) {
      return this.name.equals(((Person) o).name); // ??
    }
    return false;
  }

  
   public static void main(String[] Args) { 
     Person Marry = new Person("Ned"); 
     Person Sam = new Person("Ned"); 
     System.out.println(Marry.equals(Sam)); }
   

}


