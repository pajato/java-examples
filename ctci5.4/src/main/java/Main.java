import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Problem 5.4 CTCI Next Number
 *
 * Given a positive integer, find the next smaller and next larger number with the same number of
 * 1's as the input.
 *
 * For expediency, the next larger value is not addressed here.  It is very similar.
 *
 * Examples:
 *
 * Input   Next Smaller  Next Larger
 * 0       X             X
 * 1       X             10
 * 10      01            100
 * 11      X             101
 * 100     010           1000
 * 101     011           1001
 * ...
 * 1100    1010          10100
 * ...
 *
 * Analysis:
 *
 * The examples reveal the pattern that the rightmost 10 becomes 10 for the next smaller value and
 * the rightmost 01 becomes 10 for the next larger value such that the number of 1's are preserved.
 *
 * Algorithm: (next smaller)
 *
 * int getNextSmaller(int input)
 *     xorMask = 2
 *     bitMask = 3
 *     if input < 2 return -1
 *     while input > xorMask
 *         if input ^ xorMask & bitMask == 0 then
 *             return input ^ bitMask
 *         xorMask *= 2;
 *         bitMask *= 2;
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Next Number");
        int[] a = getArray(args);
        if (a.length == 0)
            abort("No valid input.");
        for (int value : a)
            System.out.println("Next smaller for " + value + " is " + getNextSmaller(value));
    }

    /** Return -1 or the next smaller value for the given input. */
    private static int getNextSmaller(int input) {
        int xorMask = 2;
        int bitMask = 3;
        if (input < 2)
            return -1;
        while (input >= xorMask) {
            if (((input ^ xorMask) & bitMask) == 0)
                return input ^ bitMask;
            xorMask *= 2;
            bitMask *= 2;
        }
        return -1;
    }

/** Exit with an error message. */
    private static void abort(String message) {
        System.out.println(message);
        System.exit(0);
    }


    /** Return a possibly empty int array populated with the given arguments. */
    private static int[] getArray(String... args) {
        List<Integer> values = new ArrayList<>();
        for (String arg : args)
            try {
                int value = Integer.parseInt(arg);
                values.add(value);
            } catch (NumberFormatException exc) {
                // silently ignore bad args.
            }
        int[] result = new int[values.size()];
        for (int i = 0; i < values.size(); i++)
            result[i] = values.get(i);
        return result;
    }

}
