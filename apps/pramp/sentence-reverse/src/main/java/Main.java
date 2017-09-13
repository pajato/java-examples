/**
 * Sentence Reverse
 *
 * You are given an array of characters arr that consists of sequences of characters separated by
 * space characters. Each space-delimited sequence of characters defines a word.
 *
 * Implement a function reverseWords that reverses the order of the words in the array in the most
 * efficient manner.
 *
 * Explain your solution and analyze its time and space complexities.
 *
 * Example:
 *
 * input:  arr = [ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ',
 *                 'm', 'a', 'k', 'e', 's', '  ',
 *                 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]
 *
 * output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', '  ',
 *           'm', 'a', 'k', 'e', 's', '  ',
 *           'p', 'e', 'r', 'f', 'e', 'c', 't' ]
 */
class Main {

    static char[] reverseWords(char[] arr) {
        // your code goes here
        // Special cases: null input, empty input, three characters or less, only one word.
        if (arr == null)
            return null;
        if (arr.length < 4)
            return arr;

        // Normal case.  Reverse the words in the array by reversing the entire array
        // and then reversiing each word in turn.
        reverse(arr, 0, arr.length);
        int index = 0;
        while (index < arr.length) {
            // Determine the length of the next word.
            int length = 0;
            for (int i = index; i < arr.length && arr[i] != ' '; i++)
                length++;
            reverse(arr, index, length);
            index += length + 1;
        }
        return arr;
    }

    /** Reverse the n characters in the given array at the given start index. */
    private static void reverse(char[] arr, int index, int n) {
        int start = index;
        int end = start + n - 1;
        while (start < end) {
            char tmp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = tmp;
        }
    }

}
