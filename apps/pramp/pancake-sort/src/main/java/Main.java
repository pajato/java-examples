/**
 * Pramp practice interview question.
 *
 * Pancake Sort
 *
 * Given an array of integers arr:
 *
 * Write a function flip(arr, k) that reverses the order of the first k elements in the array arr.
 *
 * Write a function pancakeSort(arr) that sorts and returns the input array. You are allowed to use
 * only the function flip you wrote in the first step in order to make changes in the array.
 *
 * Example:
 *
 * input:  arr = [1, 5, 4, 3, 2]
 *
 * output: [1, 2, 3, 4, 5] # to clarify, this is pancakeSort's output
 *
 * Analyze the time and space complexities of your solution.
 *
 * Note: it’s called pancake sort because it resembles sorting pancakes on a plate with a spatula,
 * where you can only use the spatula to flip some of the top pancakes in the plate. To read more
 * about the problem, see the
 * <a href="https://en.wikipedia.org/wiki/Pancake_sorting">Pancake Sorting Wikipedia page</a>.
 */
class Main {

    // Public class methods.

    /** Return the given array sorted by using the pancake sort described above. */
    static int[] pancakeSort(int[] arr) {
        // your code goes here

        // Handle special cases by dealing with null and empty input.
        if (arr == null || arr.length == 0)
            return arr;

        // Handle normal cases.
        for (int i = arr.length - 1; i > 0; i--) {
            int k = getMaxIndex(arr, i);
            flip(arr, k);
            flip(arr, i);
        }
        return arr;
    }

    /** Return the largest index in the given array after the given index. */
    private static int getMaxIndex(int[] arr, int index) {
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = index; i >= 0; i--) {
            if (arr[i] > maxValue) {
                maxIndex = i;
                maxValue = arr[i];
            }
        }
        return maxIndex;
    }

    /** Reorder (in-place) the first k elements of the given array. */
    private static void flip(int[] arr, int k) {
        int leftIndex = 0;
        int rightIndex = k;
        while (leftIndex < rightIndex) {
            int temp = arr[leftIndex];
            arr[leftIndex++] = arr[rightIndex];
            arr[rightIndex--] = temp;
        }
    }
}
