package full;
import java.util.Arrays;
// import java.util.EmptyStackException;

/**
 * This is an implementation of the StackADT using an oversize array. 
 * The array has a fixed CAPACITY. Recall that arrays start at index 0 in Java.
 * Suppose that the stack is represented by an array called data contains t+1 
 * elements, we oriented this stack so that the item at the bottom
 * of the stack is stored at index 0 position (i.e. data[0]), 
 * whereas the item at the top of the stack is stored in the cell with 
 * index t (i.e. data[t]). The size of the stack will be the index of
 * the top of the stack plus 1
 * 
 * @param <T> represents any type
 */


public class ArrayStack<T> implements StackADT<T> {
  // Fields
  private static final int CAPACITY = 100; // default array capacity
  private T[] data; // generic array used to store the items
                    // of type T in the stack
  private int top; // index of the top item in the stack
  // By convention when the array stack is empty, the index of the top is -1

  /**
   * Default constructor creates an empty arrayStack with default capacity
   */
  public ArrayStack() {
    this(CAPACITY); // calls the overloaded constructor which takes an integer as input
  }

  /**
   * Creates an empty arrayStack with a given capacity
   * 
   * @param capacity of the arrayStack
   * @throws IllegalArgumentException if capacity is negative
   */

  @SuppressWarnings("unchecked")
  public ArrayStack(int capacity) throws IllegalArgumentException {
    if (capacity <= 0)
      throw new IllegalArgumentException("WARNING: Unable to create "
          + "a stack with capacity <= 0!\n" + "Stack's capacity should be positive!");
    // We cannot create a generic array in Java
    // For instance,
    // data = new T[capacity]; // generates a compilation error
    data = (T[]) new Object[capacity]; // safe cast
    // The compiler may give a warning:
    // Type safety: Unchecked cast from Object[] to T[]
    // To remove this warning, as this cast is safe,
    // we added the annotation @SuppressWarnings("unchecked")
    top = -1;
  }

  /**
   * Returns the size of this stack
   * @return the number of items stored in this ArrayStack
   */
  public int size() {
    // Running Time: O(1)
    // This is method is not defined in the interface StackADT
    // We added in the implementation of ArrayStack class
    return top + 1;
  }

  /**
   * Pushes newObject into this stack
   * 
   * @param newObject to insert in this stack
   * @throws IllegalStateException if this stack is full
   */
  @Override
  public void push(T newObject) {
    // Running time: O(1)
    // add newObject at the top of the stack
    // Throw a StackException if the stack's storage is overflow
    if (size() == data.length)
      throw new StackException("WARNING: Stack is full. Unable to push " + newObject
          + ": The stack storage is overflow.");
    // insert newObject at the top of the stack
    top++;
    data[top] = newObject;
  }// end void push(T newObject)


  /**
   * Pops (removes and returns) the element stored at the head of the stack
   * 
   * @return the element that was at the top of this stack
   * @throws StackException if the stack is empty
   */
  @Override
  public T pop() {
    // Running Time: O(1)
    if (isEmpty()) // check whether the stack is empty
      throw new StackException(
          "WARNING: The Stack is empty. Unable " + "to execute a pop operation.");
    T item = data[top]; // item to be removed
    data[top] = null; // to help garbage collector to clean this object from the heap
    top--;
    return item;
  }

  /**
   * Peeks (returns without removing) the element stored at the head of the stack
   * 
   * @return the element that was at the top of the stack
   * @throws StackException if the stack is empty
   */
  @Override
  public T peek() {
    // Running Time: O(1)
    if (isEmpty()) // check whether this stack is empty
      throw new StackException(
          "WARNING: The Stack is empty. Unable" + "to execute a peek operation.");
    return data[top]; // return item at the top of the stack

  }// end T peek()

  @Override
  public boolean isEmpty() {
    // Running time: O(1)
    return top == -1;
  }


  /**
   * returns a String representation of this stack
   * 
   * @return a String representing the contents of this stack
   */
  @Override
  public String toString() {
    // Running time: O(?)
    // data is an oversize array
    // Arrays.copyOf(data, size()): returns a sub-array of
    // data with size size();
    // Arrays.toString(array) : converts an array into a String
    if (isEmpty())
      return ("Empty Stack\n");
    return Arrays.toString(Arrays.copyOf(data, size())); // print the stack as a String
    // or you can simply use a for loop to iterate over

  }

  /**
   * displays the stack status and content in a specific format
   */
  public void display() {
    StringBuilder output = new StringBuilder();
    output.append("\n***********************************\n");
    output.append("Stack empty: " + isEmpty() + "\n");
    output.append("Stack size: " + size() + "\n");
    output.append("Stack content:\n");
    output.append(toString());
    System.out.println(output);
  }

  /**
   * Main method to test the implementation of our ArrayStack class
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Test the Array Stack
    // create an array stack of items of type String
    ArrayStack<String> stringStack = new ArrayStack<>(20);
    stringStack.display();
    // push 10 items into the stringStack
    for (int i = 0; i < 10; i++)
      stringStack.push("item " + i);
    stringStack.display();
    // peek
    System.out.println("Top item: " + stringStack.peek());
    // push other 10 items into the stringStack
    for (int i = 10; i < 20; i++)
      stringStack.push("item " + i);
    stringStack.display();
    // push another item
    // An exception should be thrown as stringStack's
    // storage is overflow
    try {
      stringStack.push("Hello");
    } catch (StackException e) {
      System.err.println(e.getMessage() + "\n");
    }
    stringStack.display();
    // pop all items from the stack


    while (!stringStack.isEmpty()) {
      System.out.println(stringStack.pop() + " removed.");
      stringStack.display();
    }
    try {
      System.out.println(stringStack.pop() + " removed.");
    } catch (StackException e) {
      System.err.println(e.getMessage() + "\n");
    }

  }

}