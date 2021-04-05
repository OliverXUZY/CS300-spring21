/////////////// LinkedBox class (INCLUDE IN EVERY FILE) //////////////////////////
//
//Title: (descriptive title of the program making use of this file)
//Course: CS 300 Fall 2020
//
//Author: Zhuoyan Xu
//Email: zxu444@wisc.edu
//Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
//Persons: Hobbes LeGault
//Online Sources: zybook + piazza
//
///////////////////////////////////////////////////////////////////////////////
/**
* 
* @author Zhuoyan Xu
* This is the LinkedBox class
*/
public class LinkedBox {
  private Box box;
  private LinkedBox next;
  
  /**
   * Creates a new LinkedBox with a specified box and null as next field
   * @param box
   */
  public LinkedBox (Box box) {
    this.box = box;
  }
  
  /**
   * Creates a new LinkedBox node with given box and next fields
   * @param box
   * @param next
   */
  public LinkedBox(Box box, LinkedBox next) {
    this.box = box;
    this.next = next;
  }
  
  /**
   * 
   * @return Returns the data field box
   */
  public Box getBox() {
    return this.box;
  }
  
  /**
   * 
   * @return Returns the next linked box node
   */
  public LinkedBox getNext() {
    return this.next;
  }
  
  /**
   * Sets the link to the next linked box node
   * @param next
   */
  public void setNext (LinkedBox next) {
    this.next = next;
  }

  @Override
  public String toString() {
    if(this.next != null) {
      return this.box.toString() + " -> ";
    }
    else {
      return this.box.toString() + " -> END";
    }
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
