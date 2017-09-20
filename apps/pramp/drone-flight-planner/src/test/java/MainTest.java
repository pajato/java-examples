import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the calcDroneMinEnergy() method.
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    @Test public void testMain() {
        new Main();
    }

    @Test public void test1() {
        runTest(1, new int[][]{{0, 1, 19}}, 0);
    }

    @Test public void test2() {
        runTest(2, new int[][]{{0, 2, 10}, {10, 10, 8}}, 0);
    }

    @Test public void test3() {
        runTest(3, new int[][]{{0, 2, 6}, {10, 10, 20}}, 14);
    }

    @Test public void test4() {
        runTest(4, new int[][]{{0, 2, 10}, {3, 4, 0}, {9, 20, 6}, {10, 12, 15}, {10, 10, 8}}, 5);
    }

    @Test public void test5() {
        runTest(5, new int[][]{{0, 2, 2}, {3, 5, 38}, {9, 20, 6}, {10, 12, 15}, {10, 10, 8}}, 36);
    }

    @Test public void test6() {
        runTest(6, new int[][]{
                {0, 2, 10}, {3, 5, 9}, {9, 20, 6}, {10, 12, 2}, {10, 10, 10}, {10, 10, 2}}, 0);
    }

    @Test public void test8() {
        runTest(8, null, 0);
    }

    @Test public void test9() {
        runTest(9, new int[][]{{1, 2}}, 0);
    }

    // Private instance methods.

    private void runTest(final int testNum, final int[][] input, final int expected) {
        System.out.println("Test" + testNum);
        int actual = Main.calcDroneMinEnergy(input);
        assertEquals("The result is wrong!", expected, actual);
    }
}
