import org.junit.Test;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Locale;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Test that the isBalanced(Node) method works. Test cases should include:
 *
 * 1) a null node (true),
 * 2) a single node (true),
 * 3) a tree with depth 1 (true),
 * 4) a tree with depth 2 (true),
 * 5) an unbalanced tree with three nodes (false),
 * 6) a large (> 5 nodes) balanced tree (true),
 * 7) a large (> 5 nodes) unbalanced tree (false).
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    @Test public void testAll() {
        // 1) Test that an null node returns true.
        String errorMessage = "The null node is not balanced!";
        assertTrue(errorMessage, Main.isBalanced(null));

        // 2) Test that a single node is balanced.
        errorMessage = "A single node is balanced!";
        assertTrue(errorMessage, Main.isBalanced(new Node("one")));

        // 3), 4) Test that a tree with size 2 or 3 is balanced.
        errorMessage = "A node with size 2 is balanced!";
        assertTrue(errorMessage, Main.isBalanced(getTreeWithTwoNodes()));
        errorMessage = "A node with size 3 is balanced!";
        assertTrue(errorMessage, Main.isBalanced(getTreeWithThreeNodes()));

        // 5) Test that a tree with three nodes, one parenting the next, is unbalanced.
        errorMessage = "A straight line tree is reported as balanced!";
        assertFalse(errorMessage, Main.isBalanced(getUnbalancedTree()));

        // 6) Test that a tree with six nodes is balanced.
        errorMessage = "A complete binary tree is not balanced!";
        assertTrue(errorMessage, Main.isBalanced(getLargeBalancedTree()));

        // 7) Test that a tree with six nodes is unbalanced.
        errorMessage = "The binary tree is balanced!";
        assertFalse(errorMessage, Main.isBalanced(getLargeUnbalancedTree()));
    }

    private Node getTreeWithTwoNodes() {
        Node a = new Node("a");
        a.left = new Node("aLeft");
        return a;
    }

    private Node getTreeWithThreeNodes() {
        Node a = getTreeWithTwoNodes();
        a.right = new Node("aRight");
        return a;
    }

    private Node getUnbalancedTree() {
        Node a = getTreeWithTwoNodes();
        a.left.left = new Node("aLeftLeft");
        return a;
    }

    /** Return a tree node parenting a balanced tree with six nodes. */
    private Node getLargeBalancedTree() {
        String [][] arr = new String[][] {
            {"root", "a", "b"},
            {"a", "c", "d"},
            {"b", "e"},
            {"c"},
            {"d"},
            {"e"}
        };
        return Node.buildTree(arr);
    }

    /** Return a tree node parenting an unbalanced tree with six nodes. */
    private Node getLargeUnbalancedTree() {
        String [][] arr = new String[][] {
            {"root", "a", "b"},
            {"a"},
            {"b", "c", "d"},
            {"c"},
            {"d", "e"},
            {"e"}
        };
        return Node.buildTree(arr);
    }
}
