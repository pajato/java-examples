import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the pancakeSort() method.
 *
 * @author Paul Michael Reilly
 */
public class MainTest {


    @Test public void testMain() {
        new Main();
    }

    @Test public void test1() {
        runTest(1, "dnotq", "crime");
    }

    @Test public void test2() {
        runTest(2, "flgxswdliefy", "encyclopedia");
    }

    @Test public void test3() {
        runTest(3, "rajsb", "qqqqq");
    }

    @Test public void test4() {
        runTest(4, "bvqmjhgghjmqvbiqzjugthwmdv", "abcdefghijklmnopqrstuvwxyz");
    }

    @Test public void test5() {
        runTest(5, "eobamwpnlmhklrq", "drugtrafficking");
    }

    @Test public void test6() {
        runTest(6, "", "");
    }

    @Test public void test7() {
        runTest(7, null, null);
    }

    // Private instance methods.

    private void runTest(final int testNum, final String input, final String expected) {
        System.out.println("Test" + testNum);
        String actual = Main.decrypt(input);
        assertEquals("The result is wrong!", expected, actual);
    }
}
