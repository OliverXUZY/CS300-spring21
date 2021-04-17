
public class ListNode <T>{
  private T data;
  private ListNode<T> prev;
  private ListNode<T> next;
  
  public ListNode(T data) {
    this.data = data;
  }
  
  public ListNode(T data, ListNode<T> nextNode) {
    this.data = data;
    this.setNext(nextNode);
    nextNode.setPrev(this);
  }
  
  
  // accessors
  public T getData() {
    return this.data;
  }
  
  public ListNode<T> getPrev() {
    return this.prev;
  }
  
  public ListNode<T> getNext() {
    return this.next;
  }
  
  //mutators
  public void setPrev(ListNode<T> newPrev){
    this.prev = newPrev;
  }
  
  public void setNext(ListNode<T> newNext) {
    this.next = newNext;
  }
  

}
