import java.util.Arrays;

//////////////// SelfCheckoutKioskTester (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: (descriptive title of the program making use of this file)
// Course: CS 300 Fall 2020
//
// Author: Zhuoyan Xu
// Email: zxu444@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: Hobbes LeGault
// Online Sources: zybook + piazza
//
///////////////////////////////////////////////////////////////////////////////
/**
 * 
 * @author Zhuoyan Xu
 *
 */

public class SelfCheckoutKioskTester {

  /**
   * Checks whether SelfCheckoutKisok.getItemName() and SelfCheckoutKisok.getItemPrice() method work
   * as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testItemNameAndPriceGetterMethods() {
    // consider all identifiers values as input arguments
    // GROCERY_ITEMS array is a perfect size array. So, its elements are stored
    // in the range of indices from 0 .. GROCERY_ITEMS.length -1
    for (int i = 0; i < SelfCheckoutKiosk.GROCERY_ITEMS.length; i++) {
      // check first for the correctness of the getItemName(i) method
      if (!SelfCheckoutKiosk.getItemName(i).equals(SelfCheckoutKiosk.GROCERY_ITEMS[i][0])) {
        System.out.println("Problem detected: Called your getItemName() method with "
            + "input value " + i + ". But it did not return the expected output.");
        return false;
      }

      // Now, let's check for the correctness of the getItemPrice(i) method
      double expectedPriceOutput =
          Double.valueOf(SelfCheckoutKiosk.GROCERY_ITEMS[i][1].substring(1).trim());
      // We do not use == to compare floating-point numbers (double and float)
      // in java. Two variables a and b of type double are equal if the absolute
      // value of their difference is less or equal to a small threshold epsilon.
      // For instance, if Math.abs(a - b) <= 0.001, then a equals b
      if (Math.abs((SelfCheckoutKiosk.getItemPrice(i) - expectedPriceOutput)) > 0.001) {
        System.out.println("Problem detected: Called your getItemPrice() method with "
            + "input value " + i + ". But it did not return the expected output.");
        // you can print a descriptive error message before returning false
        return false;
      }
    }
    return true; // No defect detected -> The implementation passes this test
  }

  /**
   * Checks the correctness of SelfCheckoutKiosk.addItemToBaggingArea() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddItemToBaggingArea() {
    // Create an empty bagging area
    String[] items = new String[10];
    int size = 0;

    // System.out.println(Arrays.toString(items));

    // Define the test scenarios:

    // (1) Add one item to an empty bagging area
    // try to add an apple (id: 0) to the bagging area
    size = SelfCheckoutKiosk.addItemToBaggingArea(0, items, size);
    if (size != 1) {
      System.out.println("Problem detected: Tried to add one item to an empty, "
          + "bagging area. The returned size must be 1. But your addItemToBaggingArea "
          + "method returned a different output.");
      return false;
    }
    if (!items[0].equals(SelfCheckoutKiosk.getItemName(0))) {
      // notice here the importance of checking for the correctness of your
      // getItemName()
      // method before calling it above
      System.out.println("Problem detected: Tried to add only one item to an empty, "
          + "bagging area. But that item was not appropriately added to the contents "
          + "of the items array.");
    }

    // (2) Consider a non-empty bagging area
    items = new String[] {"Milk", "Chocolate", "Onion", null, null, null, null};
    size = 3;
    size = SelfCheckoutKiosk.addItemToBaggingArea(10, items, size);
    if (size != 4) {
      System.out.println("Problem detected: Tried to add only one item to an non-empty, "
          + "bagging area. The size must be incremented after the method returns. But "
          + "it was not the case");
      return false;
    }
    if (!items[3].equals(SelfCheckoutKiosk.getItemName(10))) {
      System.out.println("Problem detected: Tried to add one item to an non-empty, "
          + "bagging area. But that item was not appropriately added to the contents "
          + "of the items array.");
    }

    // (3) Consider adding an item to a full bagging area
    /*
     * Complete the implementation of this test scenario Check that the returned size is correct
     * (must be 3), and that no changes have been made to the content of items array {"Pizza",
     * "Eggs", "Apples"}
     */
    items = new String[] {"Pizza", "Eggs", "Apples"};
    size = 3;
    size = SelfCheckoutKiosk.addItemToBaggingArea(2, items, size);
    if (size != 3) {
      System.out.println("Problem detected: Tried to add one item to an full, "
          + "bagging area. The size must remain the same after the method returns."
          + "But it was not the case");
      return false;
    }
    if (!Arrays.equals(items, new String[] {"Pizza", "Eggs", "Apples"})) {
      System.out.println("Problem detected: Tried to add one item to an full, "
          + "bagging area. The items in the bagging area should remain the same");
      return false;

    }

    return true; // No defects detected by this unit test
  }

  // Checks the correctness of SelfCheckoutKiosk.count() method
  // Try to consider different test scenarios: (1) a bagging area (defined by
  // the items array and its size) which contains 0 occurrences of the item,
  // (2) a bagging area which contains at least 4 items and only one occurrence
  // of the item to count, and (3) a bagging area which contains at least 5 items
  // and 2 occurrences of the item to count.
  public static boolean testCount() {
    // Create an empty bagging area
    String[] items = new String[10];
    int size = 0;
    String item = null;
    int occurrence = 0;
    // (1) a bagging area (defined by
    // the items array and its size) which contains 0 occurrences of the item
    items = new String[] {"Apple", "Beef", "Butter"};
    item = "Careal";
    size = 3;
    occurrence = SelfCheckoutKiosk.count(item, items, size);
    if (occurrence != 0) {
      System.out.println("Problem detected: Tried to scan an item not in bagging area, "
          + "the occurrence must be 0. But it was not the case.");
      return false;
    }

    // (2) a bagging area which contains at least 4 items and only one occurrence
    // of the item to count
    items = new String[] {"Apple", "Beef", "Butter", "Blueberry", "Apple"};
    item = "Beef";
    size = 5;
    occurrence = SelfCheckoutKiosk.count(item, items, size);
    if (occurrence != 1) {
      System.out.println("Problem detected: Tried to scan an item occuring once in bagging area, "
          + "the occurrence must be 1. But it was not the case.");
      return false;
    }

    // (3) a bagging area which contains at least 5 items
    // and 2 occurrences of the item to count
    items = new String[] {"Apple", "Beef", "Butter", "Blueberry", "Apple", "Cookie"};
    item = "Apple";
    size = 6;
    occurrence = SelfCheckoutKiosk.count(item, items, size);
    if (occurrence != 2) {
      System.out.println("Problem detected: Tried to scan an item occureing twice in bagging area, "
          + "the occurrence must be 2. But it was not the case.");
      return false;
    }

    return true;
  }

  // Checks the correctness of SelfCheckoutKiosk.indexOf() method
  // Consider the cases where the items array contains at least one match
  // with the item to find, and the case when the item was not stored in
  // the array and the expected output is -1
  public static boolean testIndexOf() {
    // Create an empty bagging area
    String[] items = new String[10];
    int size = 0;
    String item = null;
    int index = 0;

    // (1) a bagging area (defined by
    // the items array and its size) which contains 0 occurrences of the item
    items = new String[] {"Apple", "Beef", "Butter"};
    item = "Careal";
    size = 3;
    index = SelfCheckoutKiosk.indexOf(item, items, size);
    if (index != -1) {
      System.out.println("Problem detected: Tried to scan an item not in bagging area, "
          + "the index must be -1. But it was not the case.");
      return false;
    }

    // (2) a bagging area which contains at least 4 items and only one occurrence
    // of the item to count
    items = new String[] {"Apple", "Beef", "Butter", "Blueberry", "Apple"};
    item = "Beef";
    size = 5;
    index = SelfCheckoutKiosk.indexOf(item, items, size);
    if (index != 1) {
      System.out.println("Problem detected: Tried to scan an item in bagging area, "
          + "the index must be 1. But it was not the case.");
      return false;
    }

    // (3) a bagging area which contains at least 5 items
    // and 2 occurrences of the item to count
    items = new String[] {"Apple", "Beef", "Butter", "Blueberry", "Apple", "Cookie"};
    item = "Apple";
    size = 6;
    index = SelfCheckoutKiosk.indexOf(item, items, size);
    if (index != 0) {
      System.out.println("Problem detected: Tried to scan an item in bagging area, "
          + "the index must be 0. But it was " + index);
      return false;
    }

    return true;
  }

  // Checks that when only one attempt to remove an item stored in the bagging
  // area
  // is made, only one occurrence of that item is removed from the array of items,
  // that the returned size is correct, and that the items array contains all the
  // other items.
  public static boolean testRemove() {
    // Create an empty bagging area
    String[] items = new String[10];
    int size = 0;
    String item = null;

    // (0) regular case: What would happen when an attempt is made to remove an item
    // that is in the
    // bagging are?
    items = new String[] {"Apple", "Beef", "Butter", "Mushroom", null, null, null, null};
    item = "Beef";
    size = 4;
    size = SelfCheckoutKiosk.remove(item, items, size);
    if (size != 3) {
      System.out.println("Problem detected: Tried to remove one item(occure once) in the "
          + "bagging area. The size must be 3 after the method returns."
          + "But it was not the case");
      return false;
    }
    if (!Arrays.equals(items,
        new String[] {"Apple", "Butter", "Mushroom", null, null, null, null, null})) {
      System.out.println("Problem detected: Tried to remove one item(occure once) in the "
          + "bagging area. The items in the bagging area is not right");
      return false;
    }
    System.out.println("(0) passed!");

    // (1) What would happen when an attempt is made to remove an item that is not
    // in the bagging
    // are?
    items = new String[] {"Apple", "Beef", "Butter", null, null, null, null, null};
    item = "Careal";
    size = 3;
    size = SelfCheckoutKiosk.remove(item, items, size);
    if (size != 3) {
      System.out.println("Problem detected: Tried to remove one item not in the "
          + "bagging area. The size must remain the same after the method returns."
          + "But it was not the case");
      return false;
    }
    if (!Arrays.equals(items,
        new String[] {"Apple", "Beef", "Butter", null, null, null, null, null})) {
      System.out.println("Problem detected: Tried to remove one item not in the "
          + "bagging area. The items in the bagging area should remain the same");
      return false;
    }
    System.out.println("(1) passed!");

    // (2) What would happen if an attempt is made to remove an item from an empty
    // bagging area (the
    // input size == 0)?
    items = new String[10];
    item = "Beef";
    size = 0;
    size = SelfCheckoutKiosk.remove(item, items, size);
    if (size != 0) {
      System.out.println("Problem detected: Tried to remove one item from the empty"
          + "bagging area. The size must remain 0 after the method returns."
          + "But it was not the case");
      return false;
    }
    if (!Arrays.equals(items, new String[10])) {
      System.out.println("Problem detected: Tried to remove one item from the empty "
          + "bagging area. The items in the bagging area should remain null");
      return false;
    }
    System.out.println("(2) passed!");

    // (3) What would happen when an attempt is made to remove an item that has
    // multiple occurrences
    // in the bagging area?
    items = new String[] {"Apple", "Beef", "Butter", "Blueberry", "Apple", "Cookie", "Apple", null,
        null, null, null};
    item = "Apple";
    size = 7;
    size = SelfCheckoutKiosk.remove(item, items, size);
    if (size != 4) {
      System.out.println("Problem detected: Tried to remove one item(occur 3 times) from the "
          + "bagging area. The size must be 4 after the method returns."
          + "But it was not the case");
      return false;
    }
    if (!Arrays.equals(items, new String[] {"Beef", "Butter", "Blueberry", "Cookie", null, null,
        null, null, null, null, null})) {
      System.out.println("Problem detected: Tried to remove one item(occur 3 times) from the "
          + "bagging area. The items in the bagging area is not right");
      return false;
    }
    System.out.println("(3) passed!");

    return true;
  }

  // Checks whether getSubTotalPrice method returns the correct output
  public static boolean testGetSubTotalPrice() {
    String[] items = new String[10];
    int size = 0;
    double subTotalPrice;

    items = new String[] {"Apple", "Beef", "Butter", "Blueberry", "Apple", "Cookie", null, null,
        null, null, null};
    size = 6;
    subTotalPrice = SelfCheckoutKiosk.getSubTotalPrice(items, size);
    if (subTotalPrice != 27.95) {
      System.out.println("Problem detected: Subtotal price in bagging area, "
          + "the  must be 27.95. But it was " + subTotalPrice);
      return false;
    }
    return true;
  }

  // Checks whether getUniqueCheckedOutput function is correct
  public static boolean testGetUniqueCheckedOutItems() {
    String[] items = new String[10];
    int size = 0;

    items = new String[] {"eggs", "banana", "Avocado", "eggs", "Milk", "Potato", "Milk", null, null,
        null};
    size = 7;
    String[] itemSet = new String[items.length];
    size = SelfCheckoutKiosk.getUniqueCheckedOutItems(items, size, itemSet);
    if (size != 5) {
      System.out.println("Problem detected: Tried to get unique set from the "
          + "bagging area. The size must be 4, " + "But it was " + size);
      return false;
    }
    if (!Arrays.equals(itemSet, new String[] {"eggs", "banana", "Avocado", "Milk", "Potato", null,
        null, null, null, null})) {
      System.out.println("Problem detected: Tried to Tried to get unique set from the "
          + "bagging area. The items in the bagging area is not right");
      System.out.println(Arrays.toString(itemSet));
      return false;
    }

    return true;
  }

  /**
   * main method used to call the unit tests
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out
        .println("tesItemNameAndPriceGetterMethods(): " + testItemNameAndPriceGetterMethods());
    System.out.println("call printCatalog(): ");
    SelfCheckoutKiosk.printCatalog();
    System.out.println(
        "Testing result of function AddItemToBaggingArea(): " + testAddItemToBaggingArea());
    System.out.println("Testing result of function count(): " + testCount());
    System.out.println("Testing result of function indexOf(): " + testIndexOf());

    System.out.println("Testing result of function remove(): ");
    System.out.println(testRemove());

    System.out.println("Testing result of function getSubTotalPrice(): " + testGetSubTotalPrice());
    System.out.println(
        "Testing result of function getUniqueCheckedOutItems: " + testGetUniqueCheckedOutItems());
  }
}
