import java.util.NoSuchElementException;

public class CircularQueue implements QueueADT<String>{
  private String[] contents;
  private int size = 0;
  public int front = -1;
  public int back = -1;
  
  // constructor
  public CircularQueue() {
    contents = new String[12];
  }
  
  public CircularQueue(int capacity) {
    if (capacity <= 0) contents = new String[12];
    else contents = new String[capacity];
  }

  @Override
  public void enqueue(String newElement) {
    if(isEmpty()) {
      contents[0] = newElement;
      front = 0;
      back = 0;
    } else {
      // add at back
      back = (back+1 == contents.length) ? 0 : back + 1;
      contents[back] = newElement;
    }
    size++;
  }

  @Override
  public String dequeue() {
    if(isEmpty()) throw new NoSuchElementException("Empty Queue!");
    String retval = (String) contents[front];
    size--;
    if(size == 0) {
      front = -1;
      back = -1;
    } else {
      front = (front+1) % contents.length;
    }
    return retval;
  }

  @Override
  public String peek() {
    if(isEmpty()) throw new NoSuchElementException("Empty Queue!");
    return contents[front];
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }
  

}
