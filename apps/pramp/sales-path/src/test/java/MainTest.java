import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Paul Michael Reilly
 */
public class MainTest {

    // Private class variables.

    /** The tree being tested. */
    private static final Map<String, Main.Node> nodeMap = getNodeMap();

    // Private class methods.

    /** Return the test tree. */
    private static Map<String, Main.Node> getNodeMap() {
        // Create the nodes and setup the parent/child relationships.
        final Map<String, Main.Node> nodeMap = getNodes();
        final Map<String, String[]> childMap = new HashMap<>();
        childMap.put("a", new String[]{"b", "c", "d"});
        childMap.put("b", new String[]{"e"});
        childMap.put("c", new String[]{"f", "g"});
        childMap.put("d", new String[]{"h", "i"});
        childMap.put("f", new String[]{"j"});
        childMap.put("g", new String[]{"k"});
        childMap.put("j", new String[]{"l"});
        for (Map.Entry<String, String[]> entry : childMap.entrySet()) {
            Main.Node parent = nodeMap.get(entry.getKey());
            parent.children = new Main.Node[entry.getValue().length];
            for (int i = 0; i < parent.children.length; i++) {
                parent.children[i] = nodeMap.get(entry.getValue()[i]);
                parent.children[i].parent = parent;
            }
        }
        return nodeMap;
    }

    /** Return the test tree. */
    private static Map<String, Main.Node> getNodes() {
        // Create the nodes and store them in a map.
        Map<String, Main.Node> nodes = new HashMap<>();
        final Map<String, Integer> costMap = new HashMap<>();
        costMap.put("a", 0);
        costMap.put("b", 5);
        costMap.put("c", 3);
        costMap.put("d", 6);
        costMap.put("e", 4);
        costMap.put("f", 2);
        costMap.put("g", 0);
        costMap.put("h", 1);
        costMap.put("i", 5);
        costMap.put("j", 1);
        costMap.put("k", 10);
        costMap.put("l", 1);
        for (Map.Entry<String, Integer> entry : costMap.entrySet()) {
            Main.Node n = new Main.Node(entry.getKey(), entry.getValue());
            nodes.put(entry.getKey(), n);
        }
        return nodes;
    }

    // Public test methods.

    /** Ensure that the default constructor is exercised for maximum code coverage. */
    @Test public void testMain() {
        new Main();
    }

    @Test public void testMainMethod() {
        Main.main(null);
    }

    @Test public void test1() {
        runTest(1, null, -1);
    }

    @Test public void test2() {
        runTest(2, nodeMap.get("l"), 1);
    }

    @Test public void test3() {
        runTest(3, nodeMap.get("e"), 4);
    }

    @Test public void test4() {
        runTest(4, nodeMap.get("a"), 7);
    }

    @Test public void test5() {
        runTest(5, nodeMap.get("c"), 7);
    }

    // Private instance methods.

    private void runTest(final int num, final Main.Node input, int expected) {
        System.out.println("Test" + num);
        Main.SalesPath data = new Main.SalesPath();
        int actual = data.getCheapestCost(input);
        assertEquals("The computed cheapest cost is wrong!", expected, actual);
    }
}
