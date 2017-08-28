/**
 * Problem 4.1 CTCI Route Between Nodes
 *
 * Given a directed graph, design an algorithm to find out if there is a path between two nodes.
 *
 * Examples: (input)
 *
 *    Nodes: a, b, d, q, c, x, y, z, o, p, q
 *    Children:
 *    a: b, c, p
 *    b: d
 *    d: q
 *    c: x, y, z
 *    p: a, o
 *    o: p, r
 *
 * Result: (output)
 *
 *    p does have a path to q.
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

    /** Return TRUE iff there is a path between the given nodes. */
    public static boolean hasPath(Graph g, Node n1, Node n2) {
        // Ensure that the two input nodes exist in the given graph. Fail fast if either does not.
        if (!g.hasNode(n1) || !g.hasNode(n2))
            return false;

        // Walk the levels in the graph (BFS) terminating when all the nodes in g have been visited.
        List<Node> queue = new ArrayList<>();
        queue.add(n1);
        List<Node> visited = new ArrayList<>();
        int qIndex = 0;
        while (visited.size() < g.nodes.length && qIndex < queue.size()) {
            // Process the next node in the queue but skip already visited nodes. Mark this node as
            // visited.
            Node n = queue.get(qIndex++);
            if (visited.contains(n))
                continue;
            visited.add(n);

            // Add the children of this node to the queue for subsequent processing and
            // determine if this node is the target. If so, return true and be done.
            if (n.children != null)
                for (Node node : n.children)
                    queue.add(node);
            System.out.println("Visiting node: " + n.name);
            if (n.hasNode(n2))
                return true;
        }
        return false;
    }
}
