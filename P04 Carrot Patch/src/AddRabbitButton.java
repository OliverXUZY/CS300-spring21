//////////////// Carrot Patch (INCLUDE IN EVERY FILE) //////////////////////////
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
public class AddRabbitButton extends Button {
  /**
   * Creates a new Button at a given position within a pApplet object
   * 
   * @param label      label to be assigned to this button
   * @param x          x-position where this button will be added to the display window
   * @param y          y-position where this button will be added to the display window
   * @param processing a reference to a PApplet object
   */
  public AddRabbitButton( float x, float y) {
    super("Add  Rabbit", x, y);
  }
  
  /**
   * Implements the default behavior of this button when the mouse is pressed. This method must be
   * overridden in the sub-classes to implement a specific behavior if needed.
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      processing.objects.add(new Rabbit());
      System.out.println("Add  Rabbit Button was pressed.");
    }
      
  }
}
