/**
 * This generic interface models the priority queue abstract data type
 * 
 * @author Mouna AYARI BEN HADJ KACEM
 *
 * @param <T> type parameter extends the Comparable interface
 */
public interface PriorityQueueADT<T extends Comparable<T>> {
  /**
   * inserts a newObject in the priority queue
   * 
   * @param newObject to insert in the priority queue
   */
  public void insert(T newObject); //inserts a newObject in the priority queue


  /**
   * removes and returns the element with the highest priority
   * 
   * @return the removed element
   */
  public T removeBest();


  /**
   * returns without removing the element with the highest priority
   * 
   * @return the element with the highest priority
   */
  public T peekBest();


  /**
   * checks if the priority queue is empty
   * 
   * @return true if the priority queue is empty, false otherwise
   */
  public boolean isEmpty();
}
