package full;
/**
 * LinkedStack provides an implementation of the ADT Stack using a singly linked list
 * 
 * @author Mouna AYARI BEN HADJ KACEM
 * @param <T> represents any type (reference type)
 */
public class LinkedStack<T> implements StackADT<T> {
  private LinkedNode<T> top; // top of the linked list
  private int size; // size of the stack
  // MAKE SURE to increment the size each time a new element is pushed in the stack and decrement it
  // by one each time an element is popped off this stack



  // The problem size n is the size of this stack
  /**
   * checks if the stack is empty
   * 
   * @return true if the stack is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    // Running time complexity: O(1), problem size is the size of this stack
    // check whether the top of the stack is null or its size is 0
    // TODO: Complete the implementation of this method
    return false;
  }

  /**
   * Returns the size of this stack
   * 
   * @return size of the stack
   */
  public int size() {
    // Running time complexity: O(1)
    // TODO: Complete the implementation of this method
    return 0;
  }

  /**
   * Pushes newObject into this stack
   * 
   * @param newObject to insert into the stack
   */
  @Override
  public void push(T newObject) {
    // Running time complexity: O(1)

    // This operation is equivalent to add newObject at index 0 of a singly linked list 
    // (add at the head of a singly linked list)
    // The push operation increments the size by one after adding it to the stack
    // TODO complete the implementation of this method

  }

  /**
   * Pops (removes and returns) the element stored at the head of the stack
   * 
   * @return the element that was at the top of the stack
   * @throws StackException if the stack is empty
   */
  @Override
  public T pop() throws StackException {
    // Running time complexity: O(1)
    if (isEmpty()) // check whether this stack is empty or not
      throw new StackException("WARNING: The Stack is empty. Unable to perform a pop operation.");
    // remove and return the element at the top of the stack
    // This operation is equivalent to remove(0) from a singly linked list (remove the element at
    // the head of the list)
    // Before returning the popped element, make sure to decrement the size of this stack by one

    // TODO (complete the implementation of this method)
    return null;
  }

  /**
   * Peeks (returns without removing) the element stored at the head of the stack
   * 
   * @return the element that was at the top of the stack
   * @throws StackException if the stack is empty
   */
  @Override
  public T peek() {
    // Running time complexity: O(1)
    if (isEmpty()) // checks whether this stack is empty
      throw new StackException("WARNING: The Stack is empty. Unable to perform a peek operation.");
    // return item at the top of the stack
    // TODO complete the implementation of this method
    return null;
  }

  /**
   * returns a String representation of this stack
   * 
   * @return a String representing the contents of this stack
   */
  @Override
  public String toString() {
    // Running time complexity: O(n) where the problem size represents the size of this stack
    if (isEmpty()) // check whether this stack is empty
      return ("<Empty Stack>\n");
    else { // traverse the stack starting from its top and build its String representation
      LinkedNode<T> runner = top;
      String s = "Items: ";
      while (runner != null) {
        s = s + runner.getData().toString() + " ";
        runner = runner.getNext(); // advance runner
      }
      return s.trim();
    }
  }

  /**
   * displays the stack status and content in a specific format
   */
  public void display() {
    // Running time complexity: O(n) where the problem size represents the size of this stack
    StringBuilder output = new StringBuilder();
    output.append("\n***********************************\n");
    output.append("Stack empty: " + isEmpty() + "\n");
    output.append("Stack size: " + size + "\n");
    output.append("Stack content:\n");
    output.append(this); // equivalent to: output.append(this.toString())
    System.out.println(output);
  }

}