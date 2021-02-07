
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

//////////////// MemoryGame (INCLUDE IN EVERY FILE) //////////////////////////
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
 * This class is for memory game
 */
public class MemoryGame {
  // Congratulations message
  private final static String CONGRA_MSG = "CONGRATULATIONS! YOU WON!";
  // Cards not matched message
  private final static String NOT_MATCHED = "CARDS NOT MATCHED. Try again!"; // Cards
                                                                             // matched
  // message

  private final static String MATCHED = "CARDS MATCHED! Good Job!"; // 2D-array
                                                                    // which
                                                                    // stores
                                                                    // cards
  // coordinates on the window
  // display

  private final static float[][] CARDS_COORDINATES =
      new float[][] {{170, 170}, {324, 170}, {478, 170}, {632, 170}, {170, 324}, {324, 324},
          {478, 324}, {632, 324}, {170, 478}, {324, 478}, {478, 478}, {632, 478}};
  // Array that stores the card images filenames

  private final static String[] CARD_IMAGES_NAMES = new String[] {"ball.png", "redFlower.png",
      "yellowFlower.png", "apple.png", "peach.png", "shark.png"};

  private static PApplet processing; // PApplet object that represents
  // the graphic display window

  private static Card[] cards; // one dimensional array of cards, store 12
                               // card object corresponding
  // to the draw panel

  private static PImage[] images; // array of images of the different cards

  private static Card selectedCard1 = null; // First selected card

  private static Card selectedCard2 = null; // Second selected card

  private static boolean winner; // boolean evaluated true if the game is won,
  // and false otherwise

  private static int matchedCardsCount = 0; // number of cards matched so far
  // in one session of the game

  private static String message; // Displayed message to the display window,
                                 // change according to
  // different condition

  private static int[] mixedUp; // a mixedUp indices for shuffling

  /**
   * Defines the initial environment properties of this game as the program starts
   * 
   * @param processing
   */
  public static void setup(PApplet processing) {
    MemoryGame.processing = processing;
    // System.out.println("Test setup function");

    images = new PImage[CARD_IMAGES_NAMES.length];
    for (int i = 0; i < CARD_IMAGES_NAMES.length; i++) {
      // load image file as PImage object and store its reference into
      // images
      images[i] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[i]);
    }
    // Draw an image of an apple at the center of the screen
    // processing.image(images[0], processing.width / 2, processing.height /
    // 2);
    // width [resp. height]: System variable of the processing library
    // that stores the width [resp. height] of the display window.

    // System.out.println("images" + File.separator + CARD_IMAGES_NAMES[0]);

    startNewGame();

  }

  /**
   * Initializes the Game
   */
  public static void startNewGame() {
    selectedCard1 = null;
    selectedCard2 = null;
    matchedCardsCount = 0;
    winner = false;
    message = "";

    // create the array cards whose length MUST be CARDS COORDINATES.length.
    cards = new Card[CARDS_COORDINATES.length];

    // shuffling the indices before drawing
    mixedUp = Utility.shuffleCards(cards.length);

    // allocate card objects in cards
    for (int i = 0; i < cards.length; i++) {
      cards[i] = new Card(images[mixedUp[i]], CARDS_COORDINATES[i][0], CARDS_COORDINATES[i][1]);
      // cards[i].setVisible(true); // whether the card shows face up or
      // down
      // cards[i].draw();
    }

  }
  
  /**
   * method for keyPressed
   */
  public static void keyPressed() {
    char key = processing.key;
    if (key == 'N' || key == 'n') {
      startNewGame();
    }
  }

  /**
   * Callback method draws continuously this application window display
   */
  public static void draw() {
    processing.background(245, 255, 250); // Mint cream color

    // place the draw method only to draw()
    for (int i = 0; i < cards.length; i++) {
      cards[i].draw();
    }

    displayMessage(message);

  }

  /**
   * Displays a given message to the display window
   * 
   * @param message to be displayed to the display window
   */
  public static void displayMessage(String message) {
    processing.fill(0);
    processing.textSize(20);
    processing.text(message, processing.width / 2, 50);
    processing.textSize(12);
  }

  /**
   * Checks whether the mouse is over a given Card
   * 
   * @param card
   * @return true if the mouse is over the storage list, false otherwise
   */
  public static boolean isMouseOver(Card card) {
    int Height = card.getHeight();
    int Width = card.getWidth();
    int MouseX = processing.mouseX;
    int MouseY = processing.mouseY;
    if (MouseX >= card.getX() - Width / 2 && MouseX <= card.getX() + Width / 2) {
      // System.out.println(CARDS_COORDINATES[0][0] - card.getX());
      if (MouseY >= card.getY() - Height / 2 && MouseY <= card.getY() + Height / 2) {
        return true;
      }
    }
    return false;

  }
  
  /**
   * method for find which card is pressed
   * @return the pressed card object
   */

  private static Card findPressedCard() {
    for (int i = 0; i < cards.length; i++) {
      if (isMouseOver(cards[i]) == true) {
        cards[i].select();
        return (cards[i]);
      }
    }
    return null;
  }

  /**
   * Callback method called each time the user presses the mouse
   */
  public static void mousePressed() {
    // if won, no further changes
    if (winner) {
      return;
    }
    // reset message for each new click every time
    message = "";
    // if mouse click a matched card, nothing change, continue to next click
    // (return
    // directly)
    Card localCard = findPressedCard(); // check the card this pressed first
    if (localCard.isMatched()) {
      return;
    }

    if (selectedCard1 == null) { /// --- selectedCard1 = null and
                                 /// selectedCard2 = null
      selectedCard1 = localCard;
      selectedCard1.setVisible(true);
      return;

    } else if (selectedCard2 == null) { /// --- selectedCard1 != null and
                                        /// selectedCard2 = null
      // if click twice on same card, nothing change, continue to next
      // click (return
      // directly)
      if (isMouseOver(selectedCard1)) {
        return;
      }
      selectedCard2 = localCard;
      selectedCard2.setVisible(true);
      if (matchingCards(selectedCard1, selectedCard2)) { // if two cards
                                                         // match,
                                                         // compare right
                                                         // after
        // selecting second card

        message = MATCHED;
        matchedCardsCount += 2;
        selectedCard1.setMatched(true);
        selectedCard2.setMatched(true);

        // check whether machedCount reaches 12, if it does, won
        // directly
        if (matchedCardsCount == 12) {
          message = CONGRA_MSG;
          winner = true;
          return;
        }

      } else { // if 2 cards do not match
        message = NOT_MATCHED;
      }

    } else { /// --- selectedCard1 != null and selectedCard2 != null
      // if click over the two selected cards, nothing change, continue to
      // next click
      // (return
      // directly)
      if (selectedCard1 == localCard || selectedCard2 == localCard) {
        return;
      }
      selectedCard1.deselect();
      selectedCard2.deselect();
      if (!matchingCards(selectedCard1, selectedCard2)) {
        selectedCard1.setVisible(false);
        selectedCard2.setVisible(false);
        selectedCard1 = null;
        selectedCard2 = null;

        selectedCard1 = localCard;
        selectedCard1.setVisible(true);

      } else {
        selectedCard1 = null;
        selectedCard2 = null;

        selectedCard1 = localCard;
        selectedCard1.setVisible(true);
      }

    }

    /*
     * if (selectedCard1 != null) { if (selectedCard2 != null) { /// selectedCard1 != null and
     * selectedCard2 != null if (matchingCards(selectedCard1, selectedCard2)) { // if two cards
     * match message = "CARDS MATCHED! Good job!"; matchedCardsCount += 2;
     * selectedCard1.setMatched(true); selectedCard2.setMatched(true); selectedCard1.deselect();
     * selectedCard2.deselect(); selectedCard1 = null; selectedCard2 = null;
     * 
     * if (localCard.isMatched()) { return; } selectedCard1 = localCard;
     * selectedCard1.setVisible(true); } else { // if 2 cards do not match message =
     * "CARDS NOT MATCHED. Try again!"; selectedCard1.setVisible(false);
     * selectedCard2.setVisible(false); selectedCard1.deselect(); selectedCard2.deselect();
     * selectedCard1 = null; selectedCard2 = null;
     * 
     * selectedCard1 = localCard; selectedCard1.setVisible(true); } } else { // selectedCard1 !=
     * null and selectedCard2 = null
     * 
     * // if click twice on same card, nothing change, continue to next click (return directly)
     * if(isMouseOver(selectedCard1)) { return; } selectedCard2 = findPressedCard();
     * selectedCard2.setVisible(true); } } else { // selectedCard1 = null selectedCard1 =
     * findPressedCard(); selectedCard1.setVisible(true); }
     */

  }

  /**
   * Checks whether two cards match or not
   * 
   * @param card1 reference to the first card
   * @param card2 reference to the second card
   * @return true if card1 and card2 image references are the same, false otherwise
   */
  public static boolean matchingCards(Card card1, Card card2) {
    if (card1.getImage() == card2.getImage()) {
      return true;
    }
    return false;
  }
  
  /**
   * the main function
   * @param args
   */

  public static void main(String[] args) {
    Utility.startApplication(); // starts the application

  }

}
