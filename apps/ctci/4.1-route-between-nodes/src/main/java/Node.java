/**
 */

public class Node {
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
