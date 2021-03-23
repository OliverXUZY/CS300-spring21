/////////////// PalindromeTester class (INCLUDE IN EVERY FILE) //////////////////////////
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
public class PalindromeTester {

  /**
   * test mirrorA
   * 
   * @return
   */
  public static boolean testMirrorA() {
    boolean isWork = true;
    String res = Palindrome.mirrorA('E');
    String ept = "E D C B A B C D E";
    if (!res.equals(ept)) {
      isWork = false;
    }


    try {
      System.out.println(Palindrome.mirrorA('9'));
    } catch (IllegalArgumentException excpt) {
      if (!excpt.getMessage().equals("Error! Only allow capital letter input.")) {
        isWork = false;
      }
    }


    return isWork;
  }

  /**
   * test mirrorAStep
   * 
   * @return
   */
  public static boolean testMirrorAStep() {
    boolean isWork = true;
    String res1 = Palindrome.mirrorA('E', 1);
    String ept1 = "E D C B A B C D E";
    if (!res1.equals(ept1)) {
      isWork = false;
    }


    String res2 = Palindrome.mirrorA('E', 2);
    String ept2 = "E C A C E";
    if (!res2.equals(ept2)) {
      isWork = false;

    }


    String res3 = Palindrome.mirrorA('E', 3);
    String ept3 = "E B B E";
    if (!res3.equals(ept3)) {

      isWork = false;
    }


    try {
      System.out.println(Palindrome.mirrorA('s', 1));
    } catch (IllegalArgumentException excpt) {
      if (!excpt.getMessage().equals("Error! Only allow capital letter input.")) {
        isWork = false;
      }
    }

    try {
      System.out.println(Palindrome.mirrorA('A', 0));
    } catch (IllegalArgumentException excpt) {
      if (!excpt.getMessage().equals("Error! Step should be positive.")) {
        isWork = false;
      }
    }


    return isWork;
  }

  /**
   * test mirrorZ
   * 
   * @return
   */
  public static boolean testMirrorZ() {
    boolean isWork = true;
    String res = Palindrome.mirrorZ('V');
    String ept = "V W X Y Z Y X W V";
    if (!res.equals(ept)) {
      isWork = false;
    }


    try {
      System.out.println(Palindrome.mirrorZ('9'));
    } catch (IllegalArgumentException excpt) {
      if (!excpt.getMessage().equals("Error! Only allow capital letter input.")) {
        isWork = false;
      }
    }

    return isWork;
  }

  public static boolean testMirrorZStep() {
    boolean isWork = true;
    String res1 = Palindrome.mirrorZ('V', 1);
    String ept1 = "V W X Y Z Y X W V";
    if (!res1.equals(ept1)) {
      // System.out.println("here");
      isWork = false;
    }


    String res2 = Palindrome.mirrorZ('V', 2);
    String ept2 = "V X Z X V";
    if (!res2.equals(ept2)) {
      // System.out.println("here");
      isWork = false;

    }


    String res3 = Palindrome.mirrorZ('V', 3);
    String ept3 = "V Y Y V";
    if (!res3.equals(ept3)) {

      isWork = false;
    }


    try {
      System.out.println(Palindrome.mirrorZ('s', 1));
    } catch (IllegalArgumentException excpt) {
      if (!excpt.getMessage().equals("Error! Only allow capital letter input.")) {
        isWork = false;
        // System.out.println("here");
      }
    }
    try {
      System.out.println(Palindrome.mirrorZ('V', 0));
    } catch (IllegalArgumentException excpt) {
      if (!excpt.getMessage().equals("Error! Step should be positive.")) {
        isWork = false;
      }
    }

    return isWork;
  }

  public static boolean runAllTests() {
    boolean isWork = true;
    if (!testMirrorA())
      isWork = false;
    if (!testMirrorAStep())
      isWork = false;
    if (!testMirrorZ())
      isWork = false;
    if (!testMirrorZStep())
      isWork = false;


    return isWork;

  }


  public static void main(String[] args) {
    System.out.println(runAllTests());

  }

}
/*
 * System.out.println("The result of testMirrorA() is --" + testMirrorA());
 * System.out.println("The result of testMirrorAStep() is --" + testMirrorAStep());
 * 
 * System.out.println("The result of testMirrorZ() is --" + testMirrorZ());
 * 
 * System.out.println("The result of testMirrorZStep() is --" + testMirrorZStep());
 * 
 * // TODO Auto-generated method stub char A = 'A'; //char B = 'A'; //String c = A+" " +B;
 * //System.out.println(A-1); //System.out.println( (char)(B+1) ); //String A = "ab"; String B =
 * "ab"; //System.out.println( A==B );
 * 
 * //System.out.println( Palindrome.mirrorA('s') );
 * //System.out.println(Character.isUpperCase('s')); String res = Palindrome.mirrorA('V'); String
 * ept = "V W X Y Z Y X W V"; //if(!res.equals(ept)) System.out.println(false);
 * System.out.println(Palindrome.mirrorZ('V',3));
 */

