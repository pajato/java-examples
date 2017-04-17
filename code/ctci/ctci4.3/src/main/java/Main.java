/**
 * Problem 4.3 CTCI List of Depths
 *
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each
 * depth (e.g. if you have a tree with depth D, you'll have D linked lists).
 *
 * Examples: (input)
 *
 * [1] => Level 1: (1)
 * [1, 5] => Level 1: (1)
 *           Level 2: (5)
 * [1, 5, 9] = Level 1: (1)
 * [1, 5, 9, 14]
 * [1, 5, 9, 14, 22]
 * [1, 5, 9, 14, 22, 29]
 * [1, 5, 9, 14, 22, 29, 56]
 * [1, 5, 9, 14, 22, 29, 56, 72]
 * [1, 5, 9, 14, 22, 29, 56, 72, 94]
 *
 * Analysis:
 *
 * This is pretty much an application of binary sort (apply, recurse left side, recurse right side)
 * on the array to build a tree of Node objects.
 *
 * Algorithm:
 *
 * Node getNode(int[] a, int start, int end)
 *     if (start > end) return null
 *     int mid = start + (end - start) / 2
 *     Node root = new Node(a[mid])
 *     root.left = getNode(a, start, mid - 1)
 *     root.right = getNode(a, mid + 1, end)
 *     return root;
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    /** Run the program using the command line arguments to provide the array. */
    public static void main(String[] args) throws Exception {
        // Convert the input to an array ignoring invalid arguments and ensure that there is a valid
        // (non empty) array.
        int[] a = getArray(args);
        if (a == null) {
            System.out.println("One or more integer arguments must be provided.");
            System.exit(0);
        }

        // Process the array to generate the tree and print it out.
        Node root = getNode(a, 0, a.length - 1);
        if (root != null) {
            printNode(root);
            System.exit(0);
        }
        System.out.println("The array is empty!");
    }

    /** ... */
    private static int[] getArray(String... args) {
        List<Integer> values = new ArrayList<>();
        for (String arg : args)
            try {
                int value = Integer.parseInt(arg);
                values.add(value);
            } catch (NumberFormatException exc) {
                // silently ignore bad args.
            }
        int[] result = new int[values.size()];
        for (int i = 0; i < values.size(); i++)
            result[i] = values.get(i);
        return result;
    }

    /** Return null or the node implied by the given values. */
    private static Node getNode(int[] a, int start, int end) {
        if (start > end)
            return null;
        int mid = start + (end - start) / 2;
        Node root = new Node(a[mid]);
        root.left = getNode(a, start, mid - 1);
        root.right = getNode(a, mid + 1, end);
        return root;
    }

    /** Print the given node... */
    private static void printNode(Node root) {
        List<Node> queue = new ArrayList<>();
        queue.add(root);
        int qIndex = 0;
        int level = 1;
        while (qIndex < queue.size()) {
            System.out.print("Level " + level + ": (");
            int count = queue.size();
            for (int i = qIndex; i < count; i++) {
                Node n = queue.get(i);
                System.out.print(n.value);
                if (i + 1 < count)
                    System.out.print(", ");
                if (n.left != null)
                    queue.add(n.left);
                if (n.right != null)
                    queue.add(n.right);
                qIndex++;
            }
            System.out.println(")");
            level++;
        }
    }
}
