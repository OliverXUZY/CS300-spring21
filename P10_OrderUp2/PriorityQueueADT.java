/////////////// PriorityQueueADT class (INCLUDE IN EVERY FILE) //////////////////////////
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
* @author Zhuoyan Xu This is the PriorityQueueADT class
*/

/**
 * The required operations for a PriorityQueue implementation.
 * 
 * @param <T> The type of item contained in the PriorityQueue; must implement the Comparable<T>
 * interface.
 */
public interface PriorityQueueADT <T extends Comparable<T>> {

  /**
   * Insert item newData after all equal or higher priority items
   * @param newData the item to be inserted
   */
  public void insert(T newData);
  
  /**
   * Remove the highest priority item from the queue and adjust the queue accordingly
   * @return the current highest priority item from the queue
   */
  public T removeBest();
  
  /** 
   * Return the highest priority item from the queue without altering the queue
   * @return the current highest priority item from the queue
   */
  public T peekBest();
  
  /**
   * Returns true if the queue contains no items, false otherwise
   * @return true if the queue contains no items, false otherwise
   */
  public boolean isEmpty();
  
}
