import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the getDifferentNumber() method.
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    private int[] input1 = new int[]{0};
    private int[] input2 = new int[]{0, 1, 2};
    private int[] input3 = new int[]{1, 3, 0, 2};
    private int[] input4 = new int[]{100000};
    private int[] input5 = new int[]{1, 0, 3, 4, 5};
    private int[] input6 = new int[]{0, 100000};
    private int[] input7 = new int[]{0, 99999, 100000};
    private int[] input8 = null;
    private int[] input9 = new int[]{};

    @Test public void testMain() {
        new Main();
    }

    @Test public void test1() {
        runTest(1, input1, 1);
    }

    @Test public void test2() {
        runTest(2, input2, 3);
    }

    @Test public void test3() {
        runTest(3, input3, 4);
    }

    @Test public void test4() {
        runTest(4, input4, 0);
    }

    @Test public void test5() {
        runTest(5, input5, 2);
    }

    @Test public void test6() {
        runTest(6, input6, 1);
    }

    @Test public void test7() {
        runTest(7, input7, 1);
    }

    @Test public void test8() {
        runTest(8, input8, 0);
    }

    @Test public void test9() {
        runTest(9, input9, 0);
    }

    // Private instance methods.

    private void runTest(final int testNum, final int[] input, final int expected) {
        System.out.println("Test" + testNum);
        int actual = Main.getDifferentNumber(input);
        assertEquals("The result is wrong!", expected, actual);
    }
}
