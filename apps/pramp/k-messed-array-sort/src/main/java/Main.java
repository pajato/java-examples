/**
 * Pramp practice interview question.
 *
 * K-Messed Array Sort
 *
 * Given an array of integers arr where each element is at most k places away from its sorted
 * position, code an efficient function sortKMessedArray that sorts arr. For instance, for an input
 * array of size 10 and k = 2, an element belonging to index 6 in the sorted array will be located
 * at either index 4, 5, 6, 7 or 8 in the input array.
 *
 *
 * Analyze the time and space complexities of your solution.
 *
 * Example:
 *
 * input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2
 *
 * output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 */
class Main {

    // Public class methods.

    /** Return the given array sorted using the factor k as described above. */
    static int[] sortKMessedArray(int[] arr, int k) {
        // your code goes here

        // Handle special cases.
        if (arr == null || k == 0)
            return arr;

        // Handle normal cases by using a modified sort exploiting the factor k.
        for (int i = 0; i < arr.length - 1; i++)
            sort(arr, i, k);
        return arr;
    }

    /** Sort the given array starting at index i over i places. */
    private static void sort(final int[] arr, final int i, final int k) {
        for (int j = i + 1; j < arr.length && j < i + k + 1; j++) {
            if (arr[j] < arr[i]) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
    }
}
