import java.util.*;

/**
 * Pramp: H-Tree Construction
 *
 * An H-tree is a geometric shape that consists of a repeating pattern resembles the letter “H”.
 *
 * It can be constructed by starting with a line segment of arbitrary length, drawing two segments
 * of the same length at right angles to the first through its endpoints, and continuing in the same
 * vein, reducing (dividing) the length of the line segments drawn at each stage by √2.
 *
 * The on-line () description contains three examples of H-trees at different levels of depth: (1,
 * 2, 3)
 *
 * Write a function drawHTree that constructs an H-tree, given its center (x and y coordinates), a
 * starting length, and depth. Assume that the starting line is parallel to the X-axis.
 *
 * Use the function drawLine provided to implement your algorithm. In a production code, a drawLine
 * function would render a real line between two points. However, this is not a real production
 * environment, so to make things easier, implement drawLine such that it simply prints its
 * arguments (the print format is left to your discretion).
 *
 * Analyze the time and space complexity of your algorithm. In your analysis, assume that drawLine's
 * time and space complexities are constant, i.e. O(1). * In a Binary Search Tree (BST), an Inorder
 * Successor of a node is defined as the node with the
 */
class Main {

    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        @Override public String toString() {
            return String.format(Locale.US, "(%s, %s)", x, y);
        }

    }

    static class Line {
        Point start, end;
        double length;
        Line(Point start, Point end) {
            this.start = start;
            this.end = end;
            double xLength = Math.abs(start.x - end.x);
            double yLength = Math.abs(start.y - end.y);
            length = xLength == 0 ? yLength : xLength;
        }
    }

    static class H {
        Point[] centers;
        double length;
        H(Point[] centers, double length) {
            this.centers = centers;
            this.length = length;
        }

    }

    static public void main( String args[] ) {
        System.out.println( "Practice makes Perfect!" );
    }

    /** A cache that collects drawn lines. */
    private static List<Line> lineList = new ArrayList<>();

    /** A cache that collects the lengths and centers for each depth. */
    private static Map<Integer, H> hMap = new HashMap<>();

    // Public instance methods.

    /** Return the map representation of the last H-Tree constructed. */
    static Map<Integer, H> getHTree() {
        return hMap;
    }

    /** Return the collection of lines drawn for the most recent H-Tree. */
    static List<Line> getLines() {
        return lineList;
    }

    /** Draw an H-Tree at the given point with the given length and depth. */
    static void drawHTree(final Point center, double length, int depth) {
        // Handle the special cases.
        hMap.clear();
        lineList.clear();
        if (center == null || length <= 0 || depth <= 0)
            return;

        // Deal with the normal cases.
        int d = 1;
        Point[] centers = new Point[]{center};
        do {
            if (d > 1) {
                length /= Math.sqrt(2);
                centers = getCenters(centers, length);
            }
            hMap.put(d, new H(centers, length));
            drawHTrees(d++);
        } while (d <= depth);
    }

    private static void drawHTrees(final int depth) {
        // Draw n H-Trees of the given length centered at the given point.
        // center for each tree in terms of 'center' and n.
        Point[] arr = hMap.get(depth).centers;
        double length = hMap.get(depth).length;
        for (Point p : arr) {
            drawTree(p, length);
        }
    }

    /** Draw a single H-Tree at the given center with the given length. */
    private static void drawTree(final Point center, final double length) {
        // Draw the right leg, left leg and middle connector.
        double l = length / 2.0;
        drawLine(new Point(center.x + l, center.y + l), new Point(center.x + l, center.y - l));
        drawLine(new Point(center.x - l, center.y + l), new Point(center.x - l, center.y - l));
        drawLine(new Point(center.x - l, center.y), new Point(center.x + l, center.y));
    }

    /** Return an array of center points for the next depth using the given length. */
    private static Point[] getCenters(final Point[] centers, final double length) {
        // For each existing center, create four more at the points of the current H.
        Point[] result = new Point[4 * centers.length];
        int index = 0;
        double l = length / 2;
        for (Point p : centers) {
            result[index++] = new Point(p.x - l, p.y + l);
            result[index++] = new Point(p.x + 1, p.y + l);
            result[index++] = new Point(p.x + l, p.y - l);
            result[index++] = new Point(p.x - l, p.y - l);
        }
        return result;
    }

    /** Simulate drawing a line between two given points. */
    private static void drawLine(final Point start, final Point end) {
        Line l = new Line(start, end);
        final String format = "Drawing a line of length {%s} from %s to %s.";
        System.out.println(String.format(Locale.US, format, l.length, l.start, l.end));
        lineList.add(l);
    }
}
