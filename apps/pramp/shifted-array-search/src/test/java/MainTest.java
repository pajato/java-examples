import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test that the shiftedArraySearch() method passes the test cases:
 *
 * 1) a null array throws an illegal argument exception.
 * 2) the result for [2], 2 is 0,
 * 3) the result for [1, 2], 2 is 1,
 * 4) the result for [0, 1, 2, 3, 4, 5], 1 is 1,
 * 5) the result for [1, 2, 3, 4, 5, 0], 0 is 5,
 * 6) the result for [9, 12, 17, 2, 4, 5], 17 is 2,
 * 7) the result for [9, 12, 17, 2, 4, 5, 6], 4 is 4
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    @Test public void testMain() {
        new Main();
    }

    @Test public void test1() {
        runTest(1, null, 0, -1);
    }

    @Test public void test2() {
        runTest(2, new int[]{2}, 2, 0);
    }

    @Test public void test3() {
        runTest(3, new int[]{1, 2}, 2, 1);
    }

    @Test public void test4() {
        runTest(4, new int[]{0, 1, 2, 3, 4, 5}, 1, 1);
    }

    @Test public void test5() {
        runTest(5, new int[]{1, 2, 3, 4, 5, 0}, 0, 5);
    }

    @Test public void test6() {
        runTest(6, new int[]{9, 12, 17, 2, 4, 5}, 17, 2);
    }

    @Test public void test7() {
        runTest(7, new int[]{9, 12, 17, 2, 4, 5, 6}, 4, 4);
    }

    // Private instance methods.

    private void runTest(final int testNum, final int[] arr, final int num, final int expected) {
        System.out.println("Test" + testNum);
        int actual;
        try {
            actual = Main.shiftedArrSearch(arr, num);
            assertFalse("Expected an exception to occur!", expected < 0);
            assertEquals("The result is wrong!", expected, actual);
        } catch (IllegalArgumentException exc) {
            assertTrue("Did not expect an exception to occur!", expected < 0);
        }
    }
}
