// Add Complete File Header Here

// Add javadoc style class header here
// File Header comes here
import java.util.ArrayList;
import java.util.NoSuchElementException;
/////////////// MovieTreeTester class (INCLUDE IN EVERY FILE) //////////////////////////
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
* @author Zhuoyan Xu This is the MovieTreeTester class
*/
/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * MovieTree.
 *
 */

public class MovieTreeTester {

  /**
   * Checks the correctness of the implementation of both addMovie() and toString() methods
   * implemented in the MovieTree class. This unit test considers at least the following scenarios.
   * (1) Create a new empty MovieTree, and check that its size is 0, it is empty, and that its
   * string representation is an empty string "". (2) try adding one movie and then check that the
   * addMovie() method call returns true, the tree is not empty, its size is 1, and the .toString()
   * called on the tree returns the expected output. (3) Try adding another movie which is smaller
   * that the movie at the root, (4) Try adding a third movie which is greater than the one at the
   * root, (5) Try adding at least two further movies such that one must be added at the left
   * subtree, and the other at the right subtree. For all the above scenarios, and more, double
   * check each time that size() method returns the expected value, the add method call returns
   * true, and that the .toString() method returns the expected string representation of the
   * contents of the binary search tree in an increasing order from the smallest to the greatest
   * movie with respect to year, rating, and then name. (6) Try adding a movie already stored in the
   * tree. Make sure that the addMovie() method call returned false, and that the size of the tree
   * did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddMovieToStringSize() {
    MovieTree myTree = new MovieTree();
    // (1)
    if(!myTree.isEmpty()) return false;
    if(!myTree.toString().equals("")) return false;
    
    // (2)
    if(!myTree.addMovie(new Movie(1911, 3.4, "Apple"))) return false;
    if(myTree.isEmpty()) return false;
    if(myTree.size() != 1) return false;
    if(!myTree.toString().trim().equals("[(Year: 1911) (Rate: 3.4) (Name: Apple)]")) return false;
    
    // (3)
    if(!myTree.addMovie(new Movie(1901, 3.2, "Bat"))) return false;
    if(myTree.isEmpty() || myTree.size() != 2)return false;
    
    
    
    //( 4)
    if(!myTree.addMovie(new Movie(1999, 5.5, "Cat"))) return false;
    if(myTree.isEmpty() || myTree.size() != 3)return false;
    
    // (5)
    if(!myTree.addMovie(new Movie(1905, 7.8, "Dollar"))) return false;
    if(myTree.isEmpty() || myTree.size() != 4)return false;
    if(!myTree.addMovie(new Movie(2000, 9.9, "Edge"))) return false;
    if(myTree.isEmpty() || myTree.size() != 5)return false;
    
    if(!myTree.toString().trim().equals("[(Year: 1901) (Rate: 3.2) (Name: Bat)]\n"
        + "[(Year: 1905) (Rate: 7.8) (Name: Dollar)]\n"
        + "[(Year: 1911) (Rate: 3.4) (Name: Apple)]\n"
        + "[(Year: 1999) (Rate: 5.5) (Name: Cat)]\n"
        + "[(Year: 2000) (Rate: 9.9) (Name: Edge)]")) {
      return false;
    }
    
    // (6)
    if(myTree.addMovie(new Movie(1905, 7.8, "Dollar"))) return false;
    if(myTree.isEmpty() || myTree.size() != 5)return false;
    //System.out.println(myTree);
    
    return true;
  }

  /**
   * This method checks mainly for the correctness of the MovieTree.contains() method. It must
   * consider at least the following test scenarios. (1) Create a new MovieTree. Then, check that
   * calling the contains() method on an empty MovieTree returns false. (2) Consider a MovieTree of
   * height 3 which contains at least 5 movies. Then, try to call contains() method to search for the
   * movie having a match at the root of the tree. (3) Then, search for a movie at the right and
   * left subtrees at different levels considering successful and unsuccessful search operations.
   * Make sure that the contains() method returns the expected output for every method call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testContains() {
    MovieTree myTree = new MovieTree();
    // (1)
    if(myTree.contains(1911, 3.4, "Apple")) return false;
    
    // (2)
    myTree.addMovie(new Movie(1911, 3.4, "Apple"));
    myTree.addMovie(new Movie(1901, 3.2, "Bat"));
    myTree.addMovie(new Movie(1999, 5.5, "Cat"));
    myTree.addMovie(new Movie(1905, 7.8, "Dollar"));
    myTree.addMovie(new Movie(2000, 9.9, "Edge"));
    
    if(!myTree.contains(1911, 3.4, "Apple")) return false;
    
    // (3)
    if(!myTree.contains(1901, 3.2, "Bat")) return false;
    if(myTree.contains(1901, 3.33, "Bat")) return false;
    
    if(!myTree.contains(2000, 9.9, "Edge")) return false;
    if(myTree.contains(2020, 9.9, "Edge")) return false;
    
    
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty movie tree is zero. (2) ensures that
   * the height of a tree which consists of only one node is 1. (3) ensures that the height of a
   * MovieTree with the following structure for instance, is 4. (*) / \ (*) (*) \ / \ (*) (*) (*) /
   * (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    MovieTree myTree = new MovieTree();
    // (1)
    if(myTree.height() != 0) return false;
    
    // (2)
    myTree.addMovie(new Movie(1911, 3.4, "Apple"));
    if(myTree.height() != 1) return false;
    
    // (3)
    myTree.addMovie(new Movie(1901, 3.2, "Bat"));
    myTree.addMovie(new Movie(1989, 5.5, "Cat"));
    myTree.addMovie(new Movie(1905, 7.8, "Dollar"));
    myTree.addMovie(new Movie(2000, 9.9, "Edge"));
    myTree.addMovie(new Movie(1995, 9.9, "Fox"));
    myTree.addMovie(new Movie(1904, 9.9, "Grand"));
    if(myTree.height() != 4) return false;
    
    //System.out.println(myTree);
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.getBestMovie() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetBestMovie() {
    MovieTree myTree = new MovieTree();
    
    myTree.addMovie(new Movie(1911, 3.4, "Apple"));
    myTree.addMovie(new Movie(1901, 3.2, "Bat"));
    myTree.addMovie(new Movie(1989, 5.5, "Cat"));
    myTree.addMovie(new Movie(1905, 7.8, "Dollar"));
    myTree.addMovie(new Movie(2000, 9.9, "Edge"));
    myTree.addMovie(new Movie(1995, 9.9, "Fox"));
    Movie myMovie = new Movie(2010, 9.9, "Grand");
    myTree.addMovie(myMovie);
    
    if(myTree.getBestMovie().equals(myMovie)) return true;
    
    return false;
  }

  /**
   * Checks for the correctness of MovieTree.lookup() method. This test must consider at least 3
   * test scenarios. (1) Ensures that the MovieTree.lookup() method throws a NoSuchElementException
   * when called on an empty tree. (2) Ensures that the MovieTree.lookup() method returns an array
   * list which contains all the movies satisfying the search criteria of year and rating, when called
   * on a non empty movie tree with one match, and two matches and more. Vary your search criteria
   * such that the lookup() method must check in left and right subtrees. (3) Ensures that the
   * MovieTree.lookup() method throws a NoSuchElementException when called on a non-empty movie tree
   * with no search results found.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    MovieTree myTree = new MovieTree();
    // (1)
    try {
      myTree.lookup(0, 0);
      return false;
    } catch (NoSuchElementException e) {
      
    }
    ArrayList<Movie> myList = new ArrayList<Movie>();
    // (2)
    myTree.addMovie(new Movie(1911, 3.4, "Apple"));
    myTree.addMovie(new Movie(1901, 3.2, "Bat"));
    myTree.addMovie(new Movie(2000, 5.5, "Cat"));
    myTree.addMovie(new Movie(1901, 8.2, "Dollar"));
    myTree.addMovie(new Movie(2000, 7.5, "Edge"));
    myTree.addMovie(new Movie(2000, 6.5, "Fox"));
    myTree.addMovie(new Movie(2010, 9.9, "Grand"));
    
    
    if(myTree.lookup(2010, 0).size() != 1) return false;
    if(myTree.lookup(1901, 0).size() != 2) return false;
    if(myTree.lookup(2000, 0).size() != 3) return false;
    
    // (3)
    try {
      myTree.lookup(2000, 10);
      return false;
    } catch (NoSuchElementException e) {
      
    }
    //myList = myTree.lookup(2000, 0);
    
    //System.out.println(myList);
    
    return true;
  }
  
  

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    
    System.out.println("testAddMovieToStringSize(): " + testAddMovieToStringSize());
    System.out.println("testContains(): " + testContains());
    System.out.println("testHeight(): " + testHeight());
    System.out.println("testGetBestMovie(): " + testGetBestMovie());
    System.out.println("testLookup(): " + testLookup());
    
    //demo();

    
  }
  
  /*
  public static void demo() {
    MovieTree bst = new MovieTree();
    System.out.println("Size: " + bst.size() + " Height: " + bst.height() + "\nCatalog:");
    System.out.println(bst);
    bst.addMovie(new Movie(2018, 6.5, "Airplanes"));
    bst.addMovie(new Movie(1988, 9.5, "Best"));
    System.out.println("==============================================================");
    System.out.println("Size: " + bst.size() + " Height: " + bst.height() + "\nCatalog:");
    System.out.println(bst);
    bst.addMovie(new Movie(2018, 8.5, "Cats"));
    bst.addMovie(new Movie(2018, 6.0, "Yes"));
    bst.addMovie(new Movie(2017, 5.5, "Dogs"));
    bst.addMovie(new Movie(2018, 7.5, "Earth"));
    bst.addMovie(new Movie(2018, 6.0, "Flights"));
    bst.addMovie(new Movie(2015, 8.5, "Grand Parents"));
    System.out.println("==============================================================");
    System.out.println("Size: " + bst.size() + " Height: " + bst.height() + "\nCatalog:");
    System.out.println(bst);
    try {
      System.out.println("This catalog contains (2018, 7.5, Earth): " + bst.contains(2018, 7.5, "Earth"));
      System.out.println("This catalog contains (2016, 8.4, Flowers): " + bst.contains(2018, 7.5, "Flowers"));
      System.out.println();
      System.out.println("Best movie: " + bst.getBestMovie());
      System.out.println();
      System.out.println("Lookup query: search for the movies of 2018 rated 6.5 and higher");
      System.out.println(bst.lookup(2018, 6.5));
      System.out.println();
      System.out.println("Lookup query: search for the movies of 2018 with rated 8.0 and higher");
      System.out.println(bst.lookup(2018, 8.0));
      System.out.println();
      System.out.println("Lookup query: search for the movies of 2015 with rated 9.0 and higher");
      System.out.println(bst.lookup(2015, 9.0));
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
  }
  */

}
