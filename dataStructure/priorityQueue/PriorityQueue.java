import java.util.NoSuchElementException;

/**
 * This class represents the HeapPriorityQueue data structure implemented using an array-based
 * min-heap
 */
public class PriorityQueue<T extends Comparable<T>> implements PriorityQueueADT<T> {

  private T[] heap; // array-based min heap storing the data
  private int size; // size of this readyQueue

  // root always at index 0 --> index of the parent = (childIndex - 1)/2
  // index of the leftChild = parentIndex * 2 + 1
  // index of the rightChild = parentIndex * 2 + 2
  // elements of the heap stored at the range of indices 0..size -1

  // root always at index 1 (index 0 is unused, heap[0] is always null)
  // --> index of the parent = childIndex/2
  // index of the leftChild = parentIndex * 2
  // index of the rightChild = parentIndex * 2 + 1
  // elements of the heap stored at the range of indices 1..size

  // For this implementation, the root is stored at index 0;
  private final static int ROOT = 0;

  /**
   * Creates an empty priority queue with an initial capacity of 10
   */
  @SuppressWarnings("unchecked")
  public PriorityQueue() {
    heap = (T[]) new Comparable[10]; // Notice that the upper bound for the generic
                                                   // type T is Comparable and not Object
    size = 0; // optional since zero is the default value for int
  }

  /**
   * Constructor. Creates an empty priority queue with a given capacity
   * 
   * @param capacity initial capacity of this priority queue
   * @throws IllegalArgumentException if capacity is zero or negative
   */
  public PriorityQueue(int capacity) {
    if (capacity < 0)
      throw new IllegalArgumentException(
          "Warning! Cannot create a priority queue with a negative capacity.");
    heap = (T[]) new Comparable[capacity];
  }

  /**
   * Returns the number of items in the priority queue.
   * 
   * @return the size of the heap
   */
  public int size() {
    return size;
  }

  /**
   * Checks whether the ready queue is empty or not
   * 
   * @return boolean true if the ready queue is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns (but does not remove) a custom process with the highest priority (if any).
   * 
   * @return the node having the highest priority in the Ready queue, null otherwise
   */
  @Override
  public T peekBest() {
    if (isEmpty())
      throw new NoSuchElementException("Empty Queue! Unable to perform peek operation.");
    return heap[ROOT]; // return the root
  }

  /**
   * Helper method: Resizes internal array to have given capacity >= size. This method represents a
   * bad choice for expanding the size of the array
   * 
   * @param capacity new capacity of the array
   */
  private void resize(int capacity) {
    T[] tempCopy = (T[]) new Object[capacity];
    for (int k = ROOT; k <= size; k++)
      tempCopy[k] = heap[k];
    heap = tempCopy; // start using the new array
  }


  /**
   * Helper method: Inserts element newObject at the end of the array heap.
   * 
   * @param newObject to add
   */
  private void add(T newObject) {
    if (size == heap.length) // not enough capacity
      resize(2 * heap.length); // double the current capacity: O(n) algorithm!
    heap[size] = newObject; // add the new element at the end of the list
    size++; // increment size
  }


  /**
   * Inserts a newObject to the heap
   * 
   * @param newObject element to insert in the heap
   */
  @Override
  public void insert(T newObject) {
    add(newObject); // add newObject to the end of the heap
    minHeapPercolateUp(size - 1); // minHeapPercolateUp newly added element
  }

  /**
   * helper method Returns the index of the parent of the node at position j of the heap
   * 
   * @param j index of a node
   * @return index of the parent of node at position j
   */
  private int getParentIndex(int j) {
    return (j - 1) / 2;
  }

  /**
   * helper method Returns the index of the left child of the node of index j in the heap
   * 
   * @param j index of a node
   * @return index of the left child of j
   */
  private int getLeftChildIndex(int j) {
    return 2 * j + 1;
  }

  /**
   * helper method Returns the index of the right child of the node of index j in the heap
   * 
   * @param j index of a node
   * @return index of the right child of j
   */
  private int getRightChildIndex(int j) {
    return 2 * j + 2;
  }

  /**
   * helper method Checks whether the node of index j has a left child or not
   * 
   * @param j index of a node/element stored in the heap
   * @return true if the node of index j has a left child, false otherwise
   */
  private boolean hasLeftChild(int j) {
    return getLeftChildIndex(j) < size;
  }

  /**
   * Checks whether the node of index j has a right child
   * 
   * @param j index of a particular node stored in the heap
   * @return true if the node of index j has a left child, false otherwise
   */
  private boolean hasRightChild(int j) {
    return getRightChildIndex(j) < size;
  }



  /**
   * Removes and returns an element with minimal key (having the highest priority) if any
   * 
   * @return element having the highest priority
   * @throws NoSuchElementException if the priority queue is empty
   */
  @Override
  public T removeBest() {
    if (isEmpty()) // if the priority queue is empty, return null
      throw new NoSuchElementException("Empty Queue! Unable to perform removeBest operation.");
    // save element to be removed
    // put the last item at the root of the heap
    // and remove it from the heap;
    // then fix new root by calling minHeapPercolateDown(ROOT)
    // return saved element
    T root = heap[0];
    T temp = heap[size-1];
    heap[0] = temp;
    heap[size-1] = null;
    //System.out.println(heap[0]);
    size--;
    minHeapPercolateDown(0);
    
    return root;
  }


  /**
   * Helper method UpHeapBubbling operation Moves the entry at index j higher, if necessary, to
   * restore the heap property.
   * 
   * @param index index of node to start the minHeapPercolateUp operation from
   */
  private void minHeapPercolateUp(int index) {
    // This is an iterative version of minHeapPercolateUp
    while (index > ROOT) { // continue until reaching root (or break statement)
      // TODO complete missing code
      // 1. getParentIndex of index
      // compare the element at index with its parent
      // if element at index is greater or equal to its parent --> break (order property restored)
      // else (element at index smaller than its parent)
      // --> swap the element at index with its parent
      // continue from the parent's location
      int parIndex = getParentIndex(index);
      if(heap[index].compareTo(heap[parIndex]) >= 0) return;
      else {
        swap(index,parIndex);
        index = parIndex;
      }
    }
  }

  /**
   * Helper method DownHeapBubbling operation Moves the entry at index j lower, if necessary, to
   * restore the heap property.
   * 
   * @param index index of node to start the minHeapPercolateDown operation from
   */
  private void minHeapPercolateDown(int index) {
    // This is an iterative version of minHeapPercolateDown
    while (hasLeftChild(index)) { // continue to bottom (or break statement)
      int leftIndex = getLeftChildIndex(index);
      int smallChildIndex = leftIndex; // although right may be smaller
      if (hasRightChild(index)) {
        int rightIndex = getRightChildIndex(index);
        if (heap[leftIndex].compareTo(heap[rightIndex]) > 0)
          smallChildIndex = rightIndex; // right child is smaller
      }
      // TODO complete missing code
      // Compare the key of index with the one of its smallest child
      // (i.e. with the child having the highest priority).
      // if the smallest child has a higher priority than the element at index, so perform
      // a swap with it (down-heap) and continue at position of the child)
      // otherwise, terminate the down-heap process (the min heap order
      // property is restored).
      //System.out.println(heap[smallChildIndex]);
      if(heap[smallChildIndex].compareTo(heap[index]) >= 0) return;
      else {
        swap(index,smallChildIndex);
        index = smallChildIndex;
      }
    }
  }


  /**
   * Helper Method: Checks if index is in the range [1, size]
   * 
   * @param index index to check if within bounds
   * @param size size of the heap
   * @throws IndexOutOfBoundsException if index is not within the range 1..size
   */
  private void checkIndex(int index, int size) throws IndexOutOfBoundsException {
    if (index < ROOT || index >= size)
      throw new IndexOutOfBoundsException("Illegal index: " + index);
  }

  /**
   * Helper Method: Swaps the elements at indices i and j
   * 
   * @param i index to swap with
   * @param j index to swap with
   * @throws IndexOutOfBoundsException if i or j is not in the range 0..size-1
   */
  private void swap(int i, int j) throws IndexOutOfBoundsException {
    checkIndex(i, size);
    checkIndex(j, size);

    T temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  /**
   * prints the priorityQueue in a String format
   * 
   * @return String representing the priority queue state
   */
  @Override
  public String toString() {
    String s = "";
    s += "PriorityQueue Status:";
    s += "\n\t isEmpty: " + isEmpty();
    s += "\n\t size: " + size();
    if (!isEmpty())
      s += "\n\t Element having highest priority: " + peekBest();
    s += "\n\t Contents: ";

    for (int i = 0; i < size(); i++) {
      s += heap[i].toString() + " ";
    }
    return s;
  }

  /**
   * Driver method for PriorityQueue class
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    // Test the implementation of the HeapPrioityQueue class
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
    System.out.println(priorityQueue.toString());
    System.out.println("priorityQueue.insert(5)");
    priorityQueue.insert(5);
    System.out.println(priorityQueue.toString());
    System.out.println("priorityQueue.insert(1)");
    priorityQueue.insert(1);
    System.out.println(priorityQueue.toString());
    System.out.println("priorityQueue.insert(2)");
    priorityQueue.insert(2);
    System.out.println(priorityQueue.toString());
    System.out.println("priorityQueue.insert(0)");
    priorityQueue.insert(0);
    System.out.println(priorityQueue.toString());
    try {
      System.out.println("RemoveBest: " + priorityQueue.removeBest());
      System.out.println(priorityQueue.toString());
      System.out.println("RemoveBest: " + priorityQueue.removeBest());
      System.out.println(priorityQueue.toString());
      System.out.println("RemoveBest: " + priorityQueue.removeBest());
      System.out.println(priorityQueue.toString());
      System.out.println("RemoveBest: " + priorityQueue.removeBest());
      System.out.println(priorityQueue.toString());
      System.out.println("RemoveBest: " + priorityQueue.removeBest());
      System.out.println(priorityQueue.toString());
    } catch (NoSuchElementException e) {
      System.err.println(e.getMessage());
    }

  }


}
