package full;
/**
 * < File header comes here >
 */

/**
 * Array List implementation using a dynamic array The dynamic array expansion is performed using a
 * Shadow array. This allows us to resize the array if needed in a constant time.
 * 
 * @param <T> Type parameter of the data stored in the ArrayList T can be any reference type
 * @author Mouna AYARI BEN HADJ KACEM
 */

public class DynamicArrayList<T> implements ListADT<T> {
  private static final int CAPACITY = 10; // default array capacity
  private T[] data; // generic array used for storage
  private T[] shadowData; // generic array used to expand the original
                          // array used for storage
  private int size = 0; // current number of elements in the list

  // constructors
  /**
   * default constructor constructs an instance of ArrayList with default initial capacity
   */
  public DynamicArrayList() {
    this(CAPACITY);
  }

  /**
   * constructs an instance of ArrayList with given capacity
   * 
   * @param capacity given capacity of the array list capacity should be positive (capacity > 0)
   * @throws IllegalArgumentException if capacity <= 0
   */
  @SuppressWarnings("unchecked")
  public DynamicArrayList(int capacity) throws IllegalArgumentException {
    if (capacity <= 0)
      throw new IllegalArgumentException("WARNING: capacity should be" + " a positive integer");
    data = (T[]) new Object[capacity]; // safe cast to create a generic array
    // in Java; compiler may give warning
    shadowData = (T[]) new Object[2 * capacity]; // the capacity of the shadow
    // is the double of the original one
  }

  // public methods

  /**
   * Returns the number of elements in the array list.
   * 
   * @return int the size of the list
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Checks whether the array list is empty or not
   * 
   * @return boolean true if the list is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Inserts element newObject at the end of the list
   * 
   * @param newObject the element to be inserted
   */
  @SuppressWarnings("unchecked")
  @Override
  public void add(T newObject) {
    // time complexity: O(1) (constant number of operations)
    // That's nice; expanding the capacity of the array once the list is full
    // did not affect the running time of add method compared to the case where
    // we do not use a dynamic array (throw an exception is the array is full
    // and the user tries to add a new element to the list)

    if (size == data.length) { // not enough capacity
      // throw new IllegalStateException("Array is full");
      // array expansion using a shadow array
      data = shadowData;
      shadowData = (T[]) new Object[data.length * 2]; //--- once did this, shadowData[0,size] is null
    }

    data[size] = newObject; // add the new element at the end of the list
    shadowData[size] = newObject;         //--- right now,  shadowData[0,size-1] is null
    int copyIndex = size - data.length / 2;   //---- copy once at a time
    // copyIndex equals also to: size % (data.length/2)
    if (copyIndex >= 0) // copy the old data into the shadow array
      shadowData[copyIndex] = data[copyIndex];
    size++;
  }

  /**
   * Inserts element newObject at index i of the list
   * 
   * @param index position where the newObject will be inserted in the list
   * @param newObject element to be inserted in the list
   * @throws IndexOutOfBoundsException if index is not in the range of the possible list indices
   *         0..size (if index == size --> add at the end of the list)
   */
  @SuppressWarnings("unchecked")
  @Override
  public void add(int index, T newObject) throws IndexOutOfBoundsException {
    checkIndex(index, size + 1);
    if (size == data.length) { // not enough capacity
      // throw new IllegalStateException("Array is full");
      // dynamic array expansion
      data = shadowData;
      shadowData = (T[]) new Object[data.length * 2];
    }
    for (int k = size - 1; k >= index; k--) // start by shifting rightmost
      data[k + 1] = data[k];
    data[index] = newObject; // place the new element
    shadowData[index] = newObject;
    int copyIndex = size - data.length / 2;
    // copyIndex equals also to: size % (data.length/2)
    if (copyIndex != index && copyIndex >= 0)
      shadowData[copyIndex] = data[copyIndex]; // copy the old data in
                                               // the shadow array
    size++;
  }

  /**
   * Returns (but does not remove) the element at index i
   * 
   * @param index index of the element to return
   * @return T element at position index in the array
   * @throws IndexOutOfBoundsException if index is not in the range 0..size-1
   */
  @Override
  public T get(int index) throws IndexOutOfBoundsException {
    checkIndex(index, size);
    return data[index];
  }


  /**
   * Removes/returns the element at index i, shifting subsequent elements earlier.
   * 
   * @param index index of the element to remove and return back
   * @return T removed element
   * @throws IndexOutOfBoundsException if index is not in the range 0..size-1
   */
  @Override
  public T remove(int index) throws IndexOutOfBoundsException {
    checkIndex(index, size);
    T removed = data[index];
    for (int k = index; k < size - 1; k++) { // shift elements
      data[k] = data[k + 1];
      shadowData[k] = data[k + 1];
    }
    data[size - 1] = null; // help garbage collection
    shadowData[size - 1] = null;
    size--;
    return removed;
  }


  /**
   * Replaces the element at index i with e, and returns the replaced element.
   * 
   * @param index of element to be replaced
   * @param object element to set at index i
   * @return the replaced element
   * @throws IndexOutOfBoundsException
   */
  public T set(int index, T object) throws IndexOutOfBoundsException {
    checkIndex(index, size); // checks the validity of the index
    T item = data[index]; // store element at index i
    data[index] = object; // set new element at index i
    shadowData[index] = object;
    return item;
  }


  /**
   * Returns the index of the first element of the list whose equals method matches with findObject
   * 
   * @param findObject
   * @return the index of findObject in the list if found -1 otherwise
   */
  @Override
  public int indexOf(T findObject) {
    int i = 0;
    while (i < size && !data[i].equals(findObject))
      // traverse the list looking for findObject
      i++;
    if (i < size)
      return i;
    else
      return -1;
  }

  /**
   * Checks if the list contains the element findObject
   * 
   * @param findObject
   * @return true if the list contains findObject and false otherwise
   */
  @Override
  public boolean contains(T findObject) {
    int i = 0;
    while (i < size && !data[i].equals(findObject))
      // traverse the list looking for findObject
      i++;
    if (i < size)
      return true; // element found
    else
      return false; // element not found

  }

  // Helper method
  /**
   * Checks if index is in the range [0, n-1]
   * 
   * @param index
   * @param n
   * @throws IndexOutOfBoundsException
   */
  private void checkIndex(int index, int n) throws IndexOutOfBoundsException {
    if (index < 0 || index >= n)
      throw new IndexOutOfBoundsException("Illegal index: " + index);
  }

  public static void main(String[] args) {
    DynamicArrayList<Integer> integers = new DynamicArrayList<>();
    integers.add(10);
  }

}
