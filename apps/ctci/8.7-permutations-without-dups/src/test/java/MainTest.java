import org.junit.Test;

/**
 * Test generating the permutations of a string with no duplicate characters.
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
        runTest(1, null);
    }

    @Test public void test2() {
        runTest(2, "");
    }

    @Test public void test3() {
        runTest(3, "ab");
    }

    @Test public void test4() {
        runTest(4, "abc");
    }

    @Test public void test5() {
        runTest(5, "abcd");
    }

    @Test public void test6() {
        runTest(6, "abcde");
    }

    // Private instance methods.

    /** Run a test with a given test number and input string. */
    private void runTest(final int testNum, final String input) {
        System.out.println("Running test number " + testNum);
        Main.printPermutations(input);
    }
}
