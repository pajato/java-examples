/**
 * Problem 1.7 CTCI Zero Matrix
 *
 * Write an algorithm such that is an element of an MxN matrix is zero it's entire row and column are set to 0.
 *
 * Observations:
 *
 * 1) need to collect the rows and columns to zero out, then do the zeroing, otherwise all elements are zeroed.
 * 2) only need to find the first 0 in a row or column.
 * 3) Does it make a difference which direction to traverse? I think not because in the worst case (no zeroes) all elements must be examined.
 *
 * Examples: (N/A)
 *
 * Brute Force algorithm:
 *
 *    1) scan row by row, across the columns and register the vertices of the zero elements into a list.
 *    2) use the list to drive the zeroing, row by row.
 *    3) remember the columns zeroed so the work is not repeated.
 *
 * Result: (output)
 *
 *    Zeroing row x...
 *    Zeroing col y...
 *
 * Analysis:
 *
 *    This is pretty much a BFS exercise.
 *
 * Algorithm:
 *
 * 1) scan the rows, 0 .. m
 * 2) for each row, scan the columns 0 .. n
 * 3) examine g(r, c) == 0; save r into a list, c into a map.
 * 4) clear the rows using the list of saved row numbers.
 * 5) clear the columns using the keys from the map of saved column numbers.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {

    /**
     * Run the program using the command line argument to control the number of runs: no args, do it
     * once with a 5x5 matrix, otherwise each numeric command line argument will represent the
     * matrix size (M==N).  Non-numeric arguments will be ignored.
     */
    public static void main(String[] args) throws Exception {
        // Determine whether to zero out a 5x5 matrix or one or more matrices with sizes provided on
        // the command line.
        if (args.length == 0) {
            zeroMatrix("5");
            return;
        }
        for (String value : args) {
            zeroMatrix(value);
        }
    }

    /** Return a copy of the given matrix. */
    private static int[][] copyOf(final int[][] m) {
        int size = m.length;
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                result[i][j] = m[i][j];
        return result;
    }

    /** Return the given row expressed as a string. */
    private static String getRow(int[][] m, int r) {
        int[] row = m[r];
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int c = 0; c < m.length; c++) {
            int value = row[c];
            result.append(value);
            if (c < m.length - 1)
                result.append(" ");
        }
        result.append("]");
        return result.toString();
    }

    /** Return a random value in the given (inclusive) range. */
    private static int getRandomInRange(int min, int max) {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    /** Return -1 or a positive non-zero integer given by the argument. */
    private static int getSize(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exc) {
            return -1;
        }
    }

    /** Return a list of rows that need to be zeroed. */
    private static List<Integer> getZeroRows(final int[][] m) {
        List<Integer> result = new ArrayList<>();
        int size = m.length;
        for (int r = 0; r < size; r++) {
            int[] row = m[r];
            for (int c = 0; c < size; c++) {
                if (m[r][c] == 0) {
                    result.add(r);
                    break;
                }
            }
        }
        return result;
    }

    /** Return a list of columns that need to be zeroed. */
    private static List<Integer> getZeroColumns(final int[][] m) {
        List<Integer> result = new ArrayList<>();
        int size = m.length;
        for (int c = 0; c < size; c++) {
            for (int r = 0; r < size; r++) {
                if (m[r][c] == 0) {
                    result.add(c);
                    break;
                }
            }
        }
        return result;
    }

    /** Print the given matrices side by side. */
    private static void printMatrices(final int[][] m1, final int[][] m2) {
        final int N = m1.length;
        if (m2.length != N) {
            System.out.println("Error: m1 and m2 are not of the same size.");
            System.exit(1);
        }
        for (int n = 0; n < N; n++) {
            String inputRow = getRow(m1, n);
            String outputRow = getRow(m2, n);
            String line = String.format(Locale.US, "%s    %s", inputRow, outputRow);
            System.out.println(line);
        }

    }

    /** Return a matrix of the given size populated with 0s placed at random vertices. */
    private static int[][] populateMatrix(final int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                result[i][j] = 1;

        // Generate at least one and less than size 0's placed at random vertices.
        int numberOfZeros = getRandomInRange(1, size - 1);
        int[] vertices = new int[numberOfZeros];
        for (int i = 0; i < vertices.length; i++) {
            int position = getRandomInRange(1, (size * size) - 1);
            int row = position / size;
            int col = position % size;
            result[row][col] = 0;
        }
        return result;
    }

    /**
     * Do nothing if the given value is not a positive non-zero value, otherwise zero out the rows
     * and columns for each element containing a zero value.
     */
    private static void zeroMatrix(final String value) {
        // Run BFS to determine the result.
        final int N = getSize(value);
        if (N < 0)
            return;

        // Populate the NxN matrix with randomly generated and placed 0's.  Keep a copy of the
        // original input order to print both for a side by side comparison.
        int[][] input = populateMatrix(N);
        int[][] result = copyOf(input);
        zeroMatrix(result);
        System.out.println(String.format("Matrix of size %s.", value));
        printMatrices(input, result);
    }

    /** Perform the zeroing, in-place, on the given matrix. */
    private static void zeroMatrix(final int[][] m) {
        // Set up a list to collect the rows with a zero and a map to collect the columns.
        List<Integer> rowList = getZeroRows(m);
        List<Integer> colList = getZeroColumns(m);
        zeroOutRows(m, rowList);
        zeroOutColumns(m, colList);
    }

    /** Zero out each row in the given array using the values in the given list. */
    private static void zeroOutRows(int[][] m, List<Integer> list) {
        int size = m.length;
        for (Integer r : list) {
            int[] row = m[r];
            for (int c = 0; c < size; c++)
                m[r][c] = 0;
        }
    }

    /** Zero out each column in the given array using the values in the given list. */
    private static void zeroOutColumns(final int[][] m, final List<Integer> list) {
        int size = m.length;
        for (Integer c : list) {
            for (int r = 0; r < size; r++)
                m[r][c] = 0;
        }
    }
}
