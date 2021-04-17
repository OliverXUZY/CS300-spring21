package full;
/**
 * Array List implementation using a non-dynamic array (the capacity is not expanded if reached)
 * 
 * @author Mouna AYARI BEN HADJ KACEM
 */
public class ArrayList<T> implements ListADT<T> {
  private T[] data; // generic array used for storage
  private int size; // current number of elements in the list


  // constructors
  /**
   * constructs an instance of ArrayList with the default capacity
   */
  public ArrayList() {
    this(10);
  }

  /**
   * constructs an instance of ArrayList with a given capacity
   * 
   * @param capacity
   */
  @SuppressWarnings("unchecked")
  public ArrayList(int capacity) {
    data = (T[]) new Object[capacity]; // safe cast to create a generic array // in Java; compiler
                                       // may give warning
  }

  // public methods
  // Big-Oh notation, problem size n represents the number of elements stored in this list
  /**
   * Returns the number of elements in the array list.
   * 
   * @return the size of the ArrayList
   */
  @Override
  public int size() {
    // running time complexity O(1)
    return size;
  }

  /**
   * Returns whether the array list is empty.
   * 
   * @return true of the Array List is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    // running time complexity O(1)
    return size == 0;
  }

  /**
   * Inserts element newObject at the end of the list.
   * 
   * @throws IllegalStateException if the Array List is full and the user tries to add a new object
   *         to the list
   */
  @Override
  public void add(T newObject) throws IllegalStateException {
    // time complexity: O(1)
    if (size == data.length) // not enough capacity
      throw new IllegalStateException("ArrayList is full.");
    data[size] = newObject; // add the new element at the end of the list
    size++;
  }

  /**
   * Inserts element newObject at index i of the list
   * 
   * @throws IllegalStateException if the Array List is full and the user tries to add a new object
   *         to the list
   * @throws IndexOutOfBoundsException if index is not in the range of 0 .. size
   */
  @Override
  public void add(int index, T newObject) throws IllegalStateException {
    // running time complexity O(n)
    checkIndex(index, size + 1);
    if (size == data.length) // not enough capacity
      throw new IllegalStateException("Array is full");
    for (int k = size - 1; k >= index; k--) // start by shifting rightmost
      data[k + 1] = data[k];
    data[index] = newObject; // ready to place the new element
    size++;
  }

  /**
   * Returns (but does not remove) the element at index i.
   * 
   * @return element at index
   * @throws IndexOutOfBoundsException if index is out of bounds i.e. is not in the range [0,
   *         size-1].
   */
  @Override
  public T get(int index) {
    // time complexity: O(1)
    checkIndex(index, size); // O(1)
    return data[index]; // O(1)
  }

  /**
   * Removes and returns the element at index i, shifting subsequent elements earlier.
   * 
   * @return removed element
   * @throws IndexOutOfBoundsException if index is out of bounds i.e. is not in the range [0,
   *         size-1].
   */
  public T remove(int index) throws IndexOutOfBoundsException {
    // running time O(n)
    checkIndex(index, size);
    T temp = data[index];
    for (int k = index; k < size - 1; k++) // shift elements one position to the left
      data[k] = data[k + 1];
    data[size - 1] = null; // help garbage collection
    size--;
    return temp;
  }

  /**
   * This method returns the index of the first element of this ArrayList whose equals method
   * matches with findObject
   * 
   * @param findObject element to find its index
   * @return the index of findObject in the list if found -1 otherwise
   */
  @Override
  public int indexOf(T findObject) {
    // running time complexity O(n)
    // traverse the arraylist looking for a first match with findObject
    for (int i = 0; i < size; i++)
      if (data[i].equals(findObject))
        return i;
    return -1; // The arraylist was exhausted and no match was found

  }

  /**
   * This method checks if this ArrayList contains the element findObject
   * 
   * @param findObject element to find
   * @return true if the list contains findObject and false otherwise
   */
  @Override
  public boolean contains(T findObject) {
    // running time complexity O(?)
    // traverse the list looking for findObject
    for (int i = 0; i < size; i++)
      if (data[i].equals(findObject))
        return true;
    return false;

  }

  /**
   * Returns a String representation of the content of this list
   * 
   * @return a String representation of this list
   */
  @Override
  public String toString() {
    // Running time: O(n)
    // return the content of the list as String
    String s = "";
    if (isEmpty())
      return ("<Empty List>\n");
    else {
      for (int i = 0; i < size; i++)
        s = s + data[i].toString() + " ";
    }
    return s;
  }

  /**
   * Replaces the element at index i with e, and returns the replaced element.
   * 
   * @return the replaced element
   * @throws IndexOutOfBoundsException if index is out of bounds i.e. is not in the range [0,
   *         size-1].
   */
  public T swap(int i, T e) throws IndexOutOfBoundsException {
    // running time complexity O(1)
    checkIndex(i, size);
    T temp = data[i];
    data[i] = e;
    return temp;
  }

  // Helper method
  /**
   * Checks whether the given index is in the range [0, n-1].
   */
  private void checkIndex(int i, int n) throws IndexOutOfBoundsException {
    // running time complexity O(1)
    if (i < 0 || i >= n)
      throw new IndexOutOfBoundsException("Illegal index: " + i);
  }

}
