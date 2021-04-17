package full;
/**
 * This class defines a new Exception StackException.
 * For instance, StackException can be thrown in case of Overflow: 
 * when there is no more room left to store a data item that is pushed. 
 * Underflow: when the stack is empty and the user tries to perform 
 * a pop or a operation
 */
@SuppressWarnings("serial")
// We added @SuppressWarning annotation to tell the compiler
// to ignore the following warning: "The serializable class
// StackException does not declare a static final serialVersionUID
// field of type long
// You can try to comment that line to see the warning
public class StackException extends RuntimeException {

  /**
   * Create a RuntimeException of type StackException
   * 
   * @param errorMessage
   */
  public StackException(String errorMessage) {
    super(errorMessage); // Calls RuntimeException's constructor
  }
}