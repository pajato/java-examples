import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the calcDroneMinEnergy() method.
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    @Test public void testMain() {
        new Main();
    }

    @Test public void test1() {
        runTest(1, 1, 1);
    }

    @Test public void test2() {
        runTest(2, 2, 1);
    }

    @Test public void test3() {
        runTest(3, 3, 2);
    }

    @Test public void test4() {
        runTest(4, 4, 5);
    }

    @Test public void test5() {
        runTest(5, 6, 42);
    }

    @Test public void test6() {
        runTest(6, 17, 35357670);
    }

    @Test public void test7() {
        runTest(7, 0, 0);
    }
    @Test public void test8() {
        runTest(8, -1, 0);
    }

    // Private instance methods.

    private void runTest(final int testNum, final int input, final int expected) {
        System.out.println("Test" + testNum);
        int actual = Main.numOfPathsToDest(input);
        assertEquals("The result is wrong!", expected, actual);
    }
}
