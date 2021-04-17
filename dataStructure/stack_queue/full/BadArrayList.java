package full;
/**
 * Array List implementation using a dynamic array The dynamic array expansion is performed by
 * doubling the size of the original array and copying its elements naively to the expanded one
 * 
 * @author Mouna AYARI BEN HADJ KACEM
 *
 */
public class BadArrayList<T> implements ListADT<T> {
  private static final int CAPACITY = 20; // default array capacity
  private T[] data; // generic array used for storage
  private int size = 0; // current number of elements in the list


  /**
   * Creates an Empty ArrayList with a default initial capacity
   */
  public BadArrayList() {
    this(CAPACITY);
  } // constructs an instance of ArrayList with default capacity

  /**
   * Creates an Empty ArrayList with a given initial capacity
   */
  @SuppressWarnings("unchecked")
  public BadArrayList(int capacity) { // constructs an instance of ArrayList
    // with given capacity
    data = (T[]) new Object[capacity]; // safe cast to create a generic array
    // in Java; compiler may give warning
  }

  // public methods
  /** Returns the number of elements in the array list. */
  @Override
  public int size() {
    return size;
  }

  /** Returns whether the array list is empty. */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /** Inserts element newObject at the end of the list. */
  @Override
  public void add(T newObject) {
    // Time Complexity: O(N) instead of O(1) ! This is bad!
    if (size == data.length) // not enough capacity
      resize(2 * data.length); // double the current capacity: O(N) algorithm!
    data[size] = newObject; // add the new element at the end of the list
    size++;
  }

  /** Inserts element newObject at index i of the list */
  @Override
  public void add(int index, T newObject) throws IndexOutOfBoundsException {
    checkIndex(index, size + 1);
    if (size == data.length) // not enough capacity
      resize(2 * data.length); // double the current capacity -- O(n)
    for (int k = size - 1; k >= index; k--) // start by shifting rightmost
      data[k + 1] = data[k];
    data[index] = newObject; // ready to place the new element
    size++;
  }

  /**
   * Returns (but does not remove) the element at index i.
   */
  @Override
  public T get(int index) throws IndexOutOfBoundsException {
    checkIndex(index, size);
    return data[index];
  }

  /**
   * Removes and returns the element at index i, shifting subsequent elements earlier.
   */
  public T remove(int index) throws IndexOutOfBoundsException {
    checkIndex(index, size);
    T temp = data[index];
    for (int k = index; k < size - 1; k++) // shift elements
      data[k] = data[k + 1];
    data[size - 1] = null; // help garbage collection
    size--;
    return temp;
  }

  /** Replaces the element at index i with e, and returns the replaced element. */
  public T swap(int i, T e) throws IndexOutOfBoundsException {
    checkIndex(i, size);
    T temp = data[i];
    data[i] = e;
    return temp;
  }


  @Override
  public int indexOf(T findObject) {
    int i = 0;
    while (i < size && !data[i].equals(findObject)) // traverse the list looking
                                                    // for findObject
      i++;
    if (i < size)
      return i;
    else
      return -1;

  }

  @Override
  public boolean contains(T findObject) {
    int i = 0;
    while (i < size && !data[i].equals(findObject)) // traverse the list looking
                                                    // for findObject
      i++;
    if (i < size)
      return true;
    else
      return false;

  }

  // Helper method
  /** Checks whether the given index is in the range [0, n-1]. */
  private void checkIndex(int i, int n) throws IndexOutOfBoundsException {
    if (i < 0 || i >= n)
      throw new IndexOutOfBoundsException("Illegal index: " + i);
  }

  /**
   * Helper method: Resizes internal array to have given capacity >= size. This method represents a
   * bad choice for expanding the size of the array
   * 
   * @param capacity new capacity of the array
   */
  @SuppressWarnings("unchecked")
  private void resize(int capacity) {
    // Time complexity : O(N)
    T[] temp = (T[]) new Object[capacity]; // safe cast;
    // compiler may give warning
    for (int k = 0; k < size; k++)
      temp[k] = data[k];
    data = temp; // start using the new array
  }
}
