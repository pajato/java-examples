/**
 * Problem 10.1 CTCI Sorted Merge
 *
 * You are given two sorted arrays, a and b, where a has a large enough buffer at the end to hold
 * b. Write a method to merge b into a in sorted order.
 *
 * Examples:
 *
 *    a: 2, 7, 22, 44, 56, 88, 456, 5589
 *    b: 1, 4, 9, 23, 99, 1200
 *
 * Result:
 *
 *    result: 1, 2, 4, 7, 9, 22, 23, 44, 56, 88, 99, 456, 1200, 5589
 *
 * Analysis:
 *
 *    The merge is probably most effective if the values are inserted into the buffer starting with
 *    the end of the input arrays.
 *
 *    a == a0, a1, a2, ..., ai, ... an   i.e. i is range 0..n
 *    b == b0, b1, b2, ..., bj, ... bm   i.e. j is range 0..m
 *
 * Algorithm:
 *
 * 1) Starting at the end of the arrays, compare (a, b) each descending element and place the larger
 * at the end of the result array (a).  If the values are identical, put both elements into the
 * result.
 *
 * 2) Decrement the running index for each array contributing to the result on this iteration.
 *
 * 3) Repeat until the b running index (j) is 0 (all of b have been added to a).
 *
 * i = n;
 * j = m;
 * while j >= 0 do
 *     if i < 0
 *     then
 *         a[j] = b[j]
 *     else if a[i] > b[j]
 *     then
 *         a[i+j+1] = a[i--]
 *     else if b[j] > a[i]
 *         a[i+j] = b[j--]
 *     else
 *         a[i+j] = b[j--]
 *         a[i+j] = a[i--]
 */

import java.util.Arrays;
import java.util.Locale;

public class Main {

    /** Run the program using the command line arguments. */
    public static void main(String[] args) {
        // Define a and b.
        int[] a = new int[]{2, 7, 22, 44, 56, 88, 456, 5589};
        int[] b = new int[]{1, 4, 9, 23, 99, 1200};
        int[] result = smerge(a, b);
        String format = "Result: %s";
        System.out.println(String.format(Locale.US, format, Arrays.toString(result)));
    }

    /** Return the given value in the given base. */
    private static int[] smerge(final int[] a, final int[] b) {
        final int N = a.length;
        final int M = b.length;
        int [] result = new int[N + M];
        System.arraycopy(a, 0, result, 0, N);
        int i = N - 1;
        int j = M - 1;
        while (j >= 0) {
            if (i < 0)
                result[j] = b[j--];
            else if (a[i] > b[j])
                result[i + j + 1] = a[i--];
            else if (b[j] > a[i])
                result[i + j + 1] = b[j--];
            else {
                result[i + j + 1] = a[i--];
                result[i + j + 1] = b[j--];
            }
        }
        return result;
    }
}
