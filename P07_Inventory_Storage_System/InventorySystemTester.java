/////////////// InventorySystemTester class (INCLUDE IN EVERY FILE) //////////////////////////
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
* This is the InventorySystemTester class
*/
public class InventorySystemTester {

  public static boolean testLinkedBox() {
    boolean isWork = true;

    LinkedBox box1 = new LinkedBox(new Box(Color.BLUE));
    LinkedBox box2 = new LinkedBox(new Box(Color.YELLOW), box1);
    LinkedBox box3 = new LinkedBox(new Box(Color.BROWN), box2);



    if (!box3.getNext().equals(box2))
      return false;
    if (!box2.getNext().equals(box1))
      return false;

    box1.setNext(box3);

    if (!box1.getNext().equals(box3))
      return false;


    return isWork;
  }

  // checks for the correctness of the InventoryList.clear() method
  public static boolean testClear() {
    InventoryList list = new InventoryList();

    list.addYellow(new Box(Color.YELLOW));
    list.addBlue(new Box(Color.BLUE));
    list.addBrown(new Box(Color.BROWN));
    list.addYellow(new Box(Color.YELLOW));


    list.clear();
    if (list.getBlueCount() != 0)
      return false;
    if (list.getBrownCount() != 0)
      return false;
    if (list.getYellowCount() != 0)
      return false;
    return true;
  }

  // checks for the correctness of the InventoryList.addYellow(),
  // InventoryList.addBlue(), and InventoryList.addBrown() methods
  public static boolean testAddBoxes() {
    InventoryList list = new InventoryList();

    list.addYellow(new Box(Color.YELLOW));
    list.addBlue(new Box(Color.BLUE));
    list.addBrown(new Box(Color.BROWN));
    list.addYellow(new Box(Color.YELLOW));

    if (list.get(0).getColor() != Color.YELLOW)
      return false;
    if (list.get(1).getColor() != Color.YELLOW)
      return false;
    if (list.get(2).getColor() != Color.BLUE)
      return false;
    if (list.get(3).getColor() != Color.BROWN)
      return false;

    return true;

  }

  // checks for the correctness of the InventoryList.removeBox()
  // InventoryList.removeYellow(), and InventoryList.remove Brown()
  // methods
  public static boolean testRemoveBoxes() {
    InventoryList list = new InventoryList();

    list.addYellow(new Box(Color.YELLOW));
    list.addBlue(new Box(Color.BLUE));
    list.addBrown(new Box(Color.BROWN));
    list.addYellow(new Box(Color.YELLOW));
    list.removeYellow();
    if (list.getYellowCount() != 1)
      return false;

    list.removeBrown();
    if (list.getBrownCount() != 0)
      return false;

    list.removeBox(23);
    if (list.getBlueCount() != 0)
      return false;


    return true;
  }

  // checks for the correctness of the InventoryList.get() method
  public static boolean testGetBoxes() {
    InventoryList list = new InventoryList();
    Box boxGot = new Box(Color.BROWN);
    list.addYellow(new Box(Color.YELLOW));
    list.addBlue(new Box(Color.BLUE));
    list.addBrown(boxGot);
    list.addYellow(new Box(Color.YELLOW));
    if (list.get(3) != boxGot)
      return false;

    return true;
  }

  // a test suite method to run all your test methods
  public static boolean runAllTests() {
    /*
    System.out.println("Test LinkedBox: " + testLinkedBox());
    System.out.println("Test AddBoxes: " + testAddBoxes());
    System.out.println("Test CLear(): " + testClear());
    System.out.println("Test RemoveBoxes(): " + testRemoveBoxes());
    System.out.println("Test GetBoxes(): " + testGetBoxes());
    */
    
    if (!testLinkedBox()) return false;
    if (!testAddBoxes()) return false;
    if (!testClear()) return false;
    if (!testRemoveBoxes()) return false;
    if (!testGetBoxes()) return false;
    
    
    
    return true;
  }

  public static void main(String[] args) {

    demo();

    System.out.println("\nThe result of runAllTests is " + runAllTests());
  }

  /**
   * Helper method to display the size and the count of different boxes stored in a list of boxes
   * 
   * @param list a reference to an InventoryList object
   * @throws NullPointerException if list is null
   */
  private static void displaySizeCounts(InventoryList list) {
    System.out.println("  Size: " + list.size() + ", yellowCount: " + list.getYellowCount()
        + ", blueCount: " + list.getBlueCount() + ", brownCount: " + list.getBrownCount());
  }

  /**
   * Demo method showing how to use the implemented classes in P07 Inventory Storage System
   * 
   * @param args input arguments
   */
  public static void demo() {
    // Create a new empty InventoryList object
    InventoryList list = new InventoryList();
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    // Add a blue box to an empty list
    list.addBlue(new Box(Color.BLUE)); // adds BLUE 1
    System.out.println(list); // prints list's content
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 2 at the head of the list
    System.out.println(list); // prints list's content
    list.addBlue(new Box(Color.BLUE)); // adds BLUE 3
    System.out.println(list); // prints list's content
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 4
    System.out.println(list); // prints list's content
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 5 at the head of the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    // Add more boxes to list and display its contents
    list.addBrown(new Box(Color.BROWN)); // adds BROWN 6 at the end of the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addBrown(new Box(Color.BROWN)); // adds BROWN 7 at the end of the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBrown(); // removes BROWN 7 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addBlue(new Box(Color.BLUE)); // adds BLUE 8

    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBrown(); // removes BROWN 6 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeYellow(); // removes YELLOW 5
    System.out.println(list); // prints list's content
    list.removeBox(3); // removes BLUE 3 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    try {
      list.removeBox(25); // tries to remove box #25
    } catch (java.util.NoSuchElementException e) {
      System.out.println(e.getMessage());
    }

    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    // remove all yellow boxes
    while (list.getYellowCount() != 0) {
      list.removeYellow();
    }
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBox(1); // removes BLUE 1 from the list -> empty list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts

    list.addBrown(new Box(Color.BROWN)); // adds BROWN 9 to the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBox(8); // removes BLUE 8 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBrown(); // removes BROWN 9 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 10 to the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBox(10); // removes YELLOW 10 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
  }



}
