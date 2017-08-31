/**
 * Problem 4.5 CTCI Validate BST
 *
 * Implement a function to check if a binary tree is a binary search tree.
 *
 * Analysis:
 *
 * A binary tree is a binary search tree if the value of all left nodes are less than or equal to
 * the current node and if all the right nodes are greater than the current node.
 *
 * Algorithm:
 *
 * Using the min-max approach, each node is compared to a min and max value range.  If the
 * comparison satisfies min <= data > max then the node is valid, otherwise it is not and the binary
 * tree is not a BST. When traversing the tree to the left, the min value will be adjusted to the
 * current data and when traversing the tree to the right, the max value is adjusted. Graphically:
 *
 *          20
 *       15    30
 *    10    17    40
 *  3    12
 *
 * The following need to be satisfied: (traverse left, change max; traverse right change min)
 *
 *        Node            left         right
 * -inf <= 20 < inf        15            30
 * -inf <= 15 < 20         10            17
 *   20 <= 30 < inf         -            40
 *   15 <= 10 < 20          3            12
 *   15 <= 17 < 20          -             -
 *   30 <= 40 < inf         -             -
 *   15 <=  3 < 10          -             -
 *   10 <= 12 < 20          -             -
 *
 * In terms of a pre-order traversal:
 * 1) for the current node: ensure that the node value is between min and max;
 * 2) for a left traversal, set max to the current node value;
 * 3) for a right traversal set min to the current node value.
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
    public static boolean isBST0(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(final Node node, final int min, final int max) {
        // Accept a null node.
        if (node == null)
            return true;

        // Use pre-order traversal to handle a non-null node. First accept the root.
        if (node.data > max || node.data <= min)
            return false;
        return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
    }

    private static int constraint;
    public static boolean isBST(Node root) {
        constraint = Integer.MIN_VALUE;
        return isBSTHelper(root);
    }

    private static boolean isBSTHelper(Node node) {
        if (node == null)
            return true;
        if (!isBSTHelper(node.left))
            return false;
        if (node.data < constraint)
            return false;
        constraint = node.data;
        if (!isBSTHelper(node.right))
            return false;
        return true;
    }
}
