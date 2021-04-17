package bst;

import java.util.NoSuchElementException;
//import bstComplete.BinaryNode;

/**
 * CS300 - Programming II University of Wisconsin at Madison I Implementation of a generic
 * BinarySearchTree
 * 
 * @param <T> type parameter of the data field of a binary node T should be a reference type (class)
 *            that implements the comparable interface or extends a class that implements the
 *            comparable interface (compareTo method should be defined to compare to objects of type
 *            <T>
 */

public class BinarySearchTree<T extends Comparable<T>> {
  private BinaryNode<T> root; // root of the BST

  // /**
  // * Creates an empty instance of a Binary Search Tree
  // */
  // public BinarySearchTree() {
  // root = null;
  // }


  /**
   * Checks whether the BST is empty
   * 
   * @return true if the BST is empty, false otherwise
   */
  public boolean isEmpty() {
    return root == null;
  }

  /**
   * print all the elements in the BST according to the pre-order traversal algorithm Time
   * Complexity: O(?) ; The problem size n represents the number of nodes in the tree
   */
  public void printPreOrder() {
    if (isEmpty()) {
      System.out.println("This BST is empty.");
    } else {
      printPreOrderHelper(root); // recursive algorithm
    }
  }

  /**
   * Recursive helper method to perform a pre-order traversal of the BST
   * 
   * @param currentNode
   */
  private void printPreOrderHelper(BinaryNode<T> currentNode) {
    // process the parent
    System.out.print(currentNode.getData() + " ");
    // recur on the left sub-tree if currentNode has a left child
    if (currentNode.getLeft() != null)
      printPreOrderHelper(currentNode.getLeft());
    // recur on the right sub-tree if the currentNode has a right child
    if (currentNode.getRight() != null)
      printPreOrderHelper(currentNode.getRight());
  }


  /**
   * Prints the Tree content in a sorted order: performs an in-order traversal of the BST
   */
  public void printTreeSortedOrder() {
    // root.printInOrder(); // if printInOrder() is defined in the Binary node
    System.out.print(printInOrderHelper(root));
  }

  /**
   * Recursive helper method to perform a in-order traversal of the BST
   * 
   * @param currentNode root of the subtree
   */
  private static <T> String printInOrderHelper(BinaryNode<T> currentNode) {
    String result = ""; // String representation of the in-order traversal of the subtree routed at
                        // currentNode, initialized to an empty String
    // Base case(s)?
    if(currentNode == null) return "";
    // Recursive cases?
    result = printInOrderHelper(currentNode.getLeft());
    
    result += currentNode.getData();
    
    result += printInOrderHelper(currentNode.getRight());

    return result;
  }


  /**
   * Checks whether the BST contains item
   * 
   * @param item: The item we're looking for
   * @return true if item is present in the Binary Search Tree, false otherwise
   */
  public boolean contains(T item) {
    return containsHelper(item, root);
  }

  /**
   * Helper method that checks if the subtree rooted at a given node contains item
   * 
   * @param item to look for in the subtree rooted at node
   * @param node current node in a binary search tree
   * @return true if the subtree rooted at node contains item, false otherwise
   */
  private boolean containsHelper(T item, BinaryNode<T> node) {
    // worst-case runtime complexity (problem size n is the size of the BST):
    // = number of recursive calls at worst case * runtime complexity of the code which will be run
    // for every recursive call
    // = height of the tree * O(1); // at worst case the height of a general BST equals its size
    // // in the case of a skewed BST (not balanced BST)
    // = n * O(1) = O(n)

    // Recursive algorithm (use compareTo() method to compare items)
    // Base case(s)??
    // unsuccessful search
    if (node == null) // empty subtree (or a leaf is reached without finding any match)
      return false;
    // search into a non-empty subtree rooted at node
    int comparisonResult = item.compareTo(node.getData());
    // item found -> successful search
    if (comparisonResult == 0)
      return true;
    // Recursive cases??
    if (comparisonResult < 0) {
      // recurse on the left subtree rooted at node.getLeft()
      return containsHelper(item, node.getLeft());
    } else { // comparisonResult > 0
      // recurse on the right subtree rooted at node.getRight()
      return containsHelper(item, node.getRight());
    }
  }



  /**
   * Computes and returns the number of items stored in this BST
   * 
   * @return the number of items stored in this BST
   */
  public int size() {
    return sizeHelper(root);

  }

  /**
   * Helper method that returns the number of items stored in the subtree rooted at a given
   * BinaryNode
   * 
   * @param current BinaryNode that represents a root of a subtree
   * @return the size of the subtree rooted at current
   */
  private static <T> int sizeHelper(BinaryNode<T> current) {
    // Base case ??
    if(current == null) return 0;
    // recursive cases ??

    int sizeLeft = sizeHelper(current.getLeft());
    int sizeRight = sizeHelper(current.getRight());
    
    return 1 + sizeLeft + sizeRight;
  }



  /**
   * Adds item to this Binary Search Tree
   * 
   * @param item to insert/add to this binary search tree (BST)
   * @throws an Exception if item is already stored in the tree
   */
  public void add(T item) {
    if (isEmpty()) // tree is empty
      root = new BinaryNode<T>(item); // add item at root position of this BST
    else
      addHelper(item, root); // make call to addHelper to recursively add item to this BST
  }

  // Return the parent node of item,
  /**
   * Utility/Helper method to insert into a subtree.
   * 
   * @param newItem the item to add.
   * @param node    the node that roots the tree.
   * @return the new root.
   * @throws DuplicateItemException if the newItem is already present.
   */
  private void addHelper(T newItem, BinaryNode<T> current) {
    // In this implementation, we won't allow duplicate items
    // Recursive algorithm (use compareTo() method to compare items)
    // Base case(s)?

    // Recursive cases?
    
    // if node already exist
    if(newItem.equals(current.getData())) return;
    
    // newItem is less, add to left sub tree
    if(newItem.compareTo(current.getData()) < 0 ) {
      // left child is null, add directly
      if(current.getLeft() == null) {
        current.setLeft(new BinaryNode<T>(newItem));
      }
       addHelper(newItem, current.getLeft());
    } 
    // newMovie is larger, add to right sub tree
    else {
      // right child is null, add directly
      if (current.getRight() == null) {
        current.setRight(new BinaryNode<T>(newItem));
      }
      addHelper(newItem, current.getRight());
    }
  }
  
  /**
   * Removes item from this BST
   * 
   * @param item to be removed from this BinarySearchTree and
   * @throws NoSuchElementException if item is not found in the tree
   */
  public void remove(T item) {
    root = removeHelper(item, root, null);

  }

  /**
   * Helper method to remove from a specific item from a subtree.
   * 
   * @param item the item to remove.
   * @param node the node that roots the subtree.
   * @return the new root of the subtree.
   * @throws NoSuchElementException if item is not found in the tree
   */
  private BinaryNode<T> removeHelper(T item, BinaryNode<T> node, BinaryNode<T> par) {
    if (node == null)
      // item not found
      throw new NoSuchElementException("Error! Item not found.");
    if (item.compareTo(node.getData()) < 0)
      node.setLeft(removeHelper(item, node.getLeft(), node)); // recur on the left subtree rooted at
                                                        // node.getLeft()
    else if (item.compareTo(node.getData()) > 0)
      node.setRight(removeHelper(item, node.getRight(), node)); // recur on the right subtree
    else { // item found
      // TODO (Complete the missing code with respect to the following hints
      // The most difficult operation to implement for a BST is the remove operation.
      // Once you find the node to be removed, several possibilities should be considered.
      //
      // The first problem is that the removal of a node may disconnect parts of the tree.
      // If that happens, the tree should be carefully re-attached such that the binary
      // search tree property is maintained.
      //
      // The second problem to consider is that we would like to avoid making the tree
      // unnecessarily deep since the depth of the tree affects the running time of the
      // different binary search tree algorithms (except isEmpty).
      //
      // Case 1: if the node is a leaf, its removal does not disconnect the tree,
      // So, we can remove it immediately
      if(node.getLeft() == null && node.getRight() == null) {
        node = null;
      }
      //
      // Case 2: if the node has only one child, we can remove the node after adjusting its parent's
      // child link to bypass the node.
      else if(node.getLeft() == null) {    // node has only right child
        if(par.getLeft().getData().equals(node.getData())) {
          par.setLeft(node.getRight());
        } else {
          par.setRight(node.getRight());
        }
        
      }
      else if(node.getRight() == null) {    // node has only left child
        if(par.getLeft().getData().equals(node.getData())) {
          par.setLeft(node.getLeft());
        } else {
          par.setRight(node.getLeft());
        }
      }
      //
      // Case 3: The complicated case: the node has two children
      // either replace the item in this node with the smallest item in the right subtree and then
      // remove that node.
      // or
      // replace the item in this node with the largest item in the left subtree and then
      // remove that node.
      BinaryNode<T> leftMost = getLeftmostNode(node.getRight());
      if(par.getLeft().getData().equals(node.getData())) {
        par.setLeft(leftMost);
      } else {
        par.setRight(leftMost);
      }
      
      // recur remove leftmost on the right subtree 
      node.setRight(removeHelper(leftMost.getData(), node.getRight(), node)); 
      
      
    }
    return node; // return the new root of this subtree, otherwise, the changes will be lost after
                 // the method returns
  }

  /**
   * private helper method in removeHelper (case 3)
   * Gets the leftmost in subtree with root "current"
   * 
   * @return the leftmost BinaryNode in tree and null if this tree is empty.
   */
  private BinaryNode<T> getLeftmostNode(BinaryNode<T> current) {
    if(isEmpty()) return null;
    
    while(current.getLeft() != null) {
      current = current.getLeft();
    }

    // Feel free to implement either the iterative OR the recursive version of this
    // method.

    // If you choose recursion to implement this behavior, add a private helper
    // method and call it here.

    return current; // added to let this incomplete code compile
  }

  

}
