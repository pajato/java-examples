/**
 * Sales Path
 *
 * The car manufacturer Honda holds their distribution system in the form of a tree (not necessarily
 * binary). The root is the company itself, and every node in the tree represents a car distributor
 * that receives cars from the parent node and ships them to its children nodes. The leaf nodes are
 * car dealerships that sell cars direct to consumers. In addition, every node holds an integer that
 * is the cost of shipping a car to it.
 *
 * Take for example the tree below:
 *
 * {0 {5 {4}}, {3 {2 {1 {1}}}, {0 {10}}}, {6 {1}, {5}}}
 *
 * A path from Honda’s factory to a car dealership, which is a path from the root to a leaf in the
 * tree, is called a Sales Path. The cost of a Sales Path is the sum of the costs for every node in
 * the path. For example, in the tree above one Sales Path is 0→3→0→10, and its cost is 13
 * (0+3+0+10).
 *
 * Honda wishes to find the minimal Sales Path cost in its distribution tree. Given a node rootNode,
 * write an function getCheapestCost that calculates the minimal Sales Path cost in the tree.
 *
 * Implement your function in the most efficient manner and analyze its time and space complexities.
 *
 * For example:
 *
 * Given the rootNode of the tree in diagram above
 *
 * Your function would return:
 *
 * 7 since it’s the minimal Sales Path cost (there are actually two Sales Paths in the tree whose
 * cost is 7: 0→6→1 and 0→3→2→1→1)
 */
class Main {

    static class Node {

        String name;
        int cost;
        Node[] children;
        Node parent;

        Node(String name, int cost) {
            this.name = name;
            this.cost = cost;
            children = null;
            parent = null;
        }
    }

    static class SalesPath {

        private int cost;

        int getCheapestCost(Node rootNode) {
            // your code goes here
            //
            // Handle special cases.
            if (rootNode == null)
                return -1;
            if (rootNode.children == null)
                return rootNode.cost;

            // Handle normal case: traverse the root node to recursively visit each path.
            //
            // Time complexity: O(n)
            // Space complexity: O(1)
            cost = Integer.MAX_VALUE;
            traverse(rootNode, 0);
            return cost;
        }


        private void traverse(final Node n, int sum) {
            sum += n.cost;
            if (n.children == null) {
                // At a leaf node.  Check the path given by list.
                if (sum < cost)
                    cost = sum;
            } else
                for (int i = 0; i < n.children.length; i++)
                    traverse(n.children[i], sum);
        }
    }

    /*********************************************
     * Driver program to test above method     *
     *********************************************/

    public static void main(String[] args) {

    }

}
