import java.util.Map;
import java.util.HashMap;

/**
 * Pramp practice interview question.
 *
 * Getting a Different Number
 *
 * Given an array arr of unique nonnegative integers, implement a function getDifferentNumber that
 * finds the smallest nonnegative integer that is NOT in the array.
 *
 * Even if your programming language of choice doesn’t have that restriction (like Python), assume
 * that the maximum value an integer can have is MAX_INT = 2^31-1. So, for instance, the operation
 * MAX_INT + 1 would be undefined in our case.
 *
 * Your algorithm should be efficient, both from a time and a space complexity perspectives.
 *
 * Solve first for the case when you’re NOT allowed to modify the input arr. If successful and still
 * have time, see if you can come up with an algorithm with an improved space complexity when
 * modifying arr is allowed. Do so without trading off the time complexity.
 *
 * Analyze the time and space complexities of your algorithm.
 *
 * Example:
 *
 * input:  arr = [0, 1, 2, 3]
 *
 * output: 4
 *
 * Algorithm #1: Find the largest value in arr.  This determines whether the smallest missing value
 * (smv) is to be found in the array or outside of the array. If outside the result is N; If inside
 * the smv is found by creating a map of the vales in arr. The smv will be the first index for which
 * map.containsKey(index) fails.  This is an O(n) time solution but an O(n) space as well (for the
 * map).
 */
class Main {

    // Public class methods.

    /** Return -1 or the smallest nonnegative number that is NOT in the given array. */
    static int getDifferentNumber(final int[] arr) {
        // Handle special cases.
        if (arr == null || arr.length == 0)
            return 0;

        // Handle normal cases by traversing the array looking for the smallest missing value and
        // the largest value.
        final int M = getLargestValue(arr);
        if (M + 1 == arr.length)
            return M + 1;

        // Assert: the result smv is within the bounds of the array. Create a map associating values
        // with indices (for lack of something better) and then iterate over the array to find the
        // missing map entry.  This is the result;
        Map<Integer, Integer> map = getMap(arr);
        int index = -1;
        while (index++ < arr.length - 2)
            if (!map.containsKey(index))
                return index;
        return index;
    }

    /** Return the largest value in the given array. */
    private static int getLargestValue(final int[] arr) {
        int max = -1;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    /** Return a map associating the values in the given arr with the index of the value. */
    private static Map<Integer, Integer> getMap(final int[] arr) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            result.put(arr[i], i);
        return result;
    }
}
