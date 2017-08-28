/**
 * ...
 */
public class Graph {
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
