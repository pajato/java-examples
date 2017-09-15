import java.util.Arrays;

/**
 * Pramp practice interview question.
 *
 * Array Quadruplet
 *
 * Given an unsorted array of integers arr and a number s, write a function findArrayQuadruplet that
 * finds four numbers (quadruplet) in arr that sum up to s. Your function should return an array of
 * these numbers in an ascending order. If such a quadruplet doesn’t exist, return an empty array.
 *
 * Note that there may be more than one quadruplet in arr whose sum is s. You’re asked to return the
 * first one you encounter.
 *
 * Explain and code the most efficient solution possible, and analyze its time and space
 * complexities.
 *
 * Example:
 *
 * input:  arr = [2, 7, 4, 0, 9, 5, 1, 3], s = 20
 *
 * output: [0, 4, 7, 9] # The ordered quadruplet of (7, 4, 0, 9)
 *                      # whose sum is 20. Notice that there
 *                      # are two other quadruplets whose sum is 20:
 *                      # (7, 9, 1, 3) and (2, 4, 9, 5), but again you’re
 *                      # asked to return the just one quadruplet (in an
 *                      # ascending order)
 */
class Main {

    // Public class methods.

    /** Return an empty array or an array containing the four elements which sum to s. */
    static int[] findArrayQuadruplet(int[] arr, int s) {
        // your code goes here

        // Handle special cases.
        if (arr == null || arr.length < 4)
            return new int[]{};

        // Deal with the normal cases.
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 3; i++)
            for (int j = i + 1; j < arr.length - 2; j++)
                for (int k = j + 1; k < arr.length - 1; k++) {
                    int key = s - (arr[i] + arr[j] + arr[k]);
                    if (Arrays.binarySearch(arr, k + 1, arr.length, key) >= 0)
                        return new int[]{arr[i], arr[j], arr[k], key};
                }
        return new int[]{};
    }
}
