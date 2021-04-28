import java.util.Arrays;
import java.util.NoSuchElementException;
// Remember to add your file header here
/////////////// OrderPriorityQueue class (INCLUDE IN EVERY FILE) //////////////////////////
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
* This is the OrderPriorityQueue class



/**
 * A max-heap implementation of a priority queue for Orders, where the Order with the LONGEST prep 
 * time is returned first instead of the strict first-in-first-out queue as in P08.
 * 
 *  Make sure Order implements Comparable<Order> so that this class can implement the
 * PriorityQueueADT without error!
 */
public class OrderPriorityQueue implements PriorityQueueADT<Order>{

  // Data fields; do not modify
  private Order[] queueHeap;
  private int size;
  
  /**
   * Constructs a PriorityQueue for Orders with the given capacity
   * 
   * @param capacity the initial capacity for the queue
   * @throws IllegalArgumentException if the given capacity is 0 or negative
   */
  public OrderPriorityQueue(int capacity) {
    //  throw IllegalArgumentException if capacity is invalid
    if (capacity < 0) throw new IllegalArgumentException(
        "Error! Cannot create a priority queue with a negative capacity.");
    // initialize data fields appropriately
    queueHeap = new Order[capacity];
    size = 0;
  }
  
  /**
   * Inserts a new Order into the queue in the appropriate position using a heap's add logic.
   * 
   * @param newOrder the Order to be added to the queue
   */
  @Override
  public void insert(Order newOrder) {
    // If the queue is empty, insert the new order at the root of the heap
    if(isEmpty()) {
      queueHeap[0] = newOrder;
      size++;
      return;
    }
    
    
    // If the queue is FULL, create a new Order array of double the current heap's size,
    // copy all elements of the current heap over and update the queueHeap reference
    // -> HINT: use Arrays.copyOf(), copying arrays is not the point of this assignment
    if(size == queueHeap.length) {
      Order[] copy = Arrays.copyOf(queueHeap, queueHeap.length*2);
      queueHeap = copy;
    }

    //  add the newOrder to the end of the heap and percolate up to ensure a valid heap, where
    // the Order with the LONGEST prep time is at the root of the heap
    queueHeap[size] = newOrder;
    size++;
    percolateUp(queueHeap, size-1);
    
    
  }
  
  /**
   * Helper Method: Swaps the elements at indices i and j
   * @param heap
   * @param i index to swap with
   * @param j index to swap with
   */
  private static void swap(Order[] heap, int i, int j) {
    Order temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }
  
  /**
   * A utility method to percolate Order values UP through the heap; see figure 13.3.1 in zyBooks
   * for a pseudocode algorithm.
   * 
   * @param heap an array containing the Order values to be percolated into a valid heap
   * @param orderIndex the index of the Order to be percolated up
   */
  protected static void percolateUp(Order[] heap, int orderIndex) {
    // implement the max heap percolate up algorithm to modify the heap in-place
    while(orderIndex > 0) {
      int parIndex = (orderIndex - 1)/2;
      if(heap[parIndex].compareTo(heap[orderIndex]) >= 0) return;
      else {
        swap(heap, parIndex, orderIndex);
        orderIndex = parIndex;
      }
    }

  }
  
  /**
   * Return the Order with the longest prep time from the queue and adjust the queue accordingly
   * 
   * @return the Order with the current longest prep time from the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public Order removeBest() {
    //  If the queue is empty, throw a NoSuchElementException
    if(isEmpty()) throw new NoSuchElementException("Error! Queue is empty. Nothing to remove.");
    
    // Remove the root Order of the heap and re-structure the heap to ensure that its ordering
    // is valid, then return the previous root
    Order root = queueHeap[0];
    queueHeap[0] = queueHeap[size-1];
    queueHeap[size-1] = null;
    size--;
    //System.out.println("This is" + this.toString());
    percolateDown(queueHeap, 0, size);
    
    return root; // included to prevent compiler errors
  }
  
  /**
   * A utility method to percolate Order values DOWN through the heap; see figure 13.3.2 in zyBooks
   * for a pseudocode algorithm.
   * 
   * @param heap an array containing the Order values to be percolated into a valid heap
   * @param orderIndex the index of the Order to be percolated down
   * @param size the number of initialized elements in the heap
   */
  protected static void percolateDown(Order[] heap, int orderIndex, int size) {
    // implement the max heap percolate down algorithm to modify the heap in-place
    int childIndexLeft = 2*orderIndex + 1;
    int childIndexRight = childIndexLeft + 1;
    
    while(childIndexLeft < size) {
      int largeIndex = childIndexLeft;
      if(childIndexRight < size) {
        if(heap[childIndexLeft].compareTo(heap[childIndexRight]) < 0) {
          largeIndex = childIndexRight;
        }
      }
      if(heap[orderIndex].compareTo(heap[largeIndex]) < 0) {
        swap(heap, orderIndex, largeIndex);
        orderIndex = largeIndex;
        childIndexLeft = 2*orderIndex + 1;
        childIndexRight = childIndexLeft + 1;
        //System.out.println("This is " + orderIndex + " and "+childIndexLeft);
      } else {
        //System.out.println(Arrays.toString(heap));
        return;
      }
      //System.out.println(Arrays.toString(heap));
    }
  }
  
  /**
   * Return the Order with the highest prep time from the queue without altering the queue
   * @return the Order with the current longest prep time from the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public Order peekBest() {
    //  If the queue is empty, throw a NoSuchElementException
    if(isEmpty()) throw new NoSuchElementException(
        "Error! The queue is empty. Nothing to peek.");
    
    //  Return the Order with the longest prep time currently in the queue
    Order longest = queueHeap[0];
    return longest; // included to prevent compiler errors
  }
  
  /**
   * Returns true if the queue contains no Orders, false otherwise
   * @return true if the queue contains no Orders, false otherwise
   */
  @Override
  public boolean isEmpty() {
    // implement this method according to its javadoc comment
    return size == 0; // included to prevent compiler errors
  }
  
  /**
   * Returns the number of elements currently in the queue
   * @return the number of elements currently in the queue
   */
  public int size() {
    return size; // included to prevent compiler errors
  }
  
  /**
   * Creates a String representation of this PriorityQueue. Do not modify this implementation; this
   * is the version that will be used by all provided OrderPriorityQueue implementations that your
   * tester code will be run against.
   * 
   * @return the String representation of this PriorityQueue, primarily for testing purposes
   */
  public String toString() {
    String toReturn = "";
    for (int i=0; i < this.size; i++) {
      toReturn += queueHeap[i].getID()+"("+queueHeap[i].getPrepTime()+")";
      if (i < this.size-1) toReturn += ", ";
    }
    return toReturn;
  }
  
}
