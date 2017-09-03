import java.util.Arrays;

/**
 * Pramp practice interview question.
 *
 * Nth root
 *
 * Given a non-negative value and a positive integer, compute the principal nth root of the value.
 *
 */
class Main {

    // Public class methods.

    static int shiftedArrSearch(int[] shiftArr, int num) {
        // your code goes here

        // Handle the special cases.
        if (shiftArr == null)
            throw new IllegalArgumentException("The input array is null!");

        // Algorithm: find the index of the boundary between the two pieces, then use a binary
        // search in each piece to locate the desired index.
        int index; // the given array is at least 1 shift.
        for (index = 1; index < shiftArr.length; index++)
            if (shiftArr[index] < shiftArr[index - 1])
                break;

        // index now marks the split to identify the left and right sub-arrays. Populate the two
        // sub-arrays, left and right.
        int[] left = new int[index];
        int[] right = new int[shiftArr.length - index];
        for (int i = 0; i < index; i++)
            left[i] = shiftArr[i];
        for (int i = index; i < shiftArr.length; i++)
            right[i - index] = shiftArr[i];

        // Locate the desired element within the sub-elemet.
        int numIndex = Arrays.binarySearch(left, num);
        if (numIndex >= 0)
            return numIndex;
        return index + Arrays.binarySearch(right, num);
    }
}
