/**
 * Provide a class that takes two command line arguments and converts the first from a base 10
 * number to a base r number where r is given by the second argument.
 *
 * Input: two values, an non-negative base 10 integer (value) and an integer (radix) 2..9
 * Output: the input value expressed as a base radix number.
 *
 * Examples:
 *
 *    the input 9, 2 would give the output "9 in base 2 is 1001"
 *    the input 17, 3 would give the output "17 in base 3 is 122"
 *
 * Analysis:
 *
 *    The value in base r can be represented as a sum of terms:
 *
 *    c0 * r^n + c1 * r^(n-1) + ... + cn * r^0
 *
 * where r is the radix; n is the largest integer such that r^n <= value and r^(n+1) > value and
 * each ci is largest value between 0 and r-1 such that the sum == value.
 *
 * Algorithm:
 *
 * 1) Find the value of n by iterating from 1..n until r^(n+1) > value.
 *
 * 2) Iterate over the n terms calculating each coefficient ci starting at n and walking down to 0.
 * Output the coefficient for each term.
 */

import java.util.Locale;

public class Main {

    /** Run the program using the command line arguments. */
    public static void main(String[] args) {
        // Validate the arguments.
        if (args.length != 2) {
            System.out.println("Error: invalid command: two arguments are required.");
            System.exit(1);
        }
        boolean valid = true;
        int value = Integer.parseInt(args[0]);
        int radix = Integer.parseInt(args[1]);
        if (value < 0) {
            System.out.println("Error: invalid value argument; must be positive.");
            valid = false;
        }
        if (radix < 2 || radix > 9) {
            System.out.println("Error: invalid radix: should be in the range 2..9");
            valid = false;
        }
        if (!valid)
            System.exit(1);

        // Perform the conversion to generate and display the output.
        String format = "%d in base %d is %s";
        System.out.println(String.format(Locale.US, format, value, radix, convert(value, radix)));
    }

    /** Return the given value in the given base. */
    private static String convert(final int value, final int r) {
        // Compute the value of the largest exponent, 'n' in the algorithm.
        int product = 1;
        int n = 0;
        for (int i = 0; product * r < value; i++) {
            product *= r;
            n++;
        }

        // Iterate through each term to generate the coefficient.
        StringBuilder builder = new StringBuilder();
        int sum = 0;
        int i = n;
        while (sum != value) {
            for (int j = r; j > -1; j--) {
                double c = r * 1.0;
                double e = i * 1.0;
                int exp = (int) Math.pow(c, e);
                if (sum + (j * exp) > value)
                    continue;
                else {
                    builder.append(String.valueOf(j));
                    sum += j * exp;
                    break;
                }
            }
            i--;
        }
        return builder.toString();
    }
}
