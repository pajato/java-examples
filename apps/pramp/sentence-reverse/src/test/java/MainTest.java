import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

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
        runTest(1, new char[]{' ', ' '}, new char[]{' ', ' '});
    }

    @Test public void test2() {
        runTest(2, new char[]{'a', ' ', ' ', 'b'}, new char[]{'b', ' ', ' ', 'a'});
    }

    @Test public void test3() {
        runTest(3, new char[]{'h', 'e', 'l', 'l', 'o'}, new char[]{'h', 'e', 'l', 'l', 'o'});
    }

    @Test public void test4() {
        char[] input = new char[]{
            'p','e','r','f','e','c','t',' ','m','a','k','e','s',' ','p','r','a','c','t','i','c','e'
        };
        char[] expected = new char[]{
            'p','r','a','c','t','i','c','e',' ','m','a','k','e','s',' ','p','e','r','f','e','c','t'
        };
        runTest(4, input, expected);
    }

    @Test public void test5() {
        char[] input = new char[]{
            'y','o','u',' ','w','i','t','h',' ','b','e',' ','f','o','r','c','e',' ','t','h','e',' ',
            'm','a','y'
        };
        char [] expected = new char[]{
            'm','a','y',' ','t','h','e',' ','f','o','r','c','e',' ','b','e',' ','w','i','t','h',' ',
            'y','o','u'
        };
        runTest(5, input, expected);
    }

    @Test public void test6() {
        char[] input = new char[]{
            'g','r','e','a','t','e','s','t',' ','n','a','m','e',' ','f','i','r','s','t',' ',
            'e','v','e','r',' ','n','a','m','e',' ','l','a','s','t'
        };
        char[] expected = new char[] {
            'l','a','s','t',' ','n','a','m','e',' ','e','v','e','r',' ','f','i','r','s','t',' ',
            'n','a','m','e',' ','g','r','e','a','t','e','s','t'
        };
        runTest(6, input, expected);
    }

    @Test public void testNullInput() {
        runTest(7, null, null);
    }

    @Test public void testEmtpyInput() {
        runTest(8, new char[]{}, new char[]{});
    }

    // Private instance methods.

    private void runTest(final int num, final char[] input, final char[] expected) {
        System.out.println("Test" + num);
        char[] actual = Main.reverseWords(input);
        assertArrayEquals("The reversed sentences is not correct!", expected, actual);
    }
}
