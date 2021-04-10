import java.util.Iterator;
import java.util.NoSuchElementException;
/////////////// OrderQueue class (INCLUDE IN EVERY FILE) //////////////////////////
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
* This is the OrderQueue class
*/
public class OrderQueue implements QueueADT<Order>, Iterable<Order> {
  private LinkedOrder front;
  private LinkedOrder back;
  private int size = 0;

  @Override
  /**
   * ○ Creates and returns a new OrderIterator beginning with the current value of front
   */
  public Iterator<Order> iterator() {
    OrderIterator orderIte = new OrderIterator(front);
    return orderIte;
  }

  @Override
  /**
   * ○ Adds a new LinkedOrder containing newElement to the back of the queue, updating the size
   * variable and front/back references appropriately
   */
  public void enqueue(Order newElement) {
    LinkedOrder newOrder = new LinkedOrder(newElement);
    if (isEmpty()) {
      front = newOrder;
      back = front;
    } else {
      back.setNext(newOrder);
      back = newOrder;
    }
    size++;
  }

  @Override
  /**
   * ○ Removes the next LinkedOrder from the front of the queue and returns its Order, updating the
   * size variable and front/back references appropriately ○ Throws a NoSuchElementException if the
   * queue is empty
   */
  public Order dequeue() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException("Error! No order to dequeue.");
    }
    Order removed = this.front.getOrder();
    if (this.size == 1) {
      this.front = null;
      this.back = null;
    } else {
      this.front = this.front.getNext();
    }
    this.size--;
    return removed;
  }

  @Override
  /**
   * ○ Returns the Order from the LinkedOrder at the front of the queue without removing the
   * LinkedOrder from the queue ○ Throws a NoSuchElementException if the queue is empty
   */
  public Order peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Empty queue!");
    }

    return front.getOrder();
  }

  @Override
  /**
   * ○ Returns true if and only if the queue is empty
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Creates and returns a String representation of this OrderQueue using an enhanced-for loop. For
   * example, a queue with three Orders * might look like this: 1001: fries (2) -> 1002: shake (1)
   * -> 1003: burger (3) -> END
   *
   * @return A String representation of the queue
   */
  @Override
  public String toString() {
    if (this.size == 0)
      return "";
    String qString = "";
    for (Order o : this) {
      qString += o.toString();
      qString += " -> ";
    }
    qString += "END";
    return qString;
  }

}
