import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Paul Michael Reilly
 */
public class MainTest {

    @Test public void testMain() {
        new Main();
    }

    @Test public void test1() {
        runTest(1, new char[]{'A'}, "", "");
    }

    @Test public void test2() {
        runTest(2, new char[]{'A'}, "B", "");
    }

    @Test public void test3() {
        runTest(3, new char[]{'A'}, "A", "A");
    }

    @Test public void test4() {
        runTest(4, new char[]{'A', 'B', 'C'}, "ADOBECODEBANCDDD", "BANC");
    }

    @Test public void test5() {
        runTest(5, new char[]{'A', 'B', 'C', 'E', 'K', 'I'}, "KADOBECODEBANCDDDEI", "KADOBECODEBANCDDDEI");
    }

    @Test public void test6() {
        runTest(6, new char[]{'x', 'y', 'z'}, "xyyzyzyx", "zyx");
    }

    @Test public void test7() {
        runTest(7, new char[]{'x', 'y', 'z', 'r'}, "xyyzyzyx", "");
    }

    // Private instance methods.

    private void runTest(final int num, final char[] arr, final String str, final String expected) {
        System.out.println("Test" + num);
        String actual = Main.getShortestUniqueSubstring(arr, str);
        assertEquals("The computed result is incorrect!", expected, actual);
    }
}
