import java.util.Iterator;
import java.util.NoSuchElementException;
/////////////// OrderIterator class (INCLUDE IN EVERY FILE) //////////////////////////
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
* This is the OrderIterator class
*/
public class OrderIterator implements Iterator<Order> {
  private LinkedOrder current; // the LinkedOrder that it’s currently using

  /**
   * ○ Constructor, initializes current to the provided starting LinkedOrder. ○ Does not care
   * whether the argument value is null.
   * 
   * @param start
   */
  public OrderIterator(LinkedOrder start) {
    this.current = start;
  }

  /**
   * ○ Returns true if and only if the iteration has more orders
   */
  @Override
  public boolean hasNext() {
    if (current != null)
      return true;
    return false;
  }

  @Override
  /**
   * ○ Throws a NoSuchElementException with a descriptive error message if the iteration does not
   * have more orders to return. ○ Otherwise returns the next Order and updates the current field
   * appropriately.
   */
  public Order next() throws NoSuchElementException {
    if (!hasNext())
      throw new NoSuchElementException("No next!");

    LinkedOrder retval = this.current;
    this.current = retval.getNext();
    return retval.getOrder();
  }

}
