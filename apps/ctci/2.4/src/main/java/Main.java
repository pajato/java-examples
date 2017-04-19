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
import java.util.StringTokenizer;
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
        int value = Util.getInt(args[1]);
        int size = tokenizer.countTokens();
        Node in = getNode(tokenizer);
        System.out.println("Input: " + in + ", partition value: " + value);
        Node out = partition(in, value);
        System.out.println("Output: " + out);
    }

    /** Abort for the given reason. */
    private static void abort(final String reason) {
        System.out.println(reason);
        System.exit(1);
    }

    /** Return a linked list containing the elements in the  given string token generator. */
    private static Node getNode(StringTokenizer tokenizer) {
        int size = tokenizer.countTokens();
        if (size <=0)
            abort("Input linked list is invalid or empty, aborting.");
        Node result = new Node(Util.getInt(tokenizer.nextToken()));
        Node n = result;
        for (int i = 1; i < size; i++) {
            n.next = new Node(Util.getInt(tokenizer.nextToken()));
            n = n.next;
        }
        return result;
    }

    /** Build a list of nodes satisfying the problem constraint. */
    private static Node partition(Node in, final int x) {
        Node first = new Node(in.data);
        Node last = first;
        while (in.next != null) {
            in = in.next;
            if (in.data < x) {
                Node tmp = new Node(in.data);
                tmp.next = first;
                first = tmp;
            } else
                last = last.next = new Node(in.data);
        }
        return first;
    }
}
