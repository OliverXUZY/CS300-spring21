/////////////// Palindrome class (INCLUDE IN EVERY FILE) //////////////////////////
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
public class Palindrome {
  /**
   * ○ Recursively create a simple alphabet pattern, starting at the provided character, moving
   * backward to the beginning of the alphabet, and then forward again to the provided letter,
   * separating each letter with a space. ■ If start is ​‘E’​, the method should return the string
   * ​“E D C B A B C D E” ○ This method is only valid for ​capital letter input​; if anything other
   * than a capital letter is provided as an argument, throw an IllegalArgumentException with a
   * descriptive error message.
   * 
   * @param start
   * @return
   * @throws IllegalArgumentException
   */
  public static String mirrorA(char start) throws IllegalArgumentException {
    if (!Character.isUpperCase(start)) {
      throw new IllegalArgumentException("Error! Only allow capital letter input.");
    }
    // base case
    if (start == 'A') {
      return "A";
    }
    // recursive case
    else {
      return start + " " + mirrorA((char) (start - 1)) + " " + start;
    }
  }

  /**
   * mirrorA with step 
   * ○ Recursively create an alphabet pattern, starting at the provided character,
   * and moving back and forth to the beginning of the alphabet by steps of size ​step​. ■ If start
   * is ​‘E’​ and step is 1, the method should return the same string as mirrorA(start)​. ■ If start
   * is ​‘E’​ and step is 2, the method should return ​“E C A C E” ■ If start is ​‘E’​ and step is
   * 3, the method should return ​“E B B E” ■ And so on. ○ As before, the method is only valid for
   * capital letter input and ​strictly positive​ (not zero or negative) step sizes. For invalid
   * input, throw an IllegalArgumentException with a descriptive error message.
   * 
   * @param start
   * @param step
   * @return
   * @throws IllegalArgumentException
   */
  public static String mirrorA(char start, int step) throws IllegalArgumentException {
    if (!Character.isUpperCase(start)) {
      throw new IllegalArgumentException("Error! Only allow capital letter input.");
    }
    
    if (step<=0) {
      throw new IllegalArgumentException("Error! Step should be positive.");
    }
    
    String res = "";
    if (step == 1) {
      res = mirrorA(start);
    }
    if (step >= 2) {
      // base case jump to A
      if ((start == 'A')) {
        res = Character.toString(start);
      } 
      // base case jump to B,C,...
      else if((start - step) < 65){
        res = start + " " + start;
      }
      // recursive case
      else {
        res = start + " " + mirrorA((char) (start - step), step) + " " + start;
      }
    }
    return res;
  }

  /**
   * ○ Recursively create a simple alphabet pattern, starting the provided character, and moving
   * forward to the end of the alphabet, and then backward again to the provided letter, separating
   * each letter with a space. ■ If start is ​‘V’​, the method should return the string ​“V W X Y Z
   * Y X W V” ○ This method is only valid for capital letter input; if anything other than a capital
   * letter is provided as an argument, throw an IllegalArgumentException with a descriptive error
   * message.
   * 
   * @param start
   * @param step
   * @return
   * @throws IllegalArgumentException
   */
  public static String mirrorZ(char start) throws IllegalArgumentException {
    if (!Character.isUpperCase(start)) {
      throw new IllegalArgumentException("Error! Only allow capital letter input.");
    }
    // base case
    if (start == 'Z') {
      return "Z";
    }
    // recursive case
    else {
      return start + " " + mirrorZ((char) (start + 1)) + " " + start;
    }
  }

  /**
   * mirrorZ with step 
   * ○ Recursively create an alphabet pattern, starting at the provided character,
   * and moving forward and back to the end of the alphabet by steps of size ​step​. ■ If start is
   * ​‘V’​ and step is 1, the method should return the same string as mirrorB(end). ■ If start is
   * ​‘V’​ and step is 2, the method should return ​“V X Z X V” ■ If start is ​‘V’​ and step is 3,
   * the method should return ​“V Y Y V” ■ And so on. ○ As before, the method is only valid for
   * capital letter input and ​strictly positive​ (not zero or negative) step sizes. For invalid
   * input, throw an IllegalArgumentException with a descriptive error message.
   * 
   * @param start
   * @param step
   * @return
   * @throws IllegalArgumentException
   */
  public static String mirrorZ(char start, int step) throws IllegalArgumentException {
    if (!Character.isUpperCase(start)) {
      throw new IllegalArgumentException("Error! Only allow capital letter input.");
    }
    
    if (step<=0) {
      throw new IllegalArgumentException("Error! Step should be positive.");
    }
    String res = "";
    if (step == 1) {
      res = mirrorZ(start);
    }
    if (step >= 2) {
      // base case jump to Z
      if ((start == 'Z')) {
        res = Character.toString(start);
      } 
      // base case jump to Y,X,...
      else if((start + step) > 90){
        res = start + " " + start;
      }
      // recursive case
      else {
        res = start + " " + mirrorZ((char) (start + step), step) + " " + start;
      }
    }
    return res;
  }



}
