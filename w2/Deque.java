import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
  private int N;
  private Node first;
  private Node last;
  
  private class Node {
    private Item item;
    private Node prev;
    private Node next;
  }
  // construct an empty deque
  public Deque() {
    N = 0;
    first = null;
    last = null;
  }
  
  // is the deque empty?
  public boolean isEmpty() {
    return N == 0;
  }
  
  // return the number of items on the deque
  public int size() {
    return N;
  }              
  
  // insert the item at the front
  public void addFirst(Item item) {
    if (item == null)
      throw new NullPointerException("item can't be null");
    if (N == 0) {
      first = new Node();
      last = first;
      first.prev = null;
      first.next = null;
      last.prev = null;
      last.next = null;
      first.item = item;
      last.item = item;
    }
    else {
      Node oldFirst = first;
      first = new Node();
      first.item = item;
      first.prev = null;
      first.next = oldFirst;
      oldFirst.prev = first;
    }
    
    N++;
    
  }    
  
  // insert the item at the end
  public void addLast(Item item) {
    if (item == null)
      throw new NullPointerException("item can't be null");
    
    if (isEmpty()) {
      first = new Node();
      last = first;
      first.prev = null;
      first.next = null;
      last.prev = null;
      last.next = null;
      first.item = item;
      last.item = item;
    }
    else {    
      Node oldLast = last;
      last = new Node();
      last.item = item;
      last.prev = oldLast;
      last.next = null;
      oldLast.next = last;
    }
    
    N++;
    
  }    
  
  // delete and return the item at the front
  public Item removeFirst() {
    if (isEmpty())
      throw new NoSuchElementException("empty deque");
        
    Item item = first.item;
    first = first.next;
    N--;
    return item;
  }         
  
  // delete and return the item at the end
  public Item removeLast() {
    if (isEmpty())
      throw new NoSuchElementException("empty deque");
    
    Item item = last.item;
    last = last.prev;
    N--;
    return item;
  }   
  
  // return an iterator over items in order from front to end
  public Iterator<Item> iterator() {
    return new ListIterator(); 
  }   
  
  private class ListIterator implements Iterator<Item> {
     private Node current = first;
     public boolean hasNext() {
       return current != null;
     }
     public void remove() { 
       throw new UnsupportedOperationException(); 
     }

     public Item next() {
          if (!hasNext()) throw new NoSuchElementException();
          Item item = current.item;
          current = current.next; 
          return item;
        }
  }
  
   public static void main(String[] args) {
        Deque<String> s = new Deque<String>();
        s.addFirst("a");
        s.addFirst("a");
        s.addFirst("a");
        s.addLast("dd");
        s.removeLast();
        s.removeFirst();
       
        
        StdOut.println("(" + s.size() + " left on stack)");
        
     for (String a:s)
       StdOut.println(a);
    }
}
