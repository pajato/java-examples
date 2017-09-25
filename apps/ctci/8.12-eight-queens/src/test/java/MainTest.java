import org.junit.Test;
import org.junit.Assert;

import java.util.List;

/**
 * Test the getSolutions() method.
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    /** Boiler-plate test for code-coverage only. */
    @Test public void testMain() {
        new Main();
    }

    /** Main tests for the next() method. */
    @Test public void test1() {
        runTest(1, 0, 0);
    }

    @Test public void test2() {
        runTest(2, 1, 1);
    }

    @Test public void test3() {
        runTest(3, 2, 0);
    }

    @Test public void test4() {
        runTest(4, 3, 0);
    }

    @Test public void test5() {
        runTest(5, 4, 2);
    }

    @Test public void test6() {
        runTest(6, 5, 10);
    }

    @Test public void test7() {
        runTest(7, 6, 4);
    }

    @Test public void test8() {
        runTest(8, 7, 40);
    }

    @Test public void test9() {
        runTest(9, 8, 92);
    }

    @Test public void test10() {
        runTest(10, 9, 352);
    }

    @Test public void test11() {
        runTest(11, 10, 724);
    }

    // Private instance methods.

    /** Run a test with a given test number and input string. */
    private void runTest(final int testNum, final int n, final int expected) {
        System.out.println("Running test number " + testNum);
        List<String> actual = Main.getSolutions(n);
        Assert.assertEquals("The number of solutions is wrong!", expected, actual.size());
    }
}
