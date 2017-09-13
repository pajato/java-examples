/**
 * Problem 8.7 Permutations without Dups
 *
 * Write a method to compute all permutations of a string with unique characters.
 *
 * Examples:
 *
 * input: "abc"
 * output: ["abc", "cba", "acb", "cab"]
 *
 * input: "abcd"
 * output: ["abcd", "abdc", "bacd", "badc", "cdab", "cdba", "dcab", "dcba"]
 * Analysis:
 *
 *    This is pretty much a recursion exercise.  Divide the input into two halfs, process the left
 *    half, then process the right half.  The result is the left half concatenated with the
 *    permuations of the right half, plus the right half preceded by the permuatiosn of the left
 *    half.  Each half is processed recursively.  Permutations of "a" are ["a"] and permutations of
 *    "ab" are ["ab", "ba"].
 *
 * Algorithm:
 *
 * 1) Build the graph g, with the nodes from the example.
 *
 * 2) Use BFS on the graph to find the path, if any.
 */
public class Main {

    /** Return all the permutations of the given string. */
    static void printPermutations(final String input) {
        StringBuilder builder = new StringBuilder();
        printPermutations(builder, input);
    }

    private static void printPermutations(final StringBuilder builder, final String input) {
        // Deal with special cases.
        if (input == null || input.isEmpty())
            return;

        // Deal with normal cases.
        if (input.length() == 1) {
            System.out.println(builder.append(input).toString());
            builder.delete(builder.length() - 1, builder.length());
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            builder.append(input.substring(i, i + 1));
            printPermutations(builder, substringsWithout(input, i));
            builder.delete(builder.length() - 1, builder.length());
        }
    }

    // Return the given string without the character at the given index. */
    private static String substringsWithout(final String input, final int index) {
        if (index == 0)
            return input.substring(1);
        if (index == input.length() - 1)
            return input.substring(0, index);
        return input.substring(0, index) + input.substring(index + 1, input.length());
    }
}
