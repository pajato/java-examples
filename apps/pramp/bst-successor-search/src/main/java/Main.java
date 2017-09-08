/**
 * Pramp: BST Successor Search
 *
 * In a Binary Search Tree (BST), an Inorder Successor of a node is defined as the node with the
 * smallest key greater than the key of the input node (see examples below). Given a node inputNode
 * in a BST, you’re asked to write a function findInOrderSuccessor that returns the Inorder
 * Successor of inputNode. If inputNode has no Inorder Successor, return null.
 *
 * Explain your solution and analyze its time and space complexities.
 *
 * In the diagram on the Tramp web-site, the inorder successor of 9 is 11 and the inorder successor
 * of 14 is 20.
 *
 * Example:
 *
 * In the diagram above, for inputNode whose key = 11
 *
 * Your function would return:
 *
 * The Inorder Successor node whose key = 12
 */
class Main {

    static class Node {

        int key;
        Node left;
        Node right;
        Node parent;

        Node(int key) {
            this.key = key;
            left = null;
            right = null;
            parent = null;
        }
    }

    static class BinarySearchTree {

        Node root;

        Node findInOrderSuccessor(Node inputNode) {
            // your code goes here.
            //
            // Handle the special cases.
            if (inputNode == null) {
                return null;
            }

            // Assumption is that the input node has been visited and the successor node will be
            // found in the right subtree, if one exists, or in the parent taking into account
            // whether the input node is a left or right child of it's parent.
            if (inputNode.right != null)
                return getLeftSuccessor(inputNode.right);

            // There is no right node.  Find the successor using the parent.  If the input node is
            // the left child of the parent, the result is the parent, otherwise the parent node is
            // examined recursively.
            if (inputNode == inputNode.parent.left)
                return inputNode.parent;

            // Traverse the parent nodes until either the root is encountered or a right subtree can
            // be used.
            return getRightSuccessor(inputNode.parent.right);
        }

        /** Return the successor to the given node by doing an inorder search. */
        private Node getLeftSuccessor(final Node node) {
            if (node.left != null)
                return getLeftSuccessor(node.left);
            return node;
        }

        /** Return the successor to the given node which is a right subtree of the parent. */
        private Node getRightSuccessor(final Node node) {
            if (node.parent == null)
                return null;
            if (node == node.parent.right)
                return getRightSuccessor(node.parent);
            return findInOrderSuccessor(node.parent);

        }

        //  Given a binary search tree and a number, inserts a new node
        //  with the given number in the correct place in the tree
        void insert(int key) {

            // 1. If the tree is empty, create the root
            if(this.root == null) {
                this.root = new Node(key);
                return;
            }

            // 2) Otherwise, create a node with the key
            //    and traverse down the tree to find where to
            //    to insert the new node
            Node currentNode = this.root;
            Node newNode = new Node(key);

            while(currentNode != null) {
                if(key < currentNode.key) {
                    if(currentNode.left == null) {
                        currentNode.left = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if(currentNode.right == null) {
                        currentNode.right = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }

        // Return a reference to a node in the BST by its key.
        // Use this method when you need a node to test your
        // findInOrderSuccessor method on
        Node getNodeByKey(int key) {
            Node currentNode = this.root;

            while(currentNode != null) {
                if(key == currentNode.key) {
                    return currentNode;
                }

                if(key < currentNode.key) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }

            return null;
        }
    }

    /***********************************************
     * Driver program to test findInOrderSuccessor *
     ***********************************************/

    public static void main(String[] args) {

        Node test = null, succ = null;

        // Create a Binary Search Tree
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(20);
        tree.insert(9);
        tree.insert(25);
        tree.insert(5);
        tree.insert(12);
        tree.insert(11);
        tree.insert(14);

        // Get a reference to the node whose key is 9
        test = tree.getNodeByKey(9);

        // Find the in order successor of test
        succ = tree.findInOrderSuccessor(test);

        // Print the key of the successor node
        System.out.println("Inorder successor of " + test.key + " is " + succ.key);
    }
}
