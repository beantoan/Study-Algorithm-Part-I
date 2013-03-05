import java.util.Arrays;

public class Brute {
    public static void main(String[] args) {
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);

        // read in the input
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();

        // inits point array
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
            points[i].draw();
        }
        // for (int i=0;i<N;i++){
        // StdOut.println(points[i]);
        // }
        // StdOut.println();
        Arrays.sort(points);
        //
        // for (int i=0;i<N;i++){
        // StdOut.println(points[i]);
        // }

        for (int p = 0; p < N - 3; p++)
            for (int q = p + 1; q < N - 2; q++)
                for (int r = q + 1; r < N - 1; r++)
                    for (int s = r + 1; s < N; s++) {
                        double pq = points[p].slopeTo(points[q]);
                        double pr = points[p].slopeTo(points[r]);
                        double ps = points[p].slopeTo(points[s]);
                        if (pq == pr && pq == ps) {
                            StdOut.print(points[p]);
                            StdOut.print(" -> ");
                            StdOut.print(points[q]);
                            StdOut.print(" -> ");
                            StdOut.print(points[r]);
                            StdOut.print(" -> ");
                            StdOut.print(points[s]);
                            StdOut.println();
                            points[p].drawTo(points[s]);
                        }
                    }

        // display to screen all at once
        StdDraw.show(0);

    }

}
