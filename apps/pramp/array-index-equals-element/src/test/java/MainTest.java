import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Paul Michael Reilly
 */
public class MainTest {

    // Private class variables.

    // Public test methods.

    /** Ensure that the default constructor is exercised for maximum code coverage. */
    @Test public void testMain() {
        new Main();
    }

    @Test public void testMainMethod() {
        Main.main(null);
    }

    @Test public void test1() {
        runTest(1, new int[]{0}, 0);
    }

    @Test public void test2() {
        runTest(2, new int[]{0,3}, 0);
    }

    @Test public void test3() {
        runTest(3, new int[]{-8,0,1,3,5}, 3);
    }

    @Test public void test4() {
        runTest(4, new int[]{-5,0,2,3,10,29}, 2);
    }

    @Test public void test5() {
        runTest(5, new int[]{-5,0,3,4,10,18,27}, -1);
    }

    @Test public void test6() {
        runTest(6, new int[]{-6,-5,-4,-1,1,3,5,7}, 7);
    }

    // Private instance methods.

    private void runTest(final int num, final int[] input, final int expected) {
        System.out.println("Test" + num);
        int actual = Main.indexEqualsValueSearch(input);
        assertEquals("The computed value is wrong!", expected, actual);
    }
}
