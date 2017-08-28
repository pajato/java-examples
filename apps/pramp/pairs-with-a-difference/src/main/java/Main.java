import java.io.*;
import java.util.*;

/**
 * Pairs with Specific Difference
 *
 * Given an array arr of distinct integers and a nonnegative integer k, write a function
 * findPairsWithGivenDifference that returns an array of all pairs [x,y] in arr, such that x - y =
 * k. If no such pairs exist, return an empty array.
 *
 * In your solution, try to reduce the memory usage while maintaining time efficiency. Prove the
 * correctness of your solution and analyze its time and space complexities.
 *
 * Note: the order of the pairs in the output array doesn’t matter.
 */
class Main {

    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        // Observations:
        //
        // 1) Iterate over all pairs in a minimal way by getting the difference using absolute
        // value.  This cuts the required operations in half.  Brings time complexity down to
        // O(n^2/2).  Space complexity is O(n).  Collect the results into a list of int arrays.

        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+ 1; j < arr.length; j++) {
                // Determine if there is a match between the next two values.
                if (Math.abs(arr[i] - arr[j]) == k) {
                    Integer[] intArray = new Integer[2];
                    intArray[0] = arr[i];
                    intArray[1] = arr[j];
                    list.add(intArray);
                }
            }
        }

        if (list.size() == 0)
            return new int[][]{};

        int [][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = Math.max(list.get(i)[0], list.get(i)[1]);
            result[i][1] = Math.min(list.get(i)[0], list.get(i)[1]);
        }

        return result;
    }

    public static void main(String[] args) {
        process(new int[]{1, 2, 3}, 6, new int[][]{});
        process(new int[]{0, -1, -2, 2, 1}, 1, new int[][]{{0, -1}, {1, 0}, {-1, -2}, {2, 1}});
        process(new int[]{1, 7, 5, 3, 32, 17, 12}, 17, new int[][]{});
        process(new int[]{4, 1}, 3, new int[][]{{4, 1}});
        process(new int[]{1,5,11,7}, 4, new int[][]{{5,1},{11,7}});
        process(new int[]{1,5,11,7}, 6, new int[][]{{7,1},{11,5}});
        process(new int[]{1,5,11,7}, 10, new int[][]{{11,1}});
        process(new int[]{0,-1,-2,2,1}, 1, new int[][]{{0,-1},{1,0},{-1,-2},{2,1}});
    }

    private static void process(int[] arr, int value, int[][] expected) {
        String arrStr = Arrays.toString(arr);
        String expStr = getString(expected);
        int[][] actual = findPairsWithGivenDifference(arr, value);
        String actStr = getString(actual);
        if (actual.length != expected.length) {
            String format = "find...(%s, %d) has wrong size: %s; %s";
            System.out.println(String.format(Locale.US, format, arrStr, value, actStr, expStr));
            return;
        }
        for (int i = 0; i < actual.length; i++) {
            int[] actualItem = actual[i];
            if (actualItem.length != 2) {
                String format = "item %d of array %s is of length %d; should be 2!";
                System.out.println(String.format(Locale.US, format, i, arrStr, actualItem.length));
                return;
            }

            if (actualItem[0] != expected[i][0] || actualItem[1] != expected[i][1]) {
                String format = "actual: %s; expected: %s";
                System.out.println(String.format(Locale.US, format, actStr, expStr));
                return;
            }
        }
    }

    private static String getString(int[][] arr) {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < arr.length; i++) {
            result.append(Arrays.toString(arr[i]));
            if (i != arr.length - 1)
                result.append(", ");
        }
        result.append("]");
        return result.toString();
    }
}
