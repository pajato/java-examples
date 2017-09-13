import org.junit.Test;

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

    @Test public void test1() {
        runTest(1, new double[]{2.0, 4.0}, 3.0, 1.5);
    }

    @Test public void test2() {
        runTest(2, new double[]{2.0, 4.0, 6.0}, 3.0, 1.0);
    }

    @Test public void test3() {
        runTest(3, new double[]{2.0, 100.0, 50.0, 120.0, 167.0}, 400.0, 128.0);
    }

    @Test public void test4() {
        runTest(4, new double[]{2.0, 100.0, 50.0, 120.0, 1000.0}, 190.0, 47.0);
    }

    @Test public void test5() {
        runTest(5, new double[]{21.0, 100.0, 50.0, 120.0, 130.0, 110.0}, 140.0, 23.8);
    }

    @Test public void test6() {
        runTest(6, new double[]{210.0, 200.0, 150.0, 193.0, 130.0, 110.0, 209.0, 342.0, 117.0},
                1530.0, 211.0);
    }

    @Test public void testNullInput() {
        runTest(7, null, 1.0, 0.0);
    }

    @Test public void testEmtpyInput() {
        runTest(8, new double[]{0.0}, 0.0, 0.0);
    }

    // Private instance methods.

    private void runTest(final int num, final double[] input, final double budget,
                         final double expected) {
        System.out.println("Test" + num);
        double actual = Main.findGrantsCap(input, budget);
        assertEquals("The cap is not within tolerance!", expected, actual, 0.00001);
    }
}
