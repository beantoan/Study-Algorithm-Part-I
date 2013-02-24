public class Percolation {
  private int[] elements;
  private int gridNo;
  private WeightedQuickUnionUF wq;
  
  // create N-by-N grid, with all sites blocked
  public Percolation(int N) {
    wq = new WeightedQuickUnionUF(N*N);
    gridNo = N;
       
    elements = new int[N*N];
    for (int i = 0; i < N*N; i++)
      elements[i] = 0;
  }
  
  // open site (row i, column j) if it is not already
  public void open(int i, int j) {
    //validate i,j
    if (i <= 0 || i > gridNo) 
      throw new IndexOutOfBoundsException("row i index out of range.");
    if (j <= 0 || j > gridNo) 
      throw new IndexOutOfBoundsException("row i index out of range.");
    //mark as open
    int x = xyTo1D(i, j);
    elements[x] = 1;
    //perform links
    if (validate(i, j-1) && isOpen(i, j-1)) {
      wq.union(x, xyTo1D(i, j-1));
    }
    if (validate(i-1, j) && isOpen(i-1, j)) {
      wq.union(x, xyTo1D(i-1, j));
    }
    if (validate(i, j+1) && isOpen(i, j+1)) {
      wq.union(x, xyTo1D(i, j+1));
    }
    if (validate(i+1, j) && isOpen(i+1, j)) {
      wq.union(x, xyTo1D(i+1, j));
    }  
  }
  
  // is site (row i, column j) open?
  public boolean isOpen(int i, int j) {
    if (i <= 0 || i > gridNo) 
      throw new IndexOutOfBoundsException("row i index out of range.");
    if (j <= 0 || j > gridNo) 
      throw new IndexOutOfBoundsException("row i index out of range.");
    return elements[xyTo1D(i, j)] == 1;
  }   
  
  // is site (row i, column j) full?
  public boolean isFull(int i, int j) {
    if (i <= 0 || i > gridNo) 
      throw new IndexOutOfBoundsException("row i index out of range.");
    if (j <= 0 || j > gridNo) 
      throw new IndexOutOfBoundsException("row j index out of range.");
    
    for (int n = 1; n <= gridNo; n++) {
      if (isOpen(1, n) && wq.connected(xyTo1D(1, n), xyTo1D(i, j))) {
        return true;
      }
    }
    return false;
  }   
  
  // does the system percolate?
  public boolean percolates() {
    for (int n = 1; n <= gridNo; n++) {
      if (isFull(gridNo, n))
        return true;
     }
    return false;
  }            
  
  //convert (i,j) to x
  private int xyTo1D(int i, int j)
  {
     return (i-1)* gridNo + (j-1);
  }
  
  //validate (i,j)
  private boolean validate(int i, int j) {
    return !((i <= 0 || i > gridNo) || (j <= 0 || j > gridNo));   
  }
}
