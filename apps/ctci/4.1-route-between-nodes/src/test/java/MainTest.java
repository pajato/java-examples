import org.junit.Test;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Locale;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    private static final Map<String, Node> nodeMap = new HashMap<>();

    @Test public void normalTest() {
        // Test that an actual path is reported as true.
        Node[] nodes = getNodes();
        Graph g = new Graph(nodes);
        Node p = nodeMap.get("p");
        Node q = nodeMap.get("q");
        String format = "%s %s have a path to %s";
        String errorMessage = String.format(Locale.US, format, p.name, "does not", q.name);
        assertTrue(errorMessage, Main.hasPath(g, p, q));

        // Test that a non-path is reported as false.
        Node b = nodeMap.get("b");
        Node x = nodeMap.get("x");
        errorMessage = String.format(Locale.US, format, b.name, "does", x.name);
        assertFalse(errorMessage, Main.hasPath(g, b, x));
    }

    /** Create a test graph using an adjacency list. */
    private Node[] getNodes() {
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

    private void createNodes(String... nodes) {
        for (String name : nodes) {
            Node node = new Node(name);
            nodeMap.put(name, node);
        }
    }

    private void addChildren(String name, String... names) {
        Node node = nodeMap.get(name);
        Node[] children = new Node[names.length];
        for (int i = 0; i < names.length; i++)
            children[i] = nodeMap.get(names[i]);
        node.children = children;
    }
}
