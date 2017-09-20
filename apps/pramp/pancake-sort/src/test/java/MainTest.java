import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the pancakeSort() method.
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    // Input arrays.

    private int[] input1 = new int[]{1};
    private int[] input2 = new int[]{1, 2};
    private int[] input3 = new int[]{1, 3, 1};
    private int[] input4 = new int[]{3, 1, 2, 4, 6, 5};
    private int[] input5 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private int[] input6 = new int[]{10, 9, 8, 6, 7, 5, 4, 3, 2, 1, 9, 10, 8, 7, 6, 5, 4, 3, 2, 1,
                                     10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private int[] input7 = null;
    private int[] input8 = new int[]{};

    // Expected results..

    private int[] expected1 = new int[]{1};
    private int[] expected2 = new int[]{1, 2};
    private int[] expected3 = new int[]{1, 1, 3};
    private int[] expected4 = new int[]{1, 2, 3, 4, 5, 6};
    private int[] expected5 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int[] expected6 = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7,
                                        7, 8, 8, 8, 9, 9, 9, 10, 10, 10};
    private int[] expected7 = null;
    private int[] expected8 = new int[]{};

    @Test public void testMain() {
        new Main();
    }

    @Test public void test1() {
        runTest(1, input1, expected1);
    }

    @Test public void test2() {
        runTest(2, input2, expected2);
    }

    @Test public void test3() {
        runTest(3, input3, expected3);
    }

    @Test public void test4() {
        runTest(4, input4, expected4);
    }

    @Test public void test5() {
        runTest(5, input5, expected5);
    }

    @Test public void test6() {
        runTest(6, input6, expected6);
    }

    @Test public void test7() {
        runTest(8, input7, expected7);
    }

    @Test public void test8() {
        runTest(8, input8, expected8);
    }

    // Private instance methods.

    private void runTest(final int testNum, final int[] input, final int[] expected) {
        System.out.println("Test" + testNum);
        int[] actual = Main.pancakeSort(input);
        assertArrayEquals("The result is wrong!", expected, actual);
    }
}
