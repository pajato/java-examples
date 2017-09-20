import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Pramp practice interview question.
 *
 * Find The Duplicates
 *
 * Given two sorted arrays arr1 and arr2 of passport numbers, implement a function findDuplicates
 * that returns an array of all passport numbers that are both in arr1 and arr2. Note that the
 * output array should be sorted in an ascending order.
 *
 * Let N and M be the lengths of arr1 and arr2, respectively. Solve for two cases and analyze the
 * time & space complexities of your solutions: M ≈ N - the array lengths are approximately the same
 * M ≫ N - arr2 is much bigger than arr1.
 *
 * Example:
 *
 * input:  arr1 = [1, 2, 3, 5, 6, 7], arr2 = [3, 6, 7, 8, 20]
 *
 * output: [3, 6, 7] # since only these three values are both in arr1 and arr2
 *
 */
class Main {

    // Public class methods.

    /** Return the given array sorted by using the pancake sort described above. */
    static int[] findDuplicates(int[] arr1, int[] arr2) {
        // your code goes here

        // Handle special cases.
        if (arr1 == null || arr2 == null)
            return new int[]{};

        // Handle normal cases for arr1.length ~= arr2.length
        List<Integer> result = new ArrayList<>();
        for (int value : arr1)
            if (Arrays.binarySearch(arr2, value) >= 0)
                result.add(value);
        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            resultArr[i] = result.get(i);
        return resultArr;
    }
}
