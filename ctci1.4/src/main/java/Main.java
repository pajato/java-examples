/**
 * Problem 1.4 CTCI Palindrome Permutations
 *
 * Given a string, write a function to check if it is a permutation of a palindrome.  A palindrome
 * is a word or phrase that is the same forwards or backwards. A permutation is a rearrangement of
 * letters. The palindrome does not need to be limited to dictionary words.
 *
 * Observations:
 *
 * 1) need to implement: boolean isPalPerm(String letters)
 *
 * 2) the letters are Unicode (UTF-16) and thus require 21 bits, an int. Therefore using an array to
 * count the occurrences of the letters is likely inefficient.
 *
 * 3) The letters can be a permutation of a palindrome iff there is at most one letter with an odd
 * count.
 *
 * Examples:
 *
 * abdfdba == aabbddf => true
 * abc => false
 *
 * Brute Force algorithm:
 *
 *    1) create a Character list.
 *
 *    2) for each letter:
 *
 *    2a) put it into the list if it is not already there, as this occurrence means there is an odd
 *    number of occurrences.
 *
 *    2b) remove if from the list if it is already there, as the next occurrence means there is an
 *    even number of occurrences.
 *
 *    3) if the size of the list is greater than one, return false, otherwise return true.
 *
 * Input: abdfdba abc ...
 * Output:
 *
 *    abdfdba => is a permutation of a palindrome.
 *    abc => is not a permutation of a palindrome.
 *
 * Algorithm:
 *
 * 1) for each argument:
 * 2) convert the letters to a char array.
 * 3) for each item in the array:
 * 4) determine if the char is in a list; if so then remove it, if not then add it.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import util.Util;

public class Main {

    /**
     * Run the program using the command line argument to control the number of runs: no args, print
     * a message, otherwise each argument will be processed to determine if it is a palindrome
     * permutation.
     */
    public static void main(String[] args) throws Exception {
        // Determine whether to zero out a 5x5 matrix or one or more matrices with sizes provided on
        // the command line.
        if (args.length == 0) {
            System.out.println("No inputs.");
        } else {
            for (String value : args) {
                String result = isPalPerm(value) ? "is" : "is not";
                String line = String.format("%s %s a permutation of a palindrome.", value, result);
                System.out.println(line);
            }
        }
    }

    /** Zero out each column in the given array using the values in the given list. */
    private static boolean isPalPerm(final String letters) {
        List<Character> list = new ArrayList<>();
        char[] chars = letters.toCharArray();
        for (Character letter : chars) {
            if (list.contains(letter)) {
                list.remove(letter);
            } else {
                list.add(letter);
            }
        }
        return list.size() == 0 || list.size() == 1;
    }
}
