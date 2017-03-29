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
 *    p does have a path to q.result: 1, 2, 4, 7, 9, 22, 23, 44, 56, 88, 99, 456, 1200, 5589
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

    static class Graph {
        Node[] nodes;

        Graph(Node[] nodes) {
            this.nodes = nodes;
        }

        boolean hasNode(Node n) {
            if (nodes != null)
                for (Node node : nodes)
                    if (node.name.equals(n.name))
                        return true;
            return false;
        }
    }

    static class Node {
        String name;
        Node[] children;

        Node(String name) {
            this.name = name;
        }

        boolean hasNode(Node node) {
            if (children != null)
                for (Node n : children)
                    if (n.name.equals(node.name))
                        return true;
            return false;
        }
    }

    private static final Map<String, Node> nodeMap = new HashMap<>();

    /** Run the program ignoring the command line arguments. */
    public static void main(String[] args) throws Exception {
        // Define the graph and the nodes.
        Node[] nodes = getNodes();
        Graph g = new Graph(nodes);
        Node p = nodeMap.get("p");
        Node q = nodeMap.get("q");
        boolean result = hasPath(g, p, q);
        String format = "%s %s have a path to %s";
        String message = result ? "does" : "does not";
        System.out.println(String.format(Locale.US, format, p.name, message, q.name));
    }

    /** Return TRUE iff there is a path between the given nodes. */
    public static boolean hasPath(Graph g, Node n1, Node n2) {
        // Run BFS to determine the result.
        if (!g.hasNode(n1) || !g.hasNode(n2))
            return false;
        List<Node> queue = new ArrayList<>();
        queue.add(n1);
        List<Node> visited = new ArrayList<>();
        int qIndex = 0;
        while (visited.size() < g.nodes.length) {
            // Work on node n by determining if it has been visited already, in which case it is
            // skipped.  Otherwise it is marked.
            Node n = queue.get(qIndex++);
            if (visited.contains(n))
                continue;
            visited.add(n);

            // Add the children of the node being visited to the queue for subsequent processing and
            // determine if this node is the target.
            if (n.children != null)
                for (Node node : n.children)
                    queue.add(node);
            System.out.println("Visiting node: " + n.name);
            if (n.hasNode(n2)) {
                // There is a path.  Print it.
                printPath(n1, n2, n);
                return true;
            }
        }
        return false;
    }

    private static void printPath(Node dest, Node parent, Node start) {
        System.out.print("The path is: " + dest.name);

    }
    private static Node[] getNodes() {
        createNodes("a", "b", "c", "d", "q", "x", "y", "z", "p", "o", "r");
        addChildren("a", "b", "c", "p");
        addChildren("b", "d");
        addChildren("d", "q");
        addChildren("c", "x", "y", "z");
        addChildren("p", "a", "o");
        addChildren("o", "p", "r");
        int index = 0;
        Node[] result = new Node[nodeMap.values().size()];
        for (Node node : nodeMap.values())
            result[index++] = node;
        return result;
    }

    private static void createNodes(String... nodes) {
        for (String name : nodes) {
            Node node = new Node(name);
            nodeMap.put(name, node);
        }
    }

    private static void addChildren(String name, String... names) {
        Node node = nodeMap.get(name);
        Node[] children = new Node[names.length];
        for (int i = 0; i < names.length; i++)
            children[i] = nodeMap.get(names[i]);
        node.children = children;
    }
}
