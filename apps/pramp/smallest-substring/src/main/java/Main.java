import java.util.HashMap;
import java.util.Map;

/**
 * Pramp: Smallest Substring of All Characters.
 */
class Main {
    //** The output substring, "" if there is no smallest substring. */
    static private String result = "";

    /** The map associating input characters with occurrence counts. */
    static private Map<Character, Integer> map = new HashMap<>();

    static String getShortestUniqueSubstring(char[] arr, String str) {
        // your code goes here
        // Algorithm:
        //
        // 1) Build a map associating the items in 'arr' with an occurrence count ('count').
        //
        // 2) Walk over the characters, left to right, in 'str' incrementing the occurrence count as
        // approriate.
        //
        // 3) For each iteration (character) if the map sums to 1 or greater for each map entry,
        // then the substring from 0 to the current index is a valid substring.  Store the substring
        // as the result.
        //
        // 4) if result is empty, return it.
        //
        // 5) if result is not empty, iterate over the indexes 1 .. M - N of 'str' looking for a
        // match of length < result.length to be the new result.
        //
        // 6) return non-empty result.
        //
        // Time and space complexity:
        //
        // Time complexity O(M^2) where M is the length of the intput string.
        //
        // Space complexity is O(N) where N is the length of the input array.

        // Initialize.
        result = "";
        map.clear();
        for (char c : arr)
            map.put(c, 0);

        // Walk over the input finding substrings starting at the left end.
        int end = str.length() - 1;
        for (int i = str.length() - arr.length; i > -1; i--) {
            if (getNewShortestSubstring(str, i, end))
                break;
        }

        // Detect no such smallest substring or a perfect result.
        if (result.isEmpty() || result.length() == arr.length)
            return result;

        // Repeat the loop looking for a smaller result.
        for (int i = 1; i < str.length() - result.length(); i++)
            getNewShortestSubstring(str, i, i + result.length() - 2);

        return result;
    }

    /** Process a substring using the given range. */
    private static boolean getNewShortestSubstring(final String str, final int start, final int end) {
        for (Character key : map.keySet())
            map.put(key, 0);
        for (int i = start; i <= end; i++) {
            char key = str.charAt(i);
            Integer count = map.get(key);
            if (count != null)
                map.put(key, count + 1);
        }
        for (Character key : map.keySet())
            if (map.get(key) == 0)
                return false;

        result = str.substring(start, end + 1);
        return true;
    }
}
