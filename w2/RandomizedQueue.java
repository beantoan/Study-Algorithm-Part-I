import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
  private Item[] a;
  private int N;
  
  // construct an empty randomized queue
  public RandomizedQueue() {
    a = (Item[]) new Object[2];
  }  
  
  // is the queue empty?
  public boolean isEmpty() { 
    return N == 0;
  }        
  
  // return the number of items on the queue
  public int size() {
    return N;
  }          
  
  // add the item
  public void enqueue(Item item) {
    if (item == null)
      throw new NullPointerException("item can't be null");
    
    if (N == a.length) resize(2*a.length);    // double size of array if necessary
    a[N++] = item;                         
  }    
  
  // delete and return a random item
  public Item dequeue() {
    if (isEmpty())
      throw new NoSuchElementException("empty deque");
    
    int n = StdRandom.uniform(N);
    Item item = a[n];
    a[n] = null;
    N--;
    if (N > 0 && N == a.length/4) resize(a.length/2);
    return item;
  }
  
  // return (but do not delete) a random item
  public Item sample() {
    if (isEmpty())
      throw new NoSuchElementException("empty deque");
    
    int n = StdRandom.uniform(N);
    Item item = a[n];
    return item;
  }               
  
  // return an independent iterator over items in random order
  public Iterator<Item> iterator() { 
    return new RandomArrayIterator(); 
  }  
  
  private class RandomArrayIterator implements Iterator<Item> {
    private int i;

    public RandomArrayIterator() {
        i = a.length;
        StdRandom.shuffle(a);
    }

    public boolean hasNext() {
        return i > 0;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public Item next() {
        if (!hasNext()) throw new NoSuchElementException();
        return a[--i];
    }
  }

  private void resize(int capacity) {
      Item[] temp = (Item[]) new Object[capacity];
      for (int i = 0; i < N; i++) {
          temp[i] = a[i];
      }
      a = temp;
    }
  
  public static void main(String[] args) { 
    RandomizedQueue<Integer> a = new RandomizedQueue<Integer>();
    for (int i = 0; i < 6; i++) {
      a.enqueue(i);
    }
    
    for (int t:a)
      StdOut.println(t);
    
    
  }
  
 
  
}
