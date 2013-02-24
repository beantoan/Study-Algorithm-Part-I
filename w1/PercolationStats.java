public class PercolationStats {
  private double[] results;
  private double tmean = 0.0;
  private double tstddev = 0.0;
  //private Percolation p;
  
  // perform T independent computational experiments on an N-by-N grid
  public PercolationStats(int N, int T) {
    results = new double[T];
    int i, j, count;
    
    for (int n = 0; n < T; n++) {
      count = 0;
      Percolation p = new Percolation(N);
      while (!p.percolates()) {
        i = StdRandom.uniform(1, N+1);
        j = StdRandom.uniform(1, N+1);
        if (!p.isOpen(i, j)) {
          p.open(i, j);
          count++;
        }

      }
      results[n] = 1.0*count/N/N;
    }
  } 
  
  //sample mean of percolation threshold
  public double mean() {
    double sum = 0.0;
    for (int i = 0; i < results.length; i++) {
      sum += results[i];
    }
    tmean = sum/results.length;
    return tmean;
    }
  
  // sample standard deviation of percolation threshold
  public double stddev() {
    double sum = 0.0;
    for (int i = 0; i < results.length; i++) {
      sum += (results[i]-tmean) * (results[i]-tmean);
    }
    tstddev = Math.sqrt(sum/(results.length-1));
    return tstddev;
  }
  
  // returns lower bound of the 95% confidence interval
  public double confidenceLo() {
    return tmean - 1.96*tstddev/Math.sqrt(results.length);
  }
  
  // returns upper bound of the 95% confidence interval
  public double confidenceHi() {
    return tmean + 1.96*tstddev/Math.sqrt(results.length);
  }
  
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]); 
    int t = Integer.parseInt(args[1]); 

    PercolationStats ps = new PercolationStats(n, t);
    System.out.println("mean=    "+ ps.mean());
    System.out.println("stddev=   "+ ps.stddev());
    System.out.println("95% confidence interval "+ ps.confidenceLo() 
                                              + " , " + ps.confidenceHi());
    
  } 
}

