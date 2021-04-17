package full;
/**
 * This interface defines the queue abstract data type (QueueADT). 
 * Items are inserted and deleted in this queue according to 
 * the first-in, first-out (FIFO) principle. This interface is generic.
 * 
 * @param <T> represents any type (any reference type)
 */
public interface QueueADT<T> {
  // List of Operations
  /**
   * inserts an element/item at the back of the queue
   * 
   * @param newObject item or element to add at the back (end) of the queue
   */
  public void enqueue(T newObject);

  /**
   * removes and returns the first element of the queue.
   * 
   * @return the element at the front of the queue if the queue is not empty. 
   *         Otherwise, it throws an exception or returns null.
   */
  public T dequeue();

  /**
   * returns, but does not remove, the first element of the queue.
   * 
   * @return the element at the front of the queue if the queue is not empty. 
   *         Otherwise, it throws an exception or returns null.
   */
  public T peek();

  /**
   * tests whether the queue is empty or not
   * 
   * @return true if the queue is empty, false otherwise
   */
  public boolean isEmpty();
} // end QueueADT generic interface