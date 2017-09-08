import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Test that the "countPaths" method works correctly for the following cases:
 *
 * 1) null tree (0)
 * 2) single node with value k: (1)
 * 3) single node with value not k: (0)
 * 4) complex tree (3)
 * 5) complex tree (0)
 * 6) complex tree (8);
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    /** Boiler-plate test for code-coverage only. */
    @Test public void testMain() {
        new Main();
    }

    /** Main tests for the next() method. */
    @Test public void testAll() {
        runTest(1, null, 0, 0);

        Node root = new Node("root");
        root.data = 3;
        runTest(2, root, 3, 1);
        runTest(3, root, 0, 0);

        // Build a tree to use for the next set of tests.
        String[][] arr = new String[][]{
            {"root", "a", "b"},
            {"a", "c", "d"},
            {"b", "e", "f"},
            {"c"},
            {"d"},
            {"e"},
            {"f"}
        };
        Map<String, Integer> data = new HashMap<>();
        data.put("root", 10);
        data.put("a", 8);
        data.put("b", 2);
        data.put("c", 3);
        data.put("d", 10);
        data.put("e", 2);
        data.put("f", 6);
        root = buildTree(arr, data);

        // Run the tests using the given tree.
        runTest(4, root, 21, 1);
        runTest(5, root, 15, 0);
        runTest(6, root, 2, 2);
        runTest(7, root, 18, 3);
    }

    // Private instance methods.

    /** Create and return a tree from a three-dimensional array of nodes. */
    private Node buildTree(final String[][] names, Map<String, Integer> data) {
        // Ensure that the array is well formed with at least a root node and data for each node.
        Map<String, Node> nodeMap = new HashMap<>();
        if (names.length == 0 || names[0].length == 0)
            return null;

        // Build all the parent and leaf nodes saving them in a map.
        for (String[] arr : names) {
            int size = arr.length;
            String name = size > 0 ? arr[0] : null;
            Integer value = name != null ? data.get(name) : null;
            if (value != null) {
                Node n = new Node(name);
                nodeMap.put(name, n);
                n.data = value;
            }
        }

        // Link the sub-tree nodes with the parents.
        for (String[] arr : names) {
            String name = arr.length > 0 ? arr[0] : null;
            Node n = name != null ? nodeMap.get(name) : null;
            if (n != null) {
                name = arr.length > 1 ? arr[1] : null;
                n.left = name != null ? nodeMap.get(name) : null;
                name = arr.length > 2 ? arr[2] : null;
                n.right = name != null ? nodeMap.get(name) : null;
            }
        }

        return nodeMap.get(names[0][0]);
    }

    /** Run a test with a given test number, root node, test value and expected result. */
    private void runTest(final int testNum, final Node root, final int value, final int expected) {
        System.out.println("Running test number " + testNum);
        int actual = Main.countPaths(root, value);
        assertEquals("The path count is wrong!", expected, actual);
    }
}
