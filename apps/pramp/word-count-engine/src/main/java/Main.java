import java.util.HashMap;
import java.util.Map;

/**
 * Word Count Engine
 *
 * Implement a document scanning function wordCountEngine, which receives a string document and
 * returns a list of all unique words in it and their number of occurrences, sorted by the number of
 * occurrences in a descending order. Assume that all letters are in english alphabet. You function
 * should be case-insensitive, so for instance, the words “Perfect” and “perfect” should be
 * considered the same word.
 *
 * The engine should strip out punctuation (even in the middle of a word) and use whitespaces to
 * separate words.
 *
 * Analyze the time and space complexities of your solution. Try to optimize for time while keeping
 * a polynomial space complexity.
 *
 * Examples:
 *
 * input:  document = "Practice makes perfect. you'll only get Perfect by practice. just practice!"
 *
 * output: [ ["practice", "3"], ["perfect", "2"], ["makes", "1"], ["get", "1"], ["by", "1"],
 *           ["just", "1"], ["youll", "1"], ["only", "1"] ]
 *
 * Important: please convert the occurrence integers in the output list to strings (e.g. "3" instead
 * of 3). We ask this because in compiled languages such as C#, Java, C++, C etc., it’s not
 * straightforward to create mixed-type arrays (as it is, for instance, in scripted languages like
 * JavaScript, Python, Ruby etc.). So to simplify things for all users (and us :), the output will
 * be an array of string arrays.
 */
class Main {
    // start at 11:30, for all intents and purposes.

    /** Return an array of pairs that specify a word and it's count in the given document. */
    static String[][] getWordCounts(final String doc) {
        // Algorithm:
        //
        // 0) Convert the document to lower case.
        //
        // 1) split the given document into an array of tokens (words) split on spaces. (issue: how
        // to deal with multiples spaces?  for now assume a single space)
        //
        // 2) Iterate over the list of words adding each word to a map with a count of 1 if it does
        // not exist in the map, or bumping the count if it does alreay exist.
        //
        // 3) Iterate over the entries in the map until the map is empty: using a
        // findFirstMaxEntry() method, locate the highest word count in the map, add that entry to
        // the result, and purge the entry from the map.
        //
        // 4) Return the result.

        // The time complexity is O(n*n) where n is the number of unique words.
        // The space complexity is O(n)

        // Deal with special cases.
        if (doc == null)
            return null;
        if (doc.isEmpty())
            return new String[][]{};

        // Deal with normal cases: convert the document to lower case, split the words on the
        // space characters and count the occurrences.
        Map<String, Integer> map = new HashMap<>();
        String d = doc.toLowerCase().replaceAll("[^a-z ]", "").replaceAll(" +", ":");
        String[] words = d.split(":");
        for (String word : words)
            if (map.containsKey(word))
                map.put(word, map.get(word) + 1);
            else
                map.put(word, 1);

        // Find the highest occurring word count, add it to the result.
        String[][] result = new String[map.size()][2];
        int index = 0;
        Map.Entry<String, Integer> maxEntry = null;
        while (map.size() > 0) {
            for (Map.Entry<String, Integer> entry : map.entrySet())
                if (maxEntry == null || entry.getValue() > maxEntry.getValue())
                    maxEntry = entry;
            assert maxEntry != null;
            String key = maxEntry.getKey();
            map.remove(key);
            result[index][0] = key;
            result[index++][1] = maxEntry.getValue().toString();
            maxEntry = null;
        }
        return result;
    }


    public static void main(String[] args) {
    }

}
