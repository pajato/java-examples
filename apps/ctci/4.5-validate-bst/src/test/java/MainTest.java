import org.junit.Test;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Locale;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Test that the "isBST" output value is correct for the following:
 *
 * 1) a null node (true),
 * 2) a single node (true),
 * 3) an invalid tree with > 1 node (false)
 * 4) a valid tree with > 1 node (true)
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    @Test public void testAll() {
        // 1) Test that a null node returns true.
        String errorMessage = "The null node is a BST!";
        assertTrue(errorMessage, Main.isBST(null));

        // 2) Test that a single node is a BST.
        errorMessage = "A single node is a BST!";
        assertTrue(errorMessage, Main.isBST(new Node(1)));

        // 3) Test that an invalid BST with more than 1 node is detected.
        errorMessage = "An invalid tree is reported as valid!";
        assertFalse(errorMessage, Main.isBST(getInvalidBST()));

        // 4) Test that a valid BST with more than 1 node is detected.
        errorMessage = "A valid tree is reported as invalid!";
        assertTrue(errorMessage, Main.isBST(getValidBST()));
    }

    // Private instance methods.

    /** Create and return a tree from a three-dimensional array of nodes. */
    private Node buildTree(final String[][] names, final Map<String, Integer> data) {
        // Ensure that the array is well formed with at least a root node and data for each node.
        if (names.length == 0 || names[0].length == 0 || names.length != data.size())
            return null;

        // Build all the parent and leaf nodes saving them in a map.
        Map<String, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            int size = names[i].length;
            String name = size > 0 ? names[i][0] : null;
            Integer value = name != null ? data.get(name) : null;
            if (value != null)
                nodeMap.put(name, new Node(value));
        }

        // Link the sub-tree nodes with the parents.
        for (int i = 0; i < names.length; i++) {
            int size = names[i].length;
            String name = size > 0 ? names[i][0] : null;
            Node n = name != null ? nodeMap.get(name) : null;
            name = size > 1 ? names[i][1] : null;
            n.left = name != null ? nodeMap.get(name) : null;
            name = size > 2 ? names[i][2] : null;
            n.right = name != null ? nodeMap.get(name) : null;
        }

        return nodeMap.get(names[0][0]);
    }

    /** Return a tree that is not a valid BST. */
    private Node getInvalidBST() {
        String [][] names = new String[][] {
            {"root", "a", "b"},
            {"a", "c", "d"},
            {"b"},
            {"c"},
            {"d"}
        };
        Map<String, Integer> data = new HashMap<>();
        data.put("root", 20);
        data.put("a", 15);
        data.put("b", 30);
        data.put("c", 10);
        data.put("d", 25);
        return buildTree(names, data);
    }

    /** Return a tree that is a valid BST. */
    private Node getValidBST() {
        String [][] names = new String[][] {
            {"root", "a", "b"},
            {"a", "c", "d"},
            {"b"},
            {"c"},
            {"d"}
        };
        Map<String, Integer> data = new HashMap<>();
        data.put("root", 25);
        data.put("a", 15);
        data.put("b", 30);
        data.put("c", 10);
        data.put("d", 20);
        return buildTree(names, data);
    }
}
