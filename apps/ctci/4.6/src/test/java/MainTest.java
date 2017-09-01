import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Test that the "next" (inorder successor node) output value is correct for the following:
 *
 * 1) a null node (returns null),
 * 2) a single node (returns node),
 * for the binary tree: {{root, a, b}, {a, c, d}, {b, e, f}, {c}, {d}, {e}, {f}}
 * 3) next(root, null) => c,
 * 4) next(root, c) => a,
 * 5) next(root, a) => d,
 * 6) next(root, d) => root,
 * 7) next(root, root) => e,
 * 8) next(root, e) => b,
 * 9) next(root, b) => f,
 * 10) next(root, f) => null.
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    private Map<String, Node> nodeMap = new HashMap<>();

    @Test public void testAll() {
        runTest(1, null, null, null);

        Node root = new Node("root");
        runTest(2, root, null, root);

        String[][] arr = new String[][]{
            {"root", "a", "b"},
            {"a", "c", "d"},
            {"b", "e", "f"},
            {"c"},
            {"d"},
            {"e"},
            {"f"}
        };
        root = buildTree(arr);
        runTest(3, root, null, getNode("c"));
        runTest(4, root, getNode("c"), getNode("a"));
        runTest(5, root, getNode("a"), getNode("d"));
        runTest(6, root, getNode("d"), getNode("root"));
        runTest(7, root, getNode("root"), getNode("e"));
        runTest(8, root, getNode("e"), getNode("b"));
        runTest(9, root, getNode("b"), getNode("f"));
        runTest(10, root, getNode("f"), null);
    }

    // Private instance methods.

    /** Create and return a tree from a three-dimensional array of nodes. */
    private Node buildTree(final String[][] names) {
        // Ensure that the array is well formed with at least a root node and data for each node.
        nodeMap = new HashMap<>();
        if (names.length == 0 || names[0].length == 0)
            return null;

        // Build all the parent and leaf nodes saving them in a map.
        for (String[] arr : names) {
            int size = arr.length;
            String name = size > 0 ? arr[0] : null;
            if (name != null)
                nodeMap.put(name, new Node(name));
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
                if (n.left != null)
                    n.left.parent = n;
                if (n.right != null)
                    n.right.parent = n;
            }
        }

        return nodeMap.get(names[0][0]);
    }

    /** Return a node with the given name. */
    private Node getNode(final String name) {
        return nodeMap.get(name);
    }

    /** Run a test with a given test number, root node, test node and expected result. */
    private void runTest(final int testNum, final Node root, final Node node, final Node expected) {
        System.out.println("Running test number " + testNum);
        Node actual = Main.next(root, node);
        assertEquals("The next node is wrong!", expected, actual);
    }
}
