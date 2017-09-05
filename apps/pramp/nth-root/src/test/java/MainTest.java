import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertTrue;

/**
 * Test that the nth root() method passes the test cases:
 *
 * 1) the one'th root of -1.0 throws an illegal argument exception.
 * 2) the zeroth root of 1.0 throws an illegal argument exception.
 * 3) the negative one'th root of 0.5 throws an illegal argument exception.
 * 4) the twelfth root of 0.0 is 0.0;
 * 5) the sixth root of 1.0 is 0.0;
 * 6) the one'th root of 16.4 is 16.4
 * 7) the square root of 25.0 is 5.0
 * 8) the 16th root of 1548.742 is 1.582609
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    private double[] results = new double[3];
    private int[] iterations = new int[3];

    @Test public void testMain() {
        new Main();
    }

    @Test public void test1() {
        // Test for an illegal argument exception due to a negative value.
        runTest(1, -1.0, 1, -1.0);
    }

    @Test public void test2() {
        // Test for an illegal argument exception due to a zero root.
        runTest(2, 1.0, 0, -1.0);
    }

    @Test public void test3() {
        // Test for an illegal argument exception due to a negative root.
        runTest(3, 1.0, -1, -1.0);
    }

    @Test public void test4() {
        // Test that the twelfth root of 0.0 is 0.0.
        runTest(4, 0.0, 12, 0.0);
    }

    @Test public void test5() {
        // Test that the sixth root of 1.0 is 0.0.
        runTest(5, 1.0, 6, 0.0);
    }

    @Test public void test6() {
        // Test that the one'th root of 16.4 is 16.4
        runTest(6, 16.4, 1, 16.4);
    }

    @Test public void test7() {
        // Test that the square root of 25.0 is 5.0.
        runTest(7, 25.0, 2, 5.0);
    }

    @Test public void test8() {
        // Test that the sixteenth root of 1548.742 is 1.582609?
        runTest(8, 1548.742, 16, 1.582609);
    }

    @Test public void test9() {
        // Test that the square root of 4 is 2.
        runTest(9, 4.0, 2, 2.0);
    }

    @Test public void test10() {
        // Test that the cube root of 27 is 3.
        runTest(10, 27.0, 3, 3.0);
    }

    @Test public void test11() {
        // Test that the square root of 3 is 1.732
        runTest(11, 3.0, 2, 1.7320);
    }

    @Test public void test12() {
        // Test that the cube root of 10 is 2.153
        runTest(12, 10.0, 3, 2.154435);
    }

    @Test public void test13() {
        // Test that the cube root of 160 is 5.429
        runTest(13, 160.0, 3, 5.429);
    }

    // Private instance methods.

    private void runTest(final int num, final double A, final int n, final double expected) {
        System.out.println("Test" + num);
        results = new double[3];
        iterations = new int[3];
        nr(A, n, expected);
        log(A, n, expected);
        bs(A, n, expected);

        // Compare the results;
        String[] titles = new String[]{"Antilog", "Newton Raphson", "Binary Search"};
        for (int i = 0; i < titles.length; i++) {
            String format = "%sth root of %f; Method: %s; error: %f%%; iterations: %s.";
            int count = iterations[i];
            double accuracy = Math.abs(results[i] - expected);
            System.out.println(String.format(Locale.US, format, n, A, titles[i], accuracy, count));
        }
    }

    private void log(final double A, final int n, final double expected) {
        double actual;
        try {
            actual = Main.rootByAntilog(A, n);
            assertTrue("An expected exception was not taken!", expected != -1.0);
            String format = "The %d'th root of {%f} is wrong; expected {%f}, actual {%f}";
            String errorMessage = String.format(Locale.US, format, n, A, expected, actual);
            assertTrue(errorMessage, Math.abs(expected - actual) <= Main.EPSILON);
            results[0] = actual;
            iterations[0] = Main.getIterations();
        } catch (IllegalArgumentException exc) {
            assertTrue("An unexpected exception was taken!", expected == -1.0);
        }
    }

    private void nr(final double A, final int n, final double expected) {
        double actual;
        try {
            actual = Main.rootByNewtonRaphson(A, n);
            assertTrue("An expected exception was not taken!", expected != -1.0);
            String format = "The %d'th root of {%f} is wrong; expected {%f}, actual {%f}";
            String errorMessage = String.format(Locale.US, format, n, A, expected, actual);
            assertTrue(errorMessage, Math.abs(expected - actual) <= Main.EPSILON);
            results[1] = actual;
            iterations[1] = Main.getIterations();
        } catch (IllegalArgumentException exc) {
            assertTrue("An unexpected exception was taken!", expected == -1.0);
        }
    }

    private void bs(final double A, final int n, final double expected) {
        double actual;
        try {
            actual = Main.rootByBinarySearch(A, n);
            assertTrue("An expected exception was not taken!", expected != -1.0);
            String format = "The %d'th root of {%f} is wrong; expected {%f}, actual {%f}";
            String errorMessage = String.format(Locale.US, format, n, A, expected, actual);
            assertTrue(errorMessage, Math.abs(expected - actual) <= Main.EPSILON);
            results[2] = actual;
            iterations[2] = Main.getIterations();
        } catch (IllegalArgumentException exc) {
            assertTrue("An unexpected exception was taken!", expected == -1.0);
        }
    }
}
