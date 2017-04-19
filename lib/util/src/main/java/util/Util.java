package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Provide a utility class for commonly used methods.
 */
public class Util {

    /** Return a copy of the given matrix. */
    public static int[][] copyOf(final int[][] m) {
        int size = m.length;
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                result[i][j] = m[i][j];
        return result;
    }

    /** Return an array with the unique values present in the given sorted int array. */
    public static int[] getUnique(int[] a) {
        if (a == null || a.length == 0)
            return null;
        final int N = a.length;
        final int[] b = Arrays.copyOf(a, N);
        Arrays.sort(b);
        final int M = getUniqueCount(a);
        int[] result = new int[M];
        result[0] = b[0];
        int current = b[0];
        for (int i = 1, j = 1; i < N; i++) {
            if (current != b[i]) {
                result[j++] = b[i];
                current = b[i];
            }
        }
        return result;
    }

    /** Return the number of unique values in an int array. */
    public static int getUniqueCount(int[] a) {
        if (a == null || a.length == 0)
            return 0;
        int result = 1;
        final int N = a.length;
        int[] b = Arrays.copyOf(a, N);
        Arrays.sort(b);
        int current = b[0];
        for (int i = 0; i < N; i++) {
            if (current != b[i]) {
                result++;
                current = b[i];
            }
        }
        return result;
    }

    /** Return a random value in the given (inclusive) range. */
    public static int getRandomInRange(int min, int max) {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    /** Return -1 or a positive non-zero integer given by the argument. */
    public static int getInt(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exc) {
            return -1;
        }
    }

    /** Print the given matrices side by side. */
    public static void printMatrices(final int[][] m1, final int[][] m2) {
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
}
