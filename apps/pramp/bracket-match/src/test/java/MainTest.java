import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the bracketMatch() method.
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    @Test public void testMain() {
        new Main();
    }

    @Test public void test1() {
        runTest(1, ")", 1);
    }

    @Test public void test2() {
        runTest(2, "(", 1);
    }

    @Test public void test3() {
        runTest(3, "(())", 0);
    }

    @Test public void test4() {
        runTest(4, "(()", 1);
    }

    @Test public void test5() {
        runTest(5, "())(", 2);
    }

    @Test public void test6() {
        runTest(6, "))))", 4);
    }

    @Test public void test7() {
        runTest(7, ")(", 2);
    }

    @Test public void test8() {
        runTest(8, "()()()()()", 0);
    }

    @Test public void test9() {
        runTest(9, null, -1);
    }

    @Test public void test10() {
        runTest(10, "", -1);
    }

    // Private instance methods.

    private void runTest(final int testNum, final String input, final int expected) {
        System.out.println("Test" + testNum);
        int actual = Main.bracketMatch(input);
        assertEquals("The result is wrong!", expected, actual);
    }
}
