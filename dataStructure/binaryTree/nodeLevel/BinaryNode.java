
public class BinaryNode <T extends Comparable<T>>{
  private T data;
  private BinaryNode<T> left;
  private BinaryNode<T> right;
  
  public BinaryNode(T data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
  
//accessors
 public T getData() {
   return this.data;
 }
 
 public BinaryNode<T> getLeft() {
   return this.left;
 }
 
 public BinaryNode<T> getRight() {
   return this.right;
 }
 
 //mutators
 public void setLeft(BinaryNode<T> newLeft){
   this.left = newLeft;
 }
 
 public void setRight(BinaryNode<T> newRight) {
   this.right = newRight;
 }

 public void add(T newNodeVal) {
   if(this.data.compareTo(newNodeVal) == 0) return;
   
   if(this.data.compareTo(newNodeVal) <= 0) {
     // data is less than target, add to right subtree
     if(this.right == null) this.right = new BinaryNode<T>(newNodeVal);
     this.right.add(newNodeVal);
     } 
   else {
     // data is larger than target, add to right subtree
     if(this.left == null) this.left = new BinaryNode<T>(newNodeVal);
     this.left.add(newNodeVal);
     }
 }
 
 public boolean contains(T target) {
   if(this.data.compareTo(target) == 0) return true;
   
   if(this.data.compareTo(target) <= 0) {
     // data is less than target, check right subtree
     if(this.right == null) return false;
     return this.right.contains(target);
     
   } else {
     // data is larger than target, check left subtree
     if(this.left == null) return false;
     return this.left.contains(target);
   }
   
 }
 
 
 @Override
 public String toString() {
   String result = "";
   
   // in order traversal
   
   // add left subtree's string
   if (this.left != null) result = this.left.toString();
   
   //add own data
   result += this.data.toString() + " ";
   
   // add  right subtree's data
   if(this.right != null) result += this.right.toString();
   
   return result;
 }
 
 public static void main(String[] arg) {
   BinaryNode<Integer> root = new BinaryNode<Integer>(3);
   root.add(5);
   root.add(2);
   root.add(7);
   root.add(1);
   root.add(4);
   System.out.println(root);
 }
}
