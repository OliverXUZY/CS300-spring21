import java.util.Arrays;
import java.util.NoSuchElementException;
/////////////// OrderPriorityQueueTester class (INCLUDE IN EVERY FILE) //////////////////////////
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
* @author Zhuoyan Xu This is the OrderPriorityQueueTester class
*/

// Remember to add your file header here

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * OrderPriorityQueue.
 * 
 * You MAY add additional public static boolean methods to this class if you like, and any private
 * static helper methods you need.
 */
public class OrderPriorityQueueTester {

  /**
   * Checks the correctness of the isEmpty method of OrderPriorityQueue.
   * 
   * You should, at least: (1) create a new OrderPriorityQueue and verify that it is empty (2) add a
   * new Order to the queue and verify that it is NOT empty (3) remove that Order from the queue and
   * verify that it is empty again
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testIsEmpty() {
    Order.resetIDGenerator();
    OrderPriorityQueue orderPQ;
    // implement scenario 1, then go write the constructor and isEmpty methods in your
    // OrderPriorityQueue class so that they pass the tests
    try {
      orderPQ = new OrderPriorityQueue(20);
      if (!orderPQ.isEmpty())
        return false;
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
      return false;
    }

    // implement scenario 2, then go write enough of insert() to pass the tests
    try {
      orderPQ = new OrderPriorityQueue(20);
      orderPQ.insert(new Order("apple", 1));
      orderPQ.insert(new Order("beef", 2));
      if (orderPQ.isEmpty())
        return false;
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
      return false;
    }

    // implement scenario 3, then go write enough of remove() to pass the tests
    try {
      orderPQ = new OrderPriorityQueue(20);
      orderPQ.insert(new Order("apple", 1));
      // System.out.println(orderPQ);
      orderPQ.removeBest();
      if (!orderPQ.isEmpty())
        return false;
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
      return false;
    } catch (NoSuchElementException e) {
      System.err.println(e.getMessage());
      return false;
    }
    return true; // included to prevent compiler errors
  }

  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least: (1) create a new OrderPriorityQueue and add a single order with a large
   * prepTime to it (2) use the OrderPriorityQueue toString method to verify that the queue's
   * internal structure is a valid heap (3) add at least three more orders with DECREASING prepTimes
   * to the queue and repeat step 2.
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testInsertBasic() {
    Order.resetIDGenerator();
    OrderPriorityQueue orderPQ;
    try {
      orderPQ = new OrderPriorityQueue(20);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
      return false;
    }

    // implement this method, then go write the insert method in your
    // OrderPriorityQueue class so that it passes this test method
    // (2)
    orderPQ.insert(new Order("apple", 100));
    if (!orderPQ.toString().equals("1001(100)"))
      return false;

    // (3)
    orderPQ.insert(new Order("bag", 80));
    orderPQ.insert(new Order("carrot", 60));
    orderPQ.insert(new Order("donout", 40));

    if (!orderPQ.toString().trim().equals("1001(100), 1002(80), 1003(60), 1004(40)"))
      return false;

    // System.out.println("now \n"); System.out.println(orderPQ); System.out.println("\n up");

    return true; // included to prevent compiler errors
  }

  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least: (1) create an array of at least four Orders that represents a valid heap
   * (2) add a fifth order at the next available index that is NOT in a valid heap position (3) pass
   * this array to OrderPriorityQueue.percolateUp() (4) verify that the resulting array is a valid
   * heap
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testPercolateUp() {
    Order.resetIDGenerator();

    // (1)
    Order[] orderArray = new Order[20];
    // implement this method, then go write the percolateUp() method in your
    // OrderPriorityQueue class so that it passes this test method
    // (2)
    orderArray[0] = new Order("apple", 100);
    orderArray[1] = new Order("bag", 80);
    orderArray[2] = new Order("carrot", 60);
    orderArray[3] = new Order("donout", 40);

    // (3)
    Order orderEgg = new Order("egg", 120);
    orderArray[4] = orderEgg;
    OrderPriorityQueue.percolateUp(orderArray, 4);

    // (4)
    /*
     * for(int i = 0; i<orderArray.length; i++) { System.out.println(orderArray[i]); }
     */
    // System.out.println(orderEgg);
    if (!orderArray[0].equals(orderEgg))
      return false;
    if (orderArray[1].getPrepTime() != 100)
      return false;
    if (orderArray[4].getPrepTime() != 80)
      return false;


    return true; // included to prevent compiler errors
  }

  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least: (1) create a new OrderPriorityQueue with at least 6 orders of varying
   * prepTimes, adding them to the queue OUT of order (2) use the OrderPriorityQueue toString method
   * to verify that the queue's internal structure is a valid heap
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testInsertAdvanced() {
    Order.resetIDGenerator();

    // implement this method, then go modify the insert method in your
    // OrderPriorityQueue class so that it passes this test method too
    // (1)
    OrderPriorityQueue orderPQ;
    try {
      orderPQ = new OrderPriorityQueue(20);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
      return false;
    }

    
    //(2)
    orderPQ.insert(new Order("bag", 80));
    orderPQ.insert(new Order("egg", 20));
    orderPQ.insert(new Order("donout", 40));
    orderPQ.insert(new Order("carrot", 60));
    orderPQ.insert(new Order("flower", 10));
    orderPQ.insert(new Order("apple", 100));

    if (!orderPQ.toString().trim()
        .equals("1006(100), 1004(60), 1001(80), 1002(20), 1005(10), 1003(40)"))
      return false;


    return true; // included to prevent compiler errors
  }

  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least: (1) create an array of at least five Orders where the Order at index 0 is
   * NOT in valid heap position (2) pass this array to OrderPriorityQueue.percolateDown() (3) verify
   * that the resulting array is a valid heap
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testPercolateDown() {
    Order.resetIDGenerator();
    
    // implement this method, then go write the percolateUp() method in your
    // OrderPriorityQueue class so that it passes this test method
    // (1)
    Order[] orderArray = new Order[20];
    //int small = 40;
    orderArray[0] = new Order("apple", 15);
    //int large = 80;
    orderArray[1] = new Order("bag", 25);
    orderArray[2] = new Order("carrot", 60);
    orderArray[3] = new Order("donout", 20);
    orderArray[4] = new Order("eggs", 80);
    
    
    //(2)
    OrderPriorityQueue.percolateDown(orderArray, 0, 5);
    /**
    if (orderArray[0].getPrepTime() != large) return false;
    if (orderArray[1].getPrepTime() != small) return false;
    if (orderArray[2].getPrepTime() != 60) return false;
    if (orderArray[3].getPrepTime() != 20) return false;
    if (orderArray[4].getPrepTime() != 10) return false;
    */
    
    //
    int orderSize = 0;
    for(int i = 0; i<orderArray.length;i++) {
      if(orderArray[i] == null) {
        orderSize = i;
        break;
      }
    }
    
    // the size of order is orderSize
    // num of internal node
    int internalIndex = orderSize/2 - 1;
    
    for(int i = 0; i < internalIndex; i++) { 
      if(orderArray[i] == null){
        return false;
      }
      if(orderArray[i].compareTo(orderArray[2*i+1]) < 0 || orderArray[i].compareTo(orderArray[2*i+2]) < 0) {
        return false;
      }
    }
    
        
    //System.out.println(Arrays.toString(orderArray));
    // (4)
    /*
    Order[] orderArray2 = new Order[20];
    orderArray2[0] = new Order("apple", 80);
    orderArray2[1] = new Order("bag", 40);
    orderArray2[2] = new Order("carrot", 60);
    orderArray2[3] = new Order("donout", 20);
    orderArray2[4] = new Order("eggs", 10);
    
    
    OrderPriorityQueue.percolateDown(orderArray, 0, 5);
    if (orderArray2[0].getPrepTime() != 80) return false;
    if (orderArray2[1].getPrepTime() != 40) return false;
    if (orderArray2[2].getPrepTime() != 60) return false;
    if (orderArray2[3].getPrepTime() != 20) return false;
    if (orderArray2[4].getPrepTime() != 10) return false;
    */

    return true; // included to prevent compiler errors
  }

  /**
   * Checks the correctness of the removeBest and peekBest methods of OrderPriorityQueue.
   * 
   * You should, at least: (1) create a new OrderPriorityQueue with at least 6 orders of varying
   * prepTimes, adding them to the queue in whatever order you like (2) remove all but one of the
   * orders, verifying that each order has a SHORTER prepTime than the previously-removed order (3)
   * peek to see that the only order left is the one with the SHORTEST prepTime (4) check isEmpty to
   * verify that the queue has NOT been emptied (5) remove the last order and check isEmpty to
   * verify that the queue HAS been emptied
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testPeekRemove() {
    Order.resetIDGenerator();

    //implement this method, then go write the peek and dequeue methods in your
    // OrderPriorityQueue class so that they pass your tests
    // (1)
    OrderPriorityQueue orderPQ;
    try {
      orderPQ = new OrderPriorityQueue(20);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
      return false;
    }
    orderPQ.insert(new Order("bag", 80));
    orderPQ.insert(new Order("egg", 20));
    orderPQ.insert(new Order("donout", 40));
    orderPQ.insert(new Order("carrot", 60));
    orderPQ.insert(new Order("flower", 10));
    orderPQ.insert(new Order("apple", 100));
    
    //(2)
    int shortestTime = Integer.MAX_VALUE;
    Order newRemoved;
    for(int i=0; i<5; i++) {
      try {
        newRemoved = orderPQ.removeBest();
      } catch(NoSuchElementException e) {
        System.err.println(e.getMessage());
        return false;
      }
      
      if(shortestTime - newRemoved.getPrepTime() < 0) {
        return false;
      }
      shortestTime = newRemoved.getPrepTime();
    }
    
    //(3)
    Order left;
    try {
      left =orderPQ.peekBest();
    } catch(NoSuchElementException e) {
      System.err.println(e.getMessage());
      return false;
    }
    if(shortestTime - left.getPrepTime() < 0) {
      return false;
    }
    
    //(4)
    if(orderPQ.isEmpty()) {
      return false;
    }
    //(5)
    try {
      orderPQ.removeBest();
    } catch(NoSuchElementException e) {
      System.err.println(e.getMessage());
      return false;
    }
    if(!orderPQ.isEmpty()) {
      return false;
    }


    return true; // included to prevent compiler errors
  }

  /**
   * Checks the correctness of the removeBest and peekBest methods, as well as the constructor of
   * the OrderPriorityQueue class for erroneous inputs and/or states
   * 
   * You should, at least: (1) create a new OrderPriorityQueue with an invalid capacity argument,
   * and verify that the correct exception is thrown (2) call peekBest() on an OrderPriorityQueue
   * with an invalid state for peeking, and verify that the correct exception is thrown (3) call
   * removeBest() on an OrderPriorityQueue with an invalid state for removing, and verify that the
   * correct exception is thrown
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testErrors() {
    Order.resetIDGenerator();

    OrderPriorityQueue orderPQ;
    // implement this method, then go modify the relevant methods in your
    // OrderPriorityQueue class so that they pass your tests
    //(1)
    try {
      orderPQ = new OrderPriorityQueue(-1);
      return false;
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    } catch(Exception e) {
      return false;
    }
    
    //(2)
    try {
      orderPQ = new OrderPriorityQueue(20);
      orderPQ.peekBest();
      return false;
    } catch(NoSuchElementException e) {
      System.err.println(e.getMessage());
    } catch(Exception e) {
      return false;
    }
    
    //(3)
    try {
      orderPQ = new OrderPriorityQueue(20);
      orderPQ.removeBest();
      return false;
    } catch(NoSuchElementException e) {
      System.err.println(e.getMessage());
    } catch(Exception e) {
      return false;
    }
    
    return true; // included to prevent compiler errors
  }

  /**
   * Calls the test methods individually and displays their output
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("isEmpty: " + testIsEmpty());
    System.out.println("insert basic: " + testInsertBasic());
    System.out.println("percolate UP: " + testPercolateUp());
    System.out.println("insert advanced: " + testInsertAdvanced());
    System.out.println("percolate DOWN: " + testPercolateDown());
    System.out.println("peek/remove valid: " + testPeekRemove());
    System.out.println("error: " + testErrors());
  }

}
