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
public class Main {

    /** Run the program ignoring the command line arguments. */
    public static void main(String[] args) throws Exception {
        // nop.
    }

    /** Return TRUE iff the heights of the two sub-trees of the given node differ by less than 2. */
    static Node next(Node root, Node node) {
        if (root == null)
            return null;
        if (node == null)
            return traverseLeft(root);
        if (node.right != null) {
            return traverseRight(node.right);
        }
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
            if (node.parent != null && node == node.parent.left)
                return node.parent;
        }
        return node.parent;
    }

    private static Node traverseLeft(Node node) {
        if (node == null)
            return null;
        if (node.left == null)
            return node;
        return traverseLeft(node.left);

    }

    private static Node traverseRight(Node node) {
        if (node == null)
            return null;
        if (node.left != null)
            return traverseLeft(node.left);
        return node;

    }
}
