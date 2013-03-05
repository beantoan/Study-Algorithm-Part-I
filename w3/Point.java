/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Arrays;
import java.util.Comparator;

public class Point implements Comparable<Point> {


    public final Comparator<Point> SLOPE_ORDER = new SlopeOrder();

    private class SlopeOrder implements Comparator<Point> {
        // private Point zero = new Point(0, 0);

        public int compare(Point p1, Point p2) {
            double a = slopeTo(p1);
            double b = slopeTo(p2);
            return Double.compare(a, b);
        }
    }

    private final int x; // x coordinate
    private final int y; // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        if (this.y == that.y && this.x != that.x)
            return 0;
        if (this.x == that.x && this.y != that.y)
            return Double.POSITIVE_INFINITY;
        if (this.x == that.x && this.y == that.y)
            return Double.NEGATIVE_INFINITY;
        return (that.y - this.y) * 1.0 / (that.x - this.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        if (this.y != that.y)
            return Double.compare(this.y, that.y);
        else
            return Double.compare(this.x, that.x);
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {

        Point[] p = new Point[4];
        p[0] = new Point(1, 0);
        p[1] = new Point(1, 3);
        p[2] = new Point(0, 3);
        p[3] = new Point(0, 0);

        StdOut.println(new Point(1234, 5678).slopeTo(new Point(1600, 1000)));

        Arrays.sort(p, p[2].SLOPE_ORDER);

        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i]);
        }
        System.out.println();
        Arrays.sort(p);

        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i]);
        }

    }

}
