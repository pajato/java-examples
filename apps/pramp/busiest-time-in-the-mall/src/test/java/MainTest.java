import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test that the findArrayQuadruplet() method passes the given test cases.
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    @Test public void testMain() {
        new Main();
    }

    @Test public void test1() {
        runTest(1, new int[][]{{1487799426,21,1}}, 1487799426);
    }

    @Test public void test2() {
        runTest(2, new int[][]{{1487799425,21,0},{1487799427,22,1},{1487901318,7,0}}, 1487799427);
    }

    @Test public void test3() {
        runTest(3, new int[][]{{1487799425,21,1},{1487799425,4,0},{1487901318,7,0}}, 1487799425);
    }

    @Test public void test4() {
        runTest(4, new int[][]{
                {1487799425,14,1},
                {1487799425,4,0},
                {1487799425,2,0},
                {1487800378,10,1},
                {1487801478,18,0},
                {1487801478,18,1},
                {1487901013,1,0},
                {1487901211,7,1},
                {1487901211,7,0}
            }, 1487800378);
    }

    @Test public void test5() {
        runTest(5, new int[][]{
                {1487799425,14,1},
                {1487799425,4,1},
                {1487799425,2,1},
                {1487800378,10,1},
                {1487801478,18,1},
                {1487901013,1,1},
                {1487901211,7,1},
                {1487901211,7,1}
            }, 1487901211);
    }

    @Test public void test6() {
        runTest(6, new int[][]{
                {1487799425,14,1},
                {1487799425,4,0},
                {1487799425,2,0},
                {1487800378,10,1},
                {1487801478,18,0},
                {1487801478,19,1},
                {1487801478,1,0},
                {1487801478,1,1},
                {1487901013,1,0},
                {1487901211,7,1},
                {1487901211,8,0}
            }, 1487801478);
    }

    @Test public void test7() {
        runTest(7, null, -1);
    }

    @Test public void test8() {
        runTest(8, new int[][]{}, -1);
    }

    @Test public void test9() {
        runTest(9, new int[][]{{0, 3}}, -1);
    }
    // Private instance methods.

    private void runTest(final int testNum, final int[][] data, final int expected) {
        System.out.println("Test" + testNum);
        int actual = Main.findBusiestPeriod(data);
        assertEquals("The result is wrong!", expected, actual);
    }
}
