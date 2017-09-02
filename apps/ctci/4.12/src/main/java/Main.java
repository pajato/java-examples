import java.util.ArrayList;
import java.util.List;

/**
 * Problem 4.12 Paths with Sum
 *
 * You are given a binary tree in which each node contains an integer value (which might be positive
 * or negative). Design an algorithm to count the number of paths that sum to a given value. The
 * path does not need to start or end at the root or leaf but it must go downwards (traveling only
 * from parent nodes to child nodes).
 *
 * Analysis:
 *
 * This is pretty much a BFS exercise.
 *
 * Collect all the nodes into a list (queue) and then process each node using recursive pre-order
 * traversal to find the sum for that traversal (path).
 *
 * There are a couple of possible optimizations:
 *
 * 1) mark nodes (and all of the sub-trees) that do not sum to the given value as fruitless and do
 * not process any of those marked nodes.
 *
 * 2) mark nodes (and all of the sub-trees) that do sum to the given value and terminate on a leaf
 * node as fruitless (after incrementing the path count).
 *
 * The first pass will not use optimizations.
 */
public class Main {

    /** Return the number of paths in the given tree that sum to the given value. */
    static int countPaths(Node root, int value) {
        // Use BFS to queue up all the nodes for processing.
        List<Node> queue = new ArrayList<>();
        queue.add(root);
        int index = 0;
        while (queue.size() > index) {
            Node n = queue.get(index++);
            if (n != null && n.left != null)
                queue.add(n.left);
            if (n != null && n.right != null)
                queue.add(n.right);
        }

        // Process each node.
        int pathCount = 0;
        int sum = 0;
        for (Node n : queue) {
            pathCount += getNumberOfPaths(n, value, sum);
        }

        return pathCount;
    }

    private static int getNumberOfPaths(final Node n, int value, int sum) {
        // Use a pre-order traversal so visit node n first then n.left and then n.right.
        int count = 0;
        if (n == null)
            return count;
        if (sum + n.data == value)
            count++;
        count += getNumberOfPaths(n.left, value,sum + n.data);
        count += getNumberOfPaths(n.right, value,sum + n.data);
        return count;
    }
}
