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

    /** Return the ... */
    static int[] findDuplicates(int[] arr1, int[] arr2) {
        // your code goes here

        // Handle special cases.
        if (arr1 == null || arr2 == null)
            return new int[]{};

        // Handle normal cases.
        // Compute the larger of the two arrays.
        int[] larger = arr1.length > arr2.length ? arr1 : arr2;
        int[] smaller = larger == arr1 ? arr2 : arr1;

        // The time complexity is O(S * log(L)) where L is the length of the larger input and S is
        // the length of the smaller.  For example, with L == 64 and S == 4 we get 4 * 8 == 32
        // (versus the alternative of 64 * 2 == 128!).  Note a further optimization is to bracket
        // teh binary search over the range within the larger array that covers the smaller array,
        // if such a bracketing exists.  This optimization is not pursued here.
        List<Integer> result = new ArrayList<>();
        for (int value : smaller)
            if (Arrays.binarySearch(larger, value) >= 0)
                result.add(value);
        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            resultArr[i] = result.get(i);
        return resultArr;
    }
}
