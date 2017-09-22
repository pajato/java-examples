import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Pramp practice interview question.
 *
 * Merging 2 Packages
 *
 * Given a package with a weight limit limit and an array arr of item weights, implement a function
 * getIndicesOfItemWeights that finds two items whose sum of weights equals the weight limit
 * limit. Your function should return a pair [i, j] of the indices of the item weights. If such a
 * pair doesn’t exist, return an empty array.
 *
 * Analyze the time and space complexities of your solution.
 *
 * Example:
 *
 * input:  arr = [4, 6, 10, 15, 16],  lim = 21
 *
 * output: [3, 1] # since these are the indices of the
 *                # weights 6 and 15 whose sum equals to 21
 */
class Main {

    // Public class methods.

    /** Return an empty array or the two indices of the given arr which sum to the given limit. */
    static int[] getIndicesOfItemWeights(int[] arr, int limit) {
        // your code goes here

        // Handle special cases.
        if (arr == null || arr.length < 2)
            return new int[]{};

        // Buid a map associating each value with a list of indices.
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.get(arr[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(arr[i], list);
            }
            list.add(i);
        }

        // Determine if the desired element is in the given array using the map.  If so, return a
        // distinct pair of indices.
        for (int i = arr.length - 1; i > -1; i--) {
            int diff = limit - arr[i];
            if (map.containsKey(diff)) {
                // Get the deepest index.
                List<Integer> list = map.get(diff);
                int index = list.get(list.size() - 1);
                if (i != index)
                    return new int[]{Math.max(i, index), Math.min(i, index)};
            }
        }
        return new int[]{};
    }
}
