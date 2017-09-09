import java.io.*;
import java.util.*;

/**
 * Pramp: Array Index & Element Equality
 *
 * Given a sorted array arr of distinct integers, write a function indexEqualsValueSearch that
 * returns an index i for which arr[i] == i. Return -1 if there is no such index. Analyze the time
 * and space complexities of your solution and explain its correctness.
 *
 * Examples:
 *
 * input: arr = [-8,0,2,5]
 * output: 2 # since arr[2] == 2
 *
 * input: arr = [-1,0,3,6]
 * output: -1 # since no index in arr satisfies arr[i] == i.
 *
 * input: arr = [0, 1, 2, 3, 4, 5, 6]
 * output: 3
 *
 * input: arr = [-1, 0, 1, 2, 4, 5, 6]
 * output:
 */
class Main {

    static int indexEqualsValueSearch(int[] arr) {
        // your code goes here
        //
        // Use a helper method recursively.
        return indexEqualsValueSearch(arr, 0, arr.length - 1);
    }

    /** Return -1 if there is no match, otherwise return the index whose value is identical. */
    private static int indexEqualsValueSearch(int[] arr, int start, int end) {
        // Use binary search and recursion for optimal performance, O(log(n)).  First deal with
        // special cases.
        if (end < start)
            return -1;
        if (start == end && arr[start] == start)
            return start;

        // Deal with normal cases.  Get the midpoint index and check for fast success.
        int i = start + (int) Math.floor((end - start) / 2);
        if (i == arr[i])
            return i;

        // Now try to exclude the upper or lower half.
        if (arr[i] < i)
            // The upper half may contain a result.
            return indexEqualsValueSearch(arr, i + 1, end);
        else
            // The lower half may contain a result.
            return indexEqualsValueSearch(arr, start, i - 1);
    }

    public static void main(String[] args) {
    }

}
