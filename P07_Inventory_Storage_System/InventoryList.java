/////////////// InventoryList class (INCLUDE IN EVERY FILE) //////////////////////////
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
* This is the InventoryList class
*/
public class InventoryList {
  private LinkedBox head;
  private LinkedBox tail;
  
  private int size = 0;
  private int yellowCount = 0;
  private int blueCount = 0; 
  private int brownCount = 0;
  
  
  /**
   * 
   * @return the size of this LinkedBoxList
   */
  public int size() {
    return this.size;
  }
  
  /**
   * true if this LinkedBoxList is empty, false otherwise
   * @return
   */
  public boolean isEmpty() {
    if(this.head == null) {
      return true;
    }
    return false;
  }
  
  /**
   * Removes all of the elements from this list. The list will be empty after this call returns.
   */
  public void clear() {
    this.head = null;
    this.tail = null;
    this.size = 0;
    this.yellowCount = 0;
    this.brownCount = 0;
    this.blueCount = 0;
  }
  
  /**
   * Adds a new yellow box at the head of this list
   * @param yellowBox
   * @throws IllegalArgumentException
   */
  public void addYellow(Box yellowBox) throws IllegalArgumentException{
    if (yellowBox == null || yellowBox.getColor() != Color.YELLOW) {
      throw new IllegalArgumentException(
          "Error!  yellowBox is null or if its color does not equal to Color.YELLOW"
             );
    }
    LinkedBox linkedBox = new LinkedBox(yellowBox);
    // if empty list
    if (this.head == null) {  
      this.head = linkedBox;
      this.tail = linkedBox;
    } else {
      linkedBox.setNext(this.head);
      this.head = linkedBox;
    }
    
    this.size++;
    this.yellowCount++;
  }
  
  /**
   * Adds a brown box at the end of this inventory list
   * @param brownBox
   * @throws IllegalArgumentException
   */
  public void addBrown(Box brownBox) throws IllegalArgumentException{
    
    if (brownBox == null || brownBox.getColor() != Color.BROWN) {
      throw new IllegalArgumentException(
          "Error!  brownBox is null or if its color does not equal to Color.BROWN"
             );
    }
    
    //System.out.println("add brown, tail is " + this.tail);
    LinkedBox linkedBox = new LinkedBox(brownBox);
    // if empty list
    if (this.head == null) {  
      this.head = linkedBox;
      this.tail = linkedBox;
    } else {
      this.tail.setNext(linkedBox);
      this.tail = linkedBox;
    }
    
    this.size++;
    this.brownCount++;
  }
  
  /**
   * Adds a new blue box at the top of blue boxes if the list contains any blue box. 
   * Blue boxes must be added at the bottom of yellow boxes and at the top of all the 
   * brown boxes if any. This means that a new blue box must be added at index yellowCount.
   * @param blueBox
   * @throws IllegalArgumentException
   */
  
  public void addBlue(Box blueBox) throws IllegalArgumentException {
    if (blueBox == null || blueBox.getColor() != Color.BLUE) {
      throw new IllegalArgumentException(
          "Error!  blueBox is null or if its color does not equal to Color.BLUE"
             );
    }
    
    LinkedBox linkedBox = new LinkedBox(blueBox);
    // if empty list
    if(this.head == null) {
      this.head = linkedBox;
      this.tail = linkedBox;
    }

    //System.out.println("add blue, yellow count is " + this.yellowCount);
    if(this.yellowCount == 0) { // add to head
      linkedBox.setNext(this.head);
      this.head = linkedBox;
    } else if (this.size == 1) { //add to tail
      this.head.setNext(linkedBox);
      this.tail = linkedBox;
    } else {
   // add to index of yellowCount
      LinkedBox yellowLast = this.head;
      for(int i = 0; i < yellowCount-1; i++) {
        yellowLast = yellowLast.getNext();
      }
      linkedBox.setNext(yellowLast.getNext());
      yellowLast.setNext(linkedBox);
      //System.out.println("add blue, " + yellowLast.getNext());
    }
    
    
    this.size++;
    this.blueCount++;
    
  }
  
  /**
   * Returns the element stored at position index of this list without removing it.
   * @param index
   * @return
   */
  public Box get(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(
          "Error!  Index out of bounds!"
             );
    }
    
    if(isEmpty()) return null;
    
    LinkedBox current = this.head;
    for(int i = 0; i < index; i++) {
      current = current.getNext();
    }
    
    return current.getBox();
  }
  
  /**
   * Removes and returns the box at the head of this list if its color is yellow
   * @return a reference to the removed box
   * @throws java.util.NoSuchElementException
   */
  public Box removeYellow() throws java.util.NoSuchElementException {
    if(this.yellowCount == 0) {
      throw new java.util.NoSuchElementException("Error! No yellow box to remove.");
    }
    
    Box removed = this.head.getBox();
    if(this.size == 1) {
      this.head = null;
      this.tail = null;
    } else {
      this.head = this.head.getNext();
    }
    
    this.size--;
    this.yellowCount--;
    return removed;
  }
  
  /**
   * Removes and returns the element at the tail of this list if it has a brown color
   * @return a reference to the removed box
   * @throws java.util.NoSuchElementException
   */
  public Box removeBrown() throws java.util.NoSuchElementException {
    if(this.brownCount == 0) {
      throw new java.util.NoSuchElementException("Error! No brown box to remove.");
    }
    
    Box removed = this.tail.getBox();
    if(this.size == 1) {
      this.head = null;
      this.tail = null;
    } else {
      LinkedBox last = this.head;
      // find second to last linkedBox, turn it into last(tail)
      for(int i = 0; i < this.size-2; i++) {
        last = last.getNext();
      }
      last.setNext(null);
      this.tail = last;
    }
    
    this.size--;
    this.brownCount--;
    return removed;
  }
  
  /**
   * decrease color count based on box
   * @param box
   */
  private void decreaseColorCount(Box box) {
    //System.out.print(box1.toString() + "\n" + box2.toString() );
    Color color = box.getColor();
    switch(color) {
      case BLUE:
        this.blueCount--;
        break;
      case YELLOW:
        this.yellowCount--;
        break;
      case BROWN:
        this.brownCount--;
        break;
    }
  }
  
  /**
   * Removes and returns a box given its inventory number from this list
   * @param inventoryNumber
   * @return a reference to the removed element
   * @throws java.util.NoSuchElementException
   */
  public Box removeBox(int inventoryNumber) throws java.util.NoSuchElementException {
    if (this.size == 0)
      throw new java.util.NoSuchElementException("Error! Try to remove from an empty list.");
    
    Box removed = this.head.getBox(); // random initialize, does not matter
    boolean found = false;
    
    // found at head
    if(this.head.getBox().getInventoryNumber() == inventoryNumber) {
      found = true;
      removed = this.head.getBox();
      if(this.size == 1) {
        this.head = null;
        this.tail = null;
      } else {
        this.head = this.head.getNext();
      }
      
      this.decreaseColorCount(removed);
      this.size--;
      return removed;
    }
    
    // found at tail
    if(this.tail.getBox().getInventoryNumber() == inventoryNumber) {
      found = true;
      removed = this.tail.getBox();
      if(this.size == 1) {
        this.head = null;
        this.tail = null;
      } else {
        LinkedBox last = this.head;
        // find second to last linkedBox, turn it into last(tail)
        for(int i = 0; i < this.size-2; i++) {
          last = last.getNext();
        }
        last.setNext(null);
        this.tail = last;
      }
      this.decreaseColorCount(removed);
      this.size--;
      return removed;
    }
   
    //found at middle
    LinkedBox previous = this.head;
    LinkedBox current = previous.getNext();
    for(int i = 1; i < this.size; i++) {
      if(current.getBox().getInventoryNumber() == inventoryNumber) {
        found = true;
        removed = current.getBox();
        previous.setNext(current.getNext());
        break;
      } else {
        previous = current;
        current = current.getNext();
      }
    }
    
    
    if(!found) {
      throw new java.util.NoSuchElementException("Error! No box is found"
          + " with the provided inventory number in the list.");
    } else {
      this.decreaseColorCount(removed);
      this.size--;
      return removed;
    }       
  }
  
  /**
   * Returns the number of brown boxes stored in this list
   * @return
   */
  public int getBrownCount() {
    return this.brownCount;
  }
  
  /**
   * Returns the number of yellow boxes stored in this list
   * @return
   */
  public int getYellowCount() {
    return this.yellowCount;
  }
  
  /**
   * Returns the number of blue boxes stored in this list
   * @return
   */
  public int getBlueCount() {
    return this.blueCount;
  }
  
  @Override
  public String toString(){
    if(this.size == 0) {
      return "";
    } else {
      LinkedBox current = this.head;
      //System.out.println(current);
      String res = current.toString();
      for(int i = 1; i < this.size; i++) {
        current = current.getNext();
        //System.out.println(current);
        res += current.toString();
      }
      return res;
    }
    
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

}
