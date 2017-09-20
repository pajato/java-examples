import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the pancakeSort() method.
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    // Input arrays.

    private int[] input1a = new int[]{11};
    private int[] input1b = new int[]{11};
    private int[] input2a = new int[]{1, 3, 5, 9};
    private int[] input2b = new int[]{2, 4, 6, 10};
    private int[] input3a = new int[]{1, 2, 3, 5, 6, 7};
    private int[] input3b = new int[]{3, 6, 7, 8, 20};
    private int[] input4a = new int[]{1, 2, 3, 5, 6, 7};
    private int[] input4b = new int[]{7, 8, 9, 10, 11, 12};
    private int[] input5a = new int[]{10, 20, 30, 40, 50, 60, 70, 80};
    private int[] input5b = new int[]{10, 20, 30, 40, 50, 60};
    private int[] input6a = new int[]{10, 20, 30, 40, 50, 60, 70};
    private int[] input6b = new int[]{10, 20, 30, 40, 50, 60, 70};
    private int[] input7a = null;
    private int[] input7b = null;
    private int[] input8a = new int[]{};
    private int[] input8b = new int[]{};
    private int[] input9a = new int[]{1};
    private int[] input9b = null;

    // Expected results..

    private int[] expected1 = new int[]{11};
    private int[] expected2 = new int[]{};
    private int[] expected3 = new int[]{3, 6, 7};
    private int[] expected4 = new int[]{7};
    private int[] expected5 = new int[]{10, 20, 30, 40, 50, 60};
    private int[] expected6 = new int[]{10, 20, 30, 40, 50, 60, 70};
    private int[] expected7 = new int[]{};
    private int[] expected8 = new int[]{};
    private int[] expected9 = new int[]{};

    @Test public void testMain() {
        new Main();
    }

    @Test public void test1() {
        runTest(1, input1a, input1b, expected1);
    }

    @Test public void test2() {
        runTest(2, input2a, input2b, expected2);
    }

    @Test public void test3() {
        runTest(3, input3a, input3b, expected3);
    }

    @Test public void test4() {
        runTest(4, input4a, input4b, expected4);
    }

    @Test public void test5() {
        runTest(5, input5a, input5b, expected5);
    }

    @Test public void test6() {
        runTest(6, input6a, input6b, expected6);
    }

    @Test public void test7() {
        runTest(8, input7a, input7b, expected7);
    }

    @Test public void test8() {
        runTest(8, input8a, input8b, expected8);
    }

    @Test public void test9() {
        runTest(9, input9a, input9b, expected9);
    }

    // Private instance methods.

    private void runTest(final int testNum, final int[] a, final int[] b, final int[] expected) {
        System.out.println("Test" + testNum);
        int[] actual = Main.findDuplicates(a, b);
        assertArrayEquals("The result is wrong!", expected, actual);
    }
}
