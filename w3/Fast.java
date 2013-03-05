import java.util.Arrays;

public class Fast {

    public static void main(String[] args) {
//        StdDraw.setXscale(0, 32768);
//        StdDraw.setYscale(0, 32768);
//        StdDraw.setPenColor(StdDraw.RED);
//        
//        StdDraw.show(0);

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
            //points[i].draw();
        }
        //Arrays.sort(points);
//        for (int i=0;i<N;i++){
//        	Point[] pc = new Point[N];
//        	for (int m =0;m<N;m++){
//        		pc[m] = points[m];
//        	}
//        	Arrays.sort(pc,pc[i].SLOPE_ORDER);
//
//    		StdOut.print(points[i]+" : ");
//        	for(int j=1;j<N;j++){
//        		StdOut.print(points[j]);
//        		StdOut.print(points[i].slopeTo(points[j]));
//        	}
//        	StdOut.println("--------");
//        }
//        for (int i = 0; i < N - 4; i++) {
//            Arrays.sort(points, points[i].SLOPE_ORDER);
//            for (int m =0; m< N-4;m++){
//            double a = points[m].slopeTo(points[1]);
//            double b = points[m].slopeTo(points[2]);
//            double c = points[m].slopeTo(points[3]);
//            if (a == b && a == c) {
//                StdOut.print(points[0]);
//                StdOut.print(" -> ");
//                StdOut.print(points[1]);
//                StdOut.print(" -> ");
//                StdOut.print(points[2]);
//                StdOut.print(" -> ");
//                StdOut.print(points[3]);
//                int end = 3;
//                for (int j = 4; j < N; j++) {
//                    if (points[j].slopeTo(points[0]) == a) {
//                        StdOut.print(" -> ");
//                        StdOut.print(points[j]);
//                        end = j;
//                    }
//                }
//                points[0].drawTo(points[end]);
//            }
//            }
//            StdOut.println();
//        }
//        StdDraw.show(0);
    }
}
