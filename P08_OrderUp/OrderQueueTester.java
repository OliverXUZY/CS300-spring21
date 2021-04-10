import java.util.Iterator;
import java.util.NoSuchElementException;
/////////////// OrderQueueTester class (INCLUDE IN EVERY FILE) //////////////////////////
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
* @author Zhuoyan Xu
* This is the OrderQueueTester class
*/
public class OrderQueueTester {
  
  /**
   * test OrderIterator()
   * @return
   */
  private static boolean testOrderIterator(){
    boolean isWork = true;
    LinkedOrder OrderA = new LinkedOrder(new Order("apple",1));
    LinkedOrder OrderB = new LinkedOrder(new Order("beef",2));
    LinkedOrder OrderC = new LinkedOrder(new Order("chicken",2));
    OrderA.setNext(OrderB);
    OrderB.setNext(OrderC);
    Order.resetIDGenerator();
    OrderIterator OrderIte = new OrderIterator(OrderA);
    
    int idx = 0;
    while(OrderIte.hasNext()) {
      switch(idx){
        case 0:
          if(!OrderIte.next().getDishName().equals("apple")) {
            isWork = false;
          }
          break;
        case 1:
          if(!OrderIte.next().getDishName().equals("beef")) isWork = false;
        case 2:
          if(!OrderIte.next().getDishName().equals("chicken")) isWork = false;
      }
      idx++;
    }
    try {
      OrderIte.next();
    }
    catch (NoSuchElementException e) {
      System.out.println("Catching exceptions in OrderIterator: " + e.getMessage());
    }
    return isWork;
  }
  
  /**
   * test isEmpty()
   * @return
   */
  private static boolean testIsEmpty() {
    OrderQueue queue = new OrderQueue();
    return queue.isEmpty();
  }
  
  /**
   * test enqueue()
   * @return
   */
  private static boolean testEnqueue() {
    boolean isWork = true;
    
    OrderQueue queue = new OrderQueue();
    queue.enqueue(new Order("apple",1));
    queue.enqueue(new Order("beef",2));
    queue.enqueue(new Order("chicken",2));
    Order.resetIDGenerator();
    
    // extract iterator from queue
    Iterator<Order> OrderIte = queue.iterator();
    int idx = 0;
    while(OrderIte.hasNext()) {
      switch(idx){
        case 0:
          if(!OrderIte.next().getDishName().equals("apple")) {
            isWork = false;
          }
          break;
        case 1:
          if(!OrderIte.next().getDishName().equals("beef")) isWork = false;
        case 2:
          if(!OrderIte.next().getDishName().equals("chicken")) isWork = false;
      }
      idx++;
    }
    return isWork;
  }
  
  /**
   * test dequeue()
   * @return
   */
  private static boolean testDequeue() {
    OrderQueue queue = new OrderQueue();
    queue.enqueue(new Order("apple",1));
    queue.enqueue(new Order("beef",2));
    queue.dequeue();
    Order.resetIDGenerator();
    if(queue.peek().getDishName().equals("beef")) return true;
    return false;
  }
  
  private static boolean testPeek() {
    OrderQueue queue = new OrderQueue();
    queue.enqueue(new Order("apple",1));
    if(queue.peek().getDishName().equals("apple")) return true;
    return false;
  }
  public static boolean runAllTests() {
    if(!testOrderIterator()) return false;
    if(!testIsEmpty()) return false;
    if(!testEnqueue()) return false;
    if(!testDequeue()) return false;
    if(!testPeek()) return false;
    return true;
  }
  public static void main(String[] args) {
    
    System.out.println("Run all tests: " + runAllTests());

  }

}
