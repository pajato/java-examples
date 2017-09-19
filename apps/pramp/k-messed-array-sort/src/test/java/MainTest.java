import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the sortKMessedArray() method.
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    private int[] arr9 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    private int[] arr10 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int[] arr12 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};


    @Test public void testMain() {
        new Main();
    }

    @Test public void test1() {
        int[] input = new int[]{1};
        runTest(1, input, 0, input);
    }

    @Test public void test2() {
        runTest(2, new int[]{1, 0}, 1, new int[]{0, 1});
    }

    @Test public void test3() {
        runTest(3, new int[]{1, 0, 3, 2}, 1, new int[]{0, 1, 2, 3} );
    }

    @Test public void test4() {
        runTest(4, new int[]{1, 0, 3, 2, 4, 5, 7, 6, 8}, 1, arr9);
    }

    @Test public void test5() {
        runTest(5, new int[]{1, 4, 5, 2, 3, 7, 8, 6, 10, 9}, 2, arr10);
    }

    @Test public void test6() {
        runTest(6, new int[]{6, 1, 4, 11, 2, 0, 3, 7, 10, 5, 8, 9}, 5, arr12);
    }

    @Test public void test7() {
        runTest(7, null, 1, null);
    }

    @Test public void test8() {
        runTest(8, new int[]{}, 1, new int[]{});
    }

    @Test public void test9() {
        runTest(9, new int[]{3, 2, 1}, 0, new int[]{3, 2, 1});
    }

    // Private instance methods.

    private void runTest(final int testNum, final int[] input, final int k, final int[] expected) {
        System.out.println("Test" + testNum);
        int[] actual = Main.sortKMessedArray(input, k);
        assertArrayEquals("The result is wrong!", expected, actual);
    }
}
