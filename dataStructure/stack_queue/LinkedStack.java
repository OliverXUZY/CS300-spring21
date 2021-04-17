import java.util.NoSuchElementException;

public class LinkedStack implements StackADT<String>{
  private ListNode<String> top;
  private int nodeCount = 0;
  @Override
  public void push(String newElement) {
    if (isEmpty()) this.top = new ListNode<String>(newElement);
    else {
      this.top = new ListNode<String>(newElement, this.top);
    }
    nodeCount++;
  }
  @Override
  public String pop() {
    if(isEmpty()) throw new NoSuchElementException("Empty Stack!");
    
    ListNode<String> retval  = this.top;
    this.top = retval.getNext();
    this.top.setPrev(null);
    nodeCount--;
    
    return retval.getData();
  }
  @Override
  public String peek() {
    if(isEmpty()) throw new NoSuchElementException("Empty Stack!");
    return this.top.getData();
  }
  @Override
  public boolean isEmpty() {
    return nodeCount == 0;
  }
  
  
  

}
