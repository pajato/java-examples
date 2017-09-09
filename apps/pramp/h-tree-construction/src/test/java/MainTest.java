import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Paul Michael Reilly
 */
public class MainTest {

    // Private class variables.

    /** The main test point. */
    private static Main.Point p = new Main.Point(10.0, 10.0);

    /** Ensure that the default constructor is exercised for maximum code coverage. */
    @Test public void testMain() {
        new Main();
    }

    @Test public void testMainMethod() {
        Main.main(null);
    }

    @Test public void test1() {
        // Deal with invalid depth input.
        runTest(1, p, 1.0, 0, 0, 0);
    }

    @Test public void test2() {
        // Deal with an invalid center point.
        runTest(2, null, 1.0, 1, 0, 0);
    }

    @Test public void test3() {
        // Deal with an invalid length.
        runTest(3, p, 0.0, 1, 0, 0);
    }

    @Test public void test4() {
        // Deal with a valid H-Tree of depth 1.
        runTest(4, p, 1.0, 1, 1, 3);
    }

    @Test public void test5() {
        // Deal with a valid H-Tree of depth 2.
        runTest(5, p, 1.0, 2, 5, 15);
    }

    @Test public void test6() {
        // Deal with a valid H-Tree of depth 3.
        runTest(6, p, 1.0, 3, 21, 63);
    }

    @Test public void test7() {
        runTest(7, p, 1.0, 4, 85, 255);
    }

    // Private instance methods.

    private void runTest(final int num, final Main.Point p, final double length, final int depth,
                         final int expectedTreeCount, final int expectedLineCount) {
        System.out.println("Test" + num);
        Main.drawHTree(p, length, depth);
        int actualTreeCount = getTreeCount();
        int actualLineCount = Main.getLines().size();
        assertEquals("The number of trees is wrong!", expectedTreeCount, actualTreeCount);
        assertEquals("The number of lines is wrong", expectedLineCount, actualLineCount);
    }

    /** Return the number of trees drawn. */
    private int getTreeCount() {
        Map<Integer, Main.H> map = Main.getHTree();
        int count = 0;
        for (Main.H tree : map.values())
            count += tree.centers != null ? tree.centers.length : 0;
        return count;
    }
}
