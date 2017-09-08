import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Paul Michael Reilly
 */
public class MainTest {

    // Private class variables.

    /** The BST being operated upon. */
    private static Main.BinarySearchTree tree = getTree();

    // Private class methods.

    /** Build the test tree. */
    private static Main.BinarySearchTree getTree() {
        Main.BinarySearchTree tree = new Main.BinarySearchTree();
        tree.insert(20);
        tree.insert(9);
        tree.insert(25);
        tree.insert(5);
        tree.insert(12);
        tree.insert(11);
        tree.insert(14);
        return tree;
    }

    /** Ensure that the default constructor is exercised for maximum code coverage. */
    @Test public void testMain() {
        new Main();
    }

    @Test public void testMainMethod() {
        Main.main(null);
    }

    @Test public void test1() {
        runTest(1, -1, -1);
    }

    @Test public void test2() {
        runTest(2, 20, 25);
    }

    @Test public void test3() {
        runTest(3, 9, 11);
    }

    @Test public void test4() {
        runTest(4, 25, -1);
    }

    @Test public void test5() {
        runTest(5, 5, 9);
    }

    @Test public void test6() {
        runTest(6, 12, 14);
    }

    @Test public void test7() {
        runTest(7, 11, 12);
    }

    @Test public void test8() {
        runTest(8, 14, 25);
    }

    // Private instance methods.

    private void runTest(final int num, final int inputValue, final int expectedValue) {
        System.out.println("Test" + num);
        Main.Node input = tree.getNodeByKey(inputValue);
        Main.Node expected = tree.getNodeByKey(expectedValue);
        Main.Node actual = tree.findInOrderSuccessor(input);
        int actualKey = actual != null ? actual.key : -1;
        int expectedKey = expected != null ? expected.key : -1;
        assertEquals("The output node is wrong!", expectedKey, actualKey);
    }
}
