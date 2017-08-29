import java.util.Map;
import java.util.HashMap;

/**
 * ...
 */
public class Node {

    // Public properties.

    public String name;
    public Node left;
    public Node right;

    // Public constructor.

    public Node(String name) {
        this.name = name;
    }

    // Public class methods.

    /** Create and return a node tree from a two-dimensional array of node names. */
    public static Node buildTree(final String[][] nameArray) {
        // Ensure that the name array is well formed with at least a root node name.
        if (nameArray.length == 0 || nameArray[0].length == 0)
            return null;

        // Build all the parent and leaf nodes saving them in a map.
        Map<String, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < nameArray.length; i++) {
            int size = nameArray[i].length;
            String name = size > 0 ? nameArray[i][0] : null;
            if (name != null)
                nodeMap.put(name, new Node(name));
        }

        // Link the sub-tree nodes with the parents.
        for (int i = 0; i < nameArray.length; i++) {
            int size = nameArray[i].length;
            String name = size > 0 ? nameArray[i][0] : null;
            Node n = name != null ? nodeMap.get(name) : null;
            name = size > 1 ? nameArray[i][1] : null;
            n.left = name != null ? nodeMap.get(name) : null;
            name = size > 2 ? nameArray[i][2] : null;
            n.right = name != null ? nodeMap.get(name) : null;
        }

        return nodeMap.get(nameArray[0][0]);

    }

    // Public instance methods.

    public int depth() {
        return 1 + Math.max(getDepth(left), getDepth(right));
    }

    // Private instance methods.

    private int getDepth(final Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }
}
