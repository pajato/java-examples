import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test that the findArrayQuadruplet() method passes the given test cases.
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    @Test public void testMain() {
        new Main();
    }

    @Test public void test1() {
        runTest(1, new int[]{}, 12, new int[]{});
    }

    @Test public void test2() {
        runTest(2, new int[]{4, 4, 4}, 12, new int[]{});
    }

    @Test public void test3() {
        runTest(3, new int[]{4, 4, 4, 2}, 16, new int[]{});
    }

    @Test public void test4() {
        runTest(4, new int[]{4, 4, 4, 4}, 16, new int[]{4, 4, 4, 4});
    }

    @Test public void test5() {
        runTest(5, new int[]{2, 7, 4, 0, 9, 5, 1, 3}, 20, new int[]{0, 4, 7, 9});
    }

    @Test public void test6() {
        runTest(6, new int[]{2, 7, 4, 0, 9, 5, 1, 3}, 120, new int[]{});
    }

    @Test public void test7() {
        runTest(7, new int[]{1, 2, 3, 4, 5, 19, 12, 12, 19}, 40,
                new int[]{4, 5, 12, 19});
    }

    @Test public void test8() {
        runTest(8, null, 12, new int[]{});
    }

    @Test public void test9() {
        runTest(9, new int[]{1, 2, 3}, 6, new int[]{});
    }

    // Private instance methods.

    private void runTest(final int testNum, final int[] arr, final int s, final int[] expected) {
        System.out.println("Test" + testNum);
        int[] actual = Main.findArrayQuadruplet(arr, s);
        assertArrayEquals("The result is wrong!", expected, actual);
    }
}
