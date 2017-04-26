import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }

        // Find the number of combinations by iterating over all possibilities.
        System.out.print(fc(n, coins));
    }

    /** Return the number of combinations of given coins for the given amount (n). */
    private static int fc(int n, int[] coins) {
        if (n == 0)
            return 0;
        int result = 0;
        int [] counts = getCounts(n, coins);
        int iterations = getIterations(counts);
        for (int i = 0; i < iterations; i++)
            if (getSum(i, coins, counts) == n)
                result++;
        return result;
    }

    /** Return an array with the counts associated with each coin. */
    private static int[] getCounts(int n, int[] coins) {
        int[] result = new int[coins.length];
        for (int i = 0; i < coins.length; i++)
            result[i] = (n / coins[i]) + 1;
        return result;
    }

    /** Return the number of iterations required. */
    private static int getIterations(int[] counts) {
        int result = 1;
        for (int i = 0; i < counts.length; i++) {
            result *= counts[i];
        }
        return result;
    }

    /** Return the sum of the terms for a given iteration. */
    private static int getSum(int iteration, int[] coins, int[] counts) {
        int sum = 0;
        for (int i = 0; i < coins.length; i++)
            sum += ((iteration / getChangeRate(i, counts)) % counts[i]) * coins[i];
        return sum;
    }

    /** Return the change rate of the ith term. */
    private static int getChangeRate(int i, int[] counts) {
        int result = 1;
        for (int j = i + 1; j < counts.length; j++)
            result *= counts[j];
        return result;
    }
}
