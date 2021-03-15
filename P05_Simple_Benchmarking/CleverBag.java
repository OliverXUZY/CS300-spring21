import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/////////////// CleverBag class (INCLUDE IN EVERY FILE) //////////////////////////
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
* 
*/
public class CleverBag extends SimpleBag {
  private int size = 0;

  /**
   * ○ Calls the super class’ constructor with appropriate arguments. ○ Initializes the private
   * integer field , size, which will track the current number of initialized Strings in the parent
   * class’ data array.
   * 
   * @param seed
   */
  public CleverBag(int seed) {
    super(seed);


  }

  @Override
  /**
   * ○ Reads the contents of the file as in the parent class, but instead inserts the new words at
   * the end of the array and then updates the size field accordingly. ○ If you encounter any
   * exceptions while reading the File, simply return from the method.
   */
  /**
  * Complexity: O(n) 
  * */
  public void loadData(File f) {
    try {
      Scanner scan = new Scanner(f);
      // skip first word count
      scan.next();

      while (scan.hasNext()) {
        String s = scan.next();

        data[size] = s;
        size++;
        // System.out.println("current read " + s + ", the size is " + size);
        // System.out.println(Arrays.toString(data));
        
      }
      scan.close();
    } catch (FileNotFoundException excpt) {
      System.out.println("Caught FileNotFoundException: " + excpt.getMessage());
      return;
    }
    //System.out.println(size);
    
  }

  @Override
  /**
   * ○ Generates a random integer between 0 and the current size. ○ Removes and returns the String
   * at that index. ○ Fills gaps by moving the last String into the gap and decrementing size. ○ If
   * the bag contains no strings, this method returns null.
   */
  /**
  * Complexity: O(1) 
  * */
  public String removeRandom() {
    if(size == 0) return null;
    
    int index = random.nextInt(size); // the index to remove
    String rm = data[index];
    data[index] = data[size-1];
    data[size-1] = null;
    size--;
    return rm;
  }



  /*
  public static void main(String[] args) {
    SimpleBag sb = new CleverBag(4);
    File f = new File("test.txt");
    sb.loadData(f);
    // System.out.println(Arrays.toString(sb.data));

    String rm = sb.removeRandom();
    System.out.println(rm + " \n" + Arrays.toString(sb.data));
  }
  */

}


