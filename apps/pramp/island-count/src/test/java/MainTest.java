import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test that the Island Count getNumberOfIslands() method passes the test cases:
 *
 * 1) an null input (0),
 * 2) an empty input (0),
 * 3) a matrix of size > 1 with no 1's (0),
 * 4) a matrix of size > 1 with all 1's (1),
 * 5) a matrix of size 3 with alternating 0's and 1's (4)
 * 6) a matrix of size 4 with alternating 0's and 1's (2)
 * 7) the example matrix (6)
 * 8) a matrix of size 1 containing a 0 (0),
 * 9) a matrix of size 1 containing a 1 (1),
 * 10) a non-square metrix (1x4) containing 2 islands (2).
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    @Test public void test1() {
        // Test using null input.
        runTest(1, null, 0);
    }

    @Test public void test2() {
        // Test using empty input array.
        runTest(2, new int[][]{}, 0);
    }

    @Test public void test3() {
        // Test using a matrix of all 0's.
        runTest(3, new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, 0);
    }

    @Test public void test4() {
        // Test with a matrix of all 1's.
        runTest(4, new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 1);
    }

    @Test public void test5() {
        // Test a matrix of size 3 with alternating 0's and 1's.
        runTest(5, new int[][]{{0, 1, 0}, {1, 0, 1}, {0, 1, 0}}, 4);
    }

    @Test public void test6() {
        // Test a matrix of size 4 with alternating 0's and 1's.
        runTest(6, new int[][]{{0, 1, 0, 1}, {0, 1, 0, 1}, {0, 1, 0, 1}, {0, 1, 0, 1}}, 2);
    }

    @Test public void test7() {
        // Test the example.
        int[][] example = new int[][]{
            {0, 1, 0, 1, 0},
            {0, 0, 1, 1, 1},
            {1, 0, 0, 1, 0},
            {0, 1, 1, 0, 0},
            {1, 0, 1, 0, 1}
        };
        runTest(7, example, 6);
    }

    @Test public void test8() {
        // Test using a matrix with a single 0 cell.
        runTest(8, new int[][]{{0}}, 0);
    }

    @Test public void test9() {
        // Test using a matrix with a single 0 cell.
        runTest(9, new int[][]{{1}}, 1);
    }

    @Test public void test10() {
        // Test a non-square input array.
        runTest(10, new int[][]{{1, 0, 1, 0}, {0, 1, 1, 1}, {0, 0, 1, 0}}, 2);
    }

    // Private instance methods.

    private void runTest(final int testNum, final int[][] input, final int expected) {
        System.out.println("Test" + testNum);
        int actual = Main.getNumberOfIslands(input);
        assertEquals("The computed result is incorrect!", expected, actual);
    }
}
