/**
 * Problem 2.4 Partition
 *
 * Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. If x is contained within the list, the values of x
 * only need to be after the elements less than x (see below). The partition element x can appear
 * anywhere in the "right partition"; it does not need to appear between the left and right
 * partitions.
 *
 * EXAMPLE:
 *
 * Input: 3 -> 5 -> 8 -> 10 -> 2 -> 1 [partition = 5]
 *
 * Output: 3 -> 2 -> 1 -> 5 -> 8 -> 10
 *
 * Brute Force algorithm:
 *
 *    walk through the given list:
 *        // create right or left linked list on demand
 *        element < x => append node containing element to "left" linked list
 *        element >= x => append node containing element to "right"" linked list
 *    return left + right or left or right or null // depending on existence of left or right
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import util.Util;

public class Main {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node() {}

        Node(int data) {
            this.data = data;
        }

        @Override public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("(");
            print(this, builder);
            builder.append(")");
            return builder.toString();
        }

        void print(Node n, StringBuilder builder) {
            builder.append(String.valueOf(n.data));
            if (n.next != null) {
                builder.append("->");
                print(n.next, builder);
            }
        }
    }

    /**
     * Run the program using the command line argument to provide the input values.  No input
     * generates a message to that effect.
     */
    public static void main(String[] args) throws Exception {
        final String DELIM = "->";
        if (args.length != 2)
            abort("Input must be two strings; a set of integers delimited by '->' and an int value");
        StringTokenizer tokenizer = new StringTokenizer(args[0], DELIM);
        int value = getValue(args[1]);
        int size = tokenizer.countTokens();
        Node in = getNode(tokenizer);
        System.out.println("Input: " + in);
        Node out = partition(in, value);
        System.out.println("Output: " + out);
    }

    /** Abort for the given reason. */
    private void abort(final String reason) {
        System.out.println(reason);
        System.exit(1);
    }

    /** Return a linked list containing the elements in the  given string token generator. */
    private static Node getNode(StringTokenizer tokenizer) {
        int size = tokenizer.countTokens();
        if (size <=0)
            abort("Input linked list is invalid or empty, aborting.");
        Node result;
        Node n;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                result = new Node();
                n = result;
            } else {
                n.next = new Node();
                n = n.next;
            }
            n.data = getValue(tokenizer.nextToken());
        }
    }

    /** Build a list of nodes satisfying the problem constraint. */
    private static Node partition(Node in, final int x) {
        Node first;
        Node last;
        while (in != null) {
            if (in.data <= x) {
                first = updatePrev(first, in);
                if (last == null)
                    last = first;
            } else {
                last = updateNext(last, in);
                if (first == null)
                    first = last;
            }
            in = in.next;
        }
        return first;
    }

    private Node updatePrev(Node n, Node in) {
        if (n != null) {
            n.prev = new Node(in.data);
            return n.prev;
        } else
            return new Node(in.data);
    }

    private Node updateNext(Node n, Node in) {
        if (n != null) {
            n.next = new Node(in.data);
            return n.next;
        } else
            return new Node(in.data);
    }
}
