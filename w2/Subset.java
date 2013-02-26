
public class Subset {
  
  
  public static void main(String[] args) { 
    RandomizedQueue<String> rq = new RandomizedQueue<String>();

    while (!StdIn.isEmpty()) {
      rq.enqueue(StdIn.readString());
    }
    
    int k = Integer.parseInt(args[0]);
    int i = 0;
    for (String m:rq) {
      
      if (m != null && i < k) {
        StdOut.println(m);
        i++;
      }
    }
    
  }
  

  
}
