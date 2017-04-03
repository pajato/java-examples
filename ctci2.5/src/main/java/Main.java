/**
 * Problem 2.5 Sum Lists
 *
 * You have two numbers represented by a linked list where each node contains a single digit.  The
 * digits are stored in reverse order, such that the 1's digit is at the head of the list.  Write a
 * function that adds the two numbers and returns the sum as a linked list.
 *
 * Observations:
 *
 * 1) need to implement: boolean isPalPerm(String letters)
 *
 * 2) the letters are Unicode (UTF-16) and thus require 21 bits, an int. Therefore using an array to
 * count the occurrences of the letters is likely inefficient.
 *
 * 3) The letters can be a permutation of a palindrome iff there is at most one letter with an odd
 * count.
 *
 * Examples:
 *
 * 617 (7->1->6) + 295 (5->9->2) => 912 (2->1->9)
 *
 * Brute Force algorithm:
 *
 *    walk through the two lists adding each element using 0 if the element does not exist until
 *    both lists are exhausted.
 *
 * Algorithm:
 *
 * 1) for each argument:
 * 2) convert the letters to a char array.
 * 3) for each item in the array:
 * 4) determine if the char is in a list; if so then remove it, if not then add it.
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
        Node prev;;

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
        // Ensure that there are two values.  Abort if not.
        if (args.length != 2) {
            System.out.println("Need two inputs.");
            System.exit(0);
        }

        // Ensure that the input is valid.  Abort if not.
        Node n1 = getNode(args[0]);
        if (n1 == null) {
            System.out.println("The first argument is invalid.");
        }
        Node n2 = getNode(args[1]);
        if (n2 == null) {
            System.out.println("The second argument is invalid.");
        }

        // The input is valid.  Perform the operation.
        Node r = new Node();
        plus(n1, n2, r, 0);
        String line = String.format("%s + %s => %s", n1, n2, r);
        System.out.println(line);
    }

    /** Return a the given value as a linked list. */
    private static Node getNode(String value) {
        Node result = new Node();
        Node node = result;
        char[] chars = value.toCharArray();
        for (int n = chars.length - 1; n >= 0; n--) {
            node.data = Character.getNumericValue(chars[n]);
            if (node.data < 0 || result.data > 9)
                return null;
            if (n != 0) {
                node.next = new Node();
                node = node.next;
            }
        }
        return result;
    }

    /** Zero out each column in the given array using the values in the given list. */
    private static void plus(Node n1, Node n2, Node r, int carry) {
        int d1 = n1 != null ? n1.data : 0;
        int d2 = n2 != null ? n2.data : 0;
        int result = d1 + d2 + carry;
        r.data = result % 10;
        n1 = n1.next != null ? n1.next : null;
        n2 = n2.next != null ? n2.next : null;
        r.next = n1 != null || n2 != null ? new Node() : null;
        if (r.next != null) {
            plus(n1, n2, r.next, result < 10 ? 0 : 1);
        }
    }
}
