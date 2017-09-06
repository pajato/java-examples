import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * @author Paul Michael Reilly
 */
public class MainTest {

    /** Ensure that the default constructor is exercised for maximum code coverage. */
    @Test public void testMain() {
        new Main();
    }

    @Test public void test1() {
        runTest(1, new int[][]{{1}}, new int[]{1});
    }

    @Test public void test2() {
        runTest(2, new int[][]{{1}, {2}}, new int[]{1, 2});
    }

    @Test public void test3() {
        runTest(3, new int[][]{{1, 2}}, new int[]{1, 2});
    }

    @Test public void test4() {
        runTest(4, new int[][]{{1, 2}, {3, 4}}, new int[]{1, 2, 4, 3});
    }

    @Test public void test5() {
        runTest(5, new int[][]{{1,2,3,4,5},{6,7,8,9,10}}, new int[]{1,2,3,4,5,10,9,8,7,6});
    }

    @Test public void test6() {
        runTest(6, new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}},
                new int[]{1,2,3,4,5,10,15,20,19,18,17,16,11,6,7,8,9,14,13,12});
    }

    // Private instance methods.

    private void runTest(final int num, final int[][] arr, final int[] expected) {
        System.out.println("Test" + num);
        int[] actual = Main.spiralCopy(arr);
        System.out.println("Output: " + Arrays.toString(actual));
        assertEquals("The output size is wrong!", expected.length, actual.length);
        String format = "The computed result is wrong at index: %s!";
        for (int i = 0; i < expected.length; i++)
            assertEquals(String.format(Locale.US, format, i), expected[i], actual[i]);
    }
}
