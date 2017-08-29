/**
 * Problem 4.4 CTCI Check Balanced
 *
 * Implement a function to check if a binary tree is balanced.  For the purposes of this question, a
 * balanced tree is defined to be a tree such that the heights of the two sub-trees of any node
 * never differ by more than one.
 *
 * Analysis:
 *
 *    This is pretty much a BFS exercise.
 *
 * Algorithm:
 *
 * 1) Build the graph g, with the nodes from the example.
 *
 * 2) Use BFS on the graph to find the path, if any.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {

    /** Run the program ignoring the command line arguments. */
    public static void main(String[] args) throws Exception {
        // nop.
    }

    /** Return TRUE iff the heights of the two sub-trees of the given node differ by less than 2. */
    public static boolean isBalanced(Node node) {
        // Handle a null node, a leaf node or a node containing one or two leaf nodes.
        int depth = node != null ? node.depth() : 0;
        String name = node != null ? node.name : "null";
        System.out.println(String.format(Locale.US, "Node {%s} depth is: %d.", name, depth));
        if (node == null || node.depth() <= 1)
            return true;

        // Handle a "normal" tree, one with depth > 1.
        int leftDepth = node.left != null ? node.left.depth() : 0;
        int rightDepth = node.right != null ? node.right.depth() : 0;
        System.out.println(node.name + ": " + leftDepth + ":" + rightDepth);
        if (Math.abs(leftDepth - rightDepth) <= 1)
            return true;
        return false;
    }
}
