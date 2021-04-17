package full;
import java.util.NoSuchElementException;

/**
 * Implementation of the QueueADT using a singly linked list
 * 
 */

public class LinkedQueue<T> implements QueueADT<T> {
  private LinkedNode<T> front; // front of the queue pointing to
                               // the first node in the queue
  private LinkedNode<T> back; // pointer to the last node in the queue
  private int size; // size of the queue


  /**
   * Creates an empty instance of LinkedQueue
   */
  public LinkedQueue() {
    front = null;
    back = null;
    size = 0;
  }
  
  /**
   * Checks whether this queue is empty or not
   * 
   * @return true if this queue is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    // Running Time: O(1)
    // TODO
    /* MISSING CODE */
    return false;
  }

  
  /**
   * Inserts an element/item at the back of the queue.
   * 
   * @param newObject item or element to add at the back (end) of the queue.
   */
  @Override
  public void enqueue(T newObject) {
    // Running Time: O(1)
    // This method is equivalent to add at the end of a linked list when the 
    // the tail reference (here called back) is available

    /* MISSING CODE */

  }

  /**
   * Removes and returns the first element of the queue.
   * 
   * @return the element at the front of the queue if the queue is not empty.
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public T dequeue() {
    // Running Time: O(1)
    // This method is equivalent to remove the element at index 0 from a
    // linked list

    /* MISSING CODE */
    return null;
  }

  /**
   * returns, but does not remove, the first element of the queue.
   * 
   * @return the element at the front of the queue if the queue is not empty.
   * @throws NoSuchElementException if the queue is empty.
   */
  @Override
  public T peek() {
    // Running Time: O(1)
    // This method gets the element at index 0 (at the front of this queue)
    /* MISSING CODE */
    
    return null;
    
  }
  
  /**
   * Returns the size of this queue
   * @return the size of the linked queue
   */
  public int size() {
    // Running Time: O(1)   

    /* MISSING CODE */
    return 0;
    
  }


}