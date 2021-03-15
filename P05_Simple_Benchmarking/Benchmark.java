import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/////////////// Benchmark class (INCLUDE IN EVERY FILE) //////////////////////////
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
public class Benchmark {

  /**
   * ○ Runs both classes’ loadData() implementations on the same text file. ○ Tracks the time spent
   * in milliseconds to complete each loadData(). ○ Returns a formatted String with the elapsed
   * times for each of the bag types.
   * 
   * @param f
   * @param s
   * @param c
   * @return
   */
  public static String compareLoadData(File f, SimpleBag s, CleverBag c) {
    long sbBefore = System.currentTimeMillis();
    s.loadData(f);
    long sbAfter = System.currentTimeMillis();
    long simpleBagLoadTime = sbAfter - sbBefore;

    long cbBefore = System.currentTimeMillis();
    c.loadData(f);
    long cbAfter = System.currentTimeMillis();
    long cleverBagLoadTime = cbAfter - cbBefore;


    return "load:\t" + simpleBagLoadTime + "\t" + cleverBagLoadTime + "\n";
  }

  /**
   * ○ Runs both classes’ removeRandom() method n times . ○ Tracks the time spent in milliseconds to
   * complete each type of remove ○ Returns a formatted string with n and the elapsed times for each
   * of the bag types.
   * 
   * @param n
   * @param s
   * @param c
   * @return
   */
  public static String compareRemove(int n, SimpleBag s, CleverBag c) {
    long sbBefore = System.currentTimeMillis();
    for(int i = 0; i<n; i++) {
      s.removeRandom();
    }
    long sbAfter = System.currentTimeMillis();
    long simpleBagRemoveTime = sbAfter - sbBefore;

    long cbBefore = System.currentTimeMillis();
    for(int i = 0; i<n; i++) {
      c.removeRandom();
    }
    long cbAfter = System.currentTimeMillis();
    long cleverBagRemoveTime = cbAfter - cbBefore;
    return n + "\t" + simpleBagRemoveTime + "\t" + cleverBagRemoveTime + "\n";
  }

  /**
   * ○ Creates one instance each of a SimpleBag and a CleverBag. ○ Calls compareLoadData() to
   * compare the two different data loads using the in parameter. ○ Calls compareRemove() on each of
   * the provided nValues to compare the two different remove implementations. ○ Writes the results
   * of the data load comparison followed by the remove comparisons to a file specified by the out
   * parameter. ○ Handles any exceptions raised by the methods it uses.
   * 
   * @param in
   * @param out
   * @param nValues
   */
  public static void createResultsFile(File in, File out, int[] nValues) {
    SimpleBag sb = new SimpleBag(20);
    CleverBag cb = new CleverBag(20);
    
    String loadComparison = compareLoadData(in, sb, cb);
    String[] rmComparison = new String[nValues.length];
    for(int i = 0; i < nValues.length; i++) {
      rmComparison[i] = compareRemove(nValues[i], sb, cb);
    }
    
    try {
      FileWriter fileWriter = new FileWriter(out);
      fileWriter.write(loadComparison);
      for(int i = 0; i < nValues.length; i++) {
        fileWriter.write(rmComparison[i]);
      }
      
      fileWriter.close();
    } catch (IOException excpt) {
      System.out.println("Caught IOException: " + excpt.getMessage());
      return;
    } 

  }

  public static void main(String[] args) {
    File in = new File("frank.txt");
    File out = new File("res.txt");
    int[] nValues = new int[] {10, 100, 1000, 10000, 30000};
    
    createResultsFile(in, out, nValues);

  }

}
