package full;
/**
 * This interface models a collection of Objects of the same type <T> that are inserted and removed
 * according to the LIFO (Last In First Out) principle. Although similar of purpose, this interface
 * differs from the Java.util.Stack interface
 * 
 * @param <T> generic type that can be any type
 */
public interface StackADT<T> {
  // List of Operations
  /**
   * isEmpty checks if the stack is empty
   * 
   * @return true if the stack is empty, false otherwise
   */
  public boolean isEmpty();

  /**
   * push inserts an item or element at the top of the stack
   * 
   * @param newObject the item or element to be inserted
   */
  public void push(T newObject);

  /**
   * peek returns without removing the item/element at the top of the stack
   * 
   * @return the element at the top of the stack. If the stack is empty, peek 
   *         throws a java.util.EmptyStackException or returns null.
   */
  public T peek();

  /**
   * pop removes and returns the item or element from the top of the stack
   * 
   * @return the removed element from the top of the stack. If the stack is empty, pop 
   *         throws an java.util.EmptyStackException or returns null.
   */
  public T pop();

} // end StackADT generic interface