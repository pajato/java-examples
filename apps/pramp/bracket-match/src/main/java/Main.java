import java.util.Stack;

/**
 * Pramp practice interview question.
 *
 * Bracket Match
 *
 * A string of brackets is considered correctly matched if every opening bracket in the string can
 * be paired up with a later closing bracket, and vice versa. For instance, “(())()” is correctly
 * matched, whereas “)(“ and “((” aren’t. For instance, “((” could become correctly matched by
 * adding two closing brackets at the end, so you’d return 2.
 *
 * Given a string that consists of brackets, write a function bracketMatch that takes a bracket
 * string as an input and returns the minimum number of brackets you’d need to add to the input in
 * order to make it correctly matched.
 *
 * Explain the correctness of your code, and analyze its time and space complexities.
 *
 * Examples:
 *
 * input:  text = “(()”
 * output: 1
 *
 * input:  text = “(())”
 * output: 0
 *
 * input:  text = “())(”
 * output: 2
 */
class Main {

    // Public class methods.

    static int bracketMatch(String text) {
        // your code goes here

        // Algorithm: process each character in the given text using a stack and ensure that the
        // stack is valid for each input.

        // Handle special cases.
        if (text == null || text.length() == 0)
            return -1;

        // Handle the normal case by processing the n characters one at a time, O(n) where n is the
        // length of the given text.
        int result = 0;
        Stack<Character> stack = new Stack<>();
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // For each character, push an open paren onto a stack, validate the stack has an entry
            // for a closed parens (and pop it off the stack).
            if (chars[i] == '(')
                stack.push(chars[i]);
            else if (stack.size() == 0)
                result++;
            else
                stack.pop();
        }

        // Ensure no orphaned parens are on the stack.
        if (stack.size() != 0)
            result += stack.size();

        return result;
    }
}
