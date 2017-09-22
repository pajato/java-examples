import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the getIndicesOfItemWeights() method.
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    // Input arrays.

    private int[] input1 = new int[]{9};
    private int[] input2 = new int[]{4, 4};
    private int[] input3 = new int[]{4, 4, 1};
    private int[] input4 = new int[]{4, 6, 10, 15, 16};
    private int[] input5 = new int[]{4, 6, 10, 15, 16};
    private int[] input6 = new int[]{12, 6, 7, 14, 19, 3, 0, 25, 40};
    private int[] input7 = null;
    private int[] input8 = new int[]{};
    private int[] input9 = new int[]{1, 2, 3, 4};

    // Expected output.

    private int[] expected1 = new int[]{};
    private int[] expected2 = new int[]{1, 0};
    private int[] expected3 = new int[]{2, 1};
    private int[] expected4 = new int[]{3, 1};
    private int[] expected5 = new int[]{4, 0};
    private int[] expected6 = new int[]{6, 2};
    private int[] expected7 = new int[]{};
    private int[] expected8 = new int[]{};
    private int[] expected9 = new int[]{};

    @Test public void testMain() {
        new Main();
    }

    @Test public void test1() {
        runTest(1, input1, 9, expected1);
    }

    @Test public void test2() {
        runTest(2, input2, 8, expected2);
    }

    @Test public void test3() {
        runTest(3, input3, 5, expected3);
    }

    @Test public void test4() {
        runTest(4, input4, 21, expected4);
    }

    @Test public void test5() {
        runTest(5, input5, 20, expected5);
    }

    @Test public void test6() {
        runTest(6, input6, 7, expected6);
    }

    @Test public void test7() {
        runTest(7, input7, 0, expected7);
    }

    @Test public void test8() {
        runTest(8, input8, 0, expected8);
    }

    @Test public void test9() {
        runTest(9, input9, 23, expected9);
    }

    // Private instance methods.

    private void runTest(final int testNum, final int[] input, final int limit, final int[] expected) {
        System.out.println("Test" + testNum);
        int[] actual = Main.getIndicesOfItemWeights(input, limit);
        assertArrayEquals("The result is wrong!", expected, actual);
    }
}
