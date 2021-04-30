
public class Tester {

  /**
   * This method does some work with respect to the following properties
   * 
   * @param someInput some input
   * @return true if some behavior is satisfied,a and false otherwise
   * @throws IllegalArgumentException if someInput is not valid
   */
  public static boolean someMethod(int someInput) {
    // step1

    // step2
    return false; // added to avoid compiler error
  }


  /**
   * Checks the correctness of someMethod()
   * 
   * @return true if someMethod passes all the test scenarios defined in this tester method, and
   *         false otherwise
   */
  public static boolean someMethodTester() {
    try {
      // define test scenarios and detect bugs
      // test scenario 1: Call someMethod with invalid input. Expected behavior:
      // IllegalArgumentException must be thrown
      try {
        someMethod(-10);
        // print an error message (IllegalArgumentException not thrown when your someMethod is
        // passed a invalid input)
        return false;
      } catch (IllegalArgumentException e1) {
        // expected exception
        if(e1.getMessage() == null || e1.getMessage().length() == 0) { // exception with no error message
          // print error message 
          return false;
        }
      }

      // test scenario 2: Call someMethod with a valid input
      // Properties which must be satisfied: Correct output + expected behavior actions completed
      // successfully
      boolean output = someMethod(50);
      if(/*property1 NOT satisfied || property2 NOT satisfied */) {
        // print error message
        return false;
      }
      
      

    } catch (Exception e) { // an unexpected exception was thrown
      e.printStackTrace();
      return false;
    }
    return true; // someMethod() passed all the above tester methods without errors
  }

}
