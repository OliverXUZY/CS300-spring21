import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
/////////////// SimpleBag class (INCLUDE IN EVERY FILE) //////////////////////////
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
public class SimpleBag {

  protected String[] data;  // over-size array
  protected Random random;

  /**
   * Initializes a protected field, data, which is an array of Strings with capacity 80,000. We will
   * not provide files with more than 80,000 words. Initializes a protected Random object, random,
   * using the provided seed value.
   * 
   * @param seed
   */
  public SimpleBag(int seed) {
    data = new String[80000];
    random = new Random(seed);

  }

  /**
   * ○ Reads the text contents of the provided file, inserting each new space-separated word at the
   * beginning of the data array. ○ All strings currently in the array should be shifted to the
   * right by one index to make room. That is, the string at index N should be moved to index N+1,
   * and so forth. ○ If you encounter any exceptions while reading the File, simply return from the
   * method.
   * 
   * @param f
   */
  /**
  * Complexity: O(n^2) 
  * */
  public void loadData(File f) {
    int size = 0;
    
    try {
      Scanner scan = new Scanner(f);
      // skip first word count
      scan.next();
      
      while(scan.hasNext()) {
        String s = scan.next();
        //System.out.println(s);
        for (int i = size; i > 0; i--) { // modify
          data[i] = data[i-1];
          
        }
        data[0] = s;
        size++;
        //System.out.println("current read " + s + ", the size is " + size);
        //System.out.println(Arrays.toString(data));
      }
      scan.close();
    } catch (FileNotFoundException excpt) {
      System.out.println("Caught FileNotFoundException: " + excpt.getMessage());
      return;
    }
    //System.out.println(size);

  }


  /**
   * Counts the number of Strings (i.e. non-null) values in the data array and generates a random
   * index between 0 and the number of Strings stored in this bag (exclusive).. ○ Removes and
   * returns the String at that index. ○ Fills gaps by moving all following strings to the left by
   * one index. N -> N-1, etc. ○ If the bag contains no strings, this method returns null.
   * 
   * @return
   */
  /**
  * Complexity: O(n) 
  * */
  public String removeRandom() {
    int size = 0;
    for(int i = 0; i < data.length; i++) {
      if(data[i] != null) {
        size++;
      }
    }
    if(size == 0) return null;
    
    int index = random.nextInt(size); // the index to remove
    String rm = data[index];
    for(int i = index; i < size; i++) {
      data[i] = data[i+1];
    }
    
    return rm;
  }

  /*
  public static void main(String[] args) {
    SimpleBag sb = new SimpleBag(4);
    File f = new File("test.txt");
    sb.loadData(f);
    //System.out.println(Arrays.toString(sb.data));
    
    String rm = sb.removeRandom();
    //System.out.println(rm + " \n" + Arrays.toString(sb.data));
  }
  */

}




















